package 예외.예외처리적용;

import 예외.예외처리적용.exception.ConnectException;
import 예외.예외처리적용.exception.SendException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NetworkService networkService = new NetworkService();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("보낼 메시지를 입력하세요: ");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                System.out.println("종료");
                break;
            }

            try {
                networkService.sendMessage(input);
            } catch (ConnectException e) {
                handleConnectException(e);
            } catch (SendException e) {
                handleSendException(e);
            } catch (Exception e) {
                handleUnknownException(e);
            }

            System.out.println();
        }
        scanner.close();
    }

    private static void handleConnectException(ConnectException e) {
        // 사용자에게 보낼 메시지
        System.out.println("서버 연결에 실패했습니다. 잠시 후 다시 시도해주세요.");
        // 개발자용 상세 로깅
        Logger.error("ConnectException 발생 - 주소: " + e.getAddress(), e);
    }

    private static void handleSendException(SendException e) {
        // 사용자에게 보낼 메시지
        System.out.println("데이터 전송에 실패했습니다. 입력값을 확인해주세요.");
        // 개발자용 상세 로깅
        Logger.error("SendException 발생 - 데이터: " + e.getSendData(), e);
    }

    private static void handleUnknownException(Exception e) {
        // 사용자에게 보낼 메시지
        System.out.println("알 수 없는 오류가 발생했습니다. 관리자에게 문의해주세요.");
        // 개발자용 상세 로깅
        Logger.error("Unknown Exception", e);
    }
}
