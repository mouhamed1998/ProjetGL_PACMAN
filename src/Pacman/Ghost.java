package Pacman;

import Engine.physics.movement.Entity;
import Engine.physics.movement.MovableEntity;

import javax.swing.*;
import java.awt.*;

public class Ghost extends MovableEntity {
    private int number;
    //1 ---> Rouge;
    private Image image;

    public int getNumber() {
        return number;
    }

    public Ghost(Point position, int number) {
        super(position,number);
    }

    @Override
    public String getUrls() {
        switch (number){
            case 1:{
                Image image = new ImageIcon(("src/API/ressource/pacman_img/Image/Ghost/Blinky/Blinky-0.png")).getImage();
                this.setImage(image);
                return"src/API/ressource/pacman_img/Image/Ghost/Blinky/Blinky-0.png";

            }
            case 2:{
                Image image = new ImageIcon(("src/API/ressource/pacman_img/Image/Ghost/Pinky/Pinky-0.png")).getImage();
                this.setImage(image);
                return "src/API/ressource/pacman_img/Image/Ghost/Pinky/Pinky-0.png";
            }

            case 3:{
                Image image = new ImageIcon(("src/API/ressource/pacman_img/Image/Ghost/Inky/Inky-0.png")).getImage();
                this.setImage(image);
                return "src/API/ressource/pacman_img/Image/Ghost/Inky/Inky-0.png";

            }

        }
        return null;
    }
    public Image getImage() {
        switch (number){
            case 1:{
                this.image = new ImageIcon(("src/API/ressource/pacman_img/Image/Ghost/Blinky/Blinky-0.png")).getImage();
                this.setImage(image);
                return  image;

            }
            case 2:{
                this.image = new ImageIcon(("src/API/ressource/pacman_img/Image/Ghost/Pinky/Pinky-0.png")).getImage();
                this.setImage(image);
                return image;
            }

            case 3:{
                Image image =  new ImageIcon(("src/API/ressource/pacman_img/Image/Ghost/Inky/Inky-0.png")).getImage();
                this.setImage(image);
                return image;
            }


        }
        return null;
    }

}