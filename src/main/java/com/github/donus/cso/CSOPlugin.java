package com.github.donus.cso;

import com.github.donus.cso.sounds.*;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.events.*;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import okhttp3.OkHttpClient;

import javax.inject.Inject;
import java.util.concurrent.ScheduledExecutorService;

@Slf4j
@PluginDescriptor(
	name = "Custom Sound Overhaul",
	description = "Sound packs for your Runelite",
	tags = {"GTA", "san", "andreas", "minecraft", "stats", "levels", "quests", "diary", "announce"}
)

public class CSOPlugin extends Plugin
{
	@Inject
	private Client client;

	@Getter(AccessLevel.PACKAGE)
	@Inject
	private ClientThread clientThread;

	@Inject
	private SoundEngine soundEngine;

	@Inject
	private CSOConfig config;

	@Inject
	private ScheduledExecutorService executor;

	@Inject
	private OkHttpClient okHttpClient;

	// Start of sound injections
	@Inject
	private LevelUp levelUp;

	@Inject
	private DdsSpec ddsSpec;

	@Inject
	private AgsSpec agsSpec;

	@Inject
	private Death death;

	@Inject
	private AcceptTrade acceptTrade;

	@Inject
	private ShooDog shooDog;

	@Inject
	private DebugScripts debugScripts;

	@Inject
	private PrayerDown prayerDown;

	@Inject
	private TurnOnRun turnOnRun;

	@Inject
	private ReportPlayer reportPlayer;

	@Inject
	private DeclineTrade declineTrade;

	@Inject
	private DismissRandomEvent dismissRandomEvent;

	@Inject
	private EnteringBankPin enteringBankPin;

	@Inject
	private Pet pet;

	@Inject
	private KillingRat killingRat;

	@Inject
	private ToaChestLight toaChestLight;

	@Inject
	private ToaChestOpens toaChestOpens;

	@Inject
	private TobChestLight tobChestLight;

	@Inject
	private CollectionLog collectionLog;

	@Inject
	private QuestCompleted questCompleted;

	@Inject
	private CombatAchievements combatAchievements;

	@Inject
	private AchievementDiaries achievementDiaries;

	@Inject
	private GiveBone giveBone;

	@Inject
	private HairDresser hairDresser;

	@Inject
	private PkChest pkChest;

	@Inject
	private Vengeance vengeance;

	@Inject
	private CoxSounds coxSounds;

	@Inject
	private KillingPlayer killingPlayer;
	// End of sound injections

	@Inject
	@Named("developerMode")
	private boolean developerMode;

	public static final String CJ = "Carl Johnson";

	@Override
	protected void startUp() throws Exception
	{
		clientThread.invoke(this::setupOldMaps);
		achievementDiaries.setLastLoginTick(-1);
		prayerDown.setLastLoginTick(-1);
		executor.submit(() -> {
			PlayerKillLineManager.Setup(okHttpClient);
			SoundFileManager.ensureDownloadDirectoryExists();
			SoundFileManager.downloadAllMissingSounds(okHttpClient);
			SnowballUserManager.ensureDownloadDirectoryExists();
			SnowballUserManager.downloadSnowballUsers(okHttpClient);
		});
	}

	@Override
	protected void shutDown() throws Exception
	{
		levelUp.clear();
		achievementDiaries.clearOldAchievementDiaries();
		soundEngine.close();
	}

