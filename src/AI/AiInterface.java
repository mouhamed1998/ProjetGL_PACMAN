package AI;


import Engine.physics.movement.MovementType;
import Pacman.Ghost;

import javax.swing.*;

public interface AiInterface {
    MovementType getMovement(Ghost ghost, JPanel coreKernel);
}
