package 예외.예외처리적용.exception;

public class ConnectException extends NetworkException {
    private String address;

    public ConnectException(String message, String address) {
        super(message);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}