package domain;

import java.util.ArrayList;
import java.util.List;

public enum Card {
    JAN(1), FEB(2), MAR(3), APR(4), MAY(5),
    JUN(6), JUL(7),AUG(8), SEP(9), OCT(10),
    FEB_TWO(2), APR_TWO(4), MAY_TWO(5), JUN_TWO(6),
    JUL_TWO(7),SEP_TWO(9), OCT_TWO(10),
    G_JAN(11), G_MAR(13), G_AUG(18);

    private int month;
    private boolean used;

    Card(int i) {

    }

    public static List<Card> makeCard(){
        List<Card> cards = new ArrayList<>();
        for(Card card : values()){
            cards.add(card);
        }
        return cards;
    }
// TODO : Enum(상수)에서 상태값을 바꾸면 안됨
    public void use() {
        this.used = true;
    }

    public boolean isUsed() {
        return used;
    }

    public boolean isSame(Card other) {
        return this.month == other.month;
    }

    public int getMonth(){
        return this.month;
    }
}
