package com.avansA5.noot.objects.characters;

import com.avansA5.noot.interfaces.Hittable;
import com.avansA5.noot.managers.ControlManager;
import com.avansA5.noot.types.Vector2D;
import wiiusej.wiiusejevents.physicalevents.*;
import wiiusej.wiiusejevents.utils.WiimoteListener;
import wiiusej.wiiusejevents.wiiuseapievents.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

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

        try {
            sprite = ImageIO.read(new File("res/Dragon.png"));
            vector = new Vector2D(20, 20, sprite.getWidth(), sprite.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(sprite, (int)vector.getX(), (int)vector.getY(), null);
    }

    @Override
    public void onHit(Hittable sender)
    {

    }

    @Override
    public void update()
    {
        vector.setX(vector.getX()+vector.getSpeedX());
        vector.setY(vector.getY()+vector.getSpeedY());
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
    public void onMotionSensingEvent(MotionSensingEvent motionSensingEvent) {

    }

    @Override
    public void onExpansionEvent(ExpansionEvent expansionEvent)
    {
        NunchukEvent n;
        n = (NunchukEvent)expansionEvent;
        if(n.isThereNunchukJoystickEvent());
        {
            double angle = n.getNunchukJoystickEvent().getAngle();
            double magnitude = n.getNunchukJoystickEvent().getMagnitude();
            double deg = Math.toRadians(angle);

            double _x = magnitude * Math.sin(deg);
            double _y = magnitude * Math.cos(deg);

            vector.setSpeedX(_x);
            vector.setSpeedY(_y);
//
//            double x = _x;
//            double y = _y*-1;

        }
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
