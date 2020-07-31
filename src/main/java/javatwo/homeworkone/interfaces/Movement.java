package javatwo.homeworkone.interfaces;

import javatwo.homeworkone.obstacles.Obstacle;

public interface Movement {
    void overcomeObstacle(Obstacle obstacle);
    boolean isObstacleOvercomed(Obstacle obstacle);
    void showCharacteristics();
}
