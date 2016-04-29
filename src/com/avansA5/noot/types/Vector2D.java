package com.avansA5.noot.types;

public class Vector2D
{
    private double x;
    private double y;
    private double x2;
    private double y2;

    //region Getters and Setters
    public double getX()
    {
        return x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public double getX2()
    {
        return x2;
    }

    public void setX2(double x2)
    {
        this.x2 = x2;
    }

    public double getY2()
    {
        return y2;
    }

    public void setY2(double y2)
    {
        this.y2 = y2;
    }
    //endregion

    public double getWidth()
    {
        return x - x2;
    }

    public double getHeight()
    {
        return y - y2;
    }

}
