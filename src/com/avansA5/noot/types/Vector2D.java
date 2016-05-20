package com.avansA5.noot.types;

public class Vector2D
{
    private double x = 0;
    private double y = 0;
    private double width = 0;
    private double height = 0;

    private double speedX = 0;
    private double speedY = 0;

    public Vector2D()
    {

    }

    public Vector2D(double x, double y, double width, double height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Vector2D(double x, double y, double width, double height, double speedX, double speedY)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speedX = speedX;
        this.speedY = speedY;
    }

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

    public double getWidth()
    {
        return width;
    }

    public void setWidth(double width)
    {
        this.width = width;
    }

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    public double getSpeedX()
    {
        return speedX;
    }

    public void setSpeedX(double speedX)
    {
        this.speedX = speedX;
    }

    public double getSpeedY()
    {
        return speedY;
    }

    public void setSpeedY(double speedY)
    {
        this.speedY = speedY;
    }

    //endregion

    public double getX2()
    {
        return x + width;
    }

    public double getY2()
    {
        return y + height;
    }

}
