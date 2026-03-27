package com.github.donus.sosa;

public enum Sound
{
	//Some start with '_1', some don't— if it doesn't matter, it doesn't matter, I guess.
	REDEMPTION_PROC("redemption", "RedemptionProc_r1.wav"),
	REDEMPTION_PROC_2("redemption", "RedemptionProc_r2.wav"),
	REDEMPTION_PROC_3("redemption", "RedemptionProc_r3.wav"),
	REDEMPTION_PROC_4("redemption", "RedemptionProc_r4.wav"),

	DEATH("death", "death1.wav"),
	DEATH_2("death", "death2.wav"),
	DEATH_3("death", "death3.wav"),
	DEATH_4("death", "death4.wav"),
	DEATH_5("death", "death5.wav"),
	DEATH_6("death", "death6.wav"),

	DRAGONFIRE("dragonfire" , "dragonfire1.wav"),
	DRAGONFIRE_2("dragonfire" , "dragonfire2.wav"),
	DRAGONFIRE_3("dragonfire" , "dragonfire3.wav"),

	COLLECTION_LOG_SLOT("collectionlog", "clog1.wav"),

	SMITED_NO_PRAYER("smited", "SmitedNoPrayer.wav"),

	GETTING_HIT("gettinghurt", "pain1.wav"),
	GETTING_HIT_2("gettinghurt", "pain2.wav"),
	GETTING_HIT_3("gettinghurt", "pain3.wav"),
	GETTING_HIT_4("gettinghurt", "pain4.wav"),
	GETTING_HIT_5("gettinghurt", "pain5.wav"),
	GETTING_HIT_6("gettinghurt", "pain6.wav"),
	GETTING_HIT_7("gettinghurt", "pain7.wav"),
	GETTING_HIT_8("gettinghurt", "pain8.wav"),

	NEW_PET("newpet", "pet1.wav"),
	NEW_PET_2("newpet", "pet2.wav"),
	NEW_PET_3("newpet", "pet3.wav"),

	SHOO_DOG("shoo", "shoo1.wav"),
	SHOO_DOG_2("shoo", "shoo2.wav"),
	SHOO_DOG_3("shoo", "shoo3.wav"),
	SHOO_DOG_4("shoo", "shoo4.wav"),
	SHOO_DOG_5("shoo", "shoo5.wav"),
	SHOO_DOG_6("shoo", "shoo6.wav"),

	DECLINE_TRADE("declinetrade", "tradedecline1.wav"),
	DECLINE_TRADE_2("declinetrade", "tradedecline.wav"),
	DECLINE_TRADE_3("declinetrade", "tradedecline.wav"),
	DECLINE_TRADE_4("declinetrade", "tradedecline.wav"),
	DECLINE_TRADE_5("declinetrade", "tradedecline.wav"),

	VENGEANCE("vengeance", "Vengeance1.wav"),
	VENGEANCE_2("vengeance", "Vengeance2.wav"),
	VENGEANCE_3("vengeance", "Vengeance3.wav"),
	VENGEANCE_4("vengeance", "Vengeance4.wav"),

	KILLING_SOMEONE_1("playerkilling", "pk1.wav"),
	KILLING_SOMEONE_2("playerkilling", "pk2.wav"),
	KILLING_SOMEONE_3("playerkilling", "pk3.wav"),
	KILLING_SOMEONE_4("playerkilling", "pk4.wav"),
	KILLING_SOMEONE_5("playerkilling", "pk5.wav"),
	KILLING_SOMEONE_6("playerkilling", "pk6.wav"),
	KILLING_SOMEONE_7("playerkilling", "pk7.wav"),

	REPORT_PLAYER_1("reportplayer", "report1.wav"),
	REPORT_PLAYER_2("reportplayer", "report2.wav"),

	COMBAT_TASK("quest", "quest1.wav"),
	ACHIEVEMENT_DIARY("quest", "quest1.wav"),
	QUEST("quest", "quest2.wav"),

	DDS_SPEC("ddsspec", "DdsSpec_r1.wav"),
	DDS_SPEC_2("ddsspec", "DdsSpec_r2.wav"),
	DDS_SPEC_3("ddsspec", "DdsSpec_r3.wav"),

