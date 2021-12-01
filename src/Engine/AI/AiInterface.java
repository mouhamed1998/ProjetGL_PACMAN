package Engine.AI;


import Engine.Graphics.Map;
import Engine.physics.movement.MovableEntity;
import Engine.physics.movement.MovementType;
import Pacman.Ghost;

import javax.swing.*;

public interface AiInterface {
    MovementType getMovement(MovableEntity ghost, Map map);
}
