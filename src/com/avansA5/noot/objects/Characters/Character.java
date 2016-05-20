package com.avansA5.noot.objects.characters;

import com.avansA5.noot.interfaces.*;
import com.avansA5.noot.objects.GameObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Cas on 19/05/2016.
 */
public abstract class Character extends GameObject implements Shootable, Hittable
{
    BufferedImage sprite;
    public Character()
    {

    }
}
