/*2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона
 по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при
 запросе такой фамилии должны выводиться все телефоны.*/

package javatwo.homeworkthree.task02;

public class Main {
    public static void main(String[] args) {
    TelephoneBookServiceImpl service = new TelephoneBookServiceImpl();
    service.addRecord("Иванов", "989898");
    service.addRecord("Петров", "778787");
    service.addRecord("Иванов", "111111");
    System.out.println(service.findRecord("Иванов"));
    System.out.println(service.findRecord("Петров"));
    System.out.println(service.findRecord("Чижиков"));
    }
}
