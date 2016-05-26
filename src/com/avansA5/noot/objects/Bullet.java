package com.avansA5.noot.objects;

import com.avansA5.noot.interfaces.Damaging;
import com.avansA5.noot.interfaces.Hittable;
import com.avansA5.noot.types.Vector2D;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Cas on 26/05/2016.
 */
public class Bullet extends GameObject implements Damaging {
    String type, image;
    BufferedImage bullet;

    public Bullet(String type){
        this.type = type;
        image = "res/Bullet"+type+".png";
        try {
            bullet = ImageIO.read(new File(image));
            vector = new Vector2D(50, 50, bullet.getWidth(), bullet.getHeight());
        } catch (IOException e) {
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
    public double getDamage(Hittable hit) {
        return 0;
    }
}
