package za.co.codecrafter.http.exception;

public class InternalPushBackException extends RuntimeException {

    public InternalPushBackException() {
    }

    public InternalPushBackException(String message) {
        super(message);
    }

    public InternalPushBackException(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalPushBackException(Throwable cause) {
        super(cause);
    }

    public InternalPushBackException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
