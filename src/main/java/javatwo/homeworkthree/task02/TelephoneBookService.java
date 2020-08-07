package javatwo.homeworkthree.task02;

public interface TelephoneBookService {
    String findRecord(String surname);
    void addRecord(String surname, String telephoneNumber);
}
