package Engine.AI;


import Engine.kernel.Kernel;
import Engine.physics.movement.MovementType;
import GamePlay.Pacman.Ghost;

/**
 * une interface avec une méthode getMovement() qui gère le déplacement d'un fantome
 */
public interface AiInterface {
    MovementType getMovement(Ghost ghost, Kernel kernel);
}
