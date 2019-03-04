package controller;

import domain.Card;
import domain.Game;
import domain.User;
import dto.GameDto;
import view.InputView;
import view.ResultView;

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
            User winUser = game.winner();
            ResultView.showWinner(winUser._toUserDto().getName());

            // 돈 없으면 게임 중단 추가
            isContinueGame = InputView.isRestartGame();  // 리게임 할지 묻기
        }
    }
}
