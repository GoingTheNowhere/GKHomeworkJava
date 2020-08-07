package javatwo.homeworkthree.task02;

import java.util.Iterator;

public class TelephoneBookServiceImpl implements TelephoneBookService {

    TelephoneBookModel bookrecord = new TelephoneBookModel();

    @Override
    public String findRecord(String surname){
        String result = "Найденные совпадения:\n";
        Iterator<TelephoneBookModel> iterator = TelephoneBookModel.phonebook.iterator();

        while(iterator.hasNext()){
            TelephoneBookModel check = iterator.next();
            if (check.getSurname().equalsIgnoreCase(surname)){
                result += "Фамилия: " + check.getSurname() + "\n" + "Телефонный номер: " + check.getTelephoneNumber() + "\n";
            }
        }
        return result;
    }

    @Override
    public void addRecord(String surname, String telephoneNumber){
        TelephoneBookModel.phonebook.add(new TelephoneBookModel(surname, telephoneNumber));
    }

}
