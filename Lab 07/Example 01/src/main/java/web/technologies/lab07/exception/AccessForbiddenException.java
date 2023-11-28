package web.technologies.lab07.exception;

public class AccessForbiddenException extends RuntimeException { 
    
    public AccessForbiddenException(final String message) {
        super(message);
    }
    
}
