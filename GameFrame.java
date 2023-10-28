package Snake;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import javax.swing.*;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameFrame extends JFrame{
   Snake game = new Snake();
   draw dC = new draw();
    GameFrame(){
        Snake s = new Snake();
        this.setSize(s.getWidth()+15,s.getHeight()+60);
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        
        this.setLocationRelativeTo(null);
        
        this.getContentPane().add(dC);
        this.setVisible(true);
   


    //KeyPresses
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W && !s.getDir().equals("down")) {
                    s.setDir("up");
                }
                else if (e.getKeyCode() == KeyEvent.VK_S && !s.getDir().equals("up")) {
                    s.setDir("down");
                }
                else if (e.getKeyCode() == KeyEvent.VK_D && !s.getDir().equals("left")) {
                    s.setDir("right");
                }
                else if (e.getKeyCode() == KeyEvent.VK_A && !s.getDir().equals("right")) {
                    s.setDir("left");
                }
            }
           
            @Override
            public void keyTyped(KeyEvent e)
            {
               
            }
            @Override
            public void keyReleased(KeyEvent e)
            {
                   
            }


        });

        game.StartGame();
        //Timer Loop
        Timer timer = new Timer();
        timer.schedule( new TimerTask() {
            public void run(){
                game.runGame();
                dC.repaint();
               
            }
        }, 0, 500);

    }
}