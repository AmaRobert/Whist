package Exceptions;

public class FileRepoException extends Exception{
    public FileRepoException() {
    }

    public FileRepoException(String message) {
        super(message);
    }

    public FileRepoException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileRepoException(Throwable cause) {
        super(cause);
    }

    public FileRepoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
