package Pacman;

import Pacman.Entity;

import java.awt.*;

public class Gum extends Entity {

    public Gum(Point position) {
        this.setPosition(position);
        this.setPixelPosition(new Point(position.x*this.getSize()+getSize()/4  ,position.y*this.getSize()+getSize()/4));
    }

}
