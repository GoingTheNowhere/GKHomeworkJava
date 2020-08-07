package javatwo.homeworkone.obstacles;

public strictfp class RunningTrack extends Obstacle {

    {
        this.setObstacleType(ObstacleType.FOR_RUN);
        this.setObstacleSize(Math.round(Math.random() * 100 * 100) / 100.0f + 200);
    }
}
