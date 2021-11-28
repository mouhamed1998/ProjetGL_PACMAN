package Pacman;

import Engine.physics.movement.Entity;
import Engine.physics.movement.ImmovableEntity;

import javax.swing.*;
import java.awt.*;

public class Wall extends ImmovableEntity {
    //private Image image;
    public Wall(Point position){
        super(position);
        //  this.image = new ImageIcon("src/API/ressource/pacman_img/wall.jpeg").getImage();
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