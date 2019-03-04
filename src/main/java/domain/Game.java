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
        bettingChip(baseChip, user);
        bettingChip(baseChip, computer);
    }

    private void bettingChip(Chip baseChip, User user) {
        user.bet(baseChip);
        dealer.plus(baseChip);
    }

    private void divideCard() {
        dealer.cardShuffle();
        dealer.passCard(user);
        dealer.passCard(computer);
        // 카드 회수 추가 필요(card used = false)
    }

    public User winner() {
        // 족보 비교
        User winUser =  Genealogy.winner(user, computer);
        dealer.passAward(winUser);
        return  winUser;
    }

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
