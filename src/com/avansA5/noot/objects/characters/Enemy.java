package com.avansA5.noot.objects.characters;

import com.avansA5.noot.interfaces.Hittable;

import java.awt.*;

/**
 * Created by Cas on 20/05/2016.
 */
public class Enemy extends Character{
    String kind;

    public Enemy(String kind)
    {
        this.kind = kind;
    }

    @Override
    public void draw(Graphics2D g2) {

    }

    @Override
    public void onHit(Hittable sender) {

    }

    @Override
    public void update() {

    }
}
