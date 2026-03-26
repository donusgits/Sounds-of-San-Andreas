package com.github.donus.sosa.sounds;

import com.github.donus.sosa.SOSAConfig;
import com.github.donus.sosa.Sound;
import com.github.donus.sosa.SoundEngine;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.Player;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.util.Text;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.ScheduledExecutorService;

@Singleton
@Slf4j
public class ShooDog
{
		//This was adapted from Pet Dog from Odablock sounds, which seems to have depended on line 70
		//pointing to a very specific menu option ID, which basically means I either have to find the
		//ID for shooing a stray dog, or just nuke this— and I have no idea how to find menu option
		//IDs. Could be a plugin for that.

	@Inject
	private Client client;

	@Inject
	private SOSAConfig config;

	@Inject
	private SoundEngine soundEngine;

	@Inject
	private ScheduledExecutorService executor;
	private final String shooOption = "Shoo-away";
	private final String messageByClient = "Thbbbbt!";

	private int lastShooDogTick = -1;

	public boolean onChatMessage(ChatMessage chatMessage)
	{
		int currentTick = client.getTickCount();
		Player local = client.getLocalPlayer();
		// Shooing the dog sound, only play sound when message is sent by local player within 15ticks of shooing the dog
		if (config.shooDog() &&
			// Shoo-away dog message
			Text.standardize(chatMessage.getMessage()).equals(messageByClient) &&
			// sent by current local user
			Text.standardize(chatMessage.getName()).equals(Text.standardize(local.getName())))
		{
			// Check if last shoo dog click is within 15 ticks
			if (lastShooDogTick == -1 || currentTick - lastShooDogTick < 15)
			{
				soundEngine.playClip(Sound.SHOO_DOG, executor);
				return true;
			}
		}
		return false;
	}

	public void onMenuOptionClicked(MenuOptionClicked menuOptionClicked)
	{
		int currentTick = client.getTickCount();

		String option = menuOptionClicked.getMenuOption();
		MenuAction action = menuOptionClicked.getMenuAction();


		// Shooing the dog
						//wtf does this number mean? Oh well.
//		if (config.shooDog() && menuOptionClicked.getId() == 23766 && option.equals(shooOption))
		if (config.shooDog() && option.equals(shooOption))
		{
			lastShooDogTick = currentTick;
		}
	}

	public void cleanupTicks(int currentTick)
	{
		if (lastShooDogTick != currentTick &&
			currentTick - lastShooDogTick > 15)
		{
			lastShooDogTick = -1;
		}
	}
}
