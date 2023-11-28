package web.technologies.lab07.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import web.technologies.lab07.dto.ErrorDTO;
import web.technologies.lab07.exception.AccessForbiddenException;
import web.technologies.lab07.exception.WrongPasswordException;
import web.technologies.lab07.exception.CustomerValidationException;
import web.technologies.lab07.exception.UserDoesNotExistException;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class UserExceptionHandler {
    
    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handle(final CustomerValidationException customerValidationException) {
        final var response = new ErrorDTO(BAD_REQUEST.value(), BAD_REQUEST.getReasonPhrase(), customerValidationException.getMessage());
        return ResponseEntity.status(BAD_REQUEST).body(response);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handle(final UserDoesNotExistException exception) {
        final var response = new ErrorDTO(UNAUTHORIZED.value(), UNAUTHORIZED.getReasonPhrase(), exception.getMessage());
        return ResponseEntity.status(UNAUTHORIZED).body(response);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handle(final WrongPasswordException exception) {
        final var response = new ErrorDTO(UNAUTHORIZED.value(), UNAUTHORIZED.getReasonPhrase(), exception.getMessage());
        return ResponseEntity.status(UNAUTHORIZED).body(response);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handle(final AccessForbiddenException exception) {
        final var response = new ErrorDTO(FORBIDDEN.value(), FORBIDDEN.getReasonPhrase(), exception.getMessage());
        return ResponseEntity.status(FORBIDDEN).body(response);
    }
    
}
