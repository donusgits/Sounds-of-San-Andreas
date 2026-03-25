package com.github.donus.cso.sounds;

import com.github.donus.cso.CSOConfig;
import static com.github.donus.cso.CSOPlugin.CJ;
import com.github.donus.cso.Sound;
import com.github.donus.cso.SoundEngine;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.events.ChatMessage;

@Singleton
@Slf4j
public class CombatAchievements
{

	@Inject
	private Client client;

	@Inject
	private CSOConfig config;

	@Inject
	private SoundEngine soundEngine;

	@Inject
	private ScheduledExecutorService executor;

	private static final Pattern COMBAT_TASK_REGEX = Pattern.compile("CA_ID:\\d+\\|Congratulations, you've completed an? \\w+ combat task:.*");

	public boolean onChatMessage(ChatMessage chatMessage)
	{
		if (!config.announceCombatAchievement() || !COMBAT_TASK_REGEX.matcher(chatMessage.getMessage()).matches())
		{
			return false;
		}
		if (config.showChatMessages())
		{
			client.addChatMessage(ChatMessageType.PUBLICCHAT, CJ, "Combat task: completed.", null);
		}
		soundEngine.playClip(Sound.COMBAT_TASK, executor);
		return true;
	}
}
