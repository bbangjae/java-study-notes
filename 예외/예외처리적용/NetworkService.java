package 예외.예외처리적용;

class NetworkService {
    void sendMessage(String data) {
        String address = "https://www.google.com";

        try (NetworkClient networkClient = new NetworkClient(address)) {
            networkClient.initError(data);
            networkClient.connect();
            networkClient.send(data);
        }
    }
}
