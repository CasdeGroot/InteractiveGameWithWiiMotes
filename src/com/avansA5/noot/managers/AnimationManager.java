package com.avansA5.noot.managers;

import com.avansA5.noot.objects.Animation;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class AnimationManager
{
    static CopyOnWriteArrayList<Animation> animations = new CopyOnWriteArrayList<>();
    static Thread updateThread;
    public static void start()
    {
        updateThread = new Thread(() -> updater());
        updateThread.start();
    }

    private static void updater()
    {
        while(true)
        {
            Iterator<Animation> iterator = animations.iterator();
            while (iterator.hasNext())
            {
                Animation a = iterator.next();
                a.update();
            }
        }
    }

    public static void addAnimation(Animation animation)
    {
        animations.add(animation);
    }

    public static void removeAnimation(Animation animation)
    {
        animations.remove(animation);
    }
}
