package Engine.physics.movement;

/**
 * MovementType est une enumération des differents directions que notre entitée peut prendre
 * dans le labyrinthe (Up, Down, Right, Left) et un STOP pour indiquer que l'entité ne bouge pas
 */
public enum MovementType {
    UP,
    LEFT,
    RIGHT,
    DOWN,
    STOP;
}
