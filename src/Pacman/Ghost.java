package Pacman;

import Engine.physics.movement.Entity;

import javax.swing.*;
import java.awt.*;

public class Ghost extends Entity {
    private int number;
    //1 ---> Rouge;

    public int getNumber() {
        return number;
    }
    private Image image;

    public Ghost(Point position, int number) {
        this.number = number;
        this.setPosition(position);
        this.setPixelPosition(new Point(position.x*this.getSize()+10 ,position.y*this.getSize()+10));

    }

    @Override
    public String getUrls() {
        switch (number){
            case 1:{
                Image image = new ImageIcon(("src/API/ressource/pacman_img/pngwing.com.png")).getImage();
                this.setImage(image);
                return "src/API/ressource/pacman_img/pngwing.com.png";

            }
            case 2:{
                Image image = new ImageIcon(("src/API/ressource/pacman_img/pngwing.com_1.png")).getImage();
                this.setImage(image);
                return "src/API/ressource/pacman_img/pngwing.com_1.png";
            }
            /*
            case 3:{
                Image image = new ImageIcon(this.getURLPath("src/API/ressource/pacman_img/pngwing.com_1.png")).getImage();
                this.setImage(image);
                break;
            }

             */
        }
        return null;
    }
    public Image getImage() {
        switch (number){
            case 1:{
                this.image = new ImageIcon(("src/API/ressource/pacman_img/pngwing.com.png")).getImage();
                this.setImage(image);
                return  image;

            }
            case 2:{
                this.image = new ImageIcon(("src/API/ressource/pacman_img/pngwing.com_1.png")).getImage();
                this.setImage(image);
                return image;
            }
            /*
            case 3:{
                Image image = new ImageIcon(this.getURLPath("src/API/ressource/pacman_img/pngwing.com_1.png")).getImage();
                this.setImage(image);
                break;
            }

             */
        }
        return null;
    }

}