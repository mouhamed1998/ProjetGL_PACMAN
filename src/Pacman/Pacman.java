package Pacman;

import Engine.physics.movement.MovableEntity;
import Engine.physics.movement.MovementType;

import javax.swing.*;
import java.awt.*;

public class Pacman extends MovableEntity {

    private Image  normalImage, upImage, downImage, leftImage,rightImage;

    public Pacman(Point position) {
        this.setPosition(position);
        this.setPixelPosition(new Point(position.x*this.getSize()+getSize()/4 ,position.y*this.getSize()+getSize()/4));
        this.upImage = new ImageIcon("src/API/ressource/pacman_img/pac_right.png").getImage();
        this.normalImage = new ImageIcon("src/API/ressource/pacman_img/pac_right.png").getImage();
        this.downImage = new ImageIcon("src/API/ressource/pacman_img/pac_right.png").getImage();
        this.leftImage = new ImageIcon("src/API/ressource/pacman_img/pac_right.png").getImage();
        this.rightImage = new ImageIcon("src/API/ressource/pacman_img/pac_right.png").getImage();
        this.setImage(normalImage);
    }
    @Override
    public

    String getUrls() {
        return "src/API/ressource/pacman_img/pac_right.png";
    }

    @Override

    public void move() {


        switch (this.getDirection()) {
            case UP: {
                int y = this.getPixelPosition().x - getSpeed();
                this.setPosition(new Point(getPixelPosition().x, y));
                this.setPixelPosition(new Point(getPixelPosition().x, y));

                //this.setImage(upImage);;
            }
            case DOWN: {
                System.out.println("y avant " + this.getPixelPosition().y);
                int y = this.getPixelPosition().y + getSpeed();
                System.out.println("y apres " + y);
                this.setPosition(new Point(getPixelPosition().x, y));
                this.setPixelPosition(new Point(getPixelPosition().x, y));
                System.out.println("pixel position " + this.getPixelPosition().y);
                //this.setImage(downImage);

            }
            case LEFT: {
                int x = this.getPixelPosition().x - getSpeed();
                this.setPosition(new Point(x, getPixelPosition().y));
                this.setPixelPosition(new Point(x, getPixelPosition().y));

                //this.setImage(leftImage);
            }
            case RIGHT: {
                System.out.println("x avant " + this.getPixelPosition().x);
                int x = this.getPixelPosition().x + getSpeed();
                System.out.println("x apres " + x);
                this.setPosition(new Point(x, getPixelPosition().y));
                this.setPixelPosition(new Point(x, getPixelPosition().y));
                System.out.println("pixel position x " + this.getPixelPosition().x);
            }
        }
    }


    @Override
    public String name() {
        return null;
    }

    @Override
    public void goUp() {
        direction = MovementType.UP;
    }

    @Override
    public void goDown() {
        direction = MovementType.DOWN;
    }

    @Override
    public void goLeft() {
        direction = MovementType.LEFT;
    }

    @Override
    public void goRight() {
        direction = MovementType.RIGHT;
    }

    @Override
    public void stop() {

    }
}
