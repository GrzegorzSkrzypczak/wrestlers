package pl.grzegorz.wrestlers.exceptions;

public class UserAllreadyExistsException extends RuntimeException{
    public UserAllreadyExistsException(String message) {
        super(message);
    }
}
