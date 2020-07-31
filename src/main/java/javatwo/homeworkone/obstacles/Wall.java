package javatwo.homeworkone.obstacles;

public class Wall extends Obstacle {

    {
        this.setObstacleType(ObstacleType.FOR_JUMP);
        this.setObstacleSize((double) (Math.round(Math.random() * 10 * 100)) / 100 + 1);
    }
}
