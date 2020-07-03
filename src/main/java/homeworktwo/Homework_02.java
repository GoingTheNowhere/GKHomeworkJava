package homeworktwo;

public class Homework_02 {
    public static void main(String[] args) {

        //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;

        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0 ; i < array1.length; i++){
            if (array1[i] == 0) {array1[i] = 1;}
            else {array1[i] = 0;}
        }
        //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

        int[] array2 = new int[8];
        for (int i = 1; i < array2.length; i++){
            array2[i] = array2[i-1] + 3;
        }

        // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;

        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array3.length; i++){
            if (array3[i] < 6){
                array3[i] = array3[i] * 2;
            }
        }

        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;

        int[][] array4 = new int[9][9];

        for (int i = 0; i < array4.length; i++) {
            for (int j = 0; j < array4[i].length; j++) {
                if (j == i || j == (array4[i].length - 1 - i)) {
                    array4[i][j] = 1;
                } else {
                    array4[i][j] = 0;
                }
            }
        }

        //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);

        int[] array5 = {-10, -1, -10, -23, -45, -11, -77, -44, -87, -5, 0};
        int min = array5[0];
        int max = array5[0];

        for (int i : array5) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }
    }

    //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    // если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры:
    // checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана
    // символами ||, эти символы в массив не входят.

    public static boolean isBalanceLeftRight(int[] array6){
        if (array6 == null) {return false;}
        int sumLeft = 0;
        int sumRight = 0;

        for (int i = 0; i < array6.length-1; i++){

            sumLeft = sumLeft + array6[i];
            sumRight = 0;
            for (int j = i + 1; j < array6.length; j++){
                sumRight = sumRight + array6[j];
            }
            if (sumLeft == sumRight) {return true;}
        }
        return false;
    }

    //7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
    // или отрицательным), при этом метод должен сместить все элементымассива на n позиций (Циклично). Для усложнения
    // задачи нельзя пользоваться вспомогательными массивами.
    public static void displaceArrayElements(int[] array7, int n){
        // Проверка на равенство n нулю необязательна, но оставлена для наглядности.
        if (array7 == null || n == 0 || n % array7.length == 0 || -n % array7.length == 0) {return;}
        if (n > array7.length || -n > array7.length) {n = n % array7.length;}
        if (n < 0) {n = n + array7.length;}
        for (int i = 0; i < n; i++) {
            int temp = array7[array7.length - 1];
            for (int j = 1; j < array7.length; j++) {
                array7[array7.length-j] = array7[array7.length-1-j];
            }
            array7[0] = temp;
        }
    }
}

