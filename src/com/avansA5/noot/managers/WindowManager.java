package com.avansA5.noot.managers;

import com.avansA5.noot.Program;
import com.avansA5.noot.util.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WindowManager extends JPanel
{
    public static WindowManager panel;
    public static JFrame frame;

    static Timer repaintTimer;

    public WindowManager()
    {

        repaintTimer = new Timer(1000 / 60, e -> repaint());
        repaintTimer.start();
        setBackground(Color.black);

        addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent mouseEvent)
            {
                SceneManager.onClick(new Point(mouseEvent.getX(), mouseEvent.getY()));
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent)
            {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent)
            {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent)
            {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent)
            {

            }
        });
    }

    public static void start()
    {
        Log.log("Starting WindowManager");

        panel = new WindowManager();

        JFrame frame = new JFrame(Program.TITLE);
        frame.setContentPane(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 800));

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setUndecorated(true);

        frame.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent keyEvent)
            {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent)
            {
                if(keyEvent.getKeyCode()==KeyEvent.VK_ESCAPE)
                    System.exit(0);
            }

            @Override
            public void keyReleased(KeyEvent keyEvent)
            {
            }
        });

        frame.setVisible(true);


        WindowManager.frame = frame;

        SceneManager.start();

    }

    @Override
    protected void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);

        Graphics2D g2 = (Graphics2D) graphics;

        SceneManager.draw(g2);
    }
}
