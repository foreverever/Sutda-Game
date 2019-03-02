package domain;

import dto.DealerDto;

import javax.crypto.Cipher;
import java.util.ArrayList;
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

    public void plus(Chip chip) {
        this.chip.plus(chip);
    }

    public void cardShuffle() {
        Collections.shuffle(cards);
    }

    public void passCard(User user) {
        List<Card> twoCard = new ArrayList<>();
        for (Card card : cards) {
            if (!card.isUsed()) {
                twoCard.add(card);
                card.use();
                if (twoCard.size() == 2) {
                    user.receiveCard(twoCard);
                    return;
                }
            }
        }
    }

    public DealerDto _toDealerDto() {
        return new DealerDto(chip, cards);
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "chip=" + chip +
                ", cards=" + cards +
                '}';
    }
}
