package 예외.예외처리미적용;

class NetWorkClient {
    private String address;
    private boolean connectError;
    private boolean sendError;

    NetWorkClient(String address) {
        this.address = address;
    }

    String connect() {
        if(connectError) {
            return "connectError";
        }
        System.out.println(address+ " 서버 접속 성공");
        return "success";
    }

    String send(String data) {
        if(sendError) {
            return "sendError";
        }
        System.out.println("전송 데이터: " + data);
        return "success";
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
}
