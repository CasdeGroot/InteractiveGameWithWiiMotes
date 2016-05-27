package com.avansA5.noot.objects;

import com.avansA5.noot.interfaces.Updatable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Timon on 24/05/2016.
 */
public class Animation implements Updatable
{
    private ArrayList<BufferedImage> spriteList = new ArrayList<>();
    private int maxSprites = 0;
    private int currentSprite = 0;

    private int pause = 30;

    public Animation(String tilesheetPath, int rows, int columns)
    {
        maxSprites = rows * columns;
        createSpriteList(tilesheetPath, rows, columns);
    }

    private void createSpriteList(String tileSheetPath, int rows, int columns)
    {
        try
        {
            BufferedImage tilesheetImage = ImageIO.read(new File(tileSheetPath));

            for (int r = 0; r < rows; r++)
            {
                for (int c = 0; c < columns; c++)
                {
                    BufferedImage tempImage = tilesheetImage.getSubimage(c * 64, r * 64, 64, 64);
                    spriteList.add(tempImage);
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public BufferedImage getCurrentImage()
    {
        return spriteList.get(currentSprite);
    }

    @Override
    public void update()
    {
        currentSprite++;
        if (currentSprite >= maxSprites)
            currentSprite = 0;
    }
}
