package Kyrica;

public class KyricaException extends Exception{
    public KyricaException() {
    }

    public KyricaException(String message) {
        super(message);
    }

    public KyricaException(String message, Throwable cause) {
        super(message, cause);
    }

    public KyricaException(Throwable cause) {
        super(cause);
    }

    public KyricaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
