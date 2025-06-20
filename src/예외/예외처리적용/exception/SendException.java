package 예외.예외처리적용.exception;

public class SendException extends NetworkException {
    private String sendData;

    public SendException(String message,  String sendData) {
        super(message);
        this.sendData = sendData;
    }

    public String getSendData() {
        return sendData;
    }
}