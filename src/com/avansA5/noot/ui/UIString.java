package com.avansA5.noot.ui;

import java.awt.*;

public class UIString implements UIElement
{
    private final String text;
    private final Point location;
    private final Font font;
    private Rectangle rect;

    public UIString(String text, Point location)
    {
        this(text, location, "");
    }

    public UIString(String text, Point location, String fontName)
    {
        this(text, location, fontName, 10);
    }

    public UIString(String text, Point location, String fontName, int size)
    {
        this(text, location, fontName, size, Font.PLAIN);
    }

    public UIString(String text, Point location, String fontName, int size, int attributes)
    {
        this.text = text;
        this.location = location;

        this.font = new Font(fontName, attributes, size);
    }

    @Override
    public void draw(Graphics2D g2)
    {
        g2.setFont(font);
        g2.drawString(text, (float) location.getX() - (g2.getFontMetrics().stringWidth(text) / 2), (float) location.getY() - (g2.getFontMetrics().getHeight() / 2));
        if (rect == null)
        {
            rect = new Rectangle((int) location.getX(), (int) location.getY(), g2.getFontMetrics().stringWidth(text), g2.getFontMetrics().getHeight());
        }
    }

    public void draw(Graphics2D g2, Point location)
    {
        g2.setFont(font);
        g2.drawString(text, (float) location.getX() - (g2.getFontMetrics().stringWidth(text) / 2), (float) location.getY() - (g2.getFontMetrics().getHeight() / 2));
        if (rect == null)
        {
            rect = new Rectangle((int) location.getX(), (int) location.getY(), g2.getFontMetrics().stringWidth(text), g2.getFontMetrics().getHeight());
        }
    }

    @Override
    public void update()
    {

    }

    @Override
    public Rectangle getRect()
    {
        if (rect == null)
            throw new RuntimeException("Kankerzooi");
        else
            return rect;
    }

    @Override
    public void onClick(Point p)
    {

    }
}
