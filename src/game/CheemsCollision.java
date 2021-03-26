package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class CheemsCollision implements CollisionListener {

    //constructor for the collision between doge and cheems
    private Cheems cheems;
    public CheemsCollision(Cheems cheems){
        this.cheems = cheems;
    }

    // create collision between doge and cheems
    // destroys the player (doge)
    // sets the player character to be dead
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Doge){
            e.getOtherBody().destroy();
            MyView.setPlayerDead(true);
            System.out.println("Character Dead");
        }

    }
}