	private void setupOldMaps()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			levelUp.clear();
			achievementDiaries.clearOldAchievementDiaries();
		}
		else
		{
			levelUp.setOldExperience();
			achievementDiaries.setOldAchievementDiaries();
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		collectionLog.onGameStateChanged(event);
		switch (event.getGameState())
		{
			case LOGIN_SCREEN:
			case HOPPING:
			case LOGGING_IN:
			case LOGIN_SCREEN_AUTHENTICATOR:
				levelUp.clear();
				achievementDiaries.clearOldAchievementDiaries();
			case CONNECTION_LOST:
				// set to -1 here in-case of race condition with varbits changing before this handler is called
				// when game state becomes LOGGED_IN
				//soundEngine.playClip(Sound.CLIENT_DISCONNECTS, executor);

				achievementDiaries.setLastLoginTick(-1);
				prayerDown.setLastLoginTick(-1);
				collectionLog.setlastColLogSettingWarning();
				break;
			case LOGGED_IN:
				final int currentTick = client.getTickCount();
				achievementDiaries.setLastLoginTick(currentTick);
				prayerDown.setLastLoginTick(currentTick);
				break;
		}
	}

	@Subscribe
	public void onStatChanged(StatChanged statChanged)
	{
		levelUp.onStatChanged(statChanged);
	}

	@Subscribe
	public void onActorDeath(ActorDeath actorDeath)
	{
		death.onActorDeath(actorDeath);
	}


	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{

		if (acceptTrade.onChatMessage(chatMessage))
		{
			return;
		}
		else if (shooDog.onChatMessage(chatMessage))
		{
			return;
		}
		else if (pet.onChatMessage(chatMessage))
		{
			return;
		}
		else if (killingRat.onChatMessage(chatMessage))
		{
			return;
		}
		else if (chatMessage.getType() != ChatMessageType.GAMEMESSAGE && chatMessage.getType() != ChatMessageType.SPAM)
		{
			return;
		}
		else if (collectionLog.onChatMessage(chatMessage))
		{
			return;

		}
		else if (questCompleted.onChatMessage(chatMessage))
		{
			return;
		}
		else if (combatAchievements.onChatMessage(chatMessage))
		{
			return;
		}
		else if (giveBone.onChatMessage(chatMessage))
		{
			return;
		}
		else if (killingPlayer.onChatMessage(chatMessage))
		{
			return;
		}
		else if (coxSounds.onChatMessage(chatMessage))
		{
			return;
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (developerMode && config.developerLogging())
		{
			debugScripts.onVarbitChanged(event);
		}

		vengeance.onVarbitChanged(event);
		turnOnRun.onVarbitChanged(event);
		tobChestLight.onVarbitChanged(event);
		collectionLog.onVarbitChanged(event);
		achievementDiaries.onVarbitChanged(event);
		killingPlayer.onVarbitChanged(event);
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked menuOptionClicked)
	{
		if (developerMode && config.developerLogging())
		{
			debugScripts.onMenuOptionClicked(menuOptionClicked);
		}

		shooDog.onMenuOptionClicked(menuOptionClicked);
		turnOnRun.onMenuOptionClicked(menuOptionClicked);
		reportPlayer.onMenuOptionClicked(menuOptionClicked);
		declineTrade.onMenuOptionClicked(menuOptionClicked);
		dismissRandomEvent.onMenuOptionClicked(menuOptionClicked);
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (developerMode && config.developerLogging())
		{
			debugScripts.onWidgetLoaded(event);
		}

		hairDresser.onWidgetLoaded(event);
		pkChest.onWidgetLoaded(event);
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		killingRat.onNpcDespawned(npcDespawned);
	}

	@Provides
	CSOConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CSOConfig.class);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (CSOConfig.CONFIG_GROUP.equals(event.getGroup()))
		{
			collectionLog.onConfigChanged(event);
		}
	}

	@Subscribe
	public void onInteractingChanged(InteractingChanged event)
	{
		killingRat.onInteractingChanged(event);
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}
		final Player local = client.getLocalPlayer();
		int currentTick = client.getTickCount();

		ddsSpec.onTick(currentTick, local);
		agsSpec.onTick(currentTick, local);
		prayerDown.onGameTick(event);
		tobChestLight.onGameTick(event);
		coxSounds.onGameTick(event);

		// Should always happen after all tick events
		cleanupTicks(currentTick);
	}

	private void cleanupTicks(final int currentTick)
	{
		agsSpec.cleanupTicks(currentTick);
		ddsSpec.cleanupTicks(currentTick);
		shooDog.cleanupTicks(currentTick);
	}

	@Subscribe
	public void onSoundEffectPlayed(SoundEffectPlayed event)
	{
		enteringBankPin.onSoundEffectPlayed(event);
		agsSpec.onSoundEffectPlayed(event);
		ddsSpec.onSoundEffectPlayed(event);
		prayerDown.onSoundEffectPlayed(event);
	}

	@Subscribe
	public void onWallObjectSpawned(final WallObjectSpawned event)
	{
		toaChestLight.onWallObjectSpawned(event);
	}

	@Subscribe
	private void onGameObjectSpawned(GameObjectSpawned event)
	{
		toaChestOpens.onGameObjectSpawned(event);
		tobChestLight.onGameObjectSpawned(event);
	}

	@Subscribe
	private void onGameObjectDespawned(GameObjectDespawned event)
	{
		tobChestLight.onGameObjectDespawned(event);
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent scriptCallbackEvent)
	{
		if (developerMode && config.developerLogging())
		{
			debugScripts.onScriptCallbackEvent(scriptCallbackEvent);
		}
	}

	public static int TO_GROUP(int id)
	{
		return id >>> 16;
	}
}
