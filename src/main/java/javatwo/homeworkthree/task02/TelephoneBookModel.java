package javatwo.homeworkthree.task02;

import java.util.ArrayList;
import java.util.List;

public class TelephoneBookModel {
    public static final List<TelephoneBookModel> phonebook = new ArrayList<>();
    private String surname;
    private String telephoneNumber;

    public TelephoneBookModel(){

    }

    public TelephoneBookModel(String surname, String telephoneNumber){
        this.surname = surname;
        this.telephoneNumber = telephoneNumber;
    }

/*    public static void setPhonebook(List<String> phonebook) {
        TelephoneBookModel.phonebook = phonebook;
    }*/

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

/*    public static List<TelephoneBookModel> getPhonebook(){
        return TelephoneBookModel.phonebook;
    }*/

    public String getSurname(){
        return this.surname;
    }

    public String getTelephoneNumber(){
        return this.telephoneNumber;
    }
}
