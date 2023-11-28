package web.technologies.lab07.exception;

public class UserDoesNotExistException extends RuntimeException { 
    
    public UserDoesNotExistException(final String message) {
        super(message);
    }
    
}
