package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String name;
    private Chip chip;
    private int status = 0;
    private List<Card> cards = new ArrayList<>();

    public User(String name) {
        this.name = name;
        this.chip = new Chip(10000);
    }

    public void defaultBet(Chip chip) {
        this.chip.minus(chip);
    }

    public int getStatus() {
        return status;
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

    public boolean isMaxCardSize() {
        return cards.size() == 2;
    }

    public void receiveCard(List<Card> passCard) {
        cards = passCard;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
