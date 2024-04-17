package exception;

public class InvalidCellMoveException extends RuntimeException{
    public InvalidCellMoveException(String message) {
        super(message);
    }
}