	ACCEPTED_TRADE("accepttrade", "tradeaccept1.wav"),
	ACCEPTED_TRADE_2("accepttrade", "tradeaccept2.wav"),
	ACCEPTED_TRADE_3("accepttrade", "tradeaccept3.wav"),
	ACCEPTED_TRADE_4("accepttrade", "tradeaccept4.wav"),
	ACCEPTED_TRADE_5("accepttrade", "tradeaccept5.wav"),
	ACCEPTED_TRADE_6("accepttrade", "tradeaccept6.wav"),

	GETTING_PURPLE_1("gettingpurple", "purple1.wav"),
	GETTING_PURPLE_2("gettingpurple", "purple2.wav"),
	GETTING_PURPLE_3("gettingpurple", "purple3.wav"),
	GETTING_PURPLE_4("gettingpurple", "purple4.wav"),
	GETTING_PURPLE_5("gettingpurple", "purple5.wav"),
	GETTING_PURPLE_6("gettingpurple", "purple6.wav"),

	KILLING_RAT_OR_SCURRIUS_1("killingrat", "rat1.wav"),
	KILLING_RAT_OR_SCURRIUS_2("killingrat", "rat2.wav"),
	KILLING_RAT_OR_SCURRIUS_3("killingrat", "rat3.wav"),
	KILLING_RAT_OR_SCURRIUS_4("killingrat", "rat4.wav"),

	DISMISSING_RANDOM_EVENT("dismissrandomevent", "shoo1.wav"),
	DISMISSING_RANDOM_EVENT_2("dismissrandomevent", "shoo2.wav"),
	DISMISSING_RANDOM_EVENT_3("dismissrandomevent", "shoo3.wav"),
	DISMISSING_RANDOM_EVENT_4("dismissrandomevent", "shoo4.wav"),
	DISMISSING_RANDOM_EVENT_5("dismissrandomevent", "shoo5.wav"),
	DISMISSING_RANDOM_EVENT_6("dismissrandomevent", "shoo6.wav"),

	TYPING_IN_BANKPIN("typingbankpin", "TypingInBankPin.wav"),
	BANKPIN_ENTERED("typingbankpin", "EnterBank.wav"),
	BANKPIN_EXITED("typingbankpin", "ExitBank.wav"),

	TOA_CHEST_OPENS("toachestopens", "ToaChestOpens.wav"),

	ITEMPICKUP("itempickup", "pickup.wav"),

	WHITE_LIGHT_AFTER_RAID("whitelight", "WhiteLightAfterRaid.wav"),

	TURNING_ON_RUN("turningonrun", "TurningOnRun1.wav"),
	TURNING_ON_RUN_2("turningonrun", "TurningOnRun2.wav"),
	TURNING_ON_RUN_3("turningonrun", "TurningOnRun3.wav"),
	TURNING_ON_RUN_4("turningonrun", "TurningOnRun4.wav"),

	CLICKING_PK_LOOT_CHEST("pkchest", "ClickingPkLootChest1.wav"),
	CLICKING_PK_LOOT_CHEST_2("pkchest", "ClickingPkLootChest2.wav"),
	CLICKING_PK_LOOT_CHEST_3("pkchest", "ClickingPkLootChest3.wav"),
	CLICKING_PK_LOOT_CHEST_4("pkchest", "ClickingPkLootChest4.wav"),
	CLICKING_PK_LOOT_CHEST_5("pkchest", "ClickingPkLootChest5.wav"),

	RUBY_PROC("rubyproc", "RubyProc.wav"),//#13

	LEVEL_UP("levelup", "lvlup.wav"),

	HAIRDRESSER_SOUND_1("hairdresser", "Hairdresser_r1.wav"),
	HAIRDRESSER_SOUND_2("hairdresser", "Hairdresser_r2.wav");

	private final String resourceName;
	private final String directory;

	Sound(String directory, String resourceName)
	{
		this.directory = directory;
		this.resourceName = resourceName;
	}


	String getResourceName()
	{
		return resourceName;
	}

	String getDirectory()
	{
		return directory;
	}
}
