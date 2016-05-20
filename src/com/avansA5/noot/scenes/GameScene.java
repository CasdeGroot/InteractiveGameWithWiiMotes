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
        Player player1 = new Player(0);
        CrossHair crossHair1 = new CrossHair(0);
        player1.setCrossHair(crossHair1);

//        Player player2 = new Player(1);
//        CrossHair crossHair2 = new CrossHair(1);
//        player2.setCrossHair(crossHair2);

        sprites.add(player1);
        sprites.add(crossHair1);
//        sprites.add(player2);
//        sprites.add(crossHair2);
    }

    @Override
    public void unload() {

    }
}
