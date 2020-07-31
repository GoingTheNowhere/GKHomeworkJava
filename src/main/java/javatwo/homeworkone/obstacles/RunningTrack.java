package javatwo.homeworkone.obstacles;

public class RunningTrack extends Obstacle {

    {
        this.setObstacleType(ObstacleType.FOR_RUN);
        this.setObstacleSize((double) (Math.round(Math.random() * 100 * 100)) / 100 + 200);
    }
}
