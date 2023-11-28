package web.technologies.lab07.exception;

public class CustomerValidationException extends RuntimeException { 
    
    public CustomerValidationException(final String message) {
        super(message);
    }
    
}
