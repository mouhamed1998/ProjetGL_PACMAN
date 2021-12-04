package GamePlay.Pacman;

import Engine.physics.movement.Entity;

import java.awt.*;

/**
 * cette class represente les murs, elle étend la class Entity qui fait réference
 * aux entités du jeu
 */
public class Wall extends Entity {
    //private Image image;

    /**
     * constructeur de la class Gum qui permet de créer une instance wall, il prend en parametre une position
     * @param position position du mur
     */
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

    @Override
    public void setSpeed(int i) {

    }

    @Override
    public int getNumber() {
        return 0;
    }

}
