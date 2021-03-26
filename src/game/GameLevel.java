package game;

import city.cs.engine.World;

/**
 * Represents the framework of each level that is created
 */
public abstract class GameLevel extends World {
    /**
     * Defines the classes that the elements of the levels will pull from
     */
    private Doge doge;
    private Cheems cheems1;
    private Cheems cheems2;
    private Cheems cheems3;
    private Cage cage;

    //framework for level with 3 cheems enemies, 1 doge player and a cage to the next level

    /**
     * Constructs the GameLevel class
     * Each GameLevel has 1 player, doge, 3 enemies, cheems 1, 2 and 3, and a cage for the ending point of each level
     * The cage is set a collisionlistener to go to the next level if the player collides with it with the right amount of coins
     * Each Cheems (enemy) is set a collisionlistener to destroy the player if they collide to kill them
     * @param game
     */
    public GameLevel(Game game){
        doge = new Doge(this);
        CoinCollection coinCollection = new CoinCollection(doge);
        doge.addCollisionListener(coinCollection);
        cheems1 = new Cheems(this);
        cheems2 = new Cheems(this);
        cheems3 = new Cheems(this);
        cage = new Cage(this);
        // adds the collisions between the objects
        CageCollision cageCollision = new CageCollision(this, game);
        cage.addCollisionListener(cageCollision);
        CheemsCollision c1 = new CheemsCollision(cheems1);
        cheems1.addCollisionListener(c1);
        CheemsCollision c2 = new CheemsCollision(cheems2);
        cheems2.addCollisionListener(c2);
        CheemsCollision c3 = new CheemsCollision(cheems3);
        cheems3.addCollisionListener(c3);
    }

    // returns all the aspects and starts the level isComplete method

    /**
     * Gets each element of the gamelevels
     * @return
     */
    public Doge getDoge(){
        return doge;
    }
    public Cheems getCheems1(){
        return cheems1;
    }

    public Cheems getCheems2() {
        return cheems2;
    }

    public Cheems getCheems3() {
        return cheems3;
    }

    public Cage getCage() {
        return cage;
    }

    /**
     * Each level an abstract variable for each level to check if the parameters for completion have been completed
     * Each level has an abstract string variables to return what level it is for saving and loading
     * @return
     */
    public abstract boolean isComplete();

    public abstract String getLevelName();
}
