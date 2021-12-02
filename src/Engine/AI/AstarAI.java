package Engine.AI;

import Engine.kernel.Kernel;
import Engine.physics.movement.MovementType;
import GamePlay.Pacman.Ghost;

import java.awt.*;
import java.util.EmptyStackException;
import java.util.Stack;

public class AstarAI implements AiInterface{
    @Override
    public MovementType getMovement(Ghost ghost, Kernel kernel) {
        Point pacmanPixel = kernel.pacman.getPixelPosition();
        Point pacman = new Point((pacmanPixel.x-10)/kernel.pacman.getSize(), (pacmanPixel.y-10)/kernel.pacman.getSize());
        Point ghostPoint = ghost.getCurrentPosition();
        if(ghostPoint!=null) {
            System.out.println("=========================================");
            Astar ai = new Astar(27, 24, ghostPoint.y, ghostPoint.x, pacman.y, pacman.x, kernel.getWallsPosition());
            ai.start();
            Stack<Point> solution = ai.getSolution();
            try {
                Point start = solution.pop();
                Point next = solution.peek();
                System.out.println();
                System.out.println(solution.pop());
                return getNextMovement(start, next);
            } catch (EmptyStackException exception) {
                return ghost.getDirection();
            }
        } else {
            return ghost.getDirection();
        }
    }
    MovementType getNextMovement(Point start, Point next) {
        Point rotateStart = new Point(start.y, start.x);
        Point rotateNext = new Point(next.y, next.x);
        if(rotateStart.x == rotateNext.x) {
            if(rotateStart.y > rotateNext.y) {
                return MovementType.UP;
            }else return MovementType.DOWN;
        }else {
            if(rotateStart.x < rotateNext.x) return MovementType.RIGHT;
            else return MovementType.LEFT;
        }
    }

}
