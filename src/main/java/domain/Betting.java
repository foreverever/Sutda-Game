package domain;

import java.util.Random;

import static domain.BettingType.*;

public class Betting {
    private Chip prePlayerChip = new Chip(0);

    public boolean userBet(User user, Dealer dealer, int currentTurn, int bettingType) {
//        if (currentTurn == 1) {
//            bettingType = InputView.selectDefaultGameType();    //도메인 로직 과정에서 입력을 받을 경우에는 도대체 어떻게 해야함?? 도메인에서 뷰단을 가져오면 안되잖아.. 시발
//        } else {
//            bettingType = InputView.selectGameType();
//        }

        BettingType type = BettingType.findType(bettingType);
        while (true) {
            if (type == DIE) {
                return false;
            }
            if (type == CALL) {
                Chip userChip = user.callBet(prePlayerChip);
                dealer.plus(userChip);
                return false;
            }
            if (type == DOUBLE) {
                Chip userChip = user.doubleBet(prePlayerChip);
                dealer.plus(userChip);
                prePlayerChip.plus(userChip);
                return true;
            }
            if (type == QUARTER) {
                Chip userChip = user.quarterBet(dealer._toDealerDto().getChip());
                dealer.plus(userChip);
                prePlayerChip.plus(userChip);
                return true;
            }
            if (type == HALF) {
                Chip userChip = user.halfBet(dealer._toDealerDto().getChip());
                dealer.plus(userChip);
                prePlayerChip.plus(userChip);
                return true;
            }
            System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");  //뷰단에 해야??
        }
    }

    public boolean computerBet(User computer, Dealer dealer, int currentTurn) {
        Random random = new Random();
        BettingType type;

//            int bettingType = random.nextInt(4) + 1;
//            type = BettingType.findType(bettingType);
        type = BettingType.findType(5);

        while (true) {
            if (type == DIE) {
                return false;
            }
            if (type == CALL) {
                Chip computerChip = computer.callBet(prePlayerChip);
                dealer.plus(computerChip);
                return false;
            }
            if (type == DOUBLE) {
                Chip computerChip = computer.doubleBet(prePlayerChip);
                dealer.plus(computerChip);
                prePlayerChip.plus(computerChip);
                return true;
            }
            if (type == QUARTER) {
                Chip computerChip = computer.quarterBet(dealer._toDealerDto().getChip());
                dealer.plus(computerChip);
                prePlayerChip.plus(computerChip);
                return true;
            }
            if (type == HALF) {
                System.out.println("딜러 돈 : " + dealer._toDealerDto().getChip().toString());
                Chip computerChip = computer.halfBet(dealer._toDealerDto().getChip());
                System.out.println("컴터가 투자한 돈" + computerChip.toString());
                dealer.plus(computerChip);
                System.out.println("딜러 돈 : " + dealer._toDealerDto().getChip().toString());
                System.out.println(dealer.toString());
                System.out.println("------------------------------------------");
                prePlayerChip.plus(computerChip);
                return true;
            }
        }
    }
}
