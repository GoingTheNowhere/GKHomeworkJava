/*1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
  2. Написать метод, который преобразует массив в ArrayList;*/

package javathree.homeworkone;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArrays<T> {
    public static <T> void swapArrayElements(int firstElement, int secondElement, T... array){
        if(array == null) {
            return;
        }
        if(firstElement == secondElement) {
            return;
        }
        if(firstElement >= array.length
           || secondElement >= array.length
           || firstElement  < 0
           || secondElement < 0) {
            return;
        }
        T tmp = array[firstElement];
        array[firstElement] = array[secondElement];
        array[secondElement] = tmp;
    }
    public static <T> ArrayList<T> createArrayListFromArray(T... array)
            throws IllegalArgumentException{
        if(array == null || array.length < 1) throw new IllegalArgumentException();
        ArrayList<T> arrayList = new ArrayList<>();
        for (T i:array) {
            arrayList.add(i);
        }
        return arrayList;
    }

}
