package Engine.physics.movement;

import Engine.AI.AiInterface;
import Engine.AI.AstarAI;
import Engine.Graphics.Map;
import Engine.physics.Collision.CollisionMap;

import javax.swing.*;
import java.awt.*;

import static Engine.physics.movement.MovementType.*;

public class MovableEntity extends Entity{

    protected int number;
    public MovementType direction = MovementType.STOP;
    public MovementType nextDirection;
    Map map;

    protected Image  normalImage, upImage, downImage, leftImage,rightImage,image;
    protected JPanel jPanel;
    int speed=5;
    public AiInterface AI;
    public MovableEntity(Point position){
        this.setPosition(position);
        this.setPixelPosition(new Point(position.x*getSize()+10 ,position.y*getSize()+10));
    }

    public MovableEntity(){}
    public MovableEntity(MovableEntity ghost, Map map) {
        this.nextDirection = LEFT;
        this.direction = LEFT;
        this.number = ghost.getNumber();
        this.setPosition(ghost.getPosition());
        this.setPixelPosition(new Point(ghost.getPosition().x * this.getSize() + 10, ghost.getPosition().y * this.getSize() + 10));
        switch (number) {
            case 1: {
                Image image = new ImageIcon(("src/API/ressource/pacman_img/Image/Ghost/Blinky/Blinky-0.png")).getImage();
                this.setImage(image);
                break;
            }
            case 2: {
                Image image = new ImageIcon(("src/API/ressource/pacman_img/Image/Ghost/Pinky/Pinky-0.png")).getImage();
                this.setImage(image);
                break;
            }
            case 3: {
                Image image = new ImageIcon(("src/API/ressource/pacman_img/Image/Ghost/Clyde/Clyde-0.png")).getImage();
                this.setImage(image);
                break;
            }
            default: {
                Image image = new ImageIcon(("src/API/ressource/pacman_img/Image/Ghost/Inky/Inky-0.png")).getImage();
                this.setImage(image);
                break;
            }
        }
        AI =new AstarAI();
        this.map = map;
        //nextMoveCalculateByAI(this.map);
        this.setPosition(ghost.getPosition());
        this.setPixelPosition(new Point(ghost.getPosition().x*30+10, ghost.getPosition().y*30+10));
        this.setGameBoard(map);
    }

    public MovableEntity(Point position, int number){
        this.number = number;
        this.setPosition(position);
        this.setPixelPosition(new Point(position.x*this.getSize()+10 ,position.y*this.getSize()+10));
        switch (number){
            case 1:{
                Image image = new ImageIcon(("src/API/ressource/pacman_img/Image/Ghost/Blinky/Blinky-0.png")).getImage();
                this.setImage(image);
                break;
            }
            case 2: {
                Image image = new ImageIcon(("src/API/ressource/pacman_img/Image/Ghost/Pinky/Pinky-0.png")).getImage();
                this.setImage(image);
                break;
            }
            case 3: {
                Image image = new ImageIcon(("src/API/ressource/pacman_img/Image/Ghost/Clyde/Clyde-0.png")).getImage();
                this.setImage(image);
                break;
            }
            default: {
                Image image = new ImageIcon(("src/API/ressource/pacman_img/Image/Ghost/Inky/Inky-0.png")).getImage();
                this.setImage(image);
                break;
            }
        }
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
                //this.setImage(leftImage);
                this.getPixelPosition().y -= speed;
                this.map.getGraphics().drawImage(this.image, getPixelPosition().x, getPixelPosition().y, null);
                //this.nextDirection = UP;
                //this.jPanel.repaint();
                break;
            case DOWN:
                //this.setImage(leftImage);
                this.getPixelPosition().y += speed;
                this.map.getGraphics().drawImage(this.image, getPixelPosition().x, getPixelPosition().y, null);
                //this.nextDirection = DOWN;
                //this.jPanel.repaint();
                break;
            case LEFT:
                //this.setImage(leftImage);
                this.getPixelPosition().x -= speed;
                this.map.getGraphics().drawImage(this.image, getPixelPosition().x, getPixelPosition().y, null);
                //this.nextDirection = LEFT;
                //this.jPanel.repaint();
                break;
            case RIGHT:
                this.setImage(rightImage);
                this.getPixelPosition().x += speed;
                this.map.getGraphics().drawImage(this.image, getPixelPosition().x, getPixelPosition().y, null);
                //this.nextDirection = MovementType.RIGHT;
                //this.jPanel.repaint();
                break;
            default:
                break;
        }
    }
    @Override
    public String getUrls() {
        return null;
    }
    CollisionMap collisionMap = new CollisionMap();

    public int getNumber() {
        return number;
    }

    public MovementType getDirection() {
        return direction;
    }
}