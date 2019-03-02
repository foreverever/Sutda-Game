package controller;

import dto.UserDto;
import view.ResultView;

public class TurnController {
    private static final int MAX_TURN = 5;

    public static void turn(UserDto userDto, UserDto computerDto) {
        boolean isNextTurn = true;

        while (isNextTurn) {
            ResultView.showUserPair(userDto.getCards());

            isNextTurn = BettingController.userBet(userDto);
            if (isNextTurn) {
                isNextTurn = BettingController.computerBet(computerDto);

            }
        }
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
