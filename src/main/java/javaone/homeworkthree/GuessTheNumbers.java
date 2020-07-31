import java.util.Random;
import java.util.Scanner;

public class GuessTheNumbers {
    /*
    Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
    При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
    После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет» (1 – повторить, 0 – нет).
     */
    // Переменные
    // Переменная для подсчета количества сыгранных раундов.
    private static byte playedGameCount;
    // Переменная для подсчета количества выигранных раундов.
    private static byte winGameCount;
    // Переменная класса Random для использования методов класса.
    private static Random random = new Random();
    // Переменная класса Scanner для считывания ввода пользователя из консоли.
    private static Scanner scanner = new Scanner(System.in);
    // Методы
    // Реализация метода, которому в качестве параметров можно передать в пределах между какими числами загадывать число.
    public static void startTheGame (int minLimit, int maxLimit) {
        while(true) {
            // Увеличиваем счетчик сыгранных игр.
            playedGameCount++;
            // Объявляем переменную, в которой будем хранить отгадываемое число.
            int guessedNumber;
            // Метод Random.nextInt принимает в качестве параметра только число, до которого должно быть сгенерированно
            // случайное число. Чтобы установить нижний предел, необходимо совершить дополнительные действия.
            guessedNumber = minLimit + random.nextInt(maxLimit - minLimit + 1);
            // Объявляем счетчик попыток для отгадывания пользователем загаданного числа и устанавливаем ему значение по
            // умолчанию 0.
            byte tryCount = 0;
            // Объявляем переменную для хранения пользовательского ввода. Ее можно было бы сделать типа String, чтобы в
            // случае ввода пользователем строки вместо числа не получать ошибку. Тогда нам было бы необходимо ввести
            // дополнительную переменную, в которой мы хранили бы загаданное число, приведенное к строке методом
            // String.valueOf(guessedNumber), а пользовательский ответ сравнивали бы методом userInput.equals(guessedNumber).
            // Тогда нам не пришлось бы реализовывать метод askYesNo для числовых значений, можно было бы использовать
            // метод из класса GuessTheWords.
            // Но метод String.valueOf() мы еще не проходили, поэтому программа написана так, как написана - с надеждой,
            // что пользователь не будет вводить символы вместо чисел.
            int userInput;

            System.out.println("Компьютер загадал число от " + minLimit + " до " + maxLimit + " (включительно).");
            System.out.println("Попробуйте его отгадать.");

            while (true) {
                System.out.println("Ваш ответ (введите число): ");
                userInput = scanner.nextInt();
                if (userInput == guessedNumber){
                    System.out.println("Поздравляем! Вы угадали! Загаданное число: " + guessedNumber);
                    winGameCount++;
                    break;
                } else if (userInput < minLimit || userInput > maxLimit) {
                    System.out.println("Введенное Вами число находится вне пределов угадываемого диапазона.\n" +
                            "Попробуйте еще раз, но будьте внимательнее.");
                    continue;
                } else {
                    // В этой секции сообщение с подсказкой не выводится, а лишь увеличивается счетчик количества попыток.
                    // Чтобы сообщение с подсказкой не выводилось вместе с сообщением о проигрыше, когда в подсказке нет
                    // уже никакой необходимости, сперва проводится проверка на исчерпание лимита попыток и только если
                    // количество попыток не исчерпано, выводится сообщение с подсказкой.
                    tryCount++;
                }
                if (tryCount == 3) {
                    System.out.println("Попытки кончились! Вы проиграли. Загаданное число: " + guessedNumber);
                    break;
                } else {
                    // После того, как мы убедились, что пользователь не угадал загаданное число и лимит попыток не
                    // исчерпан, выводится подсказка.
                    System.out.println("Неверно. Ваше число " + (userInput > guessedNumber ? "больше загаданного." : "меньше загаданного."));
                }
            }
            if (playedGameCount == 127) {
                System.out.println("Хватит уже играться!");
                showStatistics();
                playedGameCount = 0;
                winGameCount = 0;
                break;
            }
            System.out.println("Сыграем еще раз?");

            userInput = askYesNo();
            if (userInput == 0) {
                System.out.println("Жаль. В таком случае увидимся в другой раз!");
                showStatistics();
                playedGameCount = 0;
                winGameCount = 0;
                break;
            }
        }
    }
    // Реализация метода, который всегда загадывает число между 0 и 9.
    public static void startTheGame () {
        while(true) {
            // Увеличиваем счетчик сыгранных игр.
            playedGameCount++;
            // Объявляем переменную, в которой будем хранить отгадываемое число.
            int guessedNumber;
            // Загадываем случайное число от 0 до 9.
            guessedNumber = random.nextInt(10);
            // Объявляем счетчик попыток для отгадывания пользователем загаданного числа и устанавливаем ему значение по
            // умолчанию 0.
            byte tryCount = 0;
            // Объявляем переменную для хранения пользовательского ввода. Ее можно было бы сделать типа String, чтобы в
            // случае ввода пользователем строки вместо числа не получать ошибку. Тогда нам было бы необходимо ввести
            // дополнительную переменную, в которой мы хранили бы загаданное число, приведенное к строке методом
            // String.valueOf(guessedNumber), а пользовательский ответ сравнивали бы методом userInput.equals(guessedNumber).
            // Тогда нам не пришлось бы реализовывать метод askYesNo для числовых значений, можно было бы использовать
            // метод из класса GuessTheWords.
            // Но метод String.valueOf() мы еще не проходили, поэтому программа написана так, как написана.
            int userInput;

            System.out.println("Компьютер загадал число от 0 до 9 (включительно).");
            System.out.println("Попробуйте его отгадать.");
            // Следующий далее цикл реализует функцию загадывания числа пользователю и проверки введенного ответа.
            while (true) {
                System.out.println("Ваш ответ (введите число): ");
                userInput = scanner.nextInt();
                if (userInput == guessedNumber){
                    System.out.println("Поздравляем! Вы угадали! Загаданное число: " + guessedNumber);
                    winGameCount++;
                    break;
                } else if (userInput < 0 || userInput > 9) {
                    System.out.println("Введенное Вами число находится вне пределов угадываемого диапазона.\n" +
                            "Попробуйте еще раз, но будьте внимательнее.");
                    continue;
                } else {
                    // В этой секции сообщение с подсказкой не выводится, а лишь увеличивается счетчик количества попыток.
                    // Чтобы сообщение с подсказкой не выводилось вместе с сообщением о проигрыше, когда в подсказке нет
                    // уже никакой необходимости, сперва проводится проверка на исчерпание лимита попыток и только если
                    // количество попыток не исчерпано, выводится сообщение с подсказкой.
                    tryCount++;
                }
                if (tryCount == 3) {
                    System.out.println("Попытки кончились! Вы проиграли. Загаданное число: " + guessedNumber);
                    break;
                } else {
                    // После того, как мы убедились, что пользователь не угадал загаданное число и лимит попыток не
                    // исчерпан, выводится подсказка.
                    System.out.println("Неверно. Ваше число " + (userInput > guessedNumber ? "больше загаданного." : "меньше загаданного."));
                }
            }
            if (playedGameCount == 127) {
                System.out.println("Хватит уже играться!");
                showStatistics();
                playedGameCount = 0;
                winGameCount = 0;
                break;
            }
            System.out.println("Сыграем еще раз?");

            userInput = askYesNo();
            if (userInput == 0) {
                System.out.println("Жаль. В таком случае увидимся в другой раз!");
                showStatistics();
                playedGameCount = 0;
                winGameCount = 0;
                break;
            }
        }
    }
    private static void showStatistics(){
        System.out.println("Сыграно раундов: " + playedGameCount);
        System.out.println("Выиграно раундов: " + winGameCount);
        System.out.println("Проиграно раундов: " + (playedGameCount - winGameCount));
    }
    private static int askYesNo(){
        while(true) {
            System.out.println("Введите 1, если \"да\", или 0, если \"нет\".");
            int input = scanner.nextInt();
            if (input != 1 && input != 0) {
                System.out.println("Вы ввели неверное число! Попробуйте снова.");
                continue;
            }
            return input;
        }
    }
}
