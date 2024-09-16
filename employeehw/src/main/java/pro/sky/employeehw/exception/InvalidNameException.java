package pro.sky.employeehw.exception;

public class InvalidNameException extends RuntimeException {
    public InvalidNameException(String name) {
        super(name);
    }
}
