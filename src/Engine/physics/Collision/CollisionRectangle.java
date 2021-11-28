package Engine.physics.Collision;

import Engine.physics.movement.Entity;

import java.awt.*;

public class CollisionRectangle implements CollisionEngine {
    @Override
    public boolean isOutOfMazeWindow(Entity e1, int mazeHeight, int mazeWidth) {
        return false;
    }

    @Override
    public boolean isCollision(Entity e1, Entity e2) {
        Rectangle r1 = new Rectangle(e1.getPixelPosition().x, e1.getPixelPosition().y, e1.getSize(), e1.getSize());
        Rectangle r2 = new Rectangle(e2.getPixelPosition().x, e2.getPixelPosition().y, e2.getSize(), e2.getSize());
        return r1.intersects(r2);
    }
}
