package Kyrica;

public class KyricaExceprion extends Exception{
    public KyricaExceprion() {
    }

    public KyricaExceprion(String message) {
        super(message);
    }

    public KyricaExceprion(String message, Throwable cause) {
        super(message, cause);
    }

    public KyricaExceprion(Throwable cause) {
        super(cause);
    }

    public KyricaExceprion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
