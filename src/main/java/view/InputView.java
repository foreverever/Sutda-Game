package view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String name() {
        System.out.println("이름을 입력하세요.");
        String name = scanner.nextLine();
        return name.trim();
    }
}
