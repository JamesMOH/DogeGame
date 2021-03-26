package game;

import city.cs.engine.*;

public class Bat extends DynamicBody {

    // create the bat object
    private static final Shape batShape
            = new PolygonShape(-1.4f,-1.24f, -1.27f,-1.36f, 1.39f,1.12f, 1.31f,1.32f, 1.04f,1.4f);

    //creates the bat image
    private static final BodyImage batImage
            = new BodyImage("data/bonkbat.png", 2f);

    // creates the bat image when a bat is created
    public Bat(World world){
        super(world, batShape);
        addImage(batImage);
    }

}
