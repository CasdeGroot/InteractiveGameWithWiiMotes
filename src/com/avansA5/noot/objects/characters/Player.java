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

    public Player(int player)
    {
        Log.log("Constructing player "+player);
        ControlManager.addWiimoteListener(this, player);
        playerId = player;

        try {
            redSprite = ImageIO.read(new File("res/DragonRed.png"));
            blueSprite = ImageIO.read(new File("res/DragonBlue.png"));
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

        vector = new Vector2D(500, 500, sprite.getWidth(), sprite.getHeight());

        Log.log("Player "+player+" constructed");
    }

    public CrossHair getCrossHair() {
        return crossHair;
    }
    
    public void setCrossHair(CrossHair crossHair) {
        this.crossHair = crossHair;
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(sprite, (int)vector.getX(), (int)vector.getY(), null);
    }

    @Override
    public void update()
    {
        vector.setX(vector.getX()+vector.getSpeedX());
        vector.setY(vector.getY()-vector.getSpeedY());
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
    public void onExpansionEvent(ExpansionEvent expansionEvent)
    {
        NunchukEvent n;
        n = (NunchukEvent)expansionEvent;
        if(n.isThereNunchukJoystickEvent());
        {
            double angle = n.getNunchukJoystickEvent().getAngle();
            if(Double.isNaN(angle))
                return;

            double magnitude = n.getNunchukJoystickEvent().getMagnitude();
            double deg = Math.toRadians(angle);

            double _x = 8* magnitude * Math.sin(deg);
            double _y = 8* magnitude * Math.cos(deg);

            vector.setSpeedX(_x);
            vector.setSpeedY(_y);

            switch(n.getButtonsEvent().getButtonsJustPressed()){
                case WiimoteButtons.C:
                    toggleState();
            }

        }
    }

    void toggleState()
    {
        if(switchLock)
            return;

        state = state.next();
        if(state==State.BLUE)
            sprite = blueSprite;
        else
            sprite = redSprite;
        switchLock = true;
        Timer t = new Timer(700, e -> switchLock=false);
        t.start();


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
