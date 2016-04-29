package com.avansA5.noot.interfaces;

import com.avansA5.noot.objects.GameObject;

/**
 * Interface for objects that can receive damage
 */
public interface Hittable
{
    void onHit(Hittable sender);
}
