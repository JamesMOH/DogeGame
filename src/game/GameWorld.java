package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {

    private Doge doge;
    private Cheems cheems;

    // redundant because of the levels, refer to note at dogeSpawn!
    public GameWorld(){
        // make the ground
        Shape shape = new BoxShape(11, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, -11.5f));


        // make a platform
        Shape platform1Shape = new BoxShape(4, 0.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-9, 5.5f));

        // add another platform here
        Shape platform2Shape = new BoxShape(4, 0.5f);
        StaticBody platform2 = new StaticBody(this, platform2Shape);
        platform2.setPosition(new Vec2(9, 2.5f));
        platform2.setAngleDegrees(10);

        Shape platform3Shape = new BoxShape(4, 0.5f);
        StaticBody platform3 = new StaticBody(this, platform3Shape);
        platform3.setPosition(new Vec2(0, -3));

        Shape platform4Shape = new BoxShape(2.5f, 0.5f);
        StaticBody platform4 = new StaticBody(this, platform4Shape);
        platform4.setPosition(new Vec2(-12,-7));

        Shape platform5Shape = new BoxShape(2.5f, 0.5f);
        StaticBody platform5 = new StaticBody(this, platform5Shape);
        platform5.setPosition(new Vec2(2,7));

        // make a character
        //doge.setLinearVelocity(new Vec2(0,11));
        //doge.setAlwaysOutline(true);

        // add more bodies here

        Cheems cheems = new Cheems(this);
        cheems.setPosition(new Vec2(-8, -10));

        Cheems cheems2 = new Cheems(this);
        cheems2.setPosition(new Vec2(-9, 6));

        Cheems cheems3 = new Cheems(this);
        cheems3.setPosition(new Vec2(0, -2.5f));


        /*doge = new DogeSpawn(this).spawner(8,-10);
         */
        doge = new Doge(this);
        doge.setPosition(new Vec2(8, -10));
        CheemsCollision cheemsCollision = new CheemsCollision(cheems);
        doge.addCollisionListener(cheemsCollision);
    }

    public Doge getDoge(){
        return doge;
    }
    public Cheems getCheems(){
        return cheems;
    }

}
