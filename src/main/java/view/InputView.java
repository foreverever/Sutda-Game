package view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String name() {
        System.out.println("이름을 입력하세요.");
        return scanner.nextLine().trim();
    }

    //얘도 시작 유저일 경우랑 나중 유저일 경우랑 선택 종류가 달라짐 메소드 더 만들어야 할듯
    public static int selectGameType() {
        System.out.println("배팅 종류를 선택해 주세요.");
        System.out.println("1(다이), 2(콜), 3(더블), 4(쿼터), 5(하프)");
        return scanner.nextInt();
    }

    public static int selectDefaultGameType() {
        System.out.println("배팅 종류를 선택해 주세요.");
        System.out.println("1(다이), 5(하프)");
        return scanner.nextInt();
    }

    public static boolean isRestartGame() {
        System.out.println("게임을 계속 하시겠습니까?");
        System.out.println("1 : Yes, 2 : No");
        return scanner.nextInt() == 1;
    }
}
