package com.avansA5.noot.objects;

import com.avansA5.noot.interfaces.GiveDamage;
import com.avansA5.noot.types.State;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Bullet extends GameObject implements GiveDamage
{
    String type, image;
    State state;
    private Animation animation;

    public Bullet(State state)
    {
        this.state = state;
        if (state == State.BLUE)
            animation = new Animation("res//blueFireballTileset.png", 1, 6);
        else
            animation = new Animation("res//redFireballTileset.png", 1, 6);

    }

    @Override
    public void draw(Graphics2D g2)
    {
        AffineTransform at = new AffineTransform();
        at.translate((int)vector.getX(), (int)vector.getY());
        at.rotate(vector.getDirection() + Math.toRadians(180));
        at.translate(-((int)vector.getX() + 32), -((int)vector.getY() + 32));
        g2.transform(at);
        g2.drawImage(animation.getCurrentImage(), (int)vector.getX() , (int)vector.getY(), null);
        g2.setTransform(new AffineTransform());
    }

    @Override
    public void update()
    {
        animation.update();
    }

    @Override
    public int getDamage()
    {
        return 1;
    }
}
