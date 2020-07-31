package javatwo.homeworkone.obstacles;

import javatwo.homeworkone.interfaces.Movement;

public class ObstacleCourse {
    private Movement[] participants;
    private Obstacle[] obstacleCourse;

    public void setParticipants(Movement[] participants) {
        this.participants = participants;
    }

    public Movement[] getParticipants() {
        return participants;
    }

    public void setObstacleCourse(Obstacle[] obstacleCourse) {
        this.obstacleCourse = obstacleCourse;
    }

    public Obstacle[] getObstacleCourse() {
        return obstacleCourse;
    }

    public void start(){
        for (Movement participant : this.participants) {
            for (Obstacle obstacle : this.obstacleCourse) {
                participant.overcomeObstacle(obstacle);
                if (!(participant.isObstacleOvercomed(obstacle))) {
                    break;
                }
            }
        }
    }
}
