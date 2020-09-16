package javathree.homeworkfive.taskone;

public class ABC {

    private volatile char nextLetter = 'A';
    private final int COUNT = 5;
    private final Object LOCK = new Object();

    public void showLetters (char letterForShow) {
        synchronized (LOCK) {
            try {
                for (int i = 0; i < COUNT; i++) {
                    while (nextLetter != letterForShow) {
                        LOCK.wait();
                    }
                    System.out.print(letterForShow);
                    if (letterForShow == 'A') {
                        nextLetter = 'B';
                    }
                    if (letterForShow == 'B') {
                        nextLetter = 'C';
                    }
                    if (letterForShow == 'C') {
                        nextLetter = 'A';
                    }
                    LOCK.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
