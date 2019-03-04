package domain;

import dto.GameDto;

public class Game {
    private static User user;
    private static User computer;
    private static Dealer dealer;
    private static Turn turn;
    private int startUser;

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

//    public boolean oneTurn(int currentTurn) {
//        if (currentTurn == 1) {
//            return firstTurn(currentTurn);
//        }
//        return nextTurn(currentTurn);
//    }
//
//    private boolean firstTurn(int currentTurn) {
//        Random random = new Random();   //최초 턴 사용자 결정 (유저 or 컴퓨터 중 랜덤)
//        startUser = random.nextInt(2);
//        if (startUser == 0) {
//            return turn.userTurn(user, dealer, currentTurn);
//        }
//        return turn.computerTurn(computer, dealer, currentTurn);
//    }
//
//    private boolean nextTurn(int currentTurn) {
//        if (startUser == 0) {
//            if (currentTurn % 2 != 0) {
//                return turn.userTurn(user, dealer, currentTurn);
//            }
//            return turn.computerTurn(computer, dealer, currentTurn);
//        }
//
//        if (currentTurn % 2 != 0) {
//            return turn.computerTurn(computer, dealer, currentTurn);
//
//        }
//        return turn.userTurn(user, dealer, currentTurn);
//    }

    public GameDto _toGameDto() {
        return new GameDto(user, computer, dealer, turn);
    }

    public boolean userTurn(int currentTurn, int gameType) {
        return turn.userTurn(user, dealer, currentTurn, gameType);
    }

    public boolean computerTurn(int currentTurn) {
        return turn.computerTurn(computer, dealer, currentTurn);
    }
}
