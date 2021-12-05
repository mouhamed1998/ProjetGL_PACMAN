package GamePlay.Pacman;

import Engine.physics.Collision.CollisionMap;
import Engine.physics.movement.MovableEntity;
import Engine.physics.movement.MovementType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Pacman extends MovableEntity {


    public MovementType nextDirection;
    public double speed =1;
    public int life =3;
    private JPanel jPanel;
    String url;
    private Image  normalImage, upImage, downImage, leftImage,rightImage,image;
    public Pacman(Point position, JPanel jPanel){
        this.jPanel = jPanel;
        nextDirection = MovementType.STOP;
        this.direction = MovementType.RIGHT;
        this.setPosition(position);
        this.setPixelPosition(new Point(position.x*getSize()+10 ,position.y*getSize()+10));
        this.upImage = new ImageIcon(this.getClass().getClassLoader().getResource("API/ressource/pacman_img/Image/Pacman/up/up.gif")).getImage();
        this.normalImage = new ImageIcon(this.getClass().getClassLoader().getResource("API/ressource/pacman_img/right.gif")).getImage();
        this.image = new ImageIcon(this.getClass().getClassLoader().getResource("API/ressource/pacman_img/right.gif")).getImage();
        this.downImage = new ImageIcon(this.getClass().getClassLoader().getResource("API/ressource/pacman_img/Image/Pacman/down/down.gif")).getImage();
        this.leftImage = new ImageIcon(this.getClass().getClassLoader().getResource("API/ressource/pacman_img/Image/Pacman/left/left.gif")).getImage();
        this.rightImage = new ImageIcon(this.getClass().getClassLoader().getResource("API/ressource/pacman_img/Image/Pacman/right/right.gif")).getImage();
        this.setImage(normalImage);
    }
    public int getLife() {
        return life;
    }
    @Override
    public String getUrls() {
        switch (direction){
            case UP:
                url = "src/API/ressource/pacman_img/Image/Pacman/up/up.gif";
                return "src/API/ressource/pacman_img/Image/Pacman/up/up.gif";
            case DOWN:
                url = "src/API/ressource/pacman_img/Image/Pacman/down/down.gif";
                return "src/API/ressource/pacman_img/Image/Pacman/down/down.gif";
            case RIGHT:
                url = "src/API/ressource/pacman_img/Image/Pacman/right/right.gif";
                return "src/API/ressource/pacman_img/Image/Pacman/right/right.gif";
            case LEFT:
                url = "src/API/ressource/pacman_img/Image/Pacman/left/left.gif";
                return "src/API/ressource/pacman_img/Image/Pacman/left/left.gif";
            default:
                break;
        }
        return url;
    }

    public Image getImage(){
        return image;
    }
    public  void setImage(Image image){
        this.image = image;
    }
    public String Url(){
        return getUrls();
    }
/*
    @Override
    public void move() {


        switch (this.getDirection()) {
            case UP: {
                int y = this.getPixelPosition().x - getSpeed();
                this.setPosition(new Point(getPixelPosition().x, y));
                this.setPixelPosition(new Point(getPixelPosition().x, y));

                //this.setImage(upImage);;
            }
            case DOWN: {
                System.out.println("y avant " + this.getPixelPosition().y);
                int y = this.getPixelPosition().y + getSpeed();
                System.out.println("y apres " + y);
                this.setPosition(new Point(getPixelPosition().x, y));
                this.setPixelPosition(new Point(getPixelPosition().x, y));
                System.out.println("pixel position " + this.getPixelPosition().y);
                //this.setImage(downImage);

            }
            case LEFT: {
                int x = this.getPixelPosition().x - getSpeed();
                this.setPosition(new Point(x, getPixelPosition().y));
                this.setPixelPosition(new Point(x, getPixelPosition().y));

                //this.setImage(leftImage);
            }
            case RIGHT: {
                System.out.println("x avant " + this.getPixelPosition().x);
                int x = this.getPixelPosition().x + getSpeed();
                System.out.println("x apres " + x);
                this.setPosition(new Point(x, getPixelPosition().y));
                this.setPixelPosition(new Point(x, getPixelPosition().y));
                System.out.println("pixel position x " + this.getPixelPosition().x);
            }
        }
    }

 */


    @Override
    public String name() {
        return null;
    }

    @Override
    public void goUp() {
        this.nextDirection = MovementType.UP;
    }

    @Override
    public void goDown() {
        this.nextDirection = MovementType.DOWN;
    }

    @Override
    public void goLeft() {
        this.nextDirection = MovementType.LEFT;
    }

    @Override
    public void goRight() {
        this.nextDirection = MovementType.RIGHT;
    }

    @Override
    public void stop() {
        this.direction = MovementType.STOP;
    }

    public Pacman() {
    }

    public void verifyNextDirection(ArrayList<Wall> walls) {
        if (nextDirection == MovementType.STOP) return;
        Pacman newPacman = new Pacman();
        newPacman.setDirection(this.nextDirection);
        newPacman.setPixelPosition(this.getPixelPosition());
        CollisionMap collision = new CollisionMap();
        for (Wall wall : walls) {
            collision.collisionWithWall(newPacman, wall);
        }
        if (newPacman.getDirection() != MovementType.STOP) calculateNextDirection();
    }

    private void calculateNextDirection() {
        this.setDirection(nextDirection);
        nextDirection = MovementType.STOP;
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    @Override

    public void move() {
        //System.out.println(image.getSource());
        switch (this.getDirection()) {
            case UP:
                this.setImage(upImage);
                this.getPixelPosition().y -= speed;
                this.jPanel.getGraphics().drawImage(this.image, getPixelPosition().x, getPixelPosition().y, null);
                //this.nextDirection = MovementType.UP;
                this.jPanel.repaint();
                break;
            case DOWN:
                this.setImage(downImage);
                this.getPixelPosition().y += speed;
                this.jPanel.getGraphics().drawImage(this.image, getPixelPosition().x, getPixelPosition().y, null);
                //this.nextDirection = MovementType.DOWN;
                this.jPanel.repaint();
                break;
            case LEFT:
                this.setImage(leftImage);
                this.getPixelPosition().x -= speed;
                this.jPanel.getGraphics().drawImage(this.image, getPixelPosition().x, getPixelPosition().y, null);
                //this.nextDirection = MovementType.LEFT;
                this.jPanel.repaint();
                break;
            case RIGHT:
                this.setImage(rightImage);
                this.getPixelPosition().x += speed;
                this.jPanel.getGraphics().drawImage(this.image, getPixelPosition().x, getPixelPosition().y, null);
                //this.nextDirection = MovementType.RIGHT;
                this.jPanel.repaint();
                break;
            default:
                break;
        }

    }
    public JPanel getMap(){
        return this.jPanel;
    }
    public void setSpeed(int speed){
        this.speed= speed;
    }


}
