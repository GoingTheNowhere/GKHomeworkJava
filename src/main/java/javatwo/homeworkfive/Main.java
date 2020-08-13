package javatwo.homeworkfive;

import java.util.Arrays;

public class Main {
    static final int ARRAY_SIZE = 10_000_000;
    static final int ARRAY_HALF_SIZE = ARRAY_SIZE / 2;
    float[] arrayField;

    public Main(){
        this.arrayField = new float[ARRAY_SIZE];
        Arrays.fill(this.arrayField, 1.0f);
    }

    public void assignNewValue(float[] array, int startingPoint){
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + startingPoint / 5.f) * Math.cos(0.2f + startingPoint / 5.f) * Math.cos(0.4f + startingPoint / 2.f));
            startingPoint++;
        }
    }

    public void assignNewValue(float[] array){
        this.assignNewValue(array, 0);
    }
    public long assignNewValueOneThread(){
        long timeStart = System.currentTimeMillis();
        this.assignNewValue(this.arrayField);
        return System.currentTimeMillis() - timeStart;
    }

    public long assignNewValueTwoThreads(){
        long timeStart = System.currentTimeMillis();
        float[] arrayPartOne = new float[ARRAY_HALF_SIZE];
        float[] arrayPartTwo = new float[ARRAY_HALF_SIZE];
        System.arraycopy(this.arrayField, 0, arrayPartOne, 0, arrayPartOne.length);
        System.arraycopy(this.arrayField, arrayPartOne.length, arrayPartTwo, 0, arrayPartTwo.length);
        Thread thread1 = new Thread(() -> this.assignNewValue(arrayPartOne));
        Thread thread2 = new Thread(() -> this.assignNewValue(arrayPartTwo, arrayPartOne.length));
        thread1.start();
        thread2.start();
        try{
            thread1.join();
            thread2.join();

        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.arraycopy(arrayPartOne, 0, this.arrayField, 0, arrayPartOne.length);
        System.arraycopy(arrayPartTwo, 0, this.arrayField, arrayPartOne.length, arrayPartTwo.length);
        return System.currentTimeMillis() - timeStart;
    }

    public void showFirstAndLastTenArrayValues(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            result.append(this.arrayField[i]).append(", ");
        }
        for (int i = this.arrayField.length-10; i < this.arrayField.length; i++) {
            result.append(this.arrayField[i]).append(", ");
        }
        System.out.println(result);

    }

    public static void main(String[] args) {
        Main array1 = new Main();
        Main array2 = new Main();

        array1.showFirstAndLastTenArrayValues();
        System.out.println();
        System.out.println(array1.assignNewValueOneThread());
        System.out.println();
        array1.showFirstAndLastTenArrayValues();
        System.out.println();

        array2.showFirstAndLastTenArrayValues();
        System.out.println();
        System.out.println(array2.assignNewValueTwoThreads());
        System.out.println();
        array2.showFirstAndLastTenArrayValues();
        System.out.println();
    }
}
