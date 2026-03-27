package com.github.donus.sosa;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;

@ConfigGroup(SOSAConfig.CONFIG_GROUP)
public interface SOSAConfig extends Config
{
	String CONFIG_GROUP = "sosaplugin";

	@Range(
			min = 0,
			max = 200
	)
	@ConfigItem(
			keyName = "announcementVolume",
			name = "Announcement volume",
			description = "Adjust how loud the audio announcements are played!",
			position = 0
	)
	default int announcementVolume()
	{
		return 100;
	}

	@ConfigItem(
		keyName = "rubyBoltProc",
		name = "Ruby Bolt Rocket Launcher",
		description = "Should the ruby bolt proc be replaced with a Rocket Launcher firing?",
		position = 1
	)
	default boolean rubyBoltProc()
	{
		return true;
	}

	@ConfigItem(
		keyName = "announceHit",
		name = "Getting Hit",
		description = "Should CJ make painful sounds and grunts when he gets hit?",
		position = 2
	)
	default boolean announceHit()
	{
		return true;
	}

	@ConfigItem(
			keyName = "announceDeath",
			name = "When you die",
			description = "Should CJ say something when you die?",
			position = 3
	)
	default boolean announceDeath()
	{
		return true;
	}

	@ConfigItem(
		keyName = "playerKilling",
		name = "Player Killing",
		description = "Should CJ say something when you kill a player? (only works if you're still close to the player when he dies)",
		position = 4
	)
	default boolean playerKilling()
	{
		return true;
	}

	@ConfigItem(
			keyName = "pkChest",
			name = "PK Chest",
			description = "Should CJ say something whenever you open the PK chest?",
			position = 5
	)
	default boolean pkChest()
	{
		return true;
	}

	@ConfigItem(
		keyName = "bankPin",
		name = "Bank Pin",
		description = "Should the game make GTA UI sounds when you type in your bank pin?",
		position = 6
	)
	default boolean bankPin()
	{
		return true;
	}

	@ConfigItem(
		keyName = "turnOnRun",
		name = "Turn on run",
		description = "Should Fat CJ say something when you make him run?",
		position = 7
	)
	default boolean turnOnRun()
	{
		return true;
	}

	@ConfigItem(
		keyName = "shooDog",
		name = "Shoo the Dog",
		description = "Should CJ say something when you shoo away dogs?",
		position = 8
	)
	default boolean shooDog()
	{
		return true;
	}

	@ConfigItem(
		keyName = "dismissRandomEvent",
		name = "Dismiss random event",
		description = "Should CJ say something when you dismiss a random event?",
		position = 9
	)
	default boolean dismissRandomEvent()
	{
		return true;
	}

	@ConfigItem(
		keyName = "declineTrade",
		name = "Decline Trade",
		description = "Should CJ say something when you decline a trade?",
		position = 10
	)
	default boolean declineTrade()
	{
		return true;
	}


	@ConfigItem(
		keyName = "acceptTrade",
		name = "Accept Trade",
		description = "Should CJ say something when you accept a trade?",
		position = 11
	)
	default boolean acceptTrade()
	{
		return true;
	}

	@ConfigItem(
		keyName = "sendReport",
		name = "Send Report",
		description = "Should CJ cuss out the person you report?",
		position = 12
	)
	default boolean sendReport()
	{
		return true;
	}

	@ConfigItem(
		keyName = "announceLevelUp",
		name = "Level ups",
		description = "Should Tweleve (Orange 12) announce when you gain a level in a skill?",
		position = 13
	)
	default boolean announceLevelUp()
	{
		return true;
	}

	@ConfigItem(
		keyName = "announceLevelUpIncludesVirtual",
		name = "Include virtual level ups",
		description = "Should Tweleve (Orange 12) announce when you gain a virtual (>99) level in a skill?",
		position = 14
	)
	default boolean announceLevelUpIncludesVirtual()
	{
		return false;
	}

	@ConfigItem(
		keyName = "announceQuestCompletion",
		name = "Quest completions",
		description = "Should the Mission Complete jingle play when you complete a quest?",
		position = 15
	)
	default boolean announceQuestCompletion()
	{
		return true;
	}

	@ConfigItem(
		keyName = "prayerMessage",
		name = "Prayer Message",
		description = "Should CJ let you know when you run out of prayer?",
		position = 16
	)
	default boolean prayerMessage()
	{
		return true;
	}

	@ConfigItem(
		keyName = "redemptionMessage",
		name = "Redemption Message",
		description = "Should CJ let you know when you proc a Redemption?",
		position = 17
	)
	default boolean redemptionMessage()
	{
		return true;
	}

	@ConfigItem(
		keyName = "announceCollectionLog",
		name = "New collection log entry",
		description = "Should Tweleve (Orange 12) congratulate you when you fill in a new slot in your collection log? This one relies on you having chat messages (included with the popup option) enabled in game settings!",
		position = 18
	)
	default boolean announceCollectionLog()
	{
		return true;
	}

