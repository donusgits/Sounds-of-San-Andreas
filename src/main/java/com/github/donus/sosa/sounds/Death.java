package com.github.donus.sosa.sounds;

import com.github.donus.sosa.SOSAConfig;
import com.github.donus.sosa.Sound;
import com.github.donus.sosa.SoundEngine;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.ActorDeath;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.ScheduledExecutorService;

@Singleton
@Slf4j
public class Death
{

	@Inject
	private Client client;

	@Inject
	private SOSAConfig config;

	@Inject
	private SoundEngine soundEngine;

	@Inject
	private ScheduledExecutorService executor;


	public void onActorDeath(ActorDeath actorDeath)
	{
		if (config.announceDeath() && actorDeath.getActor() == client.getLocalPlayer())
		{
//			if (config.showChatMessages())
//			{
//				client.addChatMessage(ChatMessageType.PUBLICCHAT, CJ, "It must be a glitch?!?!", null);
//			}
			soundEngine.playClip(Sound.DEATH, executor);
		}
	}
}
