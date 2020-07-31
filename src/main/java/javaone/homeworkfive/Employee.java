package javaone.homeworkfive;

public class Employee {
    public static void main(String[] args) {
        Employee[] salesDepartment = new Employee[5];
        salesDepartment[0] = new Employee("Еремин Антон Олегович", "Консультант", "yeremin@company.com", "+7 (900) 000-00-00", 35000.00, 20);
        salesDepartment[1] = new Employee("Васильева Антонина Павловна", "Консультант", "vasilieva@company.com", "+7 (900) 000-00-01", 35000.00, 45);
        salesDepartment[2] = new Employee("Бурмистров Константин Александрович", "Руководитель отдела", "burmistrov@company.com", "+7 (900) 000-00-02", 70000.00, 50);
        salesDepartment[3] = new Employee("Петров Иннокентий Дмитриевич", "Стажер", "petrov@company.com", "+7 (900) 000-00-03", 10000.00, 18);
        salesDepartment[4] = new Employee("Хлебова Оксана Аполлинариевна", "Замруководителя отдела", "hlebova@company.com", "+7 (900) 000-00-04", 50000.00, 41);

        for (int i = 0; i < salesDepartment.length; i++) {
            if (salesDepartment[i].getAge() > 40) {
                salesDepartment[i].displayInfo();
                System.out.println();
            }

        }
    }
    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private double salary;
    private int age;


    public  Employee(String name, String position, String email, String phoneNumber, double salary, int age){
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }
    public void displayInfo (){
        System.out.println("Сведения о сотруднике:\n" +
                "ФИО: " + this.name + "\n" +
                "Возраст: " + this.age + "\n" +
                "Должность: " + this.position + "\n" +
                "Заработная плата: " + this.salary + "\n" +
                "E-mail: " + this.email + "\n" +
                "Телефон: " + this.phoneNumber);
    }
    public int getAge(){
        return this.age;
    }
}
