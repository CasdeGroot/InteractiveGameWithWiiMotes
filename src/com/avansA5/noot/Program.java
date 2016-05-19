package com.avansA5.noot;

import com.avansA5.noot.managers.GameManager;
import com.avansA5.noot.managers.WindowManager;

public class Program
{
    public static final String TITLE  = "NOOTNOOT";
    public static void main(String[] args)
    {
        WindowManager.start();
        GameManager.start();
    }
}
