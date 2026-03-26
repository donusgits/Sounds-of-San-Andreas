package com.github.donus.sosa.sounds;

import com.github.donus.sosa.SOSAConfig;
import com.github.donus.sosa.Sound;
import com.github.donus.sosa.SoundEngine;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.SoundEffectPlayed;
import net.runelite.api.events.HitsplatApplied;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.ScheduledExecutorService;

@Singleton
@Slf4j
public class Pain
{

    @Inject
    private Client client;

    @Inject
    private SOSAConfig config;

    @Inject
    private SoundEngine soundEngine;

    @Inject
    private ScheduledExecutorService executor;

    public void onHitsplatApplied(HitsplatApplied hitsplatApplied)
    {
        if (config.announceHit() && hitsplatApplied.getActor() == client.getLocalPlayer() && hitsplatApplied.getHitsplat().getAmount() > 0)
        {
            soundEngine.playClip(Sound.GETTING_HIT, executor);
        }
    }

    public void onSoundEffectPlayed(SoundEffectPlayed event)
    {
        int soundId = event.getSoundId();

        if (config.announceHit())
        {
            //I don't know how to add a range to SoundIDs, so I'm just gonna do it manually here
            if (soundId == 518 || soundId == 519 || soundId == 520 || soundId == 521)
            {
                event.consume();
            }
            //}
        }
    }
}
