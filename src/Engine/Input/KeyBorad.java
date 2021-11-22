package Engine.Input;

import Engine.Graphics.Map;
import Engine.physics.Collision.CollisionMap;
import Engine.physics.movement.Entity;
import Engine.physics.movement.MovableEntity;
import Pacman.Wall;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class KeyBorad extends KeyAdapter implements KeyListener {
    MovableEntity pacman ;
    public KeyBorad(MovableEntity pacman) {
        this.pacman = pacman;

    }


    public void keyPressed(KeyEvent event){
        CollisionMap collisionMap = new CollisionMap();
        int key = event.getKeyCode();
        if(key == KeyEvent.VK_UP){
            System.out.println("UP");
            //this.pacman.goUp();
            /*
            for (Entity entity : Map.entities){
                if(entity instanceof Wall) collisionMap.CollisionWithWall(pacman, entity);

            }

             */
            this.pacman.moveUp();
            //this.pacman.goUp();
        }
        if(key == KeyEvent.VK_DOWN){
            System.out.println("DOWN");
            //
            //
           // this.pacman.goDown();
            /*
            for (Entity entity : Map.entities){
                if(entity instanceof Wall) collisionMap.CollisionWithWall(pacman, entity);
            }

             */
            this.pacman.moveDown();
            //this.pacman.goDown();

        }
        if(key == KeyEvent.VK_LEFT){
            System.out.println("LEFT");
            //this.pacman.goLeft();
            /*
            for (Entity entity : Map.entities){
                if(entity instanceof Wall) collisionMap.CollisionWithWall(pacman, entity);
            }

             */
            this.pacman.moveLeft();
            //this.pacman.goLeft();

        }
        if(key == KeyEvent.VK_RIGHT){
            System.out.println("RIGHT");
            //this.pacman.goRight();
            /*
            for (Entity entity : Map.entities){
                if(entity instanceof Wall) collisionMap.CollisionWithWall(pacman, entity);
            }

             */
            this.pacman.moveRight();
            //this.pacman.goRight();
        }
    }


}
