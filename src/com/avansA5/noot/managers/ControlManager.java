package com.avansA5.noot.managers;

import wiiusej.WiiUseApiManager;
import wiiusej.Wiimote;

import java.util.ArrayList;
import java.util.Arrays;

public class ControlManager
{
    public static ArrayList<Wiimote> wiimotes;
    public static void start()
    {
        Wiimote[] _wiimotes = WiiUseApiManager.getWiimotes(1, true);
        wiimotes = new ArrayList(Arrays.asList(_wiimotes));

        for(int i = 0; i > wiimotes.size(); i++)
        {

        }
    }
}