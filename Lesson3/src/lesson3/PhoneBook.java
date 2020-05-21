package lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private final Map<String, Person> phoneBook;

    public PhoneBook () {
        this.phoneBook = new HashMap<>();
    }

    public void add(String name, String email, String phone) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).addEmail(email);
            phoneBook.get(name).addPhone(phone);
        } else {
            phoneBook.put(name, new Person(email, phone));
        }
    }

    public ArrayList<String> getPhones(String name) throws NullPointerException {
        if (!phoneBook.containsKey(name)) {
            throw new NullPointerException("Нет такого пользователя " + name);
        };
        return phoneBook.get(name).getPhone();
    }

    public ArrayList<String> getEmail(String name) throws NullPointerException {
        if (!phoneBook.containsKey(name)) {
            throw new NullPointerException("Нет такого пользователя " + name);
        };
        return phoneBook.get(name).getEmail();
    }

}
