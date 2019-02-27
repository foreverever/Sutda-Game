package domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChipTest {
    private Chip chip;

    @Before
    public void setUp() throws Exception {
        chip = new Chip(10000);
    }

    @Test
    public void plusTest() {
        chip.plus(new Chip(10000));
        assertThat(chip).isEqualTo(new Chip(20000));
    }

    @Test
    public void minusTest() {
        chip.minus(new Chip(10000));
        assertThat(chip).isEqualTo(new Chip(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void bet_배팅할_돈이_부족() {
        chip.minus(new Chip(10001));
    }
}
