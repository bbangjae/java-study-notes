package 예외.예외처리미적용;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NetWorkService netWorkService = new NetWorkService();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("보낼 메시지를 입력하세요: ");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                System.out.println("종료");
                break;
            }

            netWorkService.sendMessage(input);
            System.out.println();
        }
        scanner.close();
    }
}
