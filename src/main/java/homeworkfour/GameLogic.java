package homeworkfour;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*Домашнее задание по уроку № 4.
Теоретически, программа должна одинаково успешно работать с полем и выигрышной комбинацией любых размеров, однако
необходимо добавить возможность пользователю задавать произвольные настройки.
*/

public class GameLogic {
    public static final byte[] MAP_SIZE = {3, 3}; // игровое поле всегда должно быть двумерным массивом
    public static byte dotsToWin = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static int gamesPlayed = 0;
    public static int gamesWon = 0;
    public static int gamesLost = 0;
    public static String messageGameExit = "Вы вышли из игры!";

    public static void startGame(){
        System.out.println("Добро пожаловать в игру Крестики-Нолики!");
        while(true){
            boolean exit = configureGame();
            if (exit){
                System.out.println(messageGameExit);
                break;
            }
            while (true){
                gamesPlayed++;
                initMap();
                printMap();
                while(true) {
                    playerTurn();
                    printMap();
                    if (checkWin(DOT_X)) {
                        System.out.println("Вы победили!");
                        gamesWon++;
                        break;
                    }
                    if (checkDraw()) {
                        System.out.println("Ничья.");
                        break;
                    }
                    aiTurn(DOT_X);
                    printMap();
                    if (checkWin(DOT_O)) {
                        System.out.println("Вы проиграли!");
                        gamesLost++;
                        break;
                    }
                    if (checkDraw()) {
                        System.out.println("Ничья.");
                        break;
                    }
                }
                showStatistics();
                System.out.println("Сыграем еще раз?");
                System.out.println("1. Сыграть еще раз с теми же настройками.\n" +
                                   "2. Сыграть еще раз с другими настройками.\n" +
                                   "0. Выход.");
                int userInput = askUserInput(0, 2);
                if (userInput == 0){
                    System.out.println(messageGameExit);
                    return;
                }
                if (userInput== 1){continue;}
                break;
            }
        }
    }
    public static void initMap() {
        map = new char[MAP_SIZE[0]][MAP_SIZE[1]];
        for (int i = 0; i < MAP_SIZE[0]; i++) {
            for (int j = 0; j < MAP_SIZE[1]; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    private static void printMap() {
        for (int i = 0; i <= MAP_SIZE[1]; i++) {
            System.out.print(i + " ");
        }
        System.out.print("X");
        System.out.println();
        for (int i = 0; i < MAP_SIZE[0]; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < MAP_SIZE[1]; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Y");
    }
    public static void playerTurn() {
        int x, y;
        System.out.println("Ваш ход.");
        while(true){
            System.out.println("Введите координату хода по оси Y:");
            y = askUserInput(1, MAP_SIZE[0]) - 1;
            System.out.println("Введите координату хода по оси X:");
            x = askUserInput(1, MAP_SIZE[1]) - 1;
            if (isCellValid(y, x, false)) {break;}
        }
        map[y][x] = DOT_X;
    }
    public static boolean isCellValid(int y, int x, boolean ai) {
        if (y < 0 || y >= MAP_SIZE[0] || x < 0 || x >= MAP_SIZE[1]) {
            if (!ai) {
                System.out.println("В эту клетку ходить нельзя. Попробуйте снова.");
            }
            return false;
        }
        if (map[y][x] == DOT_EMPTY) return true;
        if (!ai) {
            System.out.println("В эту клетку ходить нельзя. Попробуйте снова.");
        }
        return false;
    }
    /* Задача решена не до конца. Метод работает только для случаев, когда символы игрока образуют последовательную линию.
    Если игрок сходил сперва в один угол (для поля 3х3), потом в другой угол, то метод не увидит, что игрок побеждает,
    поставив символ посередение. Скорее всего, логику работы метода целесообразно переписать полностью, или добавить отдельно
    проверку и промежуточных результатов.
    В качестве параметра методу передается символ, которым обозначается ход игрока (человека).
    */
    public static void aiTurn(char symb) {
        int x = 0, y = 0;
        for (int i = 0; i < MAP_SIZE[0]; i++) {
            for (int j = 0; j < MAP_SIZE[1]; j++) {
                if (map[i][j] == symb){
                    int emptyDots = 0;
                    // Проверяем комбо по горизонтали
                    if (j + dotsToWin - 1 < MAP_SIZE[1]) {
                        for (int k = 1; k < dotsToWin; k++) {
                            if (map[i][j + k] == DOT_EMPTY) {
                                y = i;
                                x = j + k;
                                emptyDots++;
                            }
                            if (emptyDots > 1) {
                                break;
                            }
                            if (!(map[i][j + k] == DOT_EMPTY) && !(map[i][j + k] == symb)) {
                                break;
                            }
                            if (k == dotsToWin - 1) {
                                System.out.println("Компьютер сходил в точку Y:" + (y + 1) + " X:" + (x + 1));
                                map[y][x] = DOT_O;
                                return;
                            }
                        }
                    }
                    emptyDots = 0;
                    // Проверяем комбо по вертикали
                    if (i + dotsToWin - 1 < MAP_SIZE[0]) {
                        for (int k = 1; k < dotsToWin; k++) {
                            if (map[i + k][j] == DOT_EMPTY) {
                                y = i + k;
                                x = j;
                                emptyDots++;
                            }
                            if (emptyDots > 1) {
                                break;
                            }

                            if (!(map[i + k][j] == DOT_EMPTY) && !(map[i + k][j] == symb)) {
                                break;
                            }
                            if (k == dotsToWin - 1) {
                                System.out.println("Компьютер сходил в точку Y:" + (y + 1) + " X:" + (x + 1));
                                map[y][x] = DOT_O;
                                return;
                            }
                        }
                    }
                    emptyDots = 0;
                    // Проверяем комбо по диагонали вправо
                    if (i + dotsToWin - 1 < MAP_SIZE[0] && j + dotsToWin - 1 < MAP_SIZE[1]) {
                        for (int k = 1; k < dotsToWin; k++) {
                            if (map[i + k][j + k] == DOT_EMPTY) {
                                y = i + k;
                                x = j + k;
                                emptyDots++;
                            }
                            if (emptyDots > 1) {
                                break;
                            }

                            if (!(map[i + k][j + k] == DOT_EMPTY) && !(map[i + k][j + k] == symb)) {
                                break;
                            }
                            if (k == dotsToWin - 1) {
                                System.out.println("Компьютер сходил в точку Y:" + (y + 1) + " X:" + (x + 1));
                                map[y][x] = DOT_O;
                                return;
                            }
                        }
                    }
                    emptyDots = 0;
                    // Проверяем комбо по диагонали влево
                    if (i + (dotsToWin - 1) < dotsToWin && j - (dotsToWin - 1) > -1) {
                        for (int k = 1; k < dotsToWin; k++) {
                            if (map[i + k][j - k] == DOT_EMPTY) {
                                y = i + k;
                                x = j - k;
                                emptyDots++;
                            }
                            if (emptyDots > 1) {
                                break;
                            }

                            if (!(map[i + k][j - k] == DOT_EMPTY) && !(map[i + k][j - k] == symb)) {
                                break;
                            }
                            if (k == dotsToWin - 1) {
                                System.out.println("Компьютер сходил в точку Y:" + (y + 1) + " X:" + (x + 1));
                                map[y][x] = DOT_O;
                                return;
                            }
                        }
                    }
                    emptyDots = 0;
/*                    byte stepsToWin = 1;
                    // Проверка возможности построения горизонтальной победной комбинации
                    if (j + dotsToWin - 1 < MAP_SIZE[1]){
                        for (int k = 1; k < dotsToWin-1; k++) {
                            if (map[i][j+k] == symb){
                                stepsToWin++;
                                if (stepsToWin == dotsToWin-1 && isCellValid(i, j+k+1, true)) {
                                    y = i;
                                    x = j+k+1;
                                    System.out.println("Компьютер сходил в точку Y:" + (y + 1) + " X:" + (x + 1));
                                    map[y][x] = DOT_O;
                                    return;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    stepsToWin = 1;
                    // Проверка возможности построения вертикальной победной комбинации
                    if (i + dotsToWin - 1 < MAP_SIZE[0]){
                        for (int k = 1; k < dotsToWin-1; k++) {
                            if (map[i+k][j] == symb){
                                stepsToWin++;
                                if (stepsToWin == dotsToWin-1 && isCellValid(i+k+1, j, true)) {
                                    y = i+k+1;
                                    x = j;
                                    System.out.println("Компьютер сходил в точку Y:" + (y + 1) + " X:" + (x + 1));
                                    map[y][x] = DOT_O;
                                    return;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    stepsToWin = 1;

                    // Проверка возможности построения диагональной победной комбинации вправо (вперед)
                    if (i + dotsToWin - 1 < MAP_SIZE[0] && j + dotsToWin - 1 < MAP_SIZE[1]){
                        for (int k = 1; k < dotsToWin-1; k++) {
                            if (map[i+k][j+k] == symb){
                                stepsToWin++;
                                if (stepsToWin == dotsToWin-1 && isCellValid(i+k+1, j+k+1, true)) {
                                    y = i+k+1;
                                    x = j+k+1;
                                    System.out.println("Компьютер сходил в точку Y:" + (y + 1) + " X:" + (x + 1));
                                    map[y][x] = DOT_O;
                                    return;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    stepsToWin = 1;

                    // Проверка возможности построения диагональной победной комбинации влево (назад)
                    if (i + (dotsToWin - 1) < dotsToWin && j - (dotsToWin - 1) > -1){
                        for (int k = 1; k < dotsToWin-1; k++) {
                            if (map[i+k][j-k] == symb){
                                stepsToWin++;
                                if (stepsToWin == dotsToWin-1 && isCellValid(i+k+1, j-k-1, true)) {
                                    y = i+k+1;
                                    x = j-k-1;
                                    System.out.println("Компьютер сходил в точку Y:" + (y + 1) + " X:" + (x + 1));
                                    map[y][x] = DOT_O;
                                    return;
                                }
                            } else {
                                break;
                            }
                        }
                    }*/
                }
            }
        }
        do {
            x = rand.nextInt(MAP_SIZE[1]);
            y = rand.nextInt(MAP_SIZE[0]);
        } while (!isCellValid(y, x, true));
        System.out.println("Компьютер сходил в точку Y:" + (y + 1) + " X:" + (x + 1));
        map[y][x] = DOT_O;
    }

    public static boolean checkWin(char symb) {
        char[] checkingCombo = new char[dotsToWin];
        for (int i = 0; i < checkingCombo.length; i++){
            checkingCombo[i]=symb;
        }
        char[] winCombo = new char[dotsToWin];
        for (int i = 0; i < MAP_SIZE[0]; i++){
            for (int j = 0; j < MAP_SIZE[1]; j++){
                if (map[i][j] == symb){
                    // проверить выигрышное комбо по горизонтали
                    if (j + dotsToWin - 1 < MAP_SIZE[1]){
                        for (int k = 0; k < MAP_SIZE[1] && k < dotsToWin; k++) {
                            winCombo[0+k] = map[i][j+k];
                            if (Arrays.equals(checkingCombo, winCombo)) return true;
                        }
                    }
                    winCombo = new char[dotsToWin];
                    // проверить комбо по вертикали
                    if (i +  dotsToWin - 1 < MAP_SIZE[0]) {
                        for (int k = 0; k < MAP_SIZE[0] && k < dotsToWin; k++) {
                            winCombo[0+k] = map[i+k][j];
                            if (Arrays.equals(checkingCombo, winCombo)) return true;
                        }
                    }
                    winCombo = new char[dotsToWin];
                    // проверить комбо по диагонали вперед
                    if (i +  dotsToWin - 1 < MAP_SIZE[0] && j + dotsToWin - 1 < MAP_SIZE[1]){
                        for (int k = 0; k < MAP_SIZE[0] && k < dotsToWin; k++) {
                            winCombo[0+k] = map[i+k][j+k];
                            if (Arrays.equals(checkingCombo, winCombo)) return true;
                        }
                    }
                    winCombo = new char[dotsToWin];
                    // проверить комбо по диагонали назад
                    if (i +  dotsToWin - 1 < MAP_SIZE[0] && j - (dotsToWin - 1) > -1){
                        for (int k = 0; k < MAP_SIZE[0] && k < dotsToWin; k++) {
                            winCombo[0+k] = map[i+k][j-k];
                            if (Arrays.equals(checkingCombo, winCombo)) return true;
                        }
                    }
                    winCombo = new char[dotsToWin];
                }
            }
        }
        return false;
//        // старый способ
//        for (int i = 0; i < MAP_SIZE[0]; i++) {
//            for (int j = 0; j < MAP_SIZE[1]; j++) {
//                if (map[i][j] == symb){
//                    byte stepsToWin = 1; // если мы нашли символ игрока, значит, ему осталось на 1 символ меньше для победы
//                    // Проверка возможности построения горизонтальной победной комбинации
//                    if (j + dotsToWin - 1 < MAP_SIZE[1]){
//                        for (int k = 1; k < dotsToWin; k++) {
//                            if (map[i][j+k] == symb){
//                                stepsToWin++;
//                            } else {
//                                break;
//                            }
//                        }
//                    }
//                    if (stepsToWin == dotsToWin){
//                        return true;
//                    } else {
//                        stepsToWin = 1;
//                    }
//                    // Проверка возможности построения вертикальной победной комбинации
//                    if (i + dotsToWin - 1 < MAP_SIZE[0]){
//                        for (int k = 1; k < dotsToWin; k++) {
//                            if (map[i+k][j] == symb){
//                                stepsToWin++;
//                            } else {
//                                break;
//                            }
//                        }
//                    }
//                    if (stepsToWin == dotsToWin){
//                        return true;
//                    } else {
//                        stepsToWin = 1;
//                    }
//                    // Проверка возможности построения диагональной победной комбинации вправо (вперед)
//                    if (i + dotsToWin - 1 < MAP_SIZE[0] && j + dotsToWin - 1 < MAP_SIZE[1]){
//                        for (int k = 1; k < dotsToWin; k++) {
//                            if (map[i+k][j+k] == symb){
//                                stepsToWin++;
//                            } else {
//                                break;
//                            }
//                        }
//                    }
//                    if (stepsToWin == dotsToWin){
//                        return true;
//                    } else {
//                        stepsToWin = 1;
//                    }
//                    // Проверка возможности построения диагональной победной комбинации влево (назад)
//                    if (i + (dotsToWin - 1) < dotsToWin && j - (dotsToWin - 1) > -1){
//                        for (int k = 1; k < dotsToWin; k++) {
//                            if (map[i+k][j-k] == symb){
//                                stepsToWin++;
//                            } else {
//                                break;
//                            }
//                        }
//                    }
//                    if (stepsToWin == dotsToWin){
//                     return true;
//                    }
//                }
//            }
//        }
//        return false;
    }
    public static boolean checkDraw() {
        for (int i = 0; i < MAP_SIZE[0]; i++) {
            for (int j = 0; j < MAP_SIZE[1]; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    // Метод настраивает игру, а также возвращает значение true, если пользователь решил выйти из игры.
    public static boolean configureGame(){
        System.out.println("Выберите с какими настройками запустить игру:");
        System.out.println("1. Поле 3х3, линия из 3-х знаков для победы.");
        System.out.println("2. Поле 5х5, линия из 4-х знаков для победы.)");
        System.out.println("0. Выйти из игры.");
        int userInput = askUserInput(0, 2);
        if (userInput == 0){
            resetToDefault();
            return true;
        }
        if (userInput == 1) {
            resetToDefault();
            return false;
        }
        else {
            MAP_SIZE[0] = 5;
            MAP_SIZE[1] = 5;
            dotsToWin = 4;
            return false;
        }
    }
    public static int askUserInput (int min, int max){
        while(true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
               int userInput = scanner.nextInt();
                if (userInput < min || userInput > max) {
                    System.out.println("Вы ввели недопустимое значение. Введите цифру от " + min + " до " + max + ":");
                    scanner = new Scanner(System.in); // все другие способы "очищения" сканера приводили к зацикливанию программы
                } else {
                    return userInput;
                }
            } else {
                System.out.println("Вы ввели недопустимое значение. Введите цифру от " + min + " до " + max + ":");
                scanner = new Scanner(System.in);
            }
        }
    }
    public static void resetToDefault(){
        MAP_SIZE[0] = 3;
        MAP_SIZE[1] = 3;
        dotsToWin = 3;
    }
    public static void showStatistics(){
        System.out.println("Сыграно игр: " + gamesPlayed);
        System.out.println("Выиграно игр: " + gamesWon);
        System.out.println("Проиграно игр: " + gamesLost);
        System.out.println("Завершено игр с ничейным результатом: " + (gamesPlayed - gamesWon - gamesLost));
    }
}

