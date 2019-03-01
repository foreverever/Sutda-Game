package controller;

import domain.Dealer;
import domain.User;
import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class TurnController {
    private static final int MAX_TURN = 5;

    private int allChips = 0;
    private int howMuch = 0;
    private static boolean allStop = false;
    private static List<User> users = new ArrayList<>();
    private static List<User> die = new ArrayList<>();

    public static void turn(User user, User computer, Dealer dealer) {
        users.add(user);
        users.add(computer);
        int i = 0;
        while (i < MAX_TURN) {
            i++;
            if (allStop) {
                break;
            }
            oneRound();
        }
    }

    private static void oneRound() {
        for (int i = 0; i < users.size(); i++) {
            int battingType = InputView.selectGameType();
            if (users.get(i).getStatus() != 1) {
                if (battingType == 1) {
                    users.get(i).setStatus(1);
                } else if (battingType == 2) {
                    users.get(i).setStatus(2);
                } else if (battingType == 3) {
                    users.get(i).setStatus(3);
                }
            }
        }
    }

    private static void allStop(){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getStatus() == 1) {
                allStop = true;
            } else {
                allStop = false;
            }
        }
    }

}
