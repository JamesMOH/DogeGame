package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class Level3 extends GameLevel{
    public Level3(Game game) {
        super(game);

        // create level 3 and all the positions of each element

        Shape shape = new BoxShape(11, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, -11.5f));

        getDoge().setPosition(new Vec2(8,-10));
        getCheems1().setPosition(new Vec2(-3.5f, 1));
        getCheems2().setPosition(new Vec2(7,-4));
        getCheems3().setPosition(new Vec2(-3,10));
        getCage().setPosition(new Vec2(0,11));

        // creating the platforms for the level

        Shape platform1Shape = new BoxShape(5, 0.25f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(0, -7.5f));
        platform1.setFillColor(new Color(153,38,0));

        Shape platform2Shape = new BoxShape(4, 0.5f);
        StaticBody platform2 = new StaticBody(this, platform2Shape);
        platform2.setPosition(new Vec2(9, -6));
        platform2.setFillColor(new Color(153,38,0));

        Shape platform3Shape = new BoxShape(4, 0.25f);
        StaticBody platform3 = new StaticBody(this, platform3Shape);
        platform3.setPosition(new Vec2(-9, -4));
        platform3.setAngleDegrees(10);
        platform3.setFillColor(new Color(153,38,0));

        Shape platform4Shape = new BoxShape(2, 0.5f);
        StaticBody platform4 = new StaticBody(this, platform4Shape);
        platform4.setPosition(new Vec2(10, 1));
        platform4.setAngleDegrees(20);
        platform4.setFillColor(new Color(153,38,0));

        Shape platform5Shape = new BoxShape(3, 0.25f);
        StaticBody platform5 = new StaticBody(this, platform5Shape);
        platform5.setPosition(new Vec2(-3.5f, 0));
        platform5.setFillColor(new Color(153,38,0));

        Shape platform6Shape = new BoxShape(5, 0.5f);
        StaticBody platform6 = new StaticBody(this, platform6Shape);
        platform6.setPosition(new Vec2(0, 8));
        platform6.setAngleDegrees(20);
        platform6.setFillColor(new Color(153,38,0));
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
        return "Level3";
    }
}
