package game;

import city.cs.engine.*;

import javax.imageio.IIOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Cheems extends Walker {


    // create cheems object
    private int bonkCount;

    private static SoundClip bonkSound;

    private static final Shape cheemsShape = new PolygonShape(
            0.83f,-1.21f, -0.89f,-1.13f, -0.68f,0.99f, -0.13f,1.27f, 0.89f,0.11f, 0.96f,-0.59f);

    private static final BodyImage image =
            new BodyImage("data/cheems.png",3f);


    // load bonk sound for Bonkhitter
    static {
        try {
            bonkSound = new SoundClip("data/bonkSA.wav");
            System.out.println("Loading bonk sound");
        }  catch (UnsupportedAudioFileException | LineUnavailableException | IOException e){
            System.out.println(e);
        }
    }

    //creates the cheems image when it is created in the world
    public Cheems(World world) {
        super(world, cheemsShape);
        addImage(image);
    }

    //plays the sound for when a cheems object is destroyed
    @Override
    public void destroy(){
        bonkSound.play();
        super.destroy();
    }

}
