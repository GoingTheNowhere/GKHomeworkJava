package homeworksix;

import java.util.Random;

public class Animal {
    protected String name;
    protected int maxRunDistance;
    protected int maxSwimDistance;
    protected double maxJumpHeight;
    protected static Random random = new Random();

    protected Animal(String name){
        this.name = name;
    }

    private void move (double distance, double maxDistance, String moveType){
        String message = this.name + " " + moveType + ": ";
        if (distance > 0 && distance <= maxDistance){
            System.out.println(message + "true");
        }
        else {
            System.out.println(message + "false");
        }
    }

    public void run(int distance){
        move(distance, this.maxRunDistance, "run");
    }
    public void swim(int distance){
        move(distance, this.maxSwimDistance, "swim");
    }
    public void jump(double distance){
        move(distance, this.maxJumpHeight, "jump");
    }
    public void showInfo(){
        System.out.println(
            this.name + " \n" +
            "Дистанция бега: " + this.maxRunDistance + "\n" +
            "Дистанция плавания: " + this.maxSwimDistance + "\n" +
            "Дистанция прыжка: " + this.maxJumpHeight);
    }

}
