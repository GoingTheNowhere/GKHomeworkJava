package javatwo.homeworkthree.task01;

import java.util.*;

public class WordsArray {
    private static final List<String> words = new ArrayList<>((Arrays.asList("арбуз", "арбуз", "арбуз", "ананас", "ананас",
            "абрикос", "абрикос", "абрикос", "персик",  "ежевика",  "манго", "клубника", "помидор")));

    String findUnique() {
        String result = "Список уникальных слов:\n";
        Set<String> tmp = new HashSet<>(words);
        for (Iterator<String> iteratorTmp = tmp.iterator(); iteratorTmp.hasNext();) {
            String checkingWord = iteratorTmp.next();
            int counter = 0;
            for (String word : words) {
                if (checkingWord.equals(word)) {
                    counter++;
                }
                if (counter > 1) {
                    iteratorTmp.remove();
                    break;
                }
            }
        }
        result += tmp.toString();
        return result;
    }
    String countFrequency(){

        String result = "Частота повторения слов:\n";
        Set<String> tmp = new HashSet<>(words);

        for (String checkingWord : tmp) {
            int counter = 0;
            for (String word : words) {
                if (checkingWord.equals(word)) {
                    counter++;
                }
            }
            result += checkingWord + " повторяется " + counter + " раз (-а);\n";
        }
        return result;
    }
}