package controller;

import domain.Chip;
import domain.Dealer;
import domain.User;
import view.InputView;

public class GameController {
    private static User user;
    private static User computer;
    private static Dealer dealer;

    public static void run() {
        user = new User(InputView.name());
        computer = new User("컴퓨터");
        dealer = new Dealer();
        start();
    }

    private static void start() {
        baseBet(); // 기본급 배팅
        divideCard(); // 카드 배급
        createGenealogy();
        TurnController.turn(user, computer, dealer);
    }

    private static void baseBet() {
        Chip baseChip = new Chip(100);
        user.bet(baseChip);
        dealer.plus(baseChip);
        computer.bet(baseChip);
        dealer.plus(baseChip);
    }

    private static void divideCard() {
        dealer.cardShuffle();
        dealer.passCard(user);
        dealer.passCard(computer);
//        user.receiveCard(dealer.passCard());
//        computer.receiveCard(dealer.passCard());
    }
}
