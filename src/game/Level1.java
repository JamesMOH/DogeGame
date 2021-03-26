package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Timer;
import org.jbox2d.common.Vec2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Level1 extends GameLevel{
    public Level1(Game game) {
        super(game);

        // create level 1 and all the positions of each element

        Shape shape = new BoxShape(11, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, -11.5f));

        getDoge().setPosition(new Vec2(8,-10));
        getCheems1().setPosition(new Vec2(-8,-10));
        getCheems2().setPosition(new Vec2(-9,6));
        getCheems3().setPosition(new Vec2(0,-2.5f));
        getCage().setPosition(new Vec2(-10,8));
        //getCage().setPosition(new Vec2(8,-10));


        // creating the platforms for the level

        Shape platform1Shape = new BoxShape(4, 0.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-9, 5.5f));


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

    }

    // check to see if the level is complete
    @Override
    public boolean isComplete() {
        if (getDoge().getCoin() == 3){
            return true;
        } else {
            return false;
        }
    }

    public String getLevelName(){
        return "Level1";
    }

}


