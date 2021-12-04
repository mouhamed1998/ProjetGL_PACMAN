package Engine.physics.Collision;

import Engine.physics.movement.MovableEntity;
import GamePlay.Pacman.Wall;

/**
 * une interface avec une méthode qui permet de gèrer les collisions des entitées avec les murs
 */
public interface CollisionWall {
    //public void CollisionUPWithWall(MovableEntity entity, Entity wall);
    //public void CollisionDOWNWithWall(MovableEntity entity, Entity wall);
    //public void CollisionLEFTWithWall(MovableEntity entity, Entity wall);
    //public void CollisionRIGHTWithWall(MovableEntity entity, Entity wall);
    public void collisionWithWall(MovableEntity movableEntity, Wall wall);


}
