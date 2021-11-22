package Engine.physics.Collision;

import Engine.physics.movement.Entity;
import Engine.physics.movement.MovableEntity;
import Engine.physics.movement.Movement;
import Pacman.Wall;

public interface CollisionWall {
    public void CollisionUPWithWall(MovableEntity entity, Entity wall);
    public void CollisionDOWNWithWall(MovableEntity entity, Entity wall);
    public void CollisionLEFTWithWall(MovableEntity entity, Entity wall);
    public void CollisionRIGHTWithWall(MovableEntity entity, Entity wall);


}
