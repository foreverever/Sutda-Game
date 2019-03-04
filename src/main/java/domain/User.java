package domain;

import dto.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String name;
    private Chip chip;
    private Chip bettedChip;
    private List<Card> cards = new ArrayList<>();

    public User(String name) {
        this.name = name;
        this.chip = new Chip(10000);
        this.bettedChip = new Chip(0);
    }

    public void bet(Chip chip) {
        this.chip.minus(chip);
        bettedChip.plus(chip);
    }

    public Chip halfBet(Chip chip) {
        Chip bettingChip = this.chip.halfChip(chip);
        bettedChip.plus(bettingChip);
        return bettingChip;
    }

    public Chip quarterBet(Chip chip) {
        Chip bettingChip = this.chip.quarterChip(chip);
        bettedChip.plus(bettingChip);
        return bettingChip;
    }

    public Chip doubleBet(Chip prePlayerChip) {
        Chip bettingChip = this.chip.doubleChip(chip);
        bettedChip.plus(bettingChip);
        return bettingChip;
    }

    public Chip callBet(Chip prePlayerChip) {
        System.out.println("투자한 돈 : " + bettedChip.toString());
        System.out.println("이전사람 돈 : " + prePlayerChip.toString());
        Chip bettingChip = new Chip(prePlayerChip.minus(bettedChip));
        System.out.println("내가 내야할 돈 : " + bettingChip.toString());
        bettedChip.plus(bettingChip);
        return bettingChip;
    }

    public void receiveAward(Chip chip) {
        this.chip.plus(chip);
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
