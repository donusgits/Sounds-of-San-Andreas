package com.github.donus.sosa.sounds;

import com.github.donus.sosa.*;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.VarbitChanged;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.ScheduledExecutorService;

import static com.github.donus.sosa.SOSAPlugin.CJ;

@Singleton
@Slf4j
public class TurnOnRun extends TimedSoundBase
{

	@Inject
	private Client client;

	@Inject
	private SOSAConfig config;

	@Inject
	private SoundEngine soundEngine;

	@Inject
	private ScheduledExecutorService executor;

	private boolean isRunning = false;

//	private final String message = "";
	private final String runOption = "Toggle Run";

	TurnOnRun()
	{
		super(10);
	}

	public void onVarbitChanged(VarbitChanged varbitChanged)
	{
		// Running varbit
		if (varbitChanged.getVarbitId() == SOSAVarbits.RUNNING.Id && varbitChanged.getVarpId() == SOSAVarbits.RUNNING.VarpId)
		{
			isRunning = varbitChanged.getValue() == SOSA.RUNNING_TRUE.Value;
		}
	}

	public void onMenuOptionClicked(MenuOptionClicked menuOptionClicked)
	{
		String option = menuOptionClicked.getMenuOption();
		MenuAction action = menuOptionClicked.getMenuAction();

		// Turning on run
		if (config.turnOnRun() && option.equals(runOption))
		{
			int currentTick = client.getTickCount();
			if (!isRunning && canPlaySound(currentTick))
			{
				if (config.showChatMessages())
				{
//					client.addChatMessage(ChatMessageType.PUBLICCHAT, CJ, message, null);
				}
				soundEngine.playClip(Sound.TURNING_ON_RUN, executor);
				setLastPlayedTickTick(currentTick);
			}
		}
	}
}
