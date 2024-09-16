package pro.sky.employeehw.exception;

public class InvalidSurnameException extends RuntimeException {
    public InvalidSurnameException(String surname) {
        super(surname);
    }
}
