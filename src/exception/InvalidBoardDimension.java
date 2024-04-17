package exception;

public class InvalidBoardDimension extends RuntimeException{
    public InvalidBoardDimension() {
    }

    public InvalidBoardDimension(String message) {
        super(message);
    }
}
