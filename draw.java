
import javax.swing.*;
import java.awt.*;

public class draw extends JPanel{
    Snake t = new Snake();
    


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.GRAY);
        g.fillRect(0,30, 300, 300);


        g2.setColor(Color.BLACK);
        
        drawLines(g2);
        drawSnake(g2);
        drawApple(g2);
        if(t.isGameOver() == true)
        {
            checkEnd(g2);
        }
        
    }

    public void drawLines(Graphics2D g)
    {
        //Lines
        for(int i = 0; i<=t.getHeight()/t.getSquareSize(); i++)
        {
            //vertical
            g.drawLine(i*t.getSquareSize(), t.getSquareSize(), i*t.getSquareSize(), t.getHeight());
        }
        for (int i = 0; i<=t.getHeight()/t.getSquareSize(); i++)
        {
            //horizontal
            g.drawLine(0, i*t.getSquareSize(), t.getWidth(), i*t.getSquareSize());
        }
         g.drawString("Controls WASD | Score: " + t.getScore(), 15, 20);
    }
    public void drawSnake(Graphics2D g)
    {   g.setColor(Color.green);
        g.fillRect((int)(t.getXVals().get(0))*t.getSquareSize(), (int)(t.getYVals().get(0))*t.getSquareSize(), t.getSquareSize(), t.getSquareSize());
        g.setColor(Color.blue);
        for (int i = 1; i<t.getYVals().size(); i++)
        {            
            g.fillRect((int)(t.getXVals().get(i))*t.getSquareSize(), (int)(t.getYVals().get(i))*t.getSquareSize(), t.getSquareSize(), t.getSquareSize());
        }
    }
    public void drawApple(Graphics2D g)
    {
        g.setColor(Color.red);
        g.fillRect(t.getAppleX()*t.getSquareSize(), t.getAppleY()*t.getSquareSize(), t.getSquareSize(), t.getSquareSize());
    }
    public void checkEnd(Graphics2D g)
    {
        g.setColor(Color.gray);
        g.fillRect(0, 0, t.getWidth(), t.getHeight());
        g.setColor(Color.black);
        g.drawString("Score: " + t.getScore(), 130, 150);
    }
}