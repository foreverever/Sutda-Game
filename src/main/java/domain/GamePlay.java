package domain;

public class GamePlay {
    private Dealer dealer;
    private User user;
    private User computer;

    public GamePlay(String name) {
        this.dealer = new Dealer();
        this.user = new User(name);
        this.computer = new User("컴퓨터");
    }


}
