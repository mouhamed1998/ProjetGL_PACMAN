package Engine.physics.movement;

import Engine.physics.Collision.CollisionMap;

import javax.swing.*;
import java.awt.*;

public class MovableEntity extends Entity implements Movement{
    public MovementType direction = MovementType.STOP;
    int speed=30;
    protected Image  normalImage, upImage, downImage, leftImage,rightImage,image;
    public MovementType nextDirection;
    protected JPanel jPanel;
    protected int number;

    public MovableEntity(Point position, JPanel jPanel){
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

    public MovableEntity(Point position){
        this.setPosition(position);
        this.setPixelPosition(new Point(position.x*getSize()+10 ,position.y*getSize()+10));
    }

    public MovableEntity(){}

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
    CollisionMap collisionMap = new CollisionMap();



    /*
    public  void moveUp(){
        System.out.println("UP");
        for (Entity wall : Map.entities){
            if(wall instanceof Wall){
                System.out.println("upmmmmmmm");
                collisionMap.CollisionUPWithWall(this, wall);
            }

        }
        if(this.direction == MovementType.UP){
            int y = this.getPixelPosition().y - this.getSpeed();
            //pacman.setPosition(new Point(pacman.getPixelPosition().x, y));
            this.setPixelPosition(new Point(this.getPixelPosition().x, y));
        }

    }
    public  void moveDown(){

        System.out.println("DOWN");
        for (Entity wall : Map.entities){
            if(wall instanceof Wall){
                collisionMap.CollisionDOWNWithWall(this, wall);

            }
        }

        if(this.direction == MovementType.DOWN){
            int y = this.getPixelPosition().y + this.getSpeed();
            //pacman.setPosition(new Point(pacman.getPixelPosition().x, y));
            this.setPixelPosition(new Point(this.getPixelPosition().x, y));
        }


    }
    public void moveLeft(){

        System.out.println("LEFT");
        for (Entity wall : Map.entities){
            if(wall instanceof Wall){
                System.out.println("instance");
                collisionMap.CollisionLEFTWithWall(this, wall);

            }
        }
        if(this.direction == MovementType.LEFT){
            int x = this.getPixelPosition().x - this.getSpeed();
            //pacman.setPosition(new Point(x, pacman.getPixelPosition().y));
            this.setPixelPosition(new Point(x, this.getPixelPosition().y));
        }
    }
    public void moveRight(){
        System.out.println("RIGHT");
        for (Entity wall : Map.entities){
            if(wall instanceof Wall){
                System.out.println("instance");
                collisionMap.CollisionRIGHTWithWall(this, wall);

            }
        }

        if(this.direction == MovementType.RIGHT){
            int x = this.getPixelPosition().x + this.getSpeed();
            //pacman.setPosition(new Point(x, pacman.getPixelPosition().y));
            this.setPixelPosition(new Point(x, this.getPixelPosition().y));
        }
    }

     */

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
                this.nextDirection = MovementType.UP;
                this.jPanel.repaint();
                break;
            case DOWN:
                this.setImage(downImage);
                this.getPixelPosition().y += speed;
                this.jPanel.getGraphics().drawImage(this.image, getPixelPosition().x, getPixelPosition().y, null);
                this.nextDirection = MovementType.DOWN;
                this.jPanel.repaint();
                break;
            case LEFT:
                this.setImage(leftImage);
                this.getPixelPosition().x -= speed;
                this.jPanel.getGraphics().drawImage(this.image, getPixelPosition().x, getPixelPosition().y, null);
                this.nextDirection = MovementType.LEFT;
                this.jPanel.repaint();
                break;
            case RIGHT:
                this.setImage(rightImage);
                this.getPixelPosition().x += speed;
                this.jPanel.getGraphics().drawImage(this.image, getPixelPosition().x, getPixelPosition().y, null);
                this.nextDirection = MovementType.RIGHT;
                this.jPanel.repaint();
                break;
            default:
                break;
        }
        /*
       switch (this.getDirection()){
            case UP: {
                this.goUp();
                System.out.println("UP");
                for (Entity wall : Map.entities){
                    if(wall instanceof Wall){
                        collisionMap.collisionWithWall(this, (Wall) wall);
                        System.out.println("collision wall-entity");
                    }

                }
                this.setDirection(MovementType.STOP);
                if(this.direction == MovementType.UP){
                    int y = this.getPixelPosition().y - this.getSpeed();
                    //pacman.setPosition(new Point(pacman.getPixelPosition().x, y));
                    this.setPixelPosition(new Point(this.getPixelPosition().x, y));
                }
            }
            case DOWN :{
                System.out.println("DOWN");
                this.goDown();
                for (Entity wall : Map.entities){
                    if(wall instanceof Wall){
                        collisionMap.collisionWithWall(this, (Wall) wall);
                        System.out.println("collision wall-entity");
                    }

                }
                this.setDirection(MovementType.STOP);


                int y = this.getPixelPosition().y + this.getSpeed();


                //pacman.setPosition(new Point(pacman.getPixelPosition().x, y));
                this.setPixelPosition(new Point(this.getPixelPosition().x, y));


            }
            case LEFT :{
                System.out.println("LEFT");
                this.goLeft();
                for (Entity wall : Map.entities){
                    if(wall instanceof Wall){
                        collisionMap.collisionWithWall(this, (Wall) wall);
                        System.out.println("collision wall-entity");
                    }

                }
                this.setDirection(MovementType.STOP);

                int x = this.getPixelPosition().x - this.getSpeed();
                //pacman.setPosition(new Point(x, pacman.getPixelPosition().y));
                this.setPixelPosition(new Point(x, this.getPixelPosition().y));

            }
            case RIGHT :{
                System.out.println("RIGHT");
                this.goRight();
                for (Entity wall : Map.entities){
                    if(wall instanceof Wall){
                        collisionMap.collisionWithWall(this, (Wall) wall);
                        System.out.println("collision wall-entity");
                    }

                }
                this.setDirection(MovementType.STOP);

                int x = this.getPixelPosition().x + this.getSpeed();
                //pacman.setPosition(new Point(x, pacman.getPixelPosition().y));
                this.setPixelPosition(new Point(x, this.getPixelPosition().y));

                //this.pacman.move();
            }

         */
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