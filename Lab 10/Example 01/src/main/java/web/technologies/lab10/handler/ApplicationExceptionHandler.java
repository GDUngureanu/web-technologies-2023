package web.technologies.lab10.handler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import web.technologies.lab10.exception.BaseRuntimeException;
import web.technologies.lab10.exception.CategoryNotFound;
import web.technologies.lab10.exception.CustomerNotFound;
import web.technologies.lab10.exception.ProductNotFound;
import web.technologies.lab10.response.ErrorResponse;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler({CustomerNotFound.class, ProductNotFound.class, CategoryNotFound.class})
    public ResponseEntity<ErrorResponse> handle(final BaseRuntimeException exception) {
        final var response = new ErrorResponse(NOT_FOUND.value(), NOT_FOUND.getReasonPhrase(), exception.getMessage());
        return ResponseEntity.status(NOT_FOUND).body(response);
    }

}
