package domain;

import controller.WinnerController;
import view.ResultView;

import java.util.Random;

public class Turn {
    private static final int MAX_TURN = 7;
    private static final int USER = 0;
    private static int currentTurn = 1;
    private Betting betting;

    public Turn() {
        this.betting = new Betting();
    }

    public boolean userTurn(User user, Dealer dealer, int currentTurn, int bettingType) {
        return betting.userBet(user, dealer, currentTurn, bettingType);
    }

    public boolean computerTurn(User computer, Dealer dealer, int currentTurn) {
        return betting.computerBet(computer,dealer,currentTurn);
    }

//    public void startTurn(User user, User computer, Dealer dealer) {
//        boolean isNextTurn = true;
//        Random random = new Random();
//        int startUser = random.nextInt(2);
//
//        while (isNextTurn) {
//            if (startUser == USER) {
//                isNextTurn = betting.userBet(user, dealer, currentTurn);
//                currentTurn++;
//                if (isNextTurn) {
//                    isNextTurn = betting.computerBet(computer, dealer, currentTurn);
//                    currentTurn++;
//                }
//            } else {
//                isNextTurn = betting.computerBet(computer, dealer, currentTurn);
//                currentTurn++;
//                if (isNextTurn) {
//                    isNextTurn = betting.userBet(computer, dealer, currentTurn);
//                    currentTurn++;
//                }
//            }
//        }
//
//        WinnerController.check(user, computer, dealer);
//    }


}
