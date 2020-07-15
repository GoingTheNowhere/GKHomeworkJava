package homeworksix;

public class Dog extends Animal {
    private static int dogID = 1;

    {
        super.maxJumpHeight = 0.5 + Animal.random.nextInt(3) - 0.5;
        super.maxRunDistance = 500 + Animal.random.nextInt(201) - 100;
        super.maxSwimDistance = 10 + Animal.random.nextInt(9) - 4;
    }

    public Dog(){
        super("Пес № " + dogID);
        dogID++;
    }
}
