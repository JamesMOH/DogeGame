package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler extends MouseAdapter {

    private GameLevel level;
    private MyView view;
    private Game game;

    public MouseHandler(GameLevel gl, MyView gv, Game g) {
        level = gl;
        view = gv;
        game = g;
    }

    /**
     * Create a bowling ball at the current mouse position.
     * @param e event object containing the mouse position
     */

    // spawns a bat object where the mouse is clicked and adds a collisionListener for bonkHitter

    public void mousePressed(MouseEvent e) {
        Bat bat = new  Bat(level);
        Point musePoint = e.getPoint();
        Vec2 worldPoint = view.viewToWorld(e.getPoint());
        bat.setPosition(worldPoint);
        BonkHitter hitter = new BonkHitter(bat, level.getDoge(),level,view);
        bat.addCollisionListener(hitter);
    }


    // updates the mouse when the level changes
    public void updateMouse(GameLevel gameLevel){
        this.level = gameLevel;
    }

}

