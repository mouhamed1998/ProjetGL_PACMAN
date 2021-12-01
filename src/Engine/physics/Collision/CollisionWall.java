package Engine.physics.Collision;

import Engine.physics.movement.*;
import Pacman.Pacman;
import Pacman.Wall;

public interface CollisionWall {
    //public void CollisionUPWithWall(MovableEntity entity, Entity wall);
    //public void CollisionDOWNWithWall(MovableEntity entity, Entity wall);
    //public void CollisionLEFTWithWall(MovableEntity entity, Entity wall);
    //public void CollisionRIGHTWithWall(MovableEntity entity, Entity wall);
    public void collisionWithWall(PlayerEntity movableEntity, ImmovableEntity wall);
    boolean isCollisionWithWall(PlayerEntity movableEntity, ImmovableEntity wall);

}
