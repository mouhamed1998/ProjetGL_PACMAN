package GamePlay.Pacman;

import Engine.kernel.Kernel;
import Engine.AI.AiInterface;
import Engine.AI.AstarAI;
import Engine.physics.Collision.CollisionMap;
import Engine.physics.movement.MovableEntity;
import Engine.physics.movement.MovementType;
import GamePlay.GameGraphic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Ghost extends MovableEntity {
    //public RandomMovement AI;
    public AiInterface AI;
    //import AI.RandomMovement;
    private int number;
    public MovementType nextDirection;
    private double speed = 1;
    private GameGraphic gameGraphic;
    //1 ---> Rouge;

    public int getNumber() {
        return number;
    }
    private Image image;

    public Ghost(Point position, int number) {
        //this.map = new Map();

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

    @Override
    public String getUrls() {
        switch (number){
            case 1:{
                Image image = new ImageIcon(("src/API/ressource/pacman_img/Image/Ghost/Blinky/Blinky-0.png")).getImage();
                this.setImage(image);
                return"src/API/ressource/pacman_img/Image/Ghost/Blinky/Blinky-0.png";

            }
            case 2:{
                Image image = new ImageIcon(("src/API/ressource/pacman_img/Image/Ghost/Pinky/Pinky-0.png")).getImage();
                this.setImage(image);
                return "src/API/ressource/pacman_img/Image/Ghost/Pinky/Pinky-0.png";
            }

            case 3:{
                Image image = new ImageIcon(("src/API/ressource/pacman_img/Image/Ghost/Inky/Inky-0.png")).getImage();
                this.setImage(image);
                return "src/API/ressource/pacman_img/Image/Ghost/Inky/Inky-0.png";

            }

        }
        return null;
    }

    public AiInterface getAI() {
        return AI;
    }

    public Image getImage() {
        switch (number){
            case 1:{
                this.image = new ImageIcon(("src/API/ressource/pacman_img/Image/Ghost/Blinky/Blinky-0.png")).getImage();
                this.setImage(image);
                return  image;

            }
            case 2:{
                this.image = new ImageIcon(("src/API/ressource/pacman_img/Image/Ghost/Pinky/Pinky-0.png")).getImage();
                this.setImage(image);
                return image;
            }

            case 3:{
                Image image =  new ImageIcon(("src/API/ressource/pacman_img/Image/Ghost/Inky/Inky-0.png")).getImage();
                this.setImage(image);
                return image;
            }


        }
        return null;
    }
    public Ghost(Ghost ghost, GameGraphic gameGraphic){
        this.nextDirection = MovementType.LEFT;
        this.direction = MovementType.STOP;
        this.number = ghost.getNumber();
        this.setPosition(ghost.getPosition());
        this.setPixelPosition(new Point(ghost.getPosition().x*this.getSize()+10 ,ghost.getPosition().y*this.getSize()+10));
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

        AI =new AstarAI();
        this.gameGraphic = gameGraphic;
        //nextMoveCalculateByAI(this.map);
        this.setPosition(ghost.getPosition());
        this.setPixelPosition(new Point(ghost.getPosition().x*30+10, ghost.getPosition().y*30+10));
        this.setGameBoard(this.gameGraphic);

    }
    public void nextMoveCalculateByAI(Kernel kernel){
        MovementType movementType = this.AI.getMovement(this, kernel);
        //System.out.println("movement: " + movementType);
        this.setDirection(movementType);
    }
    public Point getCurrentPosition() {
        System.out.println(getPixelPosition());
        int size=30;
        if((this.getPixelPosition().x-10)%size!=0||(this.getPixelPosition().y-10)%size!=0) return null;
        else return new Point((this.getPixelPosition().x-10)/size, (this.getPixelPosition().y-10)/size);
    }

    public Boolean canMove() {
        return true;
    }
    public void verifyNextDirection(ArrayList<Wall> walls) {
        if (nextDirection == MovementType.STOP) return;
        Ghost ghost = new Ghost(this, this.gameGraphic);
        ghost.setDirection(this.nextDirection);
        ghost.setPixelPosition(this.getPixelPosition());
        CollisionMap collision = new CollisionMap();
        for (Wall wall : walls) {
            collision.collisionWithWall(ghost, wall);
        }
        if (ghost.getDirection() != MovementType.STOP) calculateNextDirection();
    }

    private void calculateNextDirection() {
        this.setDirection(nextDirection);
        nextDirection = MovementType.STOP;
    }

    @Override
    public void move() {

        switch (this.getDirection()) {
            case UP:
                this.getPixelPosition().y -= speed;
                this.gameGraphic.getGraphics().drawImage(this.getImage(), getPixelPosition().x, getPixelPosition().y, null);
                this.gameGraphic.repaint();
                break;
            case DOWN:
                this.getPixelPosition().y += speed;
                this.gameGraphic.getGraphics().drawImage(this.getImage(), getPixelPosition().x, getPixelPosition().y, null);
                this.gameGraphic.repaint();
                break;
            case LEFT:
                this.getPixelPosition().x -= speed;
                this.gameGraphic.getGraphics().drawImage(this.getImage(), getPixelPosition().x, getPixelPosition().y, null);
                this.gameGraphic.repaint();
                break;
            case RIGHT:
                this.getPixelPosition().x += speed;
                this.gameGraphic.getGraphics().drawImage(this.getImage(), getPixelPosition().x, getPixelPosition().y, null);
                this.gameGraphic.repaint();
                break;
            default:
                //nextMoveCalculateByAI(this.map);
                //move();
                break;
        }

    }

    @Override

    public String name() {
        return null;
    }

    @Override
    public void goUp() {
        this.nextDirection = MovementType.UP;
    }

    @Override
    public void goDown() {
        this.nextDirection = MovementType.DOWN;
    }

    @Override
    public void goLeft() {
        this.nextDirection = MovementType.LEFT;
    }

    @Override
    public void goRight() {
        this.nextDirection = MovementType.RIGHT;
    }

    @Override
    public void stop() {
        this.nextDirection = MovementType.STOP;
    }
}
