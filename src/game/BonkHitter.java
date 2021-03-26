package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

public class BonkHitter implements CollisionListener {

    private Bat bat;
    private Doge doge;
    private GameLevel level;
    private MyView view;

    public BonkHitter(Bat bat, Doge doge, GameLevel level, MyView view){
        this.bat = bat;
        this.doge = doge;
        this.level = level;
        this.view = view;
    }

    // collision between bat and cheems to destroy cheems
    // creates a dogecoin object when a cheems is destroyed
    // destroys the bat on contact
    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Cheems){
            doge.addBonks();
            System.out.println(doge.getBonks());
            collisionEvent.getOtherBody().destroy();
            Dogecoin dogecoin = new Dogecoin(level);
            dogecoin.setPosition(bat.getPosition());
            bat.destroy();
        }
    }
}
