package Engine.physics.movement;

import Engine.physics.Collision.CollisionMap;

import javax.swing.*;
import java.util.Map;

public class MovableEntity extends Entity implements Movement{
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
    CollisionMap collisionMap = new CollisionMap();
    public JPanel getMap(){
        return map;
    }

    public void setMap(JPanel map){
        this.map = map;
    }
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
