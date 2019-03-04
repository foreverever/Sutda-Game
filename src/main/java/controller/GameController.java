package controller;

import domain.Card;
import domain.Game;
import domain.User;
import dto.GameDto;
import view.InputView;
import view.ResultView;

import java.util.Arrays;
import java.util.List;

public class GameController {
    private static final int MAX_TURN = 7;

    public static void run() {
        Game game = new Game(InputView.name());
        boolean isContinueGame = true;

        while (isContinueGame) {
            boolean isNextTurn = true;
            int currentTurn = 1;

            game.ready();   //게임 준비
            GameDto gameDto = game._toGameDto();
            List<Card> userCards = gameDto.getUser()._toUserDto().getCards();

            //턴 시작
            while (isNextTurn) {
                ResultView.showUserPair(userCards);
                System.out.println("------------------------------------------------");
                System.out.println("나의 턴");
                System.out.println("------------------------------------------------");

                if (currentTurn == 1) {
                    isNextTurn = game.userTurn(currentTurn, InputView.selectDefaultGameType());
                    currentTurn++;
                } else {
                    isNextTurn = game.userTurn(currentTurn, InputView.selectGameType());
                    currentTurn++;
                }

                if (isNextTurn) {
                    isNextTurn = game.computerTurn(currentTurn);
                    currentTurn++;
                }
            }

            // 게임 결과
            List<User> users = game.winner();
            System.out.println("win : " +  users.get(0).toString());
            System.out.println("lost : " +  users.get(1).toString());
            ResultView.showWinner(users.get(0)._toUserDto(), users.get(1)._toUserDto());

            // 돈 없으면 게임 중단 추가
            isContinueGame = InputView.isRestartGame();  // 리게임 할지 묻기
        }
    }
}
