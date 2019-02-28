package domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DealerTest {
    private Dealer dealer;

    @Before
    public void setUp() throws Exception {
        dealer = new Dealer();
    }

//    @Test
//    public void 딜러_배팅칩_받기() {
//        assertThat(dealer.plus(new Chip(1000))).isEqualTo(1000);
//    }
//
//    @Test
//    public void 딜러_배팅칩_승자_주기() {
//        dealer.plus(new Chip(1000));
//        assertThat(dealer.reward(UserFixture.user1)).isEqualTo(new Chip(0));
//        assertThat(UserFixture.user1.isSameChip(new Chip(11000))).isTrue();
//    }

}
