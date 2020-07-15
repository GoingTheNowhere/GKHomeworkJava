package homeworksix;

import java.util.Random;

public class Animal {
    String name;
    int maxRunDistance;
    int maxSwimDistance;
    double maxJumpHeight;
    protected static Random random = new Random();

    protected Animal(String name){
        this.name = name;
    }

    protected void run(int distance){
        if (distance > 0 && distance <= this.maxRunDistance){
            System.out.println(this.name + " run: true");
        }
        else {
            System.out.println(this.name + " run: false");
        }
    }
    protected void swim(int distance){
        if (distance > 0 && distance <= this.maxSwimDistance){
            System.out.println(this.name + " swim: true");
        }
        else {
            System.out.println(this.name + " swim: false");
        }
    }
    protected void jump(double height){
        if (height > 0 && height <= this.maxJumpHeight){
            System.out.println(this.name + " jump: true");
        }
        else {
            System.out.println(this.name + " jump: false");
        }
    }

}
