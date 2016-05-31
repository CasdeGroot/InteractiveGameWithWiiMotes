package com.avansA5.noot.objects.characters;

import com.avansA5.noot.managers.AnimationManager;
import com.avansA5.noot.managers.ControlManager;
import com.avansA5.noot.objects.Animation;
import com.avansA5.noot.objects.Bullet;
import com.avansA5.noot.objects.CrossHair;
import com.avansA5.noot.objects.GameObject;
import com.avansA5.noot.types.State;
import com.avansA5.noot.types.Vector2D;
import com.avansA5.noot.types.WiimoteButtons;
import com.avansA5.noot.util.Log;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;
import wiiusej.wiiusejevents.physicalevents.*;
import wiiusej.wiiusejevents.utils.WiimoteListener;
import wiiusej.wiiusejevents.wiiuseapievents.*;

import java.awt.*;
import java.awt.geom.AffineTransform;


/**
 * Created by Cas on 19/05/2016.
 */
public class Player extends GameObject implements WiimoteListener
{
    private Animation animation;
    CrossHair crossHair;
    private Animation redAnimation;
    private Animation blueAnimation;
    private int playerId;
    State state;

    boolean switchLock = false;
    private CrossHair ch;
    private double lookAngle;
    private double moveAngle;
    private double magnitude;
    private double deviation;
    private double speed = 7;

    private final int SPRITE_WIDTH = 130;
    private final int SPRITE_HEIGHT = 120;

    public Player(int player, CrossHair crossHair)
    {
        Log.log("Constructing player "+player);
        this.ch = crossHair;
        ControlManager.addWiimoteListener(this, player);
        playerId = player;


        redAnimation = new Animation("res/PlayerRed.png", 1, 7, 130, 120,25);
        AnimationManager.addAnimation(redAnimation);
        blueAnimation = new Animation("res/PlayerBlue.png", 1, 7, 130, 120,25);
        AnimationManager.addAnimation(blueAnimation);

        if(player==0)
        {
            animation = redAnimation;
            state = State.RED;
        }
        else
        {
            animation = blueAnimation;
            state = State.BLUE;
        }

        vector = new Vector2D(200, 200, animation.getCurrentImage().getWidth(), animation.getCurrentImage().getHeight());

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

        AffineTransform tr = new AffineTransform();
        tr.translate(vector.getX() + SPRITE_WIDTH/2, vector.getY() + SPRITE_HEIGHT/2);
        tr.rotate(lookAngle - (Math.PI/2));
        tr.translate(-vector.getX() - SPRITE_WIDTH/2, -vector.getY() - SPRITE_HEIGHT/2);
        tr.translate(vector.getX(), vector.getY());
        g2.drawImage(animation.getCurrentImage(), tr, null);
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
        switch(wiimoteButtonsEvent.getButtonsJustReleased()){
            case WiimoteButtons.B:
                new Bullet(state, new Vector2D(vector.getX()+65, vector.getY()+60), new Vector2D(ch.getLocation().getX(), ch.getLocation().getY()));
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
            animation = blueAnimation;
        else
            animation = redAnimation;

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
