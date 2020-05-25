package lesson3;

import java.util.*;

public class Main {

    //Создать массив с набором слов (20-30 слов, должны встречаться повторяющиеся):
    public static String[] createStringArray() {
        String[] ret = new String[30];
        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            ret[i] = "String" + random.nextInt(5);
        }
        return ret;
    }

    //Найти список слов, из которых состоит текст (дубликаты не считать);
    public static String[] getUniqueString(String[] array) {
        Set<String> set = new HashSet<>();

        Collections.addAll(set, array);
        String[] ret = new String[set.size()];
        set.toArray(ret);

        return ret;
    }

    //Посчитать сколько раз встречается каждое слово (использовать HashMap);
    public static Map<String, Integer> countStrings(String[] array) {
        Map<String, Integer> ret = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (ret.containsKey(array[i])) {
                ret.replace(array[i], ret.get(array[i]) + 1);
            } else {
                ret.put(array[i], 1);
            }
        }
        return ret;
    }

    //ждем рассказаз про дженерики, чтобы вот так не печатать
    public static void printArray(String[] array) {
        for (String s : array) {
            System.out.println(s);
        }
    }

    public static void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void printList(ArrayList<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        String[] stringArray = createStringArray();
        String[] uniqueStrings = getUniqueString(stringArray);
        //printArray(uniqueStrings);
        Map<String, Integer> wordsCount = countStrings(stringArray);
        //printMap(wordsCount);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("ИВАН", "ivan@ivan.ru", "88005553535");
        phoneBook.add("ИВАН", "ivan@ivan2.ru", null);
        phoneBook.add("ИВАН", null, "8024252020");
        phoneBook.add("БОРИС", "ivan@ivan.ru", null);

        try {
            printList(phoneBook.getEmail("ИВАН"));
            printList(phoneBook.getPhones("ИВАН"));
            printList(phoneBook.getEmail("БОРИС"));
            printList(phoneBook.getPhones("БОРИС"));
            printList(phoneBook.getPhones("ЫЛЬЯ"));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
