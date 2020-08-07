package javatwo.homeworkthree.task01;

/*
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов,
 из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое слово.
*/


public class Main {
    public static void main(String[] args) {
        WordsArray array = new WordsArray();
        System.out.println(array.findUnique());
        System.out.println(array.countFrequency());
    }

}
