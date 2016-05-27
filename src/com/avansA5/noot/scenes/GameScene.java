package com.avansA5.noot.scenes;

import com.avansA5.noot.managers.WindowManager;
import com.avansA5.noot.objects.*;
import com.avansA5.noot.objects.characters.*;

import java.awt.*;

/**
 * Created by Cas on 19/05/2016.
 */
public class GameScene extends Scene {

    PlayerPanel[] panels = new PlayerPanel[2];

    @Override
    public void update()
    {
        super.update();
        for(PlayerPanel p : panels)
            p.update();
    }

    @Override
    public void draw(Graphics2D g2)
    {
        super.draw(g2);
        for(PlayerPanel p : panels)
            p.draw(g2);
    }

    @Override
    public void load() {
        CrossHair crossHair1 = new CrossHair(0);
        Player player1 = new Player(0, crossHair1);

//        Player player2 = new Player(1);
//        CrossHair crossHair2 = new CrossHair(1);
//        player2.setCrossHair(crossHair2);

        sprites.add(player1);
        sprites.add(crossHair1);

//        sprites.add(player2);
//        sprites.add(crossHair2);

        panels[0] = new PlayerPanel(0);
        panels[1] = new PlayerPanel(1);
    }

    @Override
    public void unload() {

    }
}
