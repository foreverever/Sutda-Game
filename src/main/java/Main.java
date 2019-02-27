import domain.GamePlay;
import domain.User;
import view.InputView;

public class Main {
    public static void main(String[] args) {
        String name = InputView.name();
        GamePlay gamePlay = new GamePlay(name);
        while (true) {
            gamePlay.startBet();    //게임시작시 처음 배팅
            gamePlay.play(InputView.selectGameType());  //게임 시작
        }
    }
}
