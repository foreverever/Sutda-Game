package domain;

import java.util.List;

public enum Genealogy {
    SAMPAL_GT(1, "삼팔광땡"), ILPAL_GT(2, "일팔광땡"),
    ILSAM_GT(2,"일삼광땡"), TEN_T(3, "장땡"),
    ;

    private int rank;
    private String name;

    Genealogy(int rank) {
        this.rank = rank;
    }

    Genealogy(int rank, String name) {
        this.rank = rank;
        this.name = name;
    }

//    public void TTang(Card card1, Card card2) {
//        if (card1.isSame(card2)) {
//            this.rank = ;
//            this.name =
//        }
//    }
}
