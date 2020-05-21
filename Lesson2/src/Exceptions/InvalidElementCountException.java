package Exceptions;

public class InvalidElementCountException extends Exception{
    private final int count;
    private final int rowNum;

    public InvalidElementCountException(int count, int rowNum) {
        super(String.format("Wrong element count at line %d == %d", rowNum, count));
        this.count = count;
        this.rowNum = rowNum;
    }

    public int getCount() {
        return this.count;
    }
    public int getRowNum() {
        return this.rowNum;
    }
}
