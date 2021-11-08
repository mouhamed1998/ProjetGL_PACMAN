package Pacman;

import java.awt.*;

public class Pacman  extends Entity {

    private Image  normalImage, upImage, downImage, leftImage,rightImage;

    public Pacman(Point position) {
        this.setPosition(position);
        this.setPixelPosition(new Point(position.x*this.getSize()+getSize()/4  ,position.y*this.getSize()+getSize()/4));

    }
}
