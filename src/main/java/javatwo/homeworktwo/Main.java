package javatwo.homeworktwo;

public class Main {
    public static void main(String[] args) {
        /*
        3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и
        MyArrayDataException, и вывести результат расчета.
        */
        String[][] array1 = {{"1", "1", "1", "1"}, {"2", "2", "2"}, {"3", "3", "3", "3", "3"}, {"4"}};
        String[][] array2 = {{"1", "1", "1", "1"}, {"2", "2", "2", "2"}, {"3", "С новым годом!", "3", "3"}, {"4", "4", "4", "4"}};
        String[][] array3 = {{"1", "1", "1", "1"}, {"2", "2", "2", "2"}, {"3", "3", "3", "3"}, {"4", "4", "4", "4"}};

        try{
            System.out.println(ArrayTricks.sumArrayValues(array1));
        } catch (MyArraySizeException | MyArrayDataException e){
            System.out.println(e.getMessage());
        }
        try{
            System.out.println(ArrayTricks.sumArrayValues(array2));
        } catch (MyArraySizeException | MyArrayDataException e){
            System.out.println(e.getMessage());
        }
        try{
            System.out.println(ArrayTricks.sumArrayValues(array3));
        } catch (MyArraySizeException | MyArrayDataException e){
            System.out.println(e.getMessage());
        }
    }
}
