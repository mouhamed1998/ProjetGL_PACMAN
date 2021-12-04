package Engine.AI;

import Engine.kernel.Kernel;
import Engine.physics.movement.MovementType;
import GamePlay.Pacman.Ghost;

import java.awt.*;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Moteur IA
 * la class AstarAI est la class qui permet de donner un déplacement aux fantomes suivant un algorithme d'intelligence artificielle
 */
public class AstarAI implements AiInterface{
    /**
     * la méthode getMovement() permet de donner à un fantome la capacité de suivre le pacman en se basant sur l'algorithme A* qui est
     * un algorithme de recherche de chemin le plus court basé sur l'algorithme de Djikstra
     * @param ghost represente un fantome
     * @param kernel represente le noyau qui va donner l'ordre au fantome de bouger d'une certaine manière
     * @return elle retourne le mouvement du fantome dans le labyrinthe
     */
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

    /**
     * la méthode getNextMovement() permet de récupérer le prochain mouvement de l'entité
     * @param start la position initiale du fantome
     * @param next la prochaine position du fantome aprés le mouvement
     * @return le prochain mouvement du fantome
     */
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
