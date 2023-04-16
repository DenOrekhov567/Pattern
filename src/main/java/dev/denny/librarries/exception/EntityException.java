package dev.denny.librarries.exception;

public class EntityException extends RuntimeException {

    public EntityException(String message) {
        super(message);
    }

    public EntityException(String message, Throwable cause) {
        super(message, cause);
    }
}