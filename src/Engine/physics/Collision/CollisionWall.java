package Engine.physics.Collision;

import Engine.physics.movement.MovableEntity;
import GamePlay.Pacman.Wall;

public interface CollisionWall {
    //public void CollisionUPWithWall(MovableEntity entity, Entity wall);
    //public void CollisionDOWNWithWall(MovableEntity entity, Entity wall);
    //public void CollisionLEFTWithWall(MovableEntity entity, Entity wall);
    //public void CollisionRIGHTWithWall(MovableEntity entity, Entity wall);
    public void collisionWithWall(MovableEntity movableEntity, Wall wall);


}
