package Lesson2;

import Exceptions.InvalidDataException;
import Exceptions.InvalidElementCountException;
import Exceptions.InvalidRowCountException;

public class Lesson2 {

    public static int calcArray(String[][] array)
            throws InvalidDataException {
        int ret = 0;

        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array[y].length; x++) {
                try {
                    ret += Integer.parseInt(array[y][x]);
                } catch (NumberFormatException e) {
                    throw new InvalidDataException(array[y][x], y ,x);
                }
            }
        }
        return ret / 2;
    }

    public static String[][] stringToArray(String input)
            throws InvalidRowCountException, InvalidElementCountException {

        String[][] ret = new String[4][4];
        String[] lines = input.split("\\n");

        if (lines.length != 4) throw new InvalidRowCountException(lines.length);
        for (int y = 0; y < lines.length; y++) {
            String[] words = lines[y].split(" ");
            if (words.length != 4) throw new InvalidElementCountException(words.length, y);
            System.arraycopy(words, 0, ret[y], 0, words.length);
        }
        return ret;
    }

    private static void testArray(String input) {
        try {
            System.out.println("return1: " + calcArray(stringToArray(input)));
        } catch (InvalidElementCountException | InvalidRowCountException | InvalidDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main (String[] args) {
        String input1 = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String input2 = "10 3 \n 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String input3 = "10 3 1 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String input4 = "10 3 1 a\n2 3 2 2\n5 6 7 1\n300 3 1 0";

        testArray(input1);
        testArray(input2);
        testArray(input3);
        testArray(input4);
    }
}
