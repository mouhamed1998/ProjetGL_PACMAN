package Engine.physics.Collision;

import Engine.physics.movement.Entity;
import Engine.physics.movement.MovableEntity;
import Engine.physics.movement.Movement;
import Pacman.Pacman;
import Pacman.Wall;

public interface CollisionWall {
    //public void CollisionUPWithWall(MovableEntity entity, Entity wall);
    //public void CollisionDOWNWithWall(MovableEntity entity, Entity wall);
    //public void CollisionLEFTWithWall(MovableEntity entity, Entity wall);
    //public void CollisionRIGHTWithWall(MovableEntity entity, Entity wall);
    public void collisionWithWall(MovableEntity movableEntity, Wall wall);
    boolean isCollisionWithWall(MovableEntity movableEntity, Wall wall);

}
