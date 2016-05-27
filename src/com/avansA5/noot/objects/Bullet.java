package com.avansA5.noot.objects;

import com.avansA5.noot.interfaces.GiveDamage;
import com.avansA5.noot.types.State;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bullet extends GameObject implements GiveDamage
{
    String type, image;
    State state;
    BufferedImage bullet;

    public Bullet(State state){
        this.state = state;
        try
        {
            if (state == State.BLUE)
                bullet = ImageIO.read(new File("res\\bulletBlue.png"));
            else
                bullet = ImageIO.read(new File("res\\bulletRed.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(bullet, (int)vector.getX(), (int)vector.getY(), null);
    }

    @Override
    public void update() {

    }

    @Override
    public int getDamage()
    {
        return 1;
    }
}
