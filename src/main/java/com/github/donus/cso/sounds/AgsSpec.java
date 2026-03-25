package com.github.donus.cso.sounds;

import com.github.donus.cso.*;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.events.SoundEffectPlayed;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.ScheduledExecutorService;

import static com.github.donus.cso.CSOPlugin.CJ;

@Singleton
@Slf4j
public class AgsSpec extends TimedSoundBase
{

	@Inject
	private Client client;

	@Inject
	private CSOConfig config;

	@Inject
	private SoundEngine soundEngine;

	@Inject
	private ScheduledExecutorService executor;

	private final String message = "OGS!";

	AgsSpec()
	{
		super(5);
	}

	public void onTick(int currentTick, Player local)
	{
		if (config.agsSpec())
		{
			boolean agsSpecced = local.hasSpotAnim(AnimationIds.AGS_SPEC.Id);
			if (agsSpecced)
			{
				if (canPlaySound(currentTick))
				{
					if (config.showChatMessages())
					{
						client.addChatMessage(ChatMessageType.PUBLICCHAT, CJ, message, null);
					}
					soundEngine.playClip(Sound.AGS_SPEC, executor);
					setLastPlayedTickTick(currentTick);
				}
			}
		}
	}

	public void onSoundEffectPlayed(SoundEffectPlayed event)
	{
		int soundId = event.getSoundId();
		final Player local = client.getLocalPlayer();

		if (config.agsSpec())
		{
			if (soundId == SoundIds.AGS_SPEC.Id)
			{
				event.consume();
				return;
			}
		}
	}
}
