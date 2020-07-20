package homeworkseven;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Barsik", 5);
        cats[1] = new Cat("Murzik", 15);
        cats[2] = new Cat("Fatty", 150);
        Plate plate = new Plate(100);
        plate.showInfo();
        System.out.println();
        for (Cat i: cats) {
            i.showInfo();
            System.out.println();
        }
        System.out.println("Котики голодны, надо их покормить.\n");
        for (Cat i: cats) {
            i.eat(plate);
        }
        System.out.println("Котики покушали.\n");
        for (Cat i: cats) {
            i.showInfo();
            System.out.println();
        }
        plate.showInfo();
    }
}

