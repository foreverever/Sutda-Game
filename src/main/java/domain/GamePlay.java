package domain;

public class GamePlay {
    private static final int BEGIN = 0;
    private static final int CALL = 1;
    private static final int DIE = 2;
    static Dealer dealer;
    private User user;
    private User computer;

    public GamePlay(String name) {
        this.dealer = new Dealer();
        this.user = new User(name);
        this.computer = new User("컴퓨터");
    }

    public void play(int gameType){
        user.bet(gameType);
        computer.bet(1);    //컴퓨터는 랜덤값??(1~2)
    }

    public void startBet() {
        user.bet(BEGIN);
        computer.bet(BEGIN);
    }
}
