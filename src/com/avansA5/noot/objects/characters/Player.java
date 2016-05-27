package com.avansA5.noot.objects.characters;

import com.avansA5.noot.managers.ControlManager;
import com.avansA5.noot.objects.Bullet;
import com.avansA5.noot.objects.CrossHair;
import com.avansA5.noot.objects.GameObject;
import com.avansA5.noot.types.State;
import com.avansA5.noot.types.Vector2D;
import com.avansA5.noot.types.WiimoteButtons;
import com.avansA5.noot.util.Log;
import wiiusej.wiiusejevents.physicalevents.*;
import wiiusej.wiiusejevents.utils.WiimoteListener;
import wiiusej.wiiusejevents.wiiuseapievents.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * Created by Cas on 19/05/2016.
 */
public class Player extends GameObject implements WiimoteListener
{
    private BufferedImage sprite;
    CrossHair crossHair;
    private BufferedImage redSprite;
    private BufferedImage blueSprite;
    private int playerId;
    State state;

    boolean switchLock = false;
    private CrossHair ch;
    private double lookAngle;
    private double moveAngle;
    private double magnitude;
    private double deviation;
    private double speed;

    public Player(int player, CrossHair crossHair)
    {
        Log.log("Constructing player "+player);
        this.ch = crossHair;
        ControlManager.addWiimoteListener(this, player);
        playerId = player;

        try {
            redSprite = ImageIO.read(new File("res/PlayerRed.png"));
            blueSprite = ImageIO.read(new File("res/PlayerBlue.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(player==0)
        {
            sprite = redSprite;
            state = State.RED;
        }
        else
        {
            sprite = blueSprite;
            state = State.BLUE;
        }

        vector = new Vector2D(20, 20, sprite.getWidth(), sprite.getHeight());

        Log.log("Player "+player+" constructed");
    }

    public CrossHair getCrossHair() {
        return crossHair;
    }
    
    public void setCrossHair(CrossHair crossHair) {
        this.crossHair = crossHair;
    }

    @Override
    public void draw(Graphics2D g2)
    {

        AffineTransform at1 = new AffineTransform();
        at1.translate((int) vector.getX() + 64, (int) vector.getY() + 64);
        at1.rotate(lookAngle);
        at1.translate(-((int) vector.getX() + 64), -((int) vector.getY() + 64));
        g2.transform(at1);
        g2.drawImage(sprite, (int) vector.getX(), (int) vector.getY(), null);
        g2.setTransform(new AffineTransform());
    }

    @Override
    public void update()
    {
        double difX = (vector.getX() + 64) - (ch.getLocation().getX() + 32);
        double difY = (vector.getY() + 64) - (ch.getLocation().getY() + 32);

        lookAngle = Math.atan2(difY, difX);


        if (Double.isNaN(moveAngle))
        {
            moveAngle = 0.0;
        }
        if (Double.isNaN(magnitude))
        {
            magnitude = 0.0;
        }

        double cosX = Math.cos(Math.toRadians(moveAngle - 90));
        double cosY = Math.sin(Math.toRadians(moveAngle - 90));

        if (magnitude > deviation)
        {
            double moveX = cosX * magnitude * speed;
            double moveY = cosY * magnitude * speed;
            vector.setX(vector.getX() + moveX);
            vector.setY(vector.getY() + moveY);
        }
    }

    @Override
    public void onButtonsEvent(WiimoteButtonsEvent wiimoteButtonsEvent)
    {
        switch(wiimoteButtonsEvent.getButtonsJustPressed()){
            case WiimoteButtons.B:
                new Bullet(state);
                break;
            default:
                break;
        }
    }

    @Override
    public void onIrEvent(IREvent irEvent)
    {
        if(crossHair==null)
        return;
        crossHair.onIrEvent(irEvent);
    }

    @Override
    public void onMotionSensingEvent(MotionSensingEvent motionSensingEvent)
    {

    }

    @Override
    public void onExpansionEvent(ExpansionEvent exp)
    {
        NunchukEvent nun = (NunchukEvent) exp;
        ButtonsEvent but = nun.getButtonsEvent();
        JoystickEvent joy = nun.getNunchukJoystickEvent();
        moveAngle = (double) joy.getAngle();
        magnitude = (double) joy.getMagnitude();


        if (nun.getButtonsEvent().isButtonCJustReleased())
        {
            toggleState();
        }
    }

    void toggleState()
    {
        state = state.next();
        if(state==State.BLUE)
            sprite = blueSprite;
        else
            sprite = redSprite;

        Log.log("Changed state of player "+playerId+" to "+state.name());
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
