package com.avansA5.noot.ui;

import com.avansA5.noot.util.Log;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class UIButton implements UIElement
{
    Rectangle rect;
    Color color;
    Point location;
    UIElement child;


    public UIButton(Rectangle rect, Color color, Point location, UIElement child)
    {
        this.rect = rect;
        this.color = color;
        this.location = location;
        this.child = child;
    }

    @Override
    public void draw(Graphics2D g2)
    {
        g2.setColor(color);
        RoundRectangle2D rekt = new RoundRectangle2D.Double(location.getX(), location.getY(), rect.getWidth(), rect.getHeight(), 10, 10);
        g2.draw(rekt);

        g2.setColor(Color.BLACK);

        child.draw(g2, new Point((int) (rekt.getX() + rekt.getWidth()), (int) (rekt.getY() + rekt.getHeight())));

    }

    @Override
    public void update()
    {

    }

    @Override
    public Rectangle getRect()
    {
        return new Rectangle((int) location.getX(), (int) location.getY(), (int) rect.getWidth(), (int) rect.getHeight());
    }

    @Override
    public void onClick(Point p)
    {
        Log.log("Button cliek");
    }

    @Override
    public void draw(Graphics2D g2, Point location)
    {
        g2.setColor(color);
        RoundRectangle2D rekt = new RoundRectangle2D.Double(location.getX(), location.getY(), rect.getWidth(), rect.getHeight(), 10, 10);
        g2.draw(rekt);

        g2.setColor(Color.BLACK);

        child.draw(g2, new Point((int) rekt.getHeight() / 2, (int) rekt.getWidth() / 2));
    }
}
