package at.htlkaindorf.csv;

public class IllegalCsvValueException extends RuntimeException {
    public IllegalCsvValueException(String message) {
        super(message);
    }
}
