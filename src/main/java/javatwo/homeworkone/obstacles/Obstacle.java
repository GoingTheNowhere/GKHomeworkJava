package javatwo.homeworkone.obstacles;

public class Obstacle {

    private ObstacleType obstacleType;
    private double obstacleSize;

    protected void setObstacleType(ObstacleType obstacleType){
        this.obstacleType = obstacleType;
    }
    public ObstacleType getObstacleType(){
        return this.obstacleType;
    }
    protected void setObstacleSize(double obstacleSize){
        this.obstacleSize = obstacleSize;
    }
    public double getObstacleSize(){
        return this.obstacleSize;
    }

    public void showCharacteristics(){
        System.out.println("Препятствие " + this.getObstacleType());
        System.out.println("Размер: " + this.obstacleSize);
    }

    public enum ObstacleType{
        FOR_RUN,
        FOR_JUMP,
        FOR_SWIM;
    }
}
