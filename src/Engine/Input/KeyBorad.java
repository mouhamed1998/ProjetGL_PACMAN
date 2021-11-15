package Engine.Input;

import Engine.physics.MovableEntity;
import Pacman.Pacman;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBorad extends KeyAdapter implements KeyListener {
    MovableEntity pacman ;
    public KeyBorad(MovableEntity pacman) {
        this.pacman = pacman;

    }

    int x ;int y ;

    public void keyPressed(KeyEvent event){
        int key = event.getKeyCode();
        if(key == KeyEvent.VK_UP){
            System.out.println("UP");
            this.pacman.goUp();
            this.pacman.moveUp();
        }
        if(key == KeyEvent.VK_DOWN){
            System.out.println("DOWN");
            this.pacman.goDown();
            this.pacman.moveDown();

        }
        if(key == KeyEvent.VK_LEFT){
            System.out.println("LEFT");
            this.pacman.goLeft();
            this.pacman.moveLeft();
        }
        if(key == KeyEvent.VK_RIGHT){
            System.out.println("RIGHT");
            this.pacman.goRight();
            this.pacman.moveRight();
        }
    }


}
