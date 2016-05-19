package com.avansA5.noot.managers;

import wiiusej.WiiUseApiManager;
import wiiusej.Wiimote;
import wiiusej.wiiusejevents.utils.WiimoteListener;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class ControlManager
{
    private static ArrayList<Wiimote> wiimotes;

    public static void start()
    {
        Wiimote[] _wiimotes = WiiUseApiManager.getWiimotes(1, true);
        wiimotes = new ArrayList(Arrays.asList(_wiimotes));

        for(int i = 0; i > wiimotes.size(); i++)
        {
            Wiimote wiimote = wiimotes.get(i);
            if(i == 0)
            {wiimote.setLeds(true, false, false, false);}
            if(i == 1)
            {wiimote.setLeds(false, true, false, false);}
            if(i == 2)
            {wiimote.setLeds(false, false, true, false);}
            if(i == 3)
            {wiimote.setLeds(false, false, false, true);}
            wiimote.activateMotionSensing();
        }
    }

    public void addWiimoteListener(WiimoteListener wiimoteListener, int i)
    {
        Wiimote wiimote = wiimotes.get(i);
        wiimote.addWiiMoteEventListeners(wiimoteListener);
    }
}