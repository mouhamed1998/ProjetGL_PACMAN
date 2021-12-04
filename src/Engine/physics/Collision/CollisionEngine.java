package Engine.physics.Collision;

import Engine.physics.movement.Entity;

public interface CollisionEngine {

    /**
     * on peut considerer deux types de collisions :
     * Rectangle : entre ghost et Pacman
     * Cercle: entre Pacman et Gum
     */

    public boolean isOutOfMazeWindow(Entity e1, int mazeHeight, int mazeWidth);
    public boolean isCollision(Entity e1, Entity e2);

}
