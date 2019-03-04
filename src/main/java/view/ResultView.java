package view;

import domain.Card;

import java.util.List;

public class ResultView {
    public static void showUserPair(List<Card> cards) {
        System.out.print("당신의 패 : ");
        for (Card card : cards) {
            System.out.print(card + " ");
        }
        System.out.println();
    }

    public static void showWinner(String name) {
        System.out.println("우승자는 " + name + "입니다!!");
    }
}
