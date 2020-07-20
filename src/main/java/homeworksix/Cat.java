package homeworksix;

public class Cat extends Animal {
    private static int catID;

    static {
        catID = 1;
    }

    {
        super.maxJumpHeight = 2 + Animal.random.nextInt(3) - 1;
        super.maxRunDistance = 200 + Animal.random.nextInt(101) - 50;
        super.maxSwimDistance = 0;
    }

    public Cat(){
        super("Кот № " + catID);
        catID++;
    }

}
