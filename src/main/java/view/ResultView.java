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
}
