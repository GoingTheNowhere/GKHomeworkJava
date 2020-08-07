package javatwo.homeworkthree.task02;

public class TelephoneBookServiceImpl implements TelephoneBookService {

    @Override
    public String findRecord(String surname){
        String result = "Найденные совпадения:\n";
        String resultDefault = "Найденные совпадения:\n";
        for (TelephoneBookModel check : TelephoneBookModel.phonebook) {
            if (check.getSurname().equalsIgnoreCase(surname)) {
                result += "Фамилия: " + check.getSurname() + ", телефон: " + check.getTelephoneNumber() + "\n";
            }
        }
        if (resultDefault.equalsIgnoreCase(result)){
            result = surname + ": совпадений не найдено.";
        }
        return result;
    }

    @Override
    public void addRecord(String surname, String telephoneNumber){
        TelephoneBookModel.phonebook.add(new TelephoneBookModel(surname, telephoneNumber));
    }

}
