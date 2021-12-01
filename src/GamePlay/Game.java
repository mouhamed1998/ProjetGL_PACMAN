package GamePlay;

import Engine.Graphics.MazeWindow;
import Engine.physics.movement.MovableEntity;
import Engine.physics.movement.PlayerEntity;
import Pacman.Pacman;

import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException, InterruptedException {
        PlayerEntity pacman = new Pacman();
        new MazeWindow(pacman);
    }
}
