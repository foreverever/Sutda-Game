package domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    private User user;

    @Before
    public void setUp() throws Exception {
        user = UserFixture.user1;
    }
//
//    @Test
//    public void betTest() {
//        int balance = user.bet(6000);
//        assertThat(balance).isEqualTo(4000);
//    }
//
//    @Test
//    public void 받은카드_개수가_2개인지() {
//        Dealer dealer = new Dealer();
//        dealer.giveCard(UserFixture.user1);
//        assertThat(UserFixture.user1.isMaxCardSize()).isTrue();
//    }
}
