package com.avansA5.noot.managers;


import com.avansA5.noot.util.Log;

import javax.swing.*;

public class GameManager
{
    public static void start()
    {
        Log.log("Starting GameManager");
        new Timer(1000 / 60, e -> update()).start();
    }

    static void update()
    {
        SceneManager.update();
    }

}
