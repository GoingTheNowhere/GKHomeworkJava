package javathree.homeworkfive.app;

import javathree.homeworkfive.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static Interface1 interface1 = (n, list) -> {
        Integer result = -1;
        if(list == null
           || list.length == 0){
            return result;
        }
        for (Integer i: list) {
            if(i.equals(n)){
                result = i;
                return result;
            }
        }
        return result;
    };

    public static Interface2 interface2 = s -> {
        if(s == null){
            throw new IllegalArgumentException();
        }
        if(s.length() == 0){
            return s;
        }
        char[] tmp = new char[s.length()];
        for (int i = s.length() - 1, j = 0; i < s.length(); i--, j++) {
            tmp[j] = s.charAt(i);
        }
        return new String(tmp);
    };

    public static Interface3 interface3 = list -> {
        if(list == null
           || list.length == 0){
            throw new IllegalArgumentException();
        }

        Integer result = list[0];
        for (int i = 1; i < list.length; i++) {
            if(list[i] > result){
                result = list[i];
            }
        }
        return  result;
    };

    public static Interface4 interface4 = list -> {
        if(list == null
           || list.isEmpty()){
            throw new IllegalArgumentException();
        }
        Double result = 0.;
        for (Integer i : list) {
            result += i;
        }
        return result /= list.size();
    };

    public static Interface5 interface5 = list -> {
        if(list == null){
            throw new IllegalArgumentException();
        }

        List<String> result = new ArrayList<>();

        if(list.isEmpty()){
            return result;
        }

        for (String i : list) {
            if (i.startsWith("a") && i.length() == 3) {
                result.add(i);
            }
        }
        return result;
    };

}
