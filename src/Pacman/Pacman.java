package Pacman;

import Engine.physics.Entity;
import Engine.physics.MovableEntity;
import Engine.physics.Movement;
import Engine.physics.MovementType;

import javax.swing.*;
import java.awt.*;

public class Pacman extends MovableEntity {

    private Image  normalImage, upImage, downImage, leftImage,rightImage;

    public Pacman(Point position) {
        this.setPosition(position);
        this.setPixelPosition(new Point(position.x*this.getSize()+getSize()/4  ,position.y*this.getSize()+getSize()/4));
        this.upImage = new ImageIcon("src/API/ressource/pacman_img/pac_right.png").getImage();
        this.normalImage = new ImageIcon("src/API/ressource/pacman_img/pac_right.png").getImage();
        this.downImage = new ImageIcon("src/API/ressource/pacman_img/pac_right.png").getImage();
        this.leftImage = new ImageIcon("src/API/ressource/pacman_img/pac_right.png").getImage();
        this.rightImage = new ImageIcon("src/API/ressource/pacman_img/pac_right.png").getImage();
        this.setImage(normalImage);
    }

    @Override
    public String getUrls() {
        return "src/API/ressource/pacman_img/pac_right.png";
    }

    @Override
    public void move() {
        switch (this.getDirection()){
            case UP :{
                this.getPixelPosition().y -= getSpeed();
                this.setImage(upImage);
            }
            case DOWN :{
                this.getPixelPosition().y += getSpeed();
                this.setImage(downImage);

            }
            case LEFT :{
                this.getPixelPosition().x -= getSpeed();
                this.setImage(leftImage);
            }
            case RIGHT :{
                this.getPixelPosition().x += getSpeed();
                this.setImage(rightImage);
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
