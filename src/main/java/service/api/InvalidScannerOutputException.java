package service.api;

public class InvalidScannerOutputException extends RuntimeException {
    public InvalidScannerOutputException(String message, String invalidInputMessage) {
        super(message + "\n" + invalidInputMessage);
    }

    public InvalidScannerOutputException(String message) {
        super(message);
    }

    public InvalidScannerOutputException() { }
}