	@ConfigItem(
		keyName = "announceAchievementDiary",
		name = "Completed achievement diaries",
		description = "Should an alternate 'Mission Complete' jingle play when you complete a new achievement diary?",
		position = 19
	)
	default boolean announceAchievementDiary()
	{
		return true;
	}

	@ConfigItem(
		keyName = "announceCombatAchievement",
		name = "Completed combat achievement tasks",
		description = "Should an alternate 'Mission Complete' jingle play when you complete a new combat achievement task?",
		position = 20
	)
	default boolean announceCombatAchievement()
	{
		return true;
	}

	@ConfigItem(
			keyName = "vengeance",
			name = "Vengeance",
			description = "Should CJ say something when you cast Vengeance?",
			position = 21
	)
	default boolean vengeance()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showChatMessages",
		name = "Show fake public chat message (only you will see it)",
		description = "Should CJ/Tweleve announce your achievements in game chat as well as audibly?",
		position = 22
	)
	default boolean showChatMessages()
	{
		return true;
	}

	@ConfigItem(
		keyName = "hairDresser",
		name = "Hairdresser",
		description = "Should Old Reece say something whenever you open up the hairdresser interface in Falador?",
		position = 23
	)
	default boolean hairDresser()
	{
		return true;
	}

	@ConfigItem(
		keyName = "killingRat",
		name = "Killing rat (or Scurrius)",
		description = "Should CJ say something whenever you kill a rat or Scurrius?",
		position = 24
	)
	default boolean killingRat()
	{
		return true;
	}

	@ConfigItem(
		keyName = "receivedPet",
		name = "Received pet",
		description = "Should CJ say something whenever you receive a pet?",
		position = 25
	)
	default boolean receivedPet()
	{
		return true;
	}

	@ConfigItem(
			keyName = "dragonfire",
			name = "Dragonbreath",
			description = "Should CJ scream in agony whenever he gets hit with Dragonbreath?",
			position = 26
	)
	default boolean dragonfire()
	{
		return true;
	}

	@ConfigSection(
		name = "Tombs of Amascut",
		description = "All the configurations regarding Tombs of Amascut.",
		position = 100
	)
	String TOA_SECTION = "toaSection";

	@ConfigItem(
		keyName = "toaWhiteChest",
		name = "TOA White Chest",
		description = "When enabled, CJ will say something if you receive a white light.",
		section = TOA_SECTION,
		position = 101
	)
	default boolean toaWhiteChest()
	{
		return true;
	}

	@ConfigItem(
		keyName = "toaPurpleChest",
		name = "TOA Purple Chest",
		description = "When enabled, CJ will say something if you receive a purple.",
		section = TOA_SECTION,
		position = 102
	)
	default boolean toaPurpleChest()
	{
		return true;
	}

	@ConfigSection(
		name = "Theatre of Blood",
		description = "All the configurations regarding Theatre of Blood.",
		position = 200
	)
	String TOB_SECTION = "tobSection";

	@ConfigItem(
		keyName = "tobWhiteChest",
		name = "TOB White chest",
		description = "Should CJ say something whenever you receive a white chest at TOB?",
		section = TOB_SECTION,
		position = 201
	)
	default boolean tobWhiteChest()
	{
		return true;
	}

	@ConfigItem(
		keyName = "tobPurpleChest",
		name = "TOB Purple chest",
		description = "Should CJ say something whenever you receive a purple chest at TOB?",
		section = TOB_SECTION,
		position = 202
	)
	default boolean tobPurpleChest()
	{
		return true;
	}

	@ConfigSection(
		name = "Chambers of Xeric",
		description = "All the configurations regarding Chambers of Xeric.",
		position = 300
	)
	String COX_SECTION = "coxSection";

	@ConfigItem(
		keyName = "coxWhiteChest",
		name = "COX White chest",
		description = "Should CJ say something whenever you get a white light at COX?",
		section = COX_SECTION,
		position = 301
	)
	default boolean coxWhiteChest()
	{
		return true;
	}

	@ConfigItem(
		keyName = "coxPurpleChest",
		name = "COX Purple chest",
		description = "Should CJ say something whenever you get a purple light at COX?",
		section = COX_SECTION,
		position = 302
	)
	default boolean coxPurpleChest()
	{
		return true;
	}

	@ConfigSection(
		name = "Developer",
		description = "Developer mode configurations.",
		position = 400
	)
	String DEVELOPER_SECTION = "developerSection";

	@ConfigItem(
		keyName = "developerLogging",
		name = "Developer Logging",
		description = "Enable developer logging when developer mode is active.",
		section = DEVELOPER_SECTION,
		position = 401
	)
	default boolean developerLogging()
	{
		return false;
	}
}
