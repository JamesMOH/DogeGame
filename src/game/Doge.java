package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Represents the player character Doge
 */
public class Doge extends Walker {

    // create doge object with amount of bonks and coins collected
    /**
     * The Doge has the amount of enemies it has hit and the amount of coins it has picked up
     * The Doge stores a sound it plays when it dies
     * The Doge has its collisionbox defined
     */
    private int bonks = 0;
    private int coin = 0;
    private static SoundClip deadSound;
    private static final Shape dogeShape = new PolygonShape(
            0.74f,-1.38f, -1.05f,-0.97f, -0.44f,1.03f, 0.31f,1.38f, 0.91f,0.95f, 1.05f,-0.5f);

    /**
     * The Doge has its picture taken from the data folder and the height is defined
     */
    private static final BodyImage image =
            new BodyImage("data/doge.png",3f);

    /**
     * Taking the death sound from one of the wav files in the data folder
     */
    static {
        try {
            deadSound = new SoundClip("data/oof.wav");
            System.out.println("Loading death sound");
        }  catch (UnsupportedAudioFileException | LineUnavailableException | IOException e){
            System.out.println(e);
        }
    }

    /**
     * The Doge's image is placed onto the world
     * @param world
     */
    public Doge(World world) {
        super(world,dogeShape);
        addImage(image);
    }

    /**
     *Destroys the Doge and plays the death sound on contact with an enemy body
     */
    @Override
    public void destroy(){
        deadSound.play();
        super.destroy();
    }

    /**
     * Methods to add, get and set the values of both the amount of coins and bonks
     */
    public void addBonks(){
        bonks++;
    }

    public void addCoin(){
        coin++;
    }

    public int getBonks() {
        return bonks;
    }

    public int getCoin(){
        return coin;
    }

    public void setBonks(int bonks) {
        this.bonks = bonks;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }
}
