package Engine.physics.movement;

import GamePlay.MapNew;
import GamePlay.GameGraphic;

import java.awt.*;
import java.net.URL;

/**
 * Moteur physique
 * coté Mouvement
 * cette classe represente les caractéristique d'une entitée dans le jeu
 */
public abstract class Entity {
    /** l'attribut position represente la position d'une entité (à partir du centre de l'objet) */
    private Point position;

    /** l'attribut pixelposition (dernier pixel) represente la position d'une entité (à partir du centre de l'objet + la taille/2)  */
    private Point PixelPosition;

    /** l'attribut image represente l'image de l'entitée*/
    private Image image;

    /** l'attribut path represente le chemin vers l'image de l'entitée */
    private String path;
    //private String systemPath = System.getProperty("user.dir");

    /** l'attribut mapNew represente notre labyrinthe */
    private MapNew mapNew;
    private static int size = 30;



    /** des getter et des setter pour les attributs */
    public void SetImage(Image image){
        this.image =image;
    }
    public URL getURLPath(String path){
        return this.getPath().getClass().getResource(path);
    }
    public abstract Point getCurrentPosition();

    public void setPosition(Point position) {
        this.position = position;
    }

    public void setPixelPosition(Point pixelPosition) {
        PixelPosition = pixelPosition;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    public void setGameBoard(GameGraphic gameGraphic) {
        this.mapNew = this.mapNew;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Point getPixelPosition() {
        return PixelPosition;
    }

    public Image getImage() {
        return image;
    }

    public String getPath() {
        return path;
    }

    public Point getPosition() {
        return position;
    }

    public Rectangle getRectangle(){
        int x= this.getPixelPosition().x;
        int y = this.getPixelPosition().y;
        return new Rectangle(x,y,getSize(),getSize());
    }

    public abstract String getUrls();

    public abstract void setSpeed(int i);

    public abstract int getNumber();
}
