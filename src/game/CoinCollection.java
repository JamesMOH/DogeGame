package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class CoinCollection implements CollisionListener {
    private Doge doge;

    public CoinCollection(Doge doge){
        this.doge = doge;
    }

    // add collision between coin and doge
    // destroys the coin object
    // increments the amount of coins the player has
    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Dogecoin){
            System.out.println(doge.getCoin());
            collisionEvent.getOtherBody().destroy();
            doge.addCoin();
            MyView.addCoins();
        }
    }

}
