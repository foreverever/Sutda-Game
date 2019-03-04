package dto;

import domain.Card;
import domain.Chip;

import java.util.List;

public class UserDto {
    private String name;
    private List<Card> cards;
    private Chip chip;
    private String genealogy;

    public UserDto(String name, List<Card> cards, Chip chip, String genealogy) {
        this.name = name;
        this.cards = cards;
        this.chip = chip;
        this.genealogy = genealogy;
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

    public void setGenealogy(String genealogy) {
        this.genealogy = genealogy;
    }

    public String getGenealogy() {
        return genealogy;
    }
}
