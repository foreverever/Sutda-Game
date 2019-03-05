package domain;

import dto.UserDto;

import java.util.*;

public enum Genealogy {
    SAMPAL_GT(1, 13, 18, "삼팔광땡"),
    ILPAL_GT(2, 11, 18, "일팔광땡"),
    ILSAM_GT(2, 11, 13, "일삼광땡"),
    JANG_T(3, 10, 10, "장땡"),
    GU_T(4, 9, 9, "구땡"),
    PAL_T(5, 8, 18, "팔땡"),
    CHIL_T(6, 7, 7, "칠땡"),
    YUK_T(7, 6, 6, "육땡"),
    OH_T(8, 5, 5, "오땡"),
    SA_T(9, 4, 4, "사땡"),
    SAM_T(10, 3, 13, "삼땡"),
    E_T(11, 2, 2, "이땡"),
    IL_T(12, 1, 11, "일땡"),
    ARLLY(13, 1, 2, "알리"),
    ARLLY2(13, 2, 11, "알리"),
    DOKSA(14, 1, 4, "독사"),
    DOKSA2(14, 4, 11, "독사"),
    GU_BBING(15, 1, 9, "구삥"),
    GU_BBING2(15, 9, 11, "구삥"),
    JANG_BBING(16, 1, 10, "장삥"),
    JANG_BBING2(16, 10, 11, "장삥"),
    JANG_SA(17, 4, 10, "장사"),
    SAE_RYUK(18, 4, 6, "세륙"),
    GapO(19, "갑오"),
    EightGGuk(20, "여덟끗"),
    SevenGGuk(21, "일곱끗"),
    SixGGuk(22, "여섯끝"),
    FiveGGuk(23, "다섯끝"),
    FourGGuk(24, "네끗"),
    ThreeGGuk(25, "세끗"),
    TwoGGuk(26, "두끗"),
    OneGGuk(27, "한끗"),
    MangTong(28, "망통");

    private int rank;
    private String name;
    private int card1;
    private int card2;

    Genealogy(int rank, int card1, int card2, String name) {
        this.rank = rank;
        this.card1 = card1;
        this.card2 = card2;
        this.name = name;
    }

    Genealogy(int rank, String name) {
        this.rank = rank;
        this.name = name;
    }

    //list의 0번째가 우승자이다.
    public static List<User> winner(User player, User computer) {
        // TODO : winner가 누군지 알 수가 없다. User 나 Game에 있는게 낫다. Enum에 있는건 적합하지않음
        List<User> users = new ArrayList<>();

        Genealogy userGenealogy = findType(player);
        player.setGenealogy(userGenealogy.name);
        Genealogy computerGenealogy = findType(computer);
        computer.setGenealogy(computerGenealogy.name);

        // 유저가 우승일 때
        if (userGenealogy.rank < computerGenealogy.rank) {
            users.add(player);
            users.add(computer);
            return users;
        } else if (userGenealogy.rank == computerGenealogy.rank) { // TODO : 무승부일 때
            users.add(player);
            users.add(computer);
            return users;
        } else { // 컴퓨터가 우승일 때
            users.add(computer);
            users.add(player);
            return users;
        }
    }

    private static Genealogy findType(User user) {
        List<Card> cards = user._toUserDto().getCards();
        Collections.sort(cards);
        Card card1 = cards.get(0);
        Card card2 = cards.get(1);
        for (Genealogy genealogy : values()) {
            if (card1.getMonth() == genealogy.card1 && card2.getMonth() == genealogy.card2) {
                return genealogy;
            }
        }

        final int GUT = (card1.getMonth() + card1.getMonth()) % 10;
        if (GUT == 9) { // 갑오(아홉끗)
            return Genealogy.GapO;
        } else if (GUT == 8) { // 여덟끗
            return Genealogy.EightGGuk;
        } else if (GUT == 7) { // 일곱끗
            return Genealogy.SevenGGuk;
        } else if (GUT == 6) { // 여섯끗
            return Genealogy.SixGGuk;
        } else if (GUT == 5) { // 다섯끗
            return Genealogy.FiveGGuk;
        } else if (GUT == 4) { // 네끗
            return Genealogy.FourGGuk;
        } else if (GUT == 3) { // 세끗
            return Genealogy.ThreeGGuk;
        } else if (GUT == 2) { // 두끗
            return Genealogy.TwoGGuk;
        } else if (GUT == 1) { // 한끗
            return Genealogy.OneGGuk;
        } else if (GUT == 0) { // 망통
            return Genealogy.MangTong;
        }
        return null;
    }
}
