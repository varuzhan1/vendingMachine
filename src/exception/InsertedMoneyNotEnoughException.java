package exception;

public class InsertedMoneyNotEnoughException extends Exception {
    public InsertedMoneyNotEnoughException() {
    }

    public InsertedMoneyNotEnoughException(String message) {
        super(message);
    }

    public InsertedMoneyNotEnoughException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertedMoneyNotEnoughException(Throwable cause) {
        super(cause);
    }

    public InsertedMoneyNotEnoughException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
