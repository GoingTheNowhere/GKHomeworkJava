package javatwo.homeworkthree.task01;

import java.util.*;

public class WordsArray {
    private static final List<String> words = new ArrayList<>((Arrays.asList("арбуз", "арбуз", "арбуз", "ананас", "ананас",
            "абрикос", "абрикос", "абрикос", "персик",  "ежевика",  "манго", "клубника", "помидор")));

    String findUnique() {
        String result = "Список уникальных слов:\n";
        Set<String> tmp = new HashSet<>(words);
        Iterator<String> iteratorTmp= tmp.iterator();
        Iterator<String> iteratorWords = words.iterator();

        while(iteratorTmp.hasNext()){
            String checkingWord = iteratorTmp.next();
            int counter = 0;
            while(iteratorWords.hasNext()){
                if (checkingWord.equals(iteratorWords.next())){
                    counter++;
                }
                if (counter > 1){
                    iteratorTmp.remove();
                    break;
                }
            }
            iteratorWords = words.iterator();
        }

        result += tmp.toString();
        return result;
    }
    String countFrequency(){
        String result = "Частота повторения слов:\n";

        Set<String> tmp = new HashSet<>(words);
        Iterator<String> iteratorTmp= tmp.iterator();
        Iterator<String> iteratorWords = words.iterator();

        while(iteratorTmp.hasNext()){
            String checkingWord = iteratorTmp.next();
            int counter = 0;
            while(iteratorWords.hasNext()){
                if (checkingWord.equals(iteratorWords.next())){
                    counter++;
                }
            }
            result += checkingWord + " повторяется " + counter + " раз;\n";
            iteratorWords = words.iterator();
        }

        return result;
    }

}
