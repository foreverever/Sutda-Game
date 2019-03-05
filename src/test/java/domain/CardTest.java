package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardTest {
    @Test
    public void 카드생성() {
        assertThat(Card.makeCard().size()).isEqualTo(20);
    }

    @Test
    public void 일땡() {
        January card = new January();
        January card1 = new January();
        String result = card.matched(card1);
        assertThat(result).isEqualTo("일땡");
    }
}
