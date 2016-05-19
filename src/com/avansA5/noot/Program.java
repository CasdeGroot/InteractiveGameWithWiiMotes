package com.avansA5.noot;

import com.avansA5.noot.managers.ControlManager;
import com.avansA5.noot.managers.GameManager;
import com.avansA5.noot.managers.WindowManager;

public class Program
{
    public static final String TITLE  = "Cas & Michael";
    public static void main(String[] args)
    {
        ControlManager.start();
        WindowManager.start();
        GameManager.start();
    }
}
