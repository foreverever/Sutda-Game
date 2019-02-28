package view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String name() {
        System.out.println("이름을 입력하세요.");
        return scanner.nextLine().trim();
    }

    public static int selectGameType(){
        System.out.println("배팅 종류를 선택해 주세요.");
        System.out.println("다이 : 1, 삥 : 2, 따당 : 3, 콜 : 4, 쿼터 : 5, 하프 : 6");
        return scanner.nextInt();
    }
}
