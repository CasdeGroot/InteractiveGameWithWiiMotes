package com.avansA5.noot.objects;

import com.avansA5.noot.interfaces.GiveDamage;
import com.avansA5.noot.managers.AnimationManager;
import com.avansA5.noot.managers.SceneManager;
import com.avansA5.noot.managers.WindowManager;
import com.avansA5.noot.types.State;
import com.avansA5.noot.types.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Bullet extends GameObject implements GiveDamage
{
    String type, image;
    State state;
    private Animation animation;

    public Bullet(State state, Vector2D spawnPos, Vector2D targetPos)
    {

        this.state = state;
        if (state == State.BLUE)
            animation = new Animation("res//blueFireballTileset.png", 1, 6, 64, 64, 30);
        else
            animation = new Animation("res//redFireballTileset.png", 1, 6, 64, 64,30);

        double diffX = targetPos.getX() + 16 - spawnPos.getX();
        double diffY = targetPos.getY() + 16 - spawnPos.getY();
        double direction = Math.atan2(diffY, diffX);

        vector = new Vector2D(spawnPos.getX() , spawnPos.getY(), animation.getCurrentImage().getWidth(), animation.getCurrentImage().getHeight(), direction, 1);

        AnimationManager.addAnimation(animation);

        SceneManager.getCurrentScene().addSprite(this);
    }

    @Override
    public void draw(Graphics2D g2)
    {
        AffineTransform at = new AffineTransform();
        at.translate((int)vector.getX(), (int)vector.getY());
        at.rotate(vector.getDirection());
        at.translate(-((int)vector.getX() + 32), -((int)vector.getY() +32));
        g2.transform(at);
        g2.drawImage(animation.getCurrentImage(), (int)vector.getX() , (int)vector.getY(), null);
        g2.setTransform(new AffineTransform());
    }

    @Override
    public void update()
    {
        animation.update();
        //if(vector.getX() > WindowManager.frame.getWidth() -
        double moveX = Math.cos(vector.getDirection());
        double moveY = Math.sin(vector.getDirection());
        vector.setX(vector.getX() + moveX * vector.getSpeed());
        vector.setY(vector.getY() + moveY * vector.getSpeed());
    }

    @Override
    public int getDamage()
    {
        return 1;
    }
}
