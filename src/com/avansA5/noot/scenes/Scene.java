package com.avansA5.noot.scenes;


import com.avansA5.noot.objects.GameObject;
import com.avansA5.noot.ui.UIElement;

import java.awt.*;
import java.util.ArrayList;

public abstract class Scene
{
    ArrayList<UIElement> uiElements = new ArrayList<>();
    ArrayList<GameObject> sprites = new ArrayList<>();

    public ArrayList<GameObject> getSprites()
    {
        return sprites;
    }

    public ArrayList<UIElement> getUiElements()
    {
        return uiElements;
    }

    public abstract void load();

    public abstract void unload();

    public void update()
    {
        sprites.forEach(GameObject::update);
        uiElements.forEach(UIElement::update);
    }

    public void draw(Graphics2D g2)
    {
        sprites.forEach(e -> e.draw(g2));
        uiElements.forEach(e -> e.draw(g2));
    }
}
