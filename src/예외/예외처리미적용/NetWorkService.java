package 예외.예외처리미적용;

public class NetWorkService {
    public void sendMessage(String message) {
        String address = "https://www.google.com";
        NetWorkClient netWorkClient = new NetWorkClient(address);

        netWorkClient.initError(message);

        if (isError(netWorkClient.connect())) {
            System.out.println("[네트워크 오류] 서버 연결 실패");
        } else if (isError(netWorkClient.send(message))) {
            System.out.println("[네트워크 오류] 데이터 전송 실패");
        }
        netWorkClient.disconnect();
    }

    private static boolean isError(String result) {
        return !result.equals("success");
    }
}
