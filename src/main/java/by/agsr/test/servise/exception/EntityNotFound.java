package by.agsr.test.servise.exception;

public class EntityNotFound extends RuntimeException{
    public EntityNotFound(String message) {
        super(message);
    }
}
