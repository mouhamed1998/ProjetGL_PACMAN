package Engine.AI;


import Engine.kernel.Kernel;
import Engine.physics.movement.MovementType;
import GamePlay.Pacman.Ghost;

public interface AiInterface {
    MovementType getMovement(Ghost ghost, Kernel kernel);
}
