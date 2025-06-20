package 예외.예외처리적용.exception;

public class NetworkException extends RuntimeException {
    public NetworkException(String message) {
        super(message);
    }
}