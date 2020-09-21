package javathree.homeworksix;

import java.util.Arrays;

public class Task2and3 {

    public int[] copyNumbersAfterLastFour(int[] source)
        throws IllegalArgumentException,
            RuntimeException {

        if(source == null || source.length == 0){
            throw new IllegalArgumentException("Аргумент int[] source не должен быть пустым либо null");
        }
        int index = 0;
        int count = 0;
        for(int i = 0; i < source.length; i++){
            if(source[i] == 4){
                index = i;
                count++;
            }
        }

        if(count < 1){
            throw new RuntimeException("Методу передан аргументом массив, не содержащий четверок!");
        }

        int[] result = new int[source.length - index+1];
        result = Arrays.copyOfRange(source, index+1, source.length);

        return result;
    }
    public boolean isContainOneAndFour(int[] array)
        throws IllegalArgumentException {

        if(array == null || array.length == 0){
            throw new IllegalArgumentException("Аргумент int[] source не должен быть пустым либо null");
        }

        for (int i = 0, count1 = 0, count4 = 0 ; i < array.length; i++) {
            if(array[i] == 1){
                count1++;
            }
            if(array[i] == 4){
                count4++;
            }
            if(count1 > 0 && count4 > 0){
                return true;
            }
        }

        return false;
    }

}
