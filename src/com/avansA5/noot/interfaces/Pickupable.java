package com.avansA5.noot.interfaces;

import com.avansA5.noot.objects.GameObject;
import com.avansA5.noot.objects.pickups.Pickup;

/**
 * Interface for items that can be picked up
 */
public interface Pickupable
{
    /**
     *
     * @param sender The gameobject that picks up the item
     * @param pickup The pickup related info class
     */
    void onPickUp(GameObject sender, Pickup pickup);
}
