package domain;

public class Dealer {
    private Chip chip;

    public Dealer() {
        this.chip = new Chip(0);
    }

    public int plus(Chip chip) {
        return this.chip.plus(chip);
    }

    public Chip reward(User user) {
        user.receiveChip(chip);
        return chip.init();
    }
}
