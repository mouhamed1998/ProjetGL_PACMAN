package Engine.physics.movement;

import Engine.physics.Collision.CollisionMap;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlayerEntity extends Entity implements Movement {

    protected Image  normalImage, upImage, downImage, leftImage,rightImage,image;
    public MovementType nextDirection;
    protected JPanel jPanel;
    public MovementType direction = MovementType.STOP;
    int speed=1;

    public PlayerEntity(Point position, JPanel jPanel){
        this.jPanel = jPanel;
        nextDirection = MovementType.STOP;
        this.direction = MovementType.RIGHT;
        this.setPosition(position);
        this.setPixelPosition(new Point(position.x*getSize()+10 ,position.y*getSize()+10));
        this.upImage = new ImageIcon("src/API/ressource/pacman_img/Image/Pacman/up/up.gif").getImage();
        this.normalImage = new ImageIcon("src/API/ressource/pacman_img/right.gif").getImage();
        this.image = new ImageIcon("src/API/ressource/pacman_img/right.gif").getImage();
        this.downImage = new ImageIcon("src/API/ressource/pacman_img/Image/Pacman/down/down.gif").getImage();
        this.leftImage = new ImageIcon("src/API/ressource/pacman_img/Image/Pacman/left/left.gif").getImage();
        this.rightImage = new ImageIcon("src/API/ressource/pacman_img/Image/Pacman/right/right.gif").getImage();
        this.setImage(normalImage);

    }

    public PlayerEntity(Point position){
        setPosition(position);
        setPixelPosition(new Point(position.x*getSize()+10 ,position.y*getSize()+10));
    }
    public PlayerEntity(){}
    public int getSpeed() {
        return speed;
    }
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

    public void move() {

//        switch (this.getDirection()) {
//            case UP:
//                this.getPixelPosition().y -= speed;
//                //this.setImage(upImage);
//                break;
//            case DOWN:
//                this.getPixelPosition().y += speed;
//                //this.setImage(downImage);
//                break;
//            case LEFT:
//                this.getPixelPosition().x -= speed;
//                //this.setImage(leftImage);
//                break;
//            case RIGHT:
//                this.getPixelPosition().x += speed;
//                //this.setImage(rightImage);
//                break;
//            default:
//                break;
        switch (this.getDirection()) {
            case UP:
                this.setImage(upImage);
                this.getPixelPosition().y -= speed;
                this.jPanel.getGraphics().drawImage(this.image, getPixelPosition().x, getPixelPosition().y, null);
                //this.nextDirection = MovementType.UP;
                this.jPanel.repaint();
                break;
            case DOWN:
                this.setImage(downImage);
                this.getPixelPosition().y += speed;
                this.jPanel.getGraphics().drawImage(this.image, getPixelPosition().x, getPixelPosition().y, null);
                //this.nextDirection = MovementType.DOWN;
                this.jPanel.repaint();
                break;
            case LEFT:
                this.setImage(leftImage);
                this.getPixelPosition().x -= speed;
                this.jPanel.getGraphics().drawImage(this.image, getPixelPosition().x, getPixelPosition().y, null);
                //this.nextDirection = MovementType.LEFT;
                this.jPanel.repaint();
                break;
            case RIGHT:
                this.setImage(rightImage);
                this.getPixelPosition().x += speed;
                this.jPanel.getGraphics().drawImage(this.image, getPixelPosition().x, getPixelPosition().y, null);
                //this.nextDirection = MovementType.RIGHT;
                this.jPanel.repaint();
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

    public void verifyNextDirection(ArrayList<ImmovableEntity> walls) {
        if (nextDirection == MovementType.STOP) return;
        this.setDirection(this.nextDirection);
        this.setPixelPosition(this.getPixelPosition());
        CollisionMap collision = new CollisionMap();
        for (ImmovableEntity wall : walls) {
            collision.collisionWithWall(this, wall);
        }
        if (this.getDirection() != MovementType.STOP) calculateNextDirection();
    }
    private void calculateNextDirection() {
        this.setDirection(nextDirection);
        nextDirection = MovementType.STOP;
    }
}
