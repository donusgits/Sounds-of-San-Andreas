package com.github.donus.sosa.sounds;

import com.github.donus.sosa.SOSAConfig;
import com.github.donus.sosa.Sound;
import com.github.donus.sosa.SoundEngine;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.api.Hitsplat;
import net.runelite.api.events.SoundEffectPlayed;
//import net.runelite.api.events.HitsplatApplied;
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
    private Hitsplat hitsplat;

    @Inject
    private SOSAConfig config;

    @Inject
    private SoundEngine soundEngine;

    @Inject
    private ScheduledExecutorService executor;

    //I don't know the significance of using -1 here is, I would have just done 0,
    //but I see -1 a lot, so I'm not going to ask questions until it stops working
    private int hitNumber = -1;
    private boolean notifyHit = false;
    private int lastLoginTick = -1;

    public void setLastLoginTick(int tick)
    {
        lastLoginTick = tick;
    }
 //   public void onGettingHit(HitsplatApplied hitsplatApplied)
    public void onGameTick(GameTick event)
    {
        if (config.announceHit() && hitsplat.isMine() && actuallyHit() && client.getTickCount() - lastLoginTick > 2 && lastLoginTick != -1)
        {
            soundEngine.playClip(Sound.GETTING_HIT, executor);
        }
    }

    private boolean actuallyHit()
    {		int currentHit = hitsplat.getAmount();
        if (hitNumber != currentHit)
        {
            hitNumber = currentHit;
        }
        else
        {
            return false;
        }
        if (hitNumber > 0)
        {
            if (!notifyHit)
            {
                notifyHit = true;
                return true;
            }
            else
            {
                notifyHit = false;
            }
        }
        return false;
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
                return;
            }
            //}
        }
    }
}
