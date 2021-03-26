package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Dogecoin extends DynamicBody {

    // creates round dogecoin object
    private static SoundClip coinSound;
    private static final float RADIUS = 1f;

    private static final Shape coinShape
            = new CircleShape(RADIUS);

    // creates the dogecoin image
    private static final BodyImage coinImage
            = new BodyImage("data/dogecoin.png", 2*RADIUS);

    // loads the coin sound
    static {
        try {
            coinSound = new SoundClip("data/coinSA.wav");
            System.out.println("Loading coin sound");
        }  catch (UnsupportedAudioFileException | LineUnavailableException | IOException e){
            System.out.println(e);
        }
    }

    // creates the dogecoin image when it is created in the world
    public Dogecoin(World world) {
        super(world, coinShape);
        addImage(coinImage);
    }

    //plays the coin sound when it is destroyed
    @Override
    public void destroy(){
        coinSound.play();
        super.destroy();
    }

}
