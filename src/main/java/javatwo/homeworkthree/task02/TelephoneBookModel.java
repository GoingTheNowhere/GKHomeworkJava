package javatwo.homeworkthree.task02;

import java.util.ArrayList;
import java.util.List;

public class TelephoneBookModel {
    public static final List<TelephoneBookModel> phonebook = new ArrayList<>();
    private String surname;
    private String telephoneNumber;

    public TelephoneBookModel(String surname, String telephoneNumber){
        this.surname = surname;
        this.telephoneNumber = telephoneNumber;
    }

    public String getSurname(){
        return this.surname;
    }

    public String getTelephoneNumber(){
        return this.telephoneNumber;
    }
}
