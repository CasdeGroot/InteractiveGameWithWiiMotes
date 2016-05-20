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

    }

    public static void start()
    {
        Log.log("Starting WindowManager");


        JFrame frame = new JFrame(Program.TITLE);
        frame.setUndecorated(true);

        panel = new WindowManager();
        frame.setContentPane(panel);

        frame.setVisible(true);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height-1));


        frame.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent keyEvent)
            {
                if(keyEvent.getKeyCode()==KeyEvent.VK_ESCAPE)
                    System.exit(0);
            }
        });


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
