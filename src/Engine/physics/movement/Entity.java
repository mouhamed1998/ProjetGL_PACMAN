package Engine.physics.movement;

import GamePlay.MapNew;
import GamePlay.GameGraphic;

import java.awt.*;
import java.net.URL;

public abstract class Entity {
    private Point position;
    private Point PixelPosition;
    private Image image;
    private String path;
    //private String systemPath = System.getProperty("user.dir");
    private MapNew mapNew;
    private static int size = 30;
    private Point pixelPosition;


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
