package com.avansA5.noot.interfaces;

/**
 * Interface for objects that can receive damage
 */
interface Hittable
{
    void onHit(Hittable sender);
}
