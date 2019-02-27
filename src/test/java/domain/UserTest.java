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

    @Test
    public void betTest() {
        int balance = user.bet(6000);
        assertThat(balance).isEqualTo(4000);
    }

    //    @Test
//    public void batTest() {
//        User user;
//        user.bet(1000);
//
//    }
}
