package Engine.Input;

import Engine.Graphics.Map;
import Engine.physics.Collision.CollisionMap;
import Engine.physics.movement.Entity;
import Engine.physics.movement.MovableEntity;
import Engine.physics.movement.MovementType;
import Pacman.Pacman;
import Pacman.Wall;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBorad extends KeyAdapter implements KeyListener {
    Pacman pacman ;
    public KeyBorad(Pacman pacman) {
        this.pacman = pacman;

    }


    public void keyPressed(KeyEvent event){
        CollisionMap collisionMap = new CollisionMap();
        int key = event.getKeyCode();
        if(key == KeyEvent.VK_UP){
            System.out.println("UP");
            this.pacman.goUp();
            /*
            MovableEntity pac = new Pacman(new Point(pacman.getPosition().x, pacman.getPosition().y), pacman.getMap());
            int y = pacman.getPixelPosition().y - pacman.speed;
            pac.setPixelPosition(new Point(pacman.getPosition().x, ));

             */
            /*
            for (Entity entity : Map.walls){
                if(entity instanceof Wall){
                    collisionMap.collisionWithWall(pacman, (Wall) entity);
                }

            }
            this.pacman.move();

            //this.pacman.goUp();

             */
        }

        if(key == KeyEvent.VK_DOWN){
            System.out.println("DOWN");
           this.pacman.goDown();
           /*
            for (Entity entity : Map.walls){
                if(entity instanceof Wall) collisionMap.collisionWithWall(pacman, (Wall) entity);

            }
            this.pacman.move();

            //this.pacman.goDown();

            */

        }
        if(key == KeyEvent.VK_LEFT){
            System.out.println("LEFT");
            this.pacman.goLeft();
            /*
            for (Entity entity : Map.walls){
                if(entity instanceof Wall) collisionMap.collisionWithWall(pacman, (Wall) entity);

            }
            this.pacman.move();

             */

        }
        if(key == KeyEvent.VK_RIGHT){
            System.out.println("RIGHT");
            this.pacman.goRight();
            /*
            for (Entity entity : Map.walls){
                if(entity instanceof Wall) collisionMap.collisionWithWall(pacman, (Wall) entity);

            }
            this.pacman.move();

            //this.pacman.goRight();

             */
        }
    }


}
