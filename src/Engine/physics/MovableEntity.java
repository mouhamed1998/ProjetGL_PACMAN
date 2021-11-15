package Engine.physics;

import java.awt.*;

public class MovableEntity extends Entity implements Movement{
    public MovementType direction = MovementType.STOP;
    int speed=10;

    public int getSpeed() {
        return speed;
    }

    public MovementType getDirection(){
        return direction;
    }
    public void SetDirection(MovementType direction){
        this.direction =direction;
    }
    @Override
    public String getUrls() {
        return null;
    }
    public void move() {
        switch (this.getDirection()){
            case UP :{
                this.getPixelPosition().y -= getSpeed();
                setPixelPosition(new Point(getPixelPosition().x, getPixelPosition().y));
                //this.setImage(upImage);;
            }
            case DOWN :{
                this.getPixelPosition().y += getSpeed();
                setPixelPosition(new Point(getPixelPosition().x, getPixelPosition().y));
                //this.setImage(downImage);

            }
            case LEFT :{
                this.getPixelPosition().x -= getSpeed();
                setPixelPosition(new Point(getPixelPosition().x, getPixelPosition().y));
                //this.setImage(leftImage);
            }
            case RIGHT :{
                this.getPixelPosition().x += getSpeed();
                setPixelPosition(new Point(getPixelPosition().x, getPixelPosition().y));
                //this.setImage(rightImage);
            }
        }
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public void goUp() {
        this.direction = MovementType.UP;
    }

    @Override
    public void goDown() {
        this.direction = MovementType.DOWN;
    }

    @Override
    public void goLeft() {
        this.direction = MovementType.LEFT;
    }

    @Override
    public void goRight() {
        this.direction = MovementType.RIGHT;
    }

    @Override
    public void stop() {

    }
}
