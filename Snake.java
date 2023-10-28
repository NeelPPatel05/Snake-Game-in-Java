
import javax.swing.*;


import java.util.*;


public class Snake extends JPanel {
    private int height = 330;
    private int width = 300;
    private int squareSize = 30;
    private static ArrayList<Integer> snakeXTiles = new ArrayList<Integer>();
    private static ArrayList<Integer> snakeYTiles = new ArrayList<Integer>();
    private static int appleXPos;
    private static int appleYPos;
    private static String dir;
    private static int score;
    private static boolean gameOver = false;
    

    public Snake(){
        appleXPos = 7;
        appleYPos = 5;
        
        dir = "right";
    }
    public void StartGame(){
        snakeXTiles.add(3);
        snakeYTiles.add(5);
    }

//Getters and Setters    
    public int getScore(){
        return score;
    }
    public int getAppleX(){
        return appleXPos;
    }
    public int getAppleY(){
        return appleYPos;
    }
    public String getDir(){
        return dir;
    }
    public boolean isGameOver(){
        return gameOver;
    }


    public void setDir(String dir){
        this.dir = dir;
    }
   
    public int getHeight()
    {
        return height;
    }
    public int getWidth()
    {
        return width;
    }
    public int getSquareSize(){
        return squareSize;
    }

    //Getting each Val of ArrayList
    public ArrayList getYVals(){
        return snakeYTiles;
    }
    public ArrayList getXVals(){
        return snakeXTiles;
    }

   
   
       
    
    public void runGame(){
        updateAllTiles();
        checkHitItself();
        checkOutOfBounds();
        checkWin();
    }
   
   
    //Will Update the snake Tile variables
    //Will Update the apple Tile variables
    public void updateAllTiles(){
        if(dir.equals("up"))
        {
            snakeXTiles.add(0,snakeXTiles.get(0));
            snakeYTiles.add(0,snakeYTiles.get(0)-1);
        }
        else if (dir.equals("down"))
        {
            snakeXTiles.add(0,snakeXTiles.get(0));
            snakeYTiles.add(0,snakeYTiles.get(0)+1);
        }
        else if (dir.equals("left"))
        {
            snakeXTiles.add(0,snakeXTiles.get(0)-1);
            snakeYTiles.add(0,snakeYTiles.get(0));
        }
        else if (dir.equals("right"))
        {
            snakeXTiles.add(0,snakeXTiles.get(0)+1);
            snakeYTiles.add(0,snakeYTiles.get(0));
        }
        
        if(this.ateApple() == false)
        {
            snakeXTiles.remove(snakeXTiles.size()-1);
            snakeYTiles.remove(snakeYTiles.size()-1);
        }
        
    }
    public void checkHitItself(){
        for(int i = 1; i < snakeXTiles.size(); i++)
        {
            if (snakeXTiles.get(0) == snakeXTiles.get(i) && snakeYTiles.get(0) == snakeYTiles.get(i))
            {
                gameOver=true;
            }
        }
    }
    public void checkOutOfBounds(){
        if((snakeYTiles.get(0)==0) || (snakeXTiles.get(0)==-1) || (snakeYTiles.get(0) == height/squareSize) || (snakeXTiles.get(0) == width/squareSize))
        {
            gameOver=true;
        }
    }
    public boolean ateApple(){
        if (snakeYTiles.get(0)== appleYPos && snakeXTiles.get(0)==appleXPos)
        {
            
            this.newApple();
            score++;
            return true;
           
        }
        return false;
    }


    public void newApple()
    {
        appleYPos = (int) (1.0 + Math.random() *10.0);
        appleXPos = (int) (Math.random()* 10.0);   
        for(int i = 0; i <snakeXTiles.size(); i++)
        {
            if (snakeXTiles.get(i)==appleXPos && snakeYTiles.get(i)==appleYPos)
            {
                newApple();
            }
        }
    }
   
    public void checkWin(){
        if(snakeXTiles.size() == 100)
        {
            gameOver=true;
        }
    }
   
   

}