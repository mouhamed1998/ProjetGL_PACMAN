package Engine.physics.Collision;

import Engine.physics.movement.Entity;
import Engine.physics.movement.MovableEntity;
import Engine.physics.movement.MovementType;
import Pacman.Wall;

public class CollisionMap implements  CollisionWall {
    @Override
    public void CollisionUPWithWall(MovableEntity entity, Entity wall) {
        MovementType direction = entity.getDirection();
        int movableX = entity.getPixelPosition().x;
        int movableY = entity.getPixelPosition().y;
        int WallX = wall.getPixelPosition().x;
        int WallY = wall.getPixelPosition().y;
        int size = entity.getSize();
        if(direction == MovementType.UP) {
            int chekY = (movableY-WallY );
            int chekX = Math.abs(movableX - WallX);
            if(chekY <=0 && chekY<=size && chekX<size ) {
                entity.setDirection(MovementType.STOP);
                //entity.stop();
            }
        }
        /*
        MovementType direction = entity.getDirection();
        int movableX = entity.getPixelPosition().x;
        int movableY = entity.getPixelPosition().y;
        int WallX = wall.getPixelPosition().x;
        int WallY = wall.getPixelPosition().y;
        int size = wall.getSize();
        int chekY = (movableY - WallY);
        int chekX = (movableX - WallX);
        switch (direction){
            case UP:
                if(chekY <=0 && chekY<=size && chekX<size) {
                    entity.setDirection(MovementType.STOP);
                    //entity.stop();
                }
                break;
            case DOWN:
                if(chekY >=0 && chekY<=size && chekX<size) entity.setDirection(MovementType.STOP);
                break;
            case LEFT:
                if(chekX >=0 && chekX<=size && chekY<size) entity.setDirection(MovementType.STOP);
                break;
            case RIGHT:
                if(chekX >=0&& chekX<=size && chekY<size) entity.setDirection(MovementType.STOP);
                break;
        }

         */


    }

    @Override
    public void CollisionDOWNWithWall(MovableEntity entity, Entity wall) {
        MovementType direction = entity.getDirection();
        int movableX = entity.getPixelPosition().x;
        int movableY = entity.getPixelPosition().y;
        int WallX = wall.getPixelPosition().x;
        int WallY = wall.getPixelPosition().y;
        int size = wall.getSize();
        System.out.println(size);
        int chekY = (WallY - movableY);
        int chekX = Math.abs(movableX - WallX);
        if(direction == MovementType.DOWN) {
            if(chekY >=0 && chekX<size && chekY<size) entity.setDirection(MovementType.STOP);
        }
    }

    @Override
    public void CollisionLEFTWithWall(MovableEntity entity, Entity wall) {
        MovementType direction = entity.getDirection();
        int movableX = entity.getPixelPosition().x;
        int movableY = entity.getPixelPosition().y;
        int WallX = wall.getPixelPosition().x;
        int WallY = wall.getPixelPosition().y;
        int size = wall.getSize();
        int chekY = Math.abs(movableY - WallY);
        int chekX = (movableX - WallX);
        if(direction == MovementType.LEFT) if(chekX >=0 && chekX<=size && chekY<size) entity.setDirection(MovementType.STOP);
    }

    @Override
    public void CollisionRIGHTWithWall(MovableEntity entity, Entity wall) {
        MovementType direction = entity.getDirection();
        int movableX = entity.getPixelPosition().x;
        int movableY = entity.getPixelPosition().y;
        int WallX = wall.getPixelPosition().x;
        int WallY = wall.getPixelPosition().y;
        int size = wall.getSize();
        int chekX = ( WallX - movableX);
        int chekY = Math.abs(WallY - movableY);
        if(direction == MovementType.RIGHT)if(chekX >=0 && chekX<=size && chekY<size) entity.setDirection(MovementType.STOP);
    }
}
