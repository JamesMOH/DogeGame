package game;

import city.cs.engine.Walker;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DogeController implements KeyListener {

    private static final float WALKING_SPEED = 4;
    private Doge doge;


  // Controls for movement W to jump, and A and D to move right and left
    public DogeController(Doge doge){
        this.doge = doge;
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            doge.stopWalking();
        } else if (code == KeyEvent.VK_D) {
            doge.stopWalking();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_A) {
            doge.startWalking(-WALKING_SPEED);
        } else if (code == KeyEvent.VK_D) {
            doge.startWalking(WALKING_SPEED);
        } else if (code == KeyEvent.VK_W){
            doge.jump(10);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // updates the controls for the player when the level changes
    public void updateDoge(Doge doge) {
        this.doge = doge;
    }
}
