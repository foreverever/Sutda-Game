package domain;

import dto.UserDto;

import java.util.Collections;
import java.util.List;

public enum Genealogy {
    SAMPAL_GT(1, Card.G_MAR, Card.G_AUG, "삼팔광땡"),
    ILPAL_GT(2, Card.G_JAN, Card.G_AUG, "삼팔광땡"),
    ILSAM_GT(2, Card.G_JAN, Card.G_MAR, "일삼광땡"),
    JANG_T(3, Card.OCT, Card.OCT_TWO, "장땡"),
    GU_T(4, Card.SEP, Card.SEP_TWO, "구땡"),
    PAL_T(5, Card.AUG, Card.G_AUG, "팔땡"),
    CHIL_T(6, Card.JUL, Card.JUL_TWO, "칠땡"),
    YUK_T(7, Card.JUN, Card.JUN_TWO, "육땡"),
    OH_T(8, Card.MAY, Card.MAY_TWO, "오땡"),
    SA_T(9, Card.APR, Card.APR_TWO, "사땡"),
    SAM_T(10, Card.MAR, Card.G_MAR, "삼땡"),
    E_T(11, Card.FEB, Card.FEB_TWO, "이땡"),
    IL_T(12, Card.JAN, Card.G_JAN, "일땡"),
    ARLLY(13, Card.JAN, Card.FEB, "알리"), // 망함
    ;

    private int rank;
    private String name;
    private Card card1;
    private Card card2;

    Genealogy(int rank, Card card1, Card card2, String name) {
        this.rank = rank;
        this.card1 = card1;
        this.card2 = card2;
        this.name = name;
    }

    Genealogy(int rank, String name) {
        this.rank = rank;
        this.name = name;
    }

    public static User winner(User player, User computer) {
        UserDto playerDto = player._toUserDto();
        UserDto computerDto = computer._toUserDto();

        int userRank = findType(playerDto.getCards());
        int computerRank = findType(computerDto.getCards());

        // 유저가 우승일 때
        if (userRank > computerRank) {
            return player;
        } else if (userRank == computerRank) { // TODO : 무승부일 때
            return player;
        } else { // 컴퓨터가 우승일 때
            return computer;
        }
    }

    private static int findType(List<Card> cards) {
        Collections.sort(cards);
        for (Genealogy genealogy : values()) {
            if (cards.get(0).equals(genealogy.card1) && cards.get(1).equals(genealogy.card2)) {
                return genealogy.rank;
            }
        }
        return 0;
    }
}
