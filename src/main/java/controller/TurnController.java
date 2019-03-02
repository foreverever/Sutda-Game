package controller;

import domain.Dealer;
import domain.User;
import view.ResultView;

import java.util.Random;

public class TurnController {
    private static final int MAX_TURN = 7;
    private static final int USER = 0;
    private static int currentTurn = 1;

    public static void turn(User user, User computer, Dealer dealer) {
        boolean isNextTurn = true;
        Random random = new Random();
        int startUser = random.nextInt(2);


        while (isNextTurn) {
            ResultView.showUserPair(user._toUserDto().getCards());
            if (startUser == USER) {
                isNextTurn = BettingController.userBet(user, dealer, currentTurn);
                currentTurn++;
                if (isNextTurn) {
                    isNextTurn = BettingController.computerBet(computer, dealer, currentTurn);
                    currentTurn++;
                }
            } else {
                isNextTurn = BettingController.computerBet(computer, dealer, currentTurn);
                currentTurn++;
                if (isNextTurn) {
                    isNextTurn = BettingController.userBet(computer, dealer, currentTurn);
                    currentTurn++;
                }
            }
        }

        WinnerController.check(user, computer, dealer);
    }

//    public static void userTurn(User user, User computer) {
//        boolean isContinue = BettingController.bet(user);
//        if (!isContinue) WinnerController.award();
//        computerTurn();
//    }
//
//    private static void computerTurn(User user, User computer) {
//        boolean isContinue = BettingController.bet(computer);
//        if (!isContinue) WinnerController.award();
//        userTurn();
//    }
}
