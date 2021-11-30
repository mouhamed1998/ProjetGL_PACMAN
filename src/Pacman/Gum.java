package Pacman;

import Engine.physics.movement.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Gum extends Entity {
    public  boolean canEat = true;
    private Image image;
    public Gum(Point position) {
        this.image = new ImageIcon("src/API/ressource/pacman_img/big_gum.png").getImage();
        this.setPosition(position);
        this.setPixelPosition(new Point(position.x*getSize()+10 ,position.y*getSize()+10));
    }

    @Override
    public String getUrls() {
        return "src/API/ressource/pacman_img/big_gum.png";
    }
    public Image getImage(){
        return image;
    }

    @Override
    public Point getCurrentPosition() {
        return null;
    }

    public  void setImage(Image image){
        this.image = image;
    }

    public void setEat(){
        Image image = new BufferedImage(30,30,BufferedImage.TYPE_BYTE_GRAY);
        image.getGraphics().setColor(new Color(19, 53, 170));
        setImage(image);
    }
}
