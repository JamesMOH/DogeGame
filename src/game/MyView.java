package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class MyView extends UserView {
    private Image background;
    private static int coins;
    private static int clevel = 1;
    private static boolean playerDead = false;
    private static int mvseconds;
    private static boolean playerwin = false;

    // Shows the player's view of the world

    //creates a different background for the different levels
    public MyView(World w, int width, int height){
        super(w,width,height);
        if(clevel == 1){
            background = new ImageIcon("data/shack.png").getImage();
        } else if(clevel == 2){
            background = new ImageIcon("data/bhouse.png").getImage();
        } else if(clevel == 3){
            background = new ImageIcon("data/rhouse.png").getImage();
        }
    }

    //increments certain variables for the display
    public static void addCoins(){
        coins++;
    }

    public static void incLevel(){
        clevel++;
    }

    public static void incMVseconds(){
        mvseconds++;
    }

    //draws the image on the background
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 100, this);
    }

    //draws the display elements on the game, the coins collected, the level they are on and the timer
    //displays the win time and death time
    @Override
    protected void paintForeground(Graphics2D g) {
        g.drawString("Dogecoins Collected: " + coins, 10, 20);
        g.drawString("Level: " + clevel, 10,40);
        if (playerDead == true){
            g.drawString("Game over, Doge dead in " + mvseconds + " seconds.", 250,40);
        } else if (playerwin == true){
            g.drawString("Congratulations, you did it in: " + mvseconds + " seconds!",250,20);
        } else {
            g.drawString("Time: " + mvseconds, 250, 20);
        }
    }

    //sets the state of the player whether they are dead or if they won the game
    public static void setPlayerDead(boolean playerDead) {
        MyView.playerDead = playerDead;
        Game.getLevel().stop();
    }

    public static void setPlayerwin(boolean playerwin) {
        MyView.playerwin = playerwin;
    }

    //sets the current level the player is on for the display
    public static void setClevel(int clevel) {
        MyView.clevel = clevel;
    }

    public static void setMvseconds(int mvseconds) {
        MyView.mvseconds = mvseconds;
    }
}
