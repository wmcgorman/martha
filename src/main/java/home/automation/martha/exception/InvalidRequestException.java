package home.automation.martha.exception;

/**
 * Created by kerry on 25/02/2018.
 */
public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(String message) {
        super(message);
    }
}
