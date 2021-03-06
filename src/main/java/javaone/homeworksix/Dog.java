package javaone.homeworksix;

public class Dog extends Animal {
    private static int dogID;

    static {
        dogID = 1;
    }

    {
        super.maxJumpHeight = 0.5 + Animal.random.nextInt(2) - 0.3;
        super.maxRunDistance = 500 + Animal.random.nextInt(201) - 100;
        super.maxSwimDistance = 10 + Animal.random.nextInt(9) - 4;
    }

    public Dog(){
        super("Пес № " + dogID);
        dogID++;
    }
}
