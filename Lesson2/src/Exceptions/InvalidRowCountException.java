package Exceptions;

public class InvalidRowCountException extends Exception {
    int count;

    public InvalidRowCountException(int count) {
        super("Invalid row count == " + count);
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
