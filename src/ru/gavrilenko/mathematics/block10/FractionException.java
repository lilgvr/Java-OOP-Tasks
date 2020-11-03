package ru.gavrilenko.mathematics.block10;

public class FractionException extends RuntimeException{
    public FractionException() {
    }

    public FractionException(String message) {
        super(message);
    }

    public FractionException(String message, Throwable cause) {
        super(message, cause);
    }

    public FractionException(Throwable cause) {
        super(cause);
    }

}
