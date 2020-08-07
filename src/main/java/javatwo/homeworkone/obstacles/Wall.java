package javatwo.homeworkone.obstacles;

public strictfp class Wall extends Obstacle {

    {
        this.setObstacleType(ObstacleType.FOR_JUMP);
        this.setObstacleSize(Math.round(Math.random() * 10 * 100) / 100.0f + 1);
    }
}
