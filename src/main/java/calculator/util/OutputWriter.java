package calculator.util;

public interface OutputWriter {
    default void displayMessage(String message) {
        System.out.println(message);
    }
}
