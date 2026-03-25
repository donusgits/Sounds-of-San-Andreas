# Custom Sound Overhaul
##### A [RuneLite](https://runelite.net/) plugin

Sound packs for your Runelite!
Contributions and suggestions are more than welcome.

This plugin is for all intents and purposes a fork of DapperMickie's [odablock-sounds](https://github.com/DapperMickie/odablock-sounds/) plugin, in which I reverse engineered its entirety whilst learning the Java language (and only having rudimentary Python experience), as well as using some of the systems they created and expanding upon others, such as having multiple 'packs' to select from.

Some `actions` (i.e. taking damage) may have multiple sounds— if that's the case, the sound will be chosen at random.
___
## General Troubleshooting
BEFORE TRYING ANYTHING ELSE, ENABLE THIS IN THE **RUNESCAPE** SETTINGS

![image](https://user-images.githubusercontent.com/62370532/208992085-e2c07494-d8bb-489e-b7f3-ed538175acbc.png)

Whenever this does not resolve your issue, please feel free to look in the [Issues](https://github.com/donusgits/Custom-Sound-Overhaul/issues) section of this GitHub page to see if anyone else had this issue.
______
## Customizing your sounds

### Warning

Because I have a system in place that automatically updates the sounds for this plugin, it is highly recommended to have a backup folder of your custom sounds. The system __will always__ override all the sounds whenever a sound update comes out. This means that after each sound update, you will have to replace all your custom sounds again.

### 1. Locate your `.runelite` folder

On Windows this is likely to be here: `C:\Users\<your username>\.runelite`

If you aren't sure, it's the same place that stores your `settings.properties`

Within this `.runelite` folder, there should be a `Custom-Sound-Overhaul` folder, which is where the sound files are downloaded to

### 2. Prepare your sound files

Make sure your files are all `.wav` format (just changing the extension won't work, actually convert them)

Make sure the file name __exactly__ matches the name of the existing file (in `Custom-Sound-Overhaul` folder) you want to replace

### 3. Understand how the files are handled

If you replace an existing file in `Custom-Sound-Overhaul` using exactly the same file name, your sound will be loaded instead

If you place a new file with an unexpected file name in `Custom-Sound-Overhaul`, it will be deleted

If you place a new folder inside `Custom-Sound-Overhaul` that is unexpected, this should be left as is, so can be used to store multiple sounds that you may want to swap in at a future date

If you want to revert to a default sound file, simply delete the relevant file in `Custom-Sound-Overhaul` and the default file will be re-downloaded when the plugin next starts

### 4. If it fails to play your sound

Remove your sound and make sure it plays the default sound for that event - if not, there is something misconfigured in your plugin _or in-game_ settings. For example, the collection log event can only be captured if your _in-game_ notifications for collection log slots are turned on

Check that your file is actually a valid `16-bit .wav` and not just a renamed `.mp3` or similar

Check that the file is still there in the `Custom-Sound-Overhaul` folder, if you accidentally used an incorrect file name, it won't have been loaded, and will have been deleted

### 5. Resetting all sounds

You can reset all the sounds by deleting the `Custom-Sound-Overhaul` folder and then reloading your client.
___
## Other information

### Current Sound Packs

You can find all the code [here](https://github.com/DapperMickie/odablock-sounds/tree/master/src/main/java/com/github/dappermickie/odablock/sounds) and all the sound packs [here](https://github.com/DapperMickie/odablock-sounds/tree/sounds-v2).

### Systems

I will be using systems produced by [DapperMickie]((https://github.com/DapperMickie/)) and co. including but not
limited to their Sound System, Snowball System and PK Systems.

### Planned / Work In Progress expansions

- GTA:SA sound pack
    - Custom-edited sounds, such as including CJ on-fire screams to OS Dragonfire etc.
- Minecraft sound pack

### Potential future expansions

- None other at the moment— open to suggestions.

### Known Issues

PulseAudio on Linux can just refuse to accept the audio formats used despite claiming to accept them (a carry-over issue
from Odablock Sounds.)
