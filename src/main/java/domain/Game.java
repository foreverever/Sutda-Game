package domain;

import dto.GameDto;

import java.util.Random;

public class Game {
    private static User user;
    private static User computer;
    private static Dealer dealer;
    private static Turn turn;

    public Game(String name) {
        user = new User(name);
        computer = new User("컴퓨터");
        dealer = new Dealer();
        turn = new Turn();
    }

    public void ready() {
        baseBet(); // 기본급 배팅
        divideCard(); // 카드 배급
    }

    private void baseBet() {
        Chip baseChip = new Chip(100);
        user.bet(baseChip);
        dealer.plus(baseChip);
        computer.bet(baseChip);
        dealer.plus(baseChip);
    }

    private void divideCard() {
        dealer.cardShuffle();
        dealer.passCard(user);
        dealer.passCard(computer);
        //카드 회수 추가 필요(card used = false)
    }

    public boolean oneTurn(int currentTurn) {
        int startUser = 0;
        if (currentTurn == 1) {
            Random random = new Random();   //최초 턴 사용자 결정 (유저 or 컴퓨터 중 랜덤)
            startUser = random.nextInt(2);
            if (startUser == 0) return turn.userTurn(user, dealer, currentTurn);
            return turn.computerTurn(computer,dealer,currentTurn);
        }

        if(startUser == 0 && currentTurn % 2!=0){
            return turn.userTurn(user, dealer, currentTurn);
        }
        return turn.computerTurn(computer,dealer,currentTurn);
    }

    public GameDto _toGameDto() {
        return new GameDto(user, computer, dealer, turn);
    }
}
