package Engine.physics;

import Pacman.Pacman;

import java.awt.*;

public class MovableEntity extends Entity implements Movement{
    public MovementType direction = null;
    int speed=2;
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
    public  void moveUp(){
        System.out.println("UP");
        this.goUp();
        int y = this.getPixelPosition().y - this.getSpeed();

        //pacman.setPosition(new Point(pacman.getPixelPosition().x, y));
        this.setPixelPosition(new Point(this.getPixelPosition().x, y));

    }
    public  void moveDown(){
        System.out.println("DOWN");
        this.goDown();

        int y = this.getPixelPosition().y + this.getSpeed();


        //pacman.setPosition(new Point(pacman.getPixelPosition().x, y));
        this.setPixelPosition(new Point(this.getPixelPosition().x, y));


    }
    public void moveLeft(){
        System.out.println("LEFT");
        this.goLeft();
        int x = this.getPixelPosition().x - this.getSpeed();
        //pacman.setPosition(new Point(x, pacman.getPixelPosition().y));
        this.setPixelPosition(new Point(x, this.getPixelPosition().y));

    }
    public void moveRight(){
        System.out.println("RIGHT");
        this.goRight();
        int x = this.getPixelPosition().x + this.getSpeed();
        //pacman.setPosition(new Point(x, pacman.getPixelPosition().y));
        this.setPixelPosition(new Point(x, this.getPixelPosition().y));

    }
  public void move() {
       /* switch (this.getDirection()){
            case UP: {
                System.out.println("UP");
                this.goUp();
                int y = this.getPixelPosition().y - this.getSpeed();
                //pacman.setPosition(new Point(pacman.getPixelPosition().x, y));
                this.setPixelPosition(new Point(this.getPixelPosition().x, y));
            }
            case DOWN :{
                System.out.println("DOWN");
                this.goDown();

                int y = this.getPixelPosition().y + this.getSpeed();


                //pacman.setPosition(new Point(pacman.getPixelPosition().x, y));
                this.setPixelPosition(new Point(this.getPixelPosition().x, y));


            }
            case LEFT :{
                System.out.println("LEFT");
                this.goLeft();
                int x = this.getPixelPosition().x - this.getSpeed();
                //pacman.setPosition(new Point(x, pacman.getPixelPosition().y));
                this.setPixelPosition(new Point(x, this.getPixelPosition().y));

            }
            case RIGHT :{
                System.out.println("RIGHT");
                this.goRight();
                int x = this.getPixelPosition().x + this.getSpeed();
                //pacman.setPosition(new Point(x, pacman.getPixelPosition().y));
                this.setPixelPosition(new Point(x, this.getPixelPosition().y));

                //this.pacman.move();
            }
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

    }
}
