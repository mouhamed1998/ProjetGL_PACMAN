package Pacman;

import Engine.physics.Collision.CollisionMap;
import Engine.physics.movement.ImmovableEntity;
import Engine.physics.movement.MovableEntity;
import Engine.physics.movement.MovementType;
import Engine.physics.movement.PlayerEntity;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Pacman extends PlayerEntity {

    private Image  normalImage, upImage, downImage, leftImage,rightImage,image;
    public MovementType nextDirection;
    public int speed =1;
    private JPanel jPanel;
    String url;
    public Pacman(Point position, JPanel jPanel){
        super(position, jPanel);
    }

    public Pacman(Point position) {
        super(position);
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
        direction = MovementType.UP;
    }

    @Override
    public void goDown() {
        direction = MovementType.DOWN;
    }

    @Override
    public void goLeft() {
        direction = MovementType.LEFT;
    }

    @Override
    public void goRight() {
        direction = MovementType.RIGHT;
    }

    @Override
    public void stop() {
        direction = MovementType.STOP;
    }

    public Pacman() {
        super();
    }

    public void verifyNextDirection(ArrayList<ImmovableEntity> walls) {
        if (nextDirection == MovementType.STOP) return;
        PlayerEntity newPacman = new Pacman();
        newPacman.setDirection(this.nextDirection);
        newPacman.setPixelPosition(this.getPixelPosition());
        CollisionMap collision = new CollisionMap();
        for (ImmovableEntity wall : walls) {
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
                this.nextDirection = MovementType.UP;
                this.jPanel.repaint();
                break;
            case DOWN:
                this.setImage(downImage);
                this.getPixelPosition().y += speed;
                this.jPanel.getGraphics().drawImage(this.image, getPixelPosition().x, getPixelPosition().y, null);
                this.nextDirection = MovementType.DOWN;
                this.jPanel.repaint();
                break;
            case LEFT:
                this.setImage(leftImage);
                this.getPixelPosition().x -= speed;
                this.jPanel.getGraphics().drawImage(this.image, getPixelPosition().x, getPixelPosition().y, null);
                this.nextDirection = MovementType.LEFT;
                this.jPanel.repaint();
                break;
            case RIGHT:
                this.setImage(rightImage);
                this.getPixelPosition().x += speed;
                this.jPanel.getGraphics().drawImage(this.image, getPixelPosition().x, getPixelPosition().y, null);
                this.nextDirection = MovementType.RIGHT;
                this.jPanel.repaint();
                break;
            default:
                break;
        }

    }


}
