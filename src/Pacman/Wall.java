package Pacman;

import Engine.physics.movement.Entity;

import java.awt.*;

public class Wall extends Entity {

    public Wall(Point position){
        this.setPosition(position);
        this.setPixelPosition(new Point(position.x * getSize(),position.y*getSize()));
    }
    @Override
    public String getUrls() {
        return "src/API/ressource/pacman_img/wall.jpeg";
    }
}
