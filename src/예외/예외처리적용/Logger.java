package 예외.예외처리적용;

public class Logger {
    public static void error(String message, Throwable e) {
        System.err.println("[ERROR] " + message);
        e.printStackTrace(System.err);
    }
}