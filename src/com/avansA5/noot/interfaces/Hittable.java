package com.avansA5.noot.interfaces;

/**
 * Interface for objects that can receive damage
 */
public interface Hittable
{
    void onHit(Hittable sender); //damaging
}
