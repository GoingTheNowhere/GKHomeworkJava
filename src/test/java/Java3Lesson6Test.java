import javathree.homeworksix.Task2and3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Java3Lesson6Test {

    Task2and3 test = new Task2and3();
    int[] test1 = {};
    int[] test2 = null;
    int[] test3 = {0, 1, 2};
    int[] test4 = {1, 4, 5, 4, 7};
    int[] test5 = {1, 4, 5, 4};
    int[] test6 = {0, 5, 6, 7};
    int[] test7 = {0, 1, 6, 7};
    int[] test8 = {0, 4, 6, 7};
    int[] test9 = {0, 1, 2, 4};

    @Test
    public void copyNumbersAfterLastFour(){
        int[] result = {7};
        Assertions.assertArrayEquals(result, test.copyNumbersAfterLastFour(test4));
        result = new int[]{};
        Assertions.assertArrayEquals(result, test.copyNumbersAfterLastFour(test5));

        Assertions.assertThrows(IllegalArgumentException.class, () -> test.copyNumbersAfterLastFour(test1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> test.copyNumbersAfterLastFour(test2));
        Assertions.assertThrows(RuntimeException.class, () -> test.copyNumbersAfterLastFour(test3));
    }
    @Test
    public void isContainOneAndFour(){

        Assertions.assertTrue(test.isContainOneAndFour(test9));
        Assertions.assertFalse(test.isContainOneAndFour(test6));
        Assertions.assertFalse(test.isContainOneAndFour(test7));
        Assertions.assertFalse(test.isContainOneAndFour(test6));
        Assertions.assertFalse(test.isContainOneAndFour(test8));
        Assertions.assertThrows(IllegalArgumentException.class, () -> test.isContainOneAndFour(test1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> test.isContainOneAndFour(test2));
    }
}
