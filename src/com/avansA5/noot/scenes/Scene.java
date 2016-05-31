package com.avansA5.noot.scenes;


import com.avansA5.noot.objects.GameObject;
import com.avansA5.noot.ui.UIElement;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Scene
{
    CopyOnWriteArrayList<UIElement> uiElements = new CopyOnWriteArrayList<>();
    CopyOnWriteArrayList<GameObject> sprites = new CopyOnWriteArrayList<>();

    public CopyOnWriteArrayList<GameObject> getSprites()
    {
        return sprites;
    }

    public CopyOnWriteArrayList<UIElement> getUiElements()
    {
        return uiElements;
    }

    public abstract void load();

    public abstract void unload();

    public void update()
    {
        sprites.removeIf(s->s.dead);
        sprites.forEach(GameObject::update);
        uiElements.forEach(UIElement::update);
    }

    public void draw(Graphics2D g2)
    {
        sprites.forEach(e -> e.draw(g2));
        uiElements.forEach(e -> e.draw(g2));
    }

    public void addSprite(GameObject object)
    {
        sprites.add(object);
    }
}
