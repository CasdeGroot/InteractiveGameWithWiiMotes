package com.avansA5.noot.interfaces;

/**
 * Interface for objects that can do damage.
 * for example: bullets
 */
public interface Damaging
{
    /**
     *
     * @param hit The GameObject receiving the damage
     * @return the amount of damage done by this bullet
     */
    double getDamage(Hittable hit);
}
