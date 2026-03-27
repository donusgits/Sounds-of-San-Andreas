package com.github.donus.sosa.sounds;

import com.github.donus.sosa.SOSAConfig;
import com.github.donus.sosa.Sound;
import com.github.donus.sosa.SoundEngine;
import com.github.donus.sosa.SoundIds;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.events.SoundEffectPlayed;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.ScheduledExecutorService;

@Singleton
@Slf4j
public class RubyBoltProc
{

	@Inject
	private Client client;

	@Inject
	private SOSAConfig config;

	@Inject
	private SoundEngine soundEngine;

	@Inject
	private ScheduledExecutorService executor;

	public void onSoundEffectPlayed(SoundEffectPlayed event)
	{
		int soundId = event.getSoundId();

		if (config.rubyBoltProc())
		{
			if (soundId == SoundIds.RUBY_BOLT_PROC.Id)
			{
				event.consume();
				soundEngine.playClip(Sound.RUBY_PROC, executor);
				return;
			}
		}
	}
}
