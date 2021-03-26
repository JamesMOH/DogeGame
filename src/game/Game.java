package game;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A world with some bodies.
 */
public class Game implements ActionListener {

    /** The World in which the bodies move and interact. */
    private static GameLevel level;

    /** A graphical display of the world (a specialised JPanel). */
    private MyView view;

    private DogeController controller;

    private SoundClip gameMusic;

    private MouseHandler mouseHandler;

    private static Timer timer;

    public static int seconds;

    /** Initialise a new Game. */
    public Game() {

        // make the world
        level = new Level1(this);

        // make a view
        view = new MyView(level, 500, 500);

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        //Initialises the music for the whole game, may have to change with levels though >:(
        try {
            gameMusic = new SoundClip("data/backMuse.wav");
            gameMusic.loop();
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e){
            System.out.println(e);
        }

        controller = new DogeController((level.getDoge()));
        view.addKeyListener(controller);

        // add some mouse actions
        // add this to the view, so coordinates are relative to the view
        mouseHandler = new MouseHandler(level, view, this);
        view.addMouseListener(mouseHandler);

        // add the view to a frame (Java top level window)
        final JFrame frame = new JFrame("DogeGame");
        frame.add(view);

        // add the side buttons
        ControlPanel buttons = new ControlPanel(this);
        frame.add(buttons.getMainPanel(), BorderLayout.WEST);

        view.addMouseListener(new GiveFocus(view));

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        // uncomment this to make a debugging view
        // JFrame debugView = new DebugViewer(world, 500, 500);

        // start our game world simulation!

        timer = new Timer(1000, this);
        //level.start();
    }

    public void setLevel(GameLevel level){
        //stop the current level
        this.level.stop();
        // change the level to the level being loaded
        this.level = level;
        //change the view to look into new level
        view.setWorld(this.level);
        //change the controller to control the
        //student in the new world
        controller.updateDoge(this.level.getDoge());
        //start the simulation in the new level
        mouseHandler.updateMouse(this.level);
        if (level.getLevelName() == "Level2"){
            MyView.setClevel(2);
        } else if (level.getLevelName() == "Level3"){
            MyView.setClevel(3);
        }
        this.level.start();
        timer.start();
    }

    public void goToNextLevel(){

        if (level instanceof Level1){
            //stop the current level
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level2(this);
            //change the view to look into new level
            //MyView.incLevel();
            //view = new MyView(level,500,500);
            //MyView.incLevel();
            view.setWorld(level);
            //change the controller to control the
            //student in the new world
            controller.updateDoge(level.getDoge());
            //start the simulation in the new level
            mouseHandler.updateMouse(level);
            MyView.incLevel();
            level.start();
        }
        else if (level instanceof Level2){
            level.stop();
            level = new Level3(this);
            view.setWorld(level);
            controller.updateDoge(level.getDoge());
            mouseHandler.updateMouse(level);
            MyView.incLevel();
            level.start();
        }
        else if (level instanceof Level3){
            System.out.println("Well done! Game complete.");
            MyView.setPlayerwin(true);
            Game.getLevel().stop();
        }
    }

    public static GameLevel getLevel() {
        return level;
    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       seconds++;
       MyView.incMVseconds();
    }

    public static int getSeconds() {
        return seconds;
    }

    public static void setSeconds(int seconds) {
        Game.seconds = seconds;
    }

    public static Timer getTimer(){
        return timer;
    }
}
