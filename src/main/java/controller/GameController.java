package controller;

import domain.Game;
import dto.GameDto;
import view.InputView;
import view.ResultView;

public class GameController {
    private static final int MAX_TURN = 7;
    private static final int USER = 0;

    public static void run() {
        Game game = new Game(InputView.name());
        boolean isContinueGame = true;

        while (isContinueGame) {
            boolean isNextTurn = true;
            int currentTurn = 1;

            game.ready();   //게임 준비
            GameDto gameDto = game._toGameDto();

            //턴 시작
            while(isNextTurn){
                ResultView.showUserPair(gameDto.getUser()._toUserDto().getCards());
                isNextTurn = game.oneTurn(currentTurn);
                currentTurn++;
            }
            isContinueGame = InputView.isRestartGame();     //리게임 할지 묻기
        }
    }
}
