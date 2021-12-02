package Engine.physics.movement;

import Engine.physics.Collision.CollisionMap;

import javax.swing.*;
import java.awt.*;

public class MovableEntity extends Entity implements Movement{
    private Image normalImage, upImage, downImage, leftImage,rightImage,image;
    private Point pixelPosition;

    //MovableEntity pacman = new Pacman();
    public Image getNormalImage() {
        return normalImage;
    }

    public Image getUpImage() {
        return upImage;
    }

    public Image getDownImage() {
        return downImage;
    }

    public Image getLeftImage() {
        return leftImage;
    }

    public Image getRightImage() {
        return rightImage;
    }

    @Override
    public Point getCurrentPosition() {
        System.out.println(getPixelPosition());
        int size=30;
        if((this.pixelPosition.x-10)%size!=0||(this.pixelPosition.y-10)%size!=0) return null;
        else return new Point((this.pixelPosition.x-10)/size, (this.pixelPosition.y-10)/size);
    }

    @Override
    public Image getImage() {
        return image;
    }

    public CollisionMap getCollisionMap() {
        return collisionMap;
    }

    public MovementType direction = MovementType.STOP;
    int speed=1;
    public int getSpeed() {
        return speed;
    }
    private JPanel map;
    public MovementType getDirection(){
        return direction;
    }
    public void setDirection(MovementType direction){
        this.direction =direction;
    }
    @Override
    public String getUrls() {
        return null;
    }

    @Override
    public void setSpeed(int i) {

    }

    @Override
    public int getNumber() {
        return 0;
    }

    CollisionMap collisionMap = new CollisionMap();
    public JPanel getMap(){
        return map;
    }

    public void setMap(JPanel map){
        this.map = map;
    }

    public void move() {

        switch (this.getDirection()) {
            case UP:
                this.getPixelPosition().y -= speed;
                //this.setImage(upImage);
                break;
            case DOWN:
                this.getPixelPosition().y += speed;
                //this.setImage(downImage);
                break;
            case LEFT:
                this.getPixelPosition().x -= speed;
                //this.setImage(leftImage);
                break;
            case RIGHT:
                this.getPixelPosition().x += speed;
                //this.setImage(rightImage);
                break;
            default:
                break;
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
        this.direction = MovementType.STOP;
    }
}
