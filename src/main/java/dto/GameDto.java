package dto;

import domain.Dealer;
import domain.Turn;
import domain.User;

public class GameDto {
    // TODO : 인스턴스 변수를 도메인으로 받지말고 DTO로 받아라.
    private User user;
    private User computer;
    private Dealer dealer;
    private Turn turn;

    public GameDto(User user, User computer, Dealer dealer, Turn turn) {
        this.user = user;
        this.computer = computer;
        this.dealer = dealer;
        this.turn = turn;
    }

    public User getUser() {
        return user;
    }

    public User getComputer() {
        return computer;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public Turn getTurn() {
        return turn;
    }
}
