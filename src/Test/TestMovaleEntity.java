package Test;

import Engine.physics.movement.MovableEntity;
import Pacman.Pacman;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertThat;

class TestMovableEntity {

    Point position = new Point(10, 30);
    Pacman pacman = new Pacman(position);
    int speed = 3;
    MovableEntity movable = new MovableEntity();

    @Test
    public void testMoveUp(){

        System.out.println("Test MoveUp");
        movable.goUp();
        int y = pacman.getPixelPosition().y - speed;
        Point up = new Point(pacman.getPixelPosition().x, y);
        pacman.setPixelPosition(up);
        assertEquals(pacman.getPixelPosition(), up, "Le pacman se déplacer vers le haut");

        if (pacman.getPixelPosition() != up)
            throw new AssertionError("la nouvelle position du pacman doit etre égale à :" + up);
    }

    @Test
    public void testMoveDown(){
        System.out.println("Test MoveDown");
        movable.goDown();
        int y = pacman.getPixelPosition().y + speed;
        Point down = new Point(pacman.getPixelPosition().x, y);
        pacman.setPixelPosition(down);
        assertEquals(pacman.getPixelPosition(), down , "Le pacman se déplacer vers le bas");

        if (pacman.getPixelPosition() != down)
            throw new AssertionError("la nouvelle position du pacman doit etre égale à :" + down);
    }

    @Test
    public void testMoveLeft(){
        System.out.println("Test MoveLeft");
        movable.goLeft();
        int x = pacman.getPixelPosition().x - speed;
        Point left = new Point(x, pacman.getPixelPosition().y);
        pacman.setPixelPosition(left);
        assertEquals(pacman.getPixelPosition(), left, "Le pacman se déplacer vers la gauche");

        if (pacman.getPixelPosition() != left)
            throw new AssertionError("la nouvelle position du pacman doit etre égale à :" + left);
    }

    @Test
    public void testMoveRight(){
        System.out.println("Test MoveRight");
        movable.goLeft();
        int x = pacman.getPixelPosition().x + speed;
        Point right = new Point(x, pacman.getPixelPosition().y);
        pacman.setPixelPosition(right);
        assertEquals(pacman.getPixelPosition(), right ,  "Le pacman se déplacer vers la gauche");

        if (pacman.getPixelPosition() != right)
            throw new AssertionError("la nouvelle position du pacman doit etre égale à :" + right);
    }


}