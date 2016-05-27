package com.avansA5.noot.managers;

import com.avansA5.noot.Program;
import com.avansA5.noot.util.Log;
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
        Log.log("Starting ControlManager");

        //TODO: single/multi
        Wiimote[] _wiimotes = WiiUseApiManager.getWiimotes(2, true);

        if(_wiimotes==null || _wiimotes.length==0)
        {
            Log.error("No WiiMotes Connected");
            Program.stop();
        }

        wiimotes = new ArrayList(Arrays.asList(_wiimotes));

        for(int i = 0; i < wiimotes.size(); i++)
        {
            Log.log("Initializing wiimote "+i);
            Wiimote wiimote = wiimotes.get(i);
            if(i == 0)
                wiimote.setLeds(true, false, false, false);
            if(i == 1)
                wiimote.setLeds(false, true, false, false);

            wiimote.activateIRTRacking();
            wiimote.setSensorBarBelowScreen();
            wiimote.setIrSensitivity(0);
            wiimote.setIrSensitivity(3);

            Log.log("ControlManager started");
        }
    }

    public static void addWiimoteListener(WiimoteListener wiimoteListener, int i)
    {
        Log.log("Adding wiimoteListener for wiimote "+i);
        Wiimote wiimote = wiimotes.get(i);
        wiimote.addWiiMoteEventListeners(wiimoteListener);
    }
}