package web.technologies.lab07.exception;

public class WrongPasswordException extends RuntimeException {

    public WrongPasswordException(final String message) {
        super(message);
    }

}
