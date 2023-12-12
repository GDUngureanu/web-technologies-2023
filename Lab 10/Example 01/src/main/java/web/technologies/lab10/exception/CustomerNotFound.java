package web.technologies.lab10.exception;

public class CustomerNotFound extends BaseRuntimeException {

    public CustomerNotFound(final String message) {
        super(message);
    }

}
