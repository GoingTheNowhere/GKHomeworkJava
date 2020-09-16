package javathree.homeworkfive.taskthree;

import java.util.concurrent.CountDownLatch;

public class Car implements Runnable {
    private static int CARS_COUNT = 1;

    private Race race;
    private int speed;
    private String name;
    private CountDownLatch startSignal;
    private CountDownLatch doneSignal;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.race = race;
        this.speed = speed;
        this.name = "Участник №" + CARS_COUNT;
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
        CARS_COUNT++;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            startSignal.countDown();

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            MainClass.readySignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if(doneSignal.getCount() == MainClass.CARS_COUNT){
            MainClass.winner = this.name;
        }
        doneSignal.countDown();
    }
}
