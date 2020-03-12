package exception;

public class CoinIsNotValidException extends Exception {
    public CoinIsNotValidException() {
    }

    public CoinIsNotValidException(String message) {
        super(message);
    }

    public CoinIsNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoinIsNotValidException(Throwable cause) {
        super(cause);
    }

    public CoinIsNotValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
