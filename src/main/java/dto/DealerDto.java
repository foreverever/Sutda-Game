package dto;

import domain.Card;
import domain.Chip;

import java.util.List;

public class DealerDto {
    private Chip chip;
    private List<Card> cards;

    public DealerDto(Chip chip, List<Card> cards) {
        this.chip = chip;
        this.cards = cards;
    }

    public Chip getChip() {
        return chip;
    }

    public List<Card> getCards() {
        return cards;
    }
}
