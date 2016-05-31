package com.avansA5.noot.objects;


import com.avansA5.noot.interfaces.Drawable;
import com.avansA5.noot.interfaces.Updatable;
import com.avansA5.noot.types.Vector2D;

public abstract class GameObject implements Drawable, Updatable
{
    public boolean dead = false;
    protected Vector2D vector = new Vector2D();
}
