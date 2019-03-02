package controller;

import domain.BettingType;
import domain.User;
import dto.UserDto;
import view.InputView;

import java.util.Random;

import static domain.BettingType.*;

public class BettingController {

    public static boolean userBet(UserDto userDto) {
        int bettingType = InputView.selectGameType();
        BettingType type = BettingType.findType(bettingType);
        while (true) {
            if (type == DIE) {
                return false;
            }
            if (type == CALL) {
                return false;
            }
            if (type == DOUBLE) {
                return true;
            }
            if (type == BBING) {
                return true;
            }
            if (type == QUARTER) {
                return true;
            }
            if (type == HALF) {
                return true;
            }
            System.out.println("잘 못 입력하였습니다. 다시 입력해주세요.");  //뷰단에 해야??
        }
    }

    public static boolean computerBet(UserDto computerDto) {
        Random random = new Random();
        int bettingType = random.nextInt(5)+1;
        BettingType type = BettingType.findType(bettingType);
        while (true) {
            if (type == DIE) {
                return false;
            }
            if (type == CALL) {
                return false;
            }
            if (type == DOUBLE) {
                return true;
            }
            if (type == QUARTER) {
                return true;
            }
            if (type == HALF) {
                return true;
            }
            System.out.println("잘 못 입력하였습니다. 다시 입력해주세요.");  //뷰단에 해야??
        }
    }
}
