package view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String name() {
        System.out.println("이름을 입력하세요.");
        return scanner.nextLine().trim();
    }

    //얘도 시작 유저일 경우랑 나중 유저일 경우랑 선택 종류가 달라짐 메소드 더 만들어야 할듯
    public static int selectGameType(){
        System.out.println("배팅 종류를 선택해 주세요.");
        System.out.println("1(다이), 2(콜), 3(하프), 4(더블), 5(쿼터), 6(삥)");
        return scanner.nextInt();
    }
}
