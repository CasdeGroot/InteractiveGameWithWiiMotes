package com.avansA5.noot.objects.characters;

import com.avansA5.noot.interfaces.Hittable;
import com.avansA5.noot.managers.ControlManager;
import com.avansA5.noot.objects.Bullet;
import com.avansA5.noot.objects.CrossHair;
import com.avansA5.noot.scenes.GameScene;
import com.avansA5.noot.scenes.Scene;
import com.avansA5.noot.types.Vector2D;
import com.avansA5.noot.util.Log;
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
    final int b = 4, c = 2;
    String type = "Red";

    public CrossHair getCrossHair() {
        return crossHair;
    }

    public void setCrossHair(CrossHair crossHair) {
        this.crossHair = crossHair;
    }

    CrossHair crossHair;
    
    public Player(int player)
    {
        ControlManager.addWiimoteListener(this, player);
        playerId = player;

        try {
            sprite = ImageIO.read(new File("res/DragonRed.png"));
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
        vector.setY(vector.getY()-vector.getSpeedY());
    }

    @Override
    public void onButtonsEvent(WiimoteButtonsEvent wiimoteButtonsEvent)
    {
        switch(wiimoteButtonsEvent.getButtonsJustPressed()){
            case b:
                new Bullet(type);
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
                case c:
                    if(type == "Red"){
                        type = "Blue";
                    }
                    else {
                        type = "Red";
                    }

                    String image = "res/Dragon" + type + ".png";
                    try {
                        sprite = ImageIO.read(new File(image));
                        vector = new Vector2D(20, 20, sprite.getWidth(), sprite.getHeight());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

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
