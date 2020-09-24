package javathree.homeworkseven;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;


public class TestExecute {

    public static void start(Class aClass)
            throws RuntimeException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Method[] methods = aClass.getDeclaredMethods();
        Method beforeSuit = null;
        Method afterSuit = null;
        Method[] testMethods = new Method[methods.length];
        for (int i = 0, j = 0, countBeforeSuit = 0, countAfterSuit = 0; i < methods.length; i++, j++) {
            if(methods[i].getAnnotation(BeforeSuit.class) != null) {
                countBeforeSuit++;
                beforeSuit = methods[i];
                beforeSuit.setAccessible(true);
                j--;
            } else if (methods[i].getAnnotation(AfterSuit.class) != null) {
                countAfterSuit++;
                afterSuit = methods[i];
                afterSuit.setAccessible(true);
                j--;
            } else {
                if(j > testMethods.length-1 || j < 0){
                    throw new RuntimeException();
                }
                if(methods[i].getAnnotation(Test.class) != null) {
                    testMethods[j] = methods[i];
                    testMethods[j].setAccessible(true);
                }
            }
            if (countBeforeSuit > 1 || countAfterSuit > 1){
                throw new RuntimeException();
            }
        }

        Arrays.sort(testMethods,
                (o1, o2) -> o2.getAnnotation(Test.class).priority().ordinal() -
                        o1.getAnnotation(Test.class).priority().ordinal());

        Object obj = aClass.newInstance();

        if (beforeSuit != null) {
            beforeSuit.invoke(obj);
        }
        for (Method m : testMethods) {
            if (m != null) {
                m.invoke(obj);
            }
        }
        if (afterSuit != null) {
            afterSuit.invoke(obj);
        }

    }

    public static void start(String className)
            throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class aClass = Class.forName(className);
        start(aClass);
    }

}
