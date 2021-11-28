package Pacman;

import Engine.physics.movement.Entity;
import Engine.physics.movement.ImmovableEntity;

import javax.swing.*;
import java.awt.*;

public class Gum extends ImmovableEntity {
    private Image image;
    public Gum(Point position) {
        super(position);
        this.image = new ImageIcon("src/API/ressource/pacman_img/big_gum.png").getImage();
    }

    @Override
    public String getUrls() {
        return "src/API/ressource/pacman_img/big_gum.png";
    }

    public Image getImage(){
        return image;
    }

    public  void setImage(Image image){
        this.image = image;
    }
}