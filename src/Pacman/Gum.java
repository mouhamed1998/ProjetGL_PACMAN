package Pacman;

import Engine.physics.movement.Entity;

import java.awt.*;

public class Gum extends Entity {

    public Gum(Point position) {
        this.setPosition(position);
        this.setPixelPosition(new Point(position.x*this.getSize()+getSize()/4  ,position.y*this.getSize()+getSize()/4));
    }

    @Override
    public String getUrls() {
        return "src/API/ressource/pacman_img/big_gum.png";
    }
}
