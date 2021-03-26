package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class CageCollision implements CollisionListener {

    private GameLevel level;
    private Game game;

    public CageCollision(GameLevel level, Game game){
        this.level = level;
        this.game = game;
    }

    //create collision between doge and cage which leads to the next level
    //calls the method to play the cage sound effect
    @Override
    public void collide(CollisionEvent e){
        if (e.getOtherBody() instanceof Doge && level.isComplete()){
            game.goToNextLevel();
            System.out.println("Next Level");
            level.getCage().playCageSA();
        }
    }

}
