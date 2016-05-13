package com.avansA5.noot.managers;


import com.avansA5.noot.scenes.Scene;
import com.avansA5.noot.util.Log;

import java.awt.*;
import java.util.HashMap;

class SceneManager
{
    static Scene currentScene;
    static HashMap<String, Scene> scenes = new HashMap<>();

    public static void start()
    {
        Log.log("Starting SceneManager");

        setScene("");
    }

    static void setScene(String name)
    {
        if (currentScene != null)
            currentScene.unload();
        currentScene = scenes.get(name);
        currentScene.load();
        Log.log("Loaded scene: " + name);
    }

    static void draw(Graphics2D g2)
    {
        if (currentScene != null)
            currentScene.draw(g2);
    }

    static void update()
    {
        if (currentScene != null)
            currentScene.update();
    }

    public static void onClick(Point point)
    {
        currentScene.getUiElements().parallelStream().filter(e -> e.getRect().contains(point)).forEach(e -> e.onClick(point));
    }
}
