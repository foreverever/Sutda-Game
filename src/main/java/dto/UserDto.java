package dto;

import domain.Card;
import domain.Chip;

import java.util.List;

public class UserDto {
    private String name;
    private List<Card> cards;
    private Chip chip;

    public UserDto() {
    }

    public UserDto(String name, List<Card> cards, Chip chip) {
        this.name = name;
        this.cards = cards;
        this.chip = chip;
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Chip getChip() {
        return chip;
    }
}
