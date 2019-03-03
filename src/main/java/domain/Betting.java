package domain;

import view.InputView;

import java.util.Random;

import static domain.BettingType.*;
import static domain.BettingType.HALF;

public class Betting {

    public boolean userBet(User user, Dealer dealer, int currentTurn) {
        int bettingType;
        if (currentTurn == 1) {
            bettingType = InputView.selectDefaultGameType();
        } else {
            bettingType = InputView.selectGameType();
        }

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
                System.out.println("딜러 돈 : " + dealer._toDealerDto().getChip().toString());
                Chip userChip = user.half(dealer._toDealerDto().getChip());
                System.out.println("유저 가 투자한 돈" + userChip.toString());
                dealer.plus(userChip);
                System.out.println("딜러 돈 : " + dealer._toDealerDto().getChip().toString());
                System.out.println(dealer.toString());
                System.out.println("------------------------------------------");

                return true;
            }
            System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");  //뷰단에 해야??
        }
    }

    public boolean computerBet(User computer, Dealer dealer, int currentTurn) {
        Random random = new Random();
        BettingType type;
        if (currentTurn == 1) {
            type = BettingType.findType(5);
        } else {
//            int bettingType = random.nextInt(4) + 1;
//            type = BettingType.findType(bettingType);
            type = BettingType.findType(5);
        }
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
                System.out.println("딜러 돈 : " + dealer._toDealerDto().getChip().toString());
                Chip computerChip = computer.half(dealer._toDealerDto().getChip());
                System.out.println("컴터가 투자한 돈" + computerChip.toString());
                dealer.plus(computerChip);
                System.out.println("딜러 돈 : " + dealer._toDealerDto().getChip().toString());
                System.out.println(dealer.toString());
                System.out.println("------------------------------------------");
                return true;
            }
        }
    }
}
