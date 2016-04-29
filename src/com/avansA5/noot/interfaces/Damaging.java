package com.avansA5.noot.interfaces;

import com.avansA5.noot.objects.GameObject;

/**
 * Interface for objects that can do damage.
 * for example: bullets
 */
public interface Damaging
{
    float getDamage(GameObject sender);
}
