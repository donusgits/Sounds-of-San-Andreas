package com.github.donus.sosa.sounds;

import com.github.donus.sosa.SOSAConfig;
import com.github.donus.sosa.Sound;
import com.github.donus.sosa.SoundEngine;
import com.github.donus.sosa.SoundIds;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.events.SoundEffectPlayed;
import net.runelite.api.events.HitsplatApplied;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.ScheduledExecutorService;

@Singleton
@Slf4j
public class Dragonfire
{

    @Inject
    private Client client;

    @Inject
    private SOSAConfig config;

    @Inject
    private SoundEngine soundEngine;

    @Inject
    private HitsplatApplied hitsplatApplied;

    @Inject
    private ScheduledExecutorService executor;

    public void onSoundEffectPlayed(SoundEffectPlayed event)
    {
        int soundId = event.getSoundId();

        if (config.dragonfire() && hitsplatApplied.getActor() == client.getLocalPlayer() && hitsplatApplied.getHitsplat().getAmount() > 0 && soundId == SoundIds.DRAGON_FIRE.Id)
        {
                event.consume();
                soundEngine.playClip(Sound.DRAGONFIRE, executor);
                return;
        }
    }
}
