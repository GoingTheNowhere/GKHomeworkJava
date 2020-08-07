package javatwo.homeworktwo;
/*
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то
элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено
 исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
 */

public class ArrayTricks {

    public static int[][] castSquareStringArrayToIntArray(String[][] stringArray)
            throws MyArraySizeException, MyArrayDataException {

        if(stringArray.length !=4){
            throw new MyArraySizeException("Количество строк массива не равно 4!");
        }

        for (int i = 0; i < stringArray.length; i++) {
            if(stringArray[i].length != 4) {
                throw new MyArraySizeException("Длина строки № " + i + " массива не равна 4!");
            }
        }

        int[][] result = new int[stringArray.length][];
        for (int i = 0; i < result.length; i++) {
            result[i] = new int[stringArray[i].length];
        }

        for (int i = 0; i < result.length; i++){
            for (int j = 0; j < result[i].length; j++) {
                try {
                    result[i][j] = Integer.parseInt(stringArray[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException("Ячейка массива в строке № " + i + " столбце № " + j + " не содержит число!");
                }
            }
        }
        return result;
    }

    public static int sumArrayValues(String[][] stringArray)
            throws MyArraySizeException, MyArrayDataException {

        int result = 0;
        int[][] sumArray = castSquareStringArrayToIntArray(stringArray);
        for (int[] ints : sumArray) {
            for (int anInt : ints) {
                result += anInt;
            }
        }
        return result;
        /*try {
            int[][] sumArray = castSquareStringArrayToIntArray(stringArray);

            for (int[] ints : sumArray) {
                for (int anInt : ints) {
                    result += anInt;
                }
            }
            return result;
        } catch (MyArrayDataException  e){
            throw new MyArrayDataException(e.getMessage());
        } catch (MyArraySizeException e){
            throw new MyArraySizeException(e.getMessage());
        }*/
    }
}
