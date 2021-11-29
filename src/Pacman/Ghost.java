package Pacman;

import AI.AiInterface;
import AI.RandomMovement;
import Engine.Graphics.Map;
import Engine.physics.Collision.CollisionMap;
import Engine.physics.movement.Entity;
import Engine.physics.movement.MovableEntity;
import Engine.physics.movement.MovementType;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.jar.JarEntry;

public class Ghost extends MovableEntity {
    public RandomMovement AI;;
    private int number;
    public MovementType nextDirection;
    private double speed = 1;
    private Map map;
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
    public Ghost(Ghost ghost, Map map){
        this.nextDirection = MovementType.LEFT;
        this.direction = MovementType.LEFT;
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

        AI =new RandomMovement();
        this.map = map;
        nextMoveCalculateByAI(this.map);
        this.setPosition(ghost.getPosition());
        this.setPixelPosition(new Point(ghost.getPosition().x*30+10, ghost.getPosition().y*30+10));
        this.setGameBoard(map);
        /*
        try {
            String path = System.getProperty("user.dir");
            Image image = ImageIO.read(new File(path+ "/resources/Ghost/7.png"));
            this.setImage(image);
            //this.image = ImageIO.read(this.getClass().getResource("resources/Ghost/7.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

         */

    }
    public void nextMoveCalculateByAI(JPanel jPanel){
        MovementType movementType = this.AI.getMovement(this, jPanel);
        //System.out.println("movement: " + movementType);
        this.setDirection(movementType);
    }

    public Boolean canMove() {
        return true;
    }
    public void verifyNextDirection(ArrayList<Wall> walls) {
        if (nextDirection == MovementType.STOP) return;
        Ghost ghost = new Ghost(this, this.map);
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
        CollisionMap collisionMap = new CollisionMap();
        for (Entity entity : Map.walls){
            if(entity instanceof Wall){
                if(collisionMap.iscollisionWithWall(this, (Wall) entity)){
                    this.setDirection(MovementType.STOP);
                    nextMoveCalculateByAI(this.map);
                    move();
                }
            }
        }
        switch (this.getDirection()) {
            case UP:
                this.getPixelPosition().y -= speed;
                this.map.getGraphics().drawImage(this.getImage(), getPixelPosition().x, getPixelPosition().y, null);
                //this.map.repaint();
                break;
            case DOWN:
                this.getPixelPosition().y += speed;
                this.map.getGraphics().drawImage(this.getImage(), getPixelPosition().x, getPixelPosition().y, null);
                //this.map.repaint();
                break;
            case LEFT:
                this.getPixelPosition().x -= speed;
                this.map.getGraphics().drawImage(this.getImage(), getPixelPosition().x, getPixelPosition().y, null);
                //this.map.repaint();
                break;
            case RIGHT:
                this.getPixelPosition().x += speed;
                this.map.getGraphics().drawImage(this.getImage(), getPixelPosition().x, getPixelPosition().y, null);
                //this.map.repaint();
                break;
            default:
                nextMoveCalculateByAI(this.map);
                move();
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
