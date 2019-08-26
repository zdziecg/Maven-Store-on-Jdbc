package info.zdziech.g;

import info.zdziech.g.Clients.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class UsersTest {

    private User user = new User(1, "username", "password", 1234);

    @Test
    void usersWithSameNameShouldBeEquals() {

        assertEquals(user.getName(), "username");
    }
    @Test
    void usersWithDifferentNameShouldtBeEquals(){
        assertNotEquals(user.getName(), "Username");
    }

    @Test
    void checkPasswordShouldBeEquals() {
        assertEquals(user.getPassword(),"password");
    }
    @Test
    void differentPasswordShouldntBeEquals() {
        assertNotEquals(user.getPassword(),"password1");
    }

    @Test
    void UsersWithDifferentNameAndSamePasswordAndPhoneShoulBeNotEqualt() {
        assertNotEquals(new User(2, "name", "password",1234), user);

    }
}