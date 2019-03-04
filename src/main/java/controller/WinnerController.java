package controller;

import domain.Card;
import domain.Dealer;
import domain.User;

import java.util.List;

public class WinnerController {
    public static void check(User user, User computer, Dealer dealer) {
        List<Card> cards = user._toUserDto().getCards();
    }
}
