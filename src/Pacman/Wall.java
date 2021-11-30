package Pacman;

import Engine.physics.movement.Entity;

import javax.swing.*;
import java.awt.*;

public class Wall extends Entity {
    //private Image image;
    public Wall(Point position){
      //  this.image = new ImageIcon("src/API/ressource/pacman_img/wall.jpeg").getImage();
        this.setPosition(position);
        this.setPixelPosition(new Point(position.x * getSize()+10,position.y*getSize()+10));
    }

    @Override
    public Point getCurrentPosition() {
        return null;
    }

    @Override
    public String getUrls() {
        return "src/API/ressource/pacman_img/wall.jpeg";
    }
    /*
    public Image getImage(){
        return image;
    }
    public  void setImage(Image image){
        this.image = image;
    }

     */
}
