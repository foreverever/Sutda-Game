package domain;

import java.util.Objects;

public class User {
    private static final int CALL = 1;
    private static final int DIE = 2;
    private String name;
    private Chip chip;

    public User(String name) {
        this.name = name;
        this.chip = new Chip(10000);
    }

//    public int bet(Chip chip) {
//        return this.chip.minus(chip);
//    }

    public int bet(int input) {
        if(input == CALL){
            return this.chip.minus(chip);
        }
        if(input == DIE){
            return 0;
        }
        return 0;
    }

    public void receiveChip(Chip reward) {
        this.chip.plus(reward);
    }

    public boolean isSameChip(Chip chip) {
        return this.chip.equals(chip);
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
