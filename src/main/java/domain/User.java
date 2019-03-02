package domain;

import dto.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String name;
    private Chip chip;
    private List<Card> cards = new ArrayList<>();

    public User(String name) {
        this.name = name;
        this.chip = new Chip(10000);
    }

    public void bet(Chip chip) {
        this.chip.minus(chip);
    }

    public Chip half(Chip chip) {
        return this.chip.halfChip(chip);
    }

    public boolean isMaxCardSize() {
        return cards.size() == 2;
    }

    public int getCardSize() {
        return cards.size();
    }

    public void receiveCard(List<Card> passCard) {
        cards = passCard;
    }

    public UserDto _toUserDto() {
        return new UserDto(name, cards, chip);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(chip, user.chip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, chip);
    }
}
