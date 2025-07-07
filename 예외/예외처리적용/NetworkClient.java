package 예외.예외처리적용;

import 예외.예외처리적용.exception.ConnectException;
import 예외.예외처리적용.exception.SendException;

class NetworkClient implements AutoCloseable {
    private String address;
    private boolean connectError;
    private boolean sendError;

    NetworkClient(String address) {
        this.address = address;
    }

    void connect() throws ConnectException {
        if(connectError) {
            throw new ConnectException(
                    "[네트워크 오류] " + address + " 서버 연결 실패",
                    address
            );
        }
        System.out.println(address+ " 서버 접속 성공");
    }

    void send(String data) throws SendException {
        if(sendError) {
            throw new SendException(
                    "[네트워크 오류] 데이터 전송 실패 데이터: " + data,
                    data
            );
        }
        System.out.println("전송 데이터: " + data);
    }

    void disconnect() {
        System.out.println("연결 해제");
    }

    void initError(String message) {
        if (message.contains("error1")) {
            connectError = true;
        }
        if (message.contains("error2")) {
            sendError = true;
        }
    }

    @Override
    public void close() {
        disconnect();
    }
}
