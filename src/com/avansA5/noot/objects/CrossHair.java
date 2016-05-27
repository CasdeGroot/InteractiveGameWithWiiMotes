package com.avansA5.noot.objects;

import com.avansA5.noot.managers.ControlManager;
import com.avansA5.noot.util.Log;
import wiiusej.wiiusejevents.physicalevents.ExpansionEvent;
import wiiusej.wiiusejevents.physicalevents.IREvent;
import wiiusej.wiiusejevents.physicalevents.MotionSensingEvent;
import wiiusej.wiiusejevents.physicalevents.WiimoteButtonsEvent;
import wiiusej.wiiusejevents.utils.WiimoteListener;
import wiiusej.wiiusejevents.wiiuseapievents.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Cas on 20/05/2016.
 */
public class CrossHair extends GameObject implements WiimoteListener {

    public Point getLocation()
    {
        return location;
    }

    Point location;
    BufferedImage image;
    String imageString;

    public CrossHair(int player)
    {
        Log.log("Constructing crosshair for player "+player);
        if(player == 0){imageString = "res/BlueCrossHair.png";}
        else {imageString = "res/RedCrossHair.png";}

        try {
            image = ImageIO.read(new File(imageString));
        } catch (IOException e) {
            e.printStackTrace();
        }

        location = new Point(50,50);

        Log.log("Crosshair for player "+player+" constructed");
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(image, location.x, location.y, image.getWidth()/5, image.getHeight()/5, null);
    }

    @Override
    public void update() {

    }

    @Override
    public void onButtonsEvent(WiimoteButtonsEvent wiimoteButtonsEvent) {

    }

    @Override
    public void onIrEvent(IREvent irEvent) {

        location.x = irEvent.getAx() * 2;
        location.y = irEvent.getAy() * 2;
    }

    @Override
    public void onMotionSensingEvent(MotionSensingEvent motionSensingEvent) {

    }

    @Override
    public void onExpansionEvent(ExpansionEvent expansionEvent) {

    }

    @Override
    public void onStatusEvent(StatusEvent statusEvent) {

    }

    @Override
    public void onDisconnectionEvent(DisconnectionEvent disconnectionEvent) {

    }

    @Override
    public void onNunchukInsertedEvent(NunchukInsertedEvent nunchukInsertedEvent) {

    }

    @Override
    public void onNunchukRemovedEvent(NunchukRemovedEvent nunchukRemovedEvent) {

    }

    @Override
    public void onGuitarHeroInsertedEvent(GuitarHeroInsertedEvent guitarHeroInsertedEvent) {

    }

    @Override
    public void onGuitarHeroRemovedEvent(GuitarHeroRemovedEvent guitarHeroRemovedEvent) {

    }

    @Override
    public void onClassicControllerInsertedEvent(ClassicControllerInsertedEvent classicControllerInsertedEvent) {

    }

    @Override
    public void onClassicControllerRemovedEvent(ClassicControllerRemovedEvent classicControllerRemovedEvent) {

    }
}
