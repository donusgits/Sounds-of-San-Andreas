package com.github.donus.cso.sounds;

import com.github.donus.cso.CSOConfig;
import com.github.donus.cso.Sound;
import com.github.donus.cso.SoundEngine;
import com.github.donus.cso.SoundIds;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.SoundEffectPlayed;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.ScheduledExecutorService;

@Singleton
@Slf4j
public class EnteringBankPin
{

	@Inject
	private Client client;

	@Inject
	private CSOConfig config;

	@Inject
	private SoundEngine soundEngine;

	@Inject
	private ScheduledExecutorService executor;

	public void onSoundEffectPlayed(SoundEffectPlayed event)
	{
		int soundId = event.getSoundId();

		if (config.bankPin())
		{
			if (soundId == SoundIds.BANK_PIN.Id)
			{
				event.consume();
				soundEngine.playClip(Sound.TYPING_IN_BANKPIN, executor);
				return;
			}
		}
	}
}
