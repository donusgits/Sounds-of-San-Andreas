package com.github.donus.cso.sounds;

import com.github.donus.cso.CSOConfig;
import com.github.donus.cso.Sound;
import com.github.donus.cso.SoundEngine;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.events.ActorDeath;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.ScheduledExecutorService;

import static com.github.donus.cso.CSOPlugin.CJ;

@Singleton
@Slf4j
public class Death
{

	@Inject
	private Client client;

	@Inject
	private CSOConfig config;

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
