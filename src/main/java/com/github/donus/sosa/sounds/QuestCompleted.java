package com.github.donus.sosa.sounds;

import com.github.donus.sosa.SOSAConfig;
import static com.github.donus.sosa.SOSAPlugin.CJ;
import com.github.donus.sosa.Sound;
import com.github.donus.sosa.SoundEngine;
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
public class QuestCompleted
{

	@Inject
	private Client client;

	@Inject
	private SOSAConfig config;

	@Inject
	private SoundEngine soundEngine;

	@Inject
	private ScheduledExecutorService executor;

	private static final Pattern QUEST_REGEX = Pattern.compile("Congratulations, you've completed a quest:.*");

	public boolean onChatMessage(ChatMessage chatMessage)
	{
		if (!config.announceQuestCompletion() || !QUEST_REGEX.matcher(chatMessage.getMessage()).matches())
		{
			return false;
		}
		if (config.showChatMessages())
		{
			client.addChatMessage(ChatMessageType.PUBLICCHAT, CJ, "Quest: completed.", null);
		}
		soundEngine.playClip(Sound.QUEST, executor);
		return true;
	}
}
