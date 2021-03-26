package game;

import org.jbox2d.common.Vec2;

public class DogeSpawn {

    private GameWorld world;
    private MyView view;

    //this doesn't do anything anymore - some things are better to teach us first or at least tell us to adapt our code around!

    public DogeSpawn(GameWorld w){
        world = w;
    }

    public Doge spawner(int xval, int yval){
        Doge doge = new Doge(world);
        doge.setPosition(new Vec2(xval, yval));
        CheemsCollision cheemsCollision = new CheemsCollision(world.getCheems());
        doge.addCollisionListener(cheemsCollision);
        return doge;
    }
}
