package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardTest {
    @Test
    public void 카드생성() {
        assertThat(Card.makeCard().size()).isEqualTo(20);
    }
}
