package Engine.physics;

import java.awt.*;

public class Movement {

    private Entity entity;
    private EDirection directionTo;
    private boolean isMoving = false;


    public Movement(Entity entity, EDirection to){
        this.entity = entity;
        this.directionTo = to;
    }

    public Point currentPosition(){
        return entity.getCurrentPosition();
    }

    public Point getNextPosition(){
        Point nextPosition = currentPosition();
        switch (directionTo) {
            case UP : nextPosition.setLocation(nextPosition.x, nextPosition.y-entity.getSpeed());break;
            case DOWN : nextPosition.setLocation(nextPosition.x, nextPosition.y+entity.getSpeed());break;
            case LEFT : nextPosition.setLocation(nextPosition.x-entity.getSpeed(), nextPosition.y);break;
            case RIGHT : nextPosition.setLocation(nextPosition.x+entity.getSpeed(), nextPosition.y);break;
        }
        return nextPosition;
    }

}
