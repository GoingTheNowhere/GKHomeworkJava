package javatwo.homeworkone.creatures;

import javatwo.homeworkone.interfaces.Movement;
import javatwo.homeworkone.obstacles.Obstacle;

public class Human implements Movement {
    private static int humanID;
    private String name;
    private double maxRunLenght;
    private double maxJumpHeight;

    {
        humanID++;
        this.name = "Человек № " + humanID;
        this.maxRunLenght = (double) (Math.round(Math.random() * 100 * 100)) / 100 + 200;
        this.maxJumpHeight = (double) (Math.round(Math.random() * 10 * 100)) / 100 + 1;
    }
    @Override
    public void showCharacteristics(){
        System.out.println(this.name);
        System.out.println("Дистанция бега: " + this.maxRunLenght);
        System.out.println("Высота прыжка: " + this.maxJumpHeight);
    }

    @Override
    public void overcomeObstacle(Obstacle obstacle) {
        switch (obstacle.getObstacleType()){
            case FOR_RUN:
                if(this.maxRunLenght > obstacle.getObstacleSize()) {
                    System.out.println(this.name + " перебежал препятствие.");
                } else {
                    System.out.println(this.name + " не смог перебежать препятствие.");
                }
                break;
            case FOR_JUMP:
                if(this.maxJumpHeight > obstacle.getObstacleSize()) {
                    System.out.println(this.name + " перепрыгнул через препятствие.");
                } else {
                    System.out.println(this.name + " не смог перепрыгнуть через препятствие.");
                }
                break;
        }
    }

    @Override
    public boolean isObstacleOvercomed(Obstacle obstacle) {
        switch (obstacle.getObstacleType()){
            case FOR_RUN:
                if(this.maxRunLenght > obstacle.getObstacleSize()) {return true;}
                break;
            case FOR_JUMP:
                if(this.maxJumpHeight > obstacle.getObstacleSize()) {return true;}
                break;
            default:
                return false;
        }
        return false;
    }
}
