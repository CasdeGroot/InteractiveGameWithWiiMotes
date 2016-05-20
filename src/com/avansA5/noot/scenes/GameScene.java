package com.avansA5.noot.scenes;

import com.avansA5.noot.objects.CrossHair;
import com.avansA5.noot.objects.GameObject;
import com.avansA5.noot.objects.characters.Player;
import com.avansA5.noot.ui.UIElement;

import java.awt.*;

/**
 * Created by Cas on 19/05/2016.
 */
public class GameScene extends Scene {
    @Override
    public void load() {
        sprites.add(new Player(0));
        sprites.add(new CrossHair(0));
    }

    @Override
    public void unload() {

    }
}
