package pl.grzegorz.wrestlers.exceptions;

public class NoSuchFileTypeException extends RuntimeException{
    public NoSuchFileTypeException(String message) {
        super(message);
    }
}
