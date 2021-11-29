package Test;

import Engine.physics.Collision.CollisionMap;
import Engine.physics.movement.MovableEntity;
import Engine.physics.movement.MovementType;
import Pacman.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertThat;

import java.awt.*;

public class TestCollision {

    Point movablePosition = new Point(10, 30);
    Point wallPosition = new Point(15, 20);
    MovableEntity pacman = new Pacman(movablePosition);
    Wall wall = new Wall(wallPosition);
    CollisionMap test = new CollisionMap();


    @Test
    public void testCollisionWithWall(){
        pacman.setDirection(MovementType.UP);
        assertTrue(test.isCollisionWithWall(pacman,wall));

        pacman.setDirection(MovementType.DOWN);
        assertTrue(test.isCollisionWithWall(pacman,wall));

        pacman.setDirection(MovementType.LEFT);
        assertTrue(test.isCollisionWithWall(pacman,wall));

        pacman.setDirection(MovementType.RIGHT);
        assertTrue(test.isCollisionWithWall(pacman,wall));

    }

}