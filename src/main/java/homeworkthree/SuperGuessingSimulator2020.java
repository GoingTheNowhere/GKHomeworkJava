import java.util.Scanner;

// Создание данного класса не требовалось в домашнем задании, однако он все же был реализован для закрепления пройденного
// материла.

public class SuperGuessingSimulator2020 {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в SuperGuessingSimulator2020!");
        outer: while (true)
        {
            System.out.println("В какую игру Вы хотите сыграть?");
            System.out.println("1. Угадай числа.");
            System.out.println("2. Угадай слова.");
            System.out.println("0. Выход.");
            System.out.println("Введите число, соответствующее Вашему выбору: ");
            int choice = chooseGame(0, 2);
            switch (choice) {
                case 0: break outer;
                case 1:
                    System.out.println(
                            "По умолчанию игра загадывает числа от 0 до 9.\n" +
                            "Но Вы можете настроить диапазон чисел, в пределах которого компьютер будет загадывать число.");
                    System.out.println(
                            "1. Запустить игру с настройками по умолчанию.\n" +
                            "2. Запустить игру со своими настройками.");
                    System.out.println("Введите число, соответствующее Вашему выбору: ");
                    choice = chooseGame(1, 2);
                    if (choice == 1){
                        GuessTheNumbers.startTheGame();
                        break;
                    } else {
                        System.out.println("Введите минимальное число загадываемого диапазона:");
                        Scanner scanner = new Scanner(System.in);
                        int min = scanner.nextInt();
                        System.out.println("Введите максимальное число загадываемого диапазона:");
                        int max;
                        while (true) {
                            max = scanner.nextInt();
                            if (max <= min){
                                System.out.println("Максимальное число должно быть больше минимального!\n" +
                                        "Попробуйте снова:");
                            } else {break;}
                        }
                        GuessTheNumbers.startTheGame(min, max);
                        break;
                    }
                case 2:
                    GuessTheWords.startTheGame();
                    break;
            }
        }
        // По идее, сканеры надо закрывать, но если это сделать, программа вылетает с ошибкой.
        System.out.println("Вы закончили работу с приложением. Как Вам известно из лицензионного соглашения,\n" +
                "которое Вы внимательно прочитали, использование нашего приложения - платное.\n" +
                "Стоимость составляет 1 000$ за каждый запуск.");
    }
    public static int chooseGame(int min, int max){
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int result = scanner.nextInt();
            if (result >= min && result <= max){
                return result;
            }
            System.out.println("Вы ввели недопустимое число! Введите число от " + min + " до " + max +":");
        }
    }
}
