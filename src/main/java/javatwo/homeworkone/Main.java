package javatwo.homeworkone;

import javatwo.homeworkone.creatures.Cat;
import javatwo.homeworkone.creatures.Human;
import javatwo.homeworkone.creatures.Robot;
import javatwo.homeworkone.interfaces.Movement;
import javatwo.homeworkone.obstacles.Obstacle;
import javatwo.homeworkone.obstacles.ObstacleCourse;
import javatwo.homeworkone.obstacles.RunningTrack;
import javatwo.homeworkone.obstacles.Wall;

public class Main {
    public static void main(String[] args) {
        ObstacleCourse competitionOne = new ObstacleCourse();
        competitionOne.setObstacleCourse(new Obstacle[]{new RunningTrack(), new Wall(), new RunningTrack(), new Wall()});
        competitionOne.setParticipants(new Movement[]{new Cat(), new Robot(), new Human()});

        for (Movement i : competitionOne.getParticipants()) {
            i.showCharacteristics();
        }
        for (Obstacle i : competitionOne.getObstacleCourse()) {
            i.showCharacteristics();
        }
        competitionOne.start();
    }
}
