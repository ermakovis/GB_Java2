package lesson3;

import java.util.ArrayList;
import java.util.HashMap;

//В каждой записи всего два поля: phone, e-mail
//Фамилию таки хочется добавить
public class Person {
    private final ArrayList<String> email;
    private final ArrayList<String> phone;

    public Person() {
        this.email = new ArrayList<>();
        this.phone = new ArrayList<>();
    }

    public Person(String email, String phone) {
        this();
        this.addEmail(email);
        this.addPhone(phone);
    }

    public ArrayList<String> getEmail() {
        return email;
    }

    public ArrayList<String> getPhone() {
        return phone;
    }

    public void addPhone(String number) {
        if (number == null) return;
        this.phone.add(number);
    }

    public void addEmail(String email) {
        if (email == null) return;
        this.email.add(email);
    }

    public void removePhone(String number) {
        phone.remove(number);
    }

    public void removeEmail(String email) {
        phone.remove(email);
    }

}
