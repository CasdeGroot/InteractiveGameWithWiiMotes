package com.avansA5.noot;

import com.avansA5.noot.managers.ControlManager;
import com.avansA5.noot.managers.GameManager;
import com.avansA5.noot.managers.WindowManager;

public class Program
{
    public static final String TITLE  = "Fired up 0.1 pre beta release of the bleeding edge alpha";

    public static void start()
    {
        ControlManager.start();
        WindowManager.start();
        GameManager.start();
    }

    public static void stop()
    {
        System.exit(0);
    }

    public static void main(String[] args)
    {
        System.setProperty("sun.java2d.opengl", "True");
        Program.start();
    }
}
