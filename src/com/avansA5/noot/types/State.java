package com.avansA5.noot.types;

public enum State
{
    RED,
    BLUE;

    private static State[] vals = values();
    public State next()
    {
        return vals[(this.ordinal()+1) % vals.length];
    }
}
