package javathree.homeworkfive.taskone;

public class Main {
    public static void main(String[] args) {

        ABC abc = new ABC();

        new Thread(() -> {
            abc.showLetters('A');
        }).start();

        new Thread(() -> {
            abc.showLetters('B');
        }).start();

        new Thread(() -> {
            abc.showLetters('C');
        }).start();

    }
}
