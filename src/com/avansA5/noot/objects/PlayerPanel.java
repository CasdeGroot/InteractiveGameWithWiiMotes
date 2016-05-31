package com.avansA5.noot.objects;

import com.avansA5.noot.managers.WindowManager;
import com.avansA5.noot.types.State;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by RMSjoshua on 5/24/2016.
 */
public class PlayerPanel extends GameObject
{

    // Image of the side panels
    private BufferedImage playerPanelImg;
    private BufferedImage selectedRed;
    private BufferedImage selectedBlue;
    private BufferedImage blackHeart;

    private int score = 0;
    private String playerNr = "";
    private String difficulty = "";
    private int highscore = 0;
    private int heartCount = 3;

    private final int PANEL_WIDTH = 390;
    private final int PANEL_HEIGHT = 1080;

    // Positions for drawi0ng on the stats
    private final Point highscorePos    = new Point(170,38);
    private final Point scorePos        = new Point(110,98);
    private final Point playerPos       = new Point(110,160);
    private final Point difPos          = new Point(135,965);
    private final Point redColor        = new Point(95,635);
    private final Point blueColor       = new Point(260,635);
    private ArrayList<Point> heartpos = new ArrayList<>();

    private State state = State.RED;
    private int playerId;
    private double scale;


    public PlayerPanel(int playerId)
    {

        this.playerId = playerId;
        heartpos.add(new Point(256,776));
        heartpos.add(new Point(147,776));
        heartpos.add(new Point(39,776));
        try
        {
            playerPanelImg = ImageIO.read(new File("res" + File.separator + "PlayerPanel.png"));
            selectedBlue = ImageIO.read(new File("res" + File.separator + "BlueSelected.png"));
            selectedRed = ImageIO.read(new File("res" + File.separator + "RedSelected.png"));
            blackHeart = ImageIO.read(new File("res" + File.separator + "BlackHeart.png"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        calculateScale();

        //TODO boolean is redselected according to player who connects

        //this.add(playerPanelImage);
        //this.setSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setHearts(int heartCount)
    {
        this.heartCount = heartCount;
    }

    public void setPlayer(int playerNr)
    {
        this.playerNr = ""+playerNr;
    }

    public void setDifficulty(String diff)
    {
        this.difficulty = diff;
    }

    public void setHighscore(int highscore)
    {
        this.highscore = highscore;
    }

    public void setState(State state)
    {
        this.state = state;
    }

    // draws a string a point in a readable way
    public void drawString(Graphics2D g2, Point p, String text)
    {
        float xPos = (float) p.getX();
        float yPos = (float) p.getY();

        g2.setColor(Color.black);
        for(int x = -1; x <= 1; x++)
            for(int y = -1; y <= 1; y++)
                g2.drawString(text, xPos + x, yPos+y);
        g2.setColor(Color.white);
        g2.drawString(text,xPos, yPos);

    }

    public void drawSelectedColor(Graphics2D g2)
    {
        switch(state)
        {
            case RED:
                g2.drawImage(selectedRed,45,565,null);
                break;
            case BLUE:
                g2.drawImage(selectedBlue,210,565,null);
                break;
        }

        drawString(g2,blueColor,"C" );
        drawString(g2,redColor,"Z" );
    }

    public void draw(Graphics2D g2)
    {
        AffineTransform transform = new AffineTransform();

        if(playerId==1)
            transform.translate(WindowManager.getDimension().getWidth()-390*scale, 0);

        transform.scale(scale,scale);


        g2.drawImage(playerPanelImg,transform,null);


        g2.setFont(g2.getFont().deriveFont(28.0f));


        //TODO put highscore of player and such in the strings
        drawString(g2,highscorePos,""+highscore);
        drawString(g2,scorePos, ""+score );
        drawString(g2,playerPos, playerNr );
        drawString(g2,difPos, difficulty );
        drawSelectedColor(g2);

        for(int i = 2; i > heartCount-1; i--)
        {
            AffineTransform tr = new AffineTransform();
            tr.translate((int) heartpos.get(i).getX(),(int) heartpos.get(i).getY());
            tr.scale(scale,scale);
            g2.drawImage(blackHeart,tr, null);
        }
    }

    @Override
    public void update()
    {

    }

    public void calculateScale()
    {
        scale = WindowManager.getDimension().getHeight() / playerPanelImg.getHeight();
    }
}
