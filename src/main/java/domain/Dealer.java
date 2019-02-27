package domain;

import java.util.Collections;
import java.util.List;

public class Dealer {
    private Chip chip;
    private List<Card> cards;

    public Dealer() {
        this.chip = new Chip(0);
        this.cards = Card.makeCard();
    }

    public void initCard() {
        this.cards = Card.makeCard();
    }

    public int plus(Chip chip) {
        return this.chip.plus(chip);
    }

    public Chip reward(User user) {
        user.receiveChip(chip);
        return chip.init();
    }

    public void cardShuffle() {
        Collections.shuffle(cards);
    }

    public void giveCard(User user) {
        for (int i = 0; i < cards.size(); i++) {
            if (!cards.get(i).isUsed()) {
                if (user.isMaxCardSize()) {
                    return;
                }
                user.receiveCard(cards.get(i));
                cards.get(i).use();
            }
        }
    }
}
