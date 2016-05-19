package com.avansA5.noot.managers;


import com.avansA5.noot.util.Log;

import javax.swing.*;

public class GameManager
{
    private static int tickCount = 0;
    public static void start()
    {
        Log.log("Starting GameManager");
        new Timer(1000 / 60, e -> update()).start();
    }

    static void update()
    {
        tickCount++;
        SceneManager.update();
    }
}
