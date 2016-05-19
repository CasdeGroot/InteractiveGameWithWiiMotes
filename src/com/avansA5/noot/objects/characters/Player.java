package com.avansA5.noot.objects.characters;

import com.avansA5.noot.interfaces.Hittable;
import com.avansA5.noot.managers.ControlManager;
import wiiusej.wiiusejevents.physicalevents.ExpansionEvent;
import wiiusej.wiiusejevents.physicalevents.IREvent;
import wiiusej.wiiusejevents.physicalevents.MotionSensingEvent;
import wiiusej.wiiusejevents.physicalevents.WiimoteButtonsEvent;
import wiiusej.wiiusejevents.utils.WiimoteListener;
import wiiusej.wiiusejevents.wiiuseapievents.*;

import java.awt.*;

/**
 * Created by Cas on 19/05/2016.
 */
public class Player extends Character implements WiimoteListener
{

    int playerId;
    public Player(int player)
    {
        ControlManager.addWiimoteListener(this, player);
        playerId = player;
    }
    @Override
    public void draw(Graphics2D g2) {

    }

    @Override
    public void onHit(Hittable sender) {

    }

    @Override
    public void update() {

    }

    @Override
    public void onButtonsEvent(WiimoteButtonsEvent wiimoteButtonsEvent)
    {

    }

    @Override
    public void onIrEvent(IREvent irEvent)
    {

    }

    @Override
    public void onMotionSensingEvent(MotionSensingEvent motionSensingEvent)
    {

    }

    @Override
    public void onExpansionEvent(ExpansionEvent expansionEvent)
    {

    }

    @Override
    public void onStatusEvent(StatusEvent statusEvent)
    {

    }

    @Override
    public void onDisconnectionEvent(DisconnectionEvent disconnectionEvent)
    {

    }

    @Override
    public void onNunchukInsertedEvent(NunchukInsertedEvent nunchukInsertedEvent)
    {

    }

    @Override
    public void onNunchukRemovedEvent(NunchukRemovedEvent nunchukRemovedEvent)
    {

    }

    @Override
    public void onGuitarHeroInsertedEvent(GuitarHeroInsertedEvent guitarHeroInsertedEvent)
    {

    }

    @Override
    public void onGuitarHeroRemovedEvent(GuitarHeroRemovedEvent guitarHeroRemovedEvent)
    {

    }

    @Override
    public void onClassicControllerInsertedEvent(ClassicControllerInsertedEvent classicControllerInsertedEvent)
    {

    }

    @Override
    public void onClassicControllerRemovedEvent(ClassicControllerRemovedEvent classicControllerRemovedEvent)
    {

    }
}
