package Exceptions;

public class InvalidDataException extends NumberFormatException {
    private final String data;
    private final int y;
    private final int x;

    public InvalidDataException(String data, int y, int x) {
        super(String.format("Incorrect data at %d:%d == %s", y, x, data));
        this.data = data;
        this.x = x;
        this.y = y;
    }

    public String getData() {
        return data;
    }
    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }

}
