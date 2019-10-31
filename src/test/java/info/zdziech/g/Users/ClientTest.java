package info.zdziech.g.Users;

import info.zdziech.g.ShopProducts.Basket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ClientTest {

    Basket b = new Basket();
    User client = new Client("client1", "password", 1234, b);

    @Test
    void usersWithSameNameShouldBeEquals() {

        assertEquals(client.getName(), "client1");
    }
    @Test
    void usersWithDifferentNameShouldtBeEquals(){
        assertNotEquals(client.getName(), "Username");
    }

    @Test
    void checkPasswordShouldBeEquals() {
        assertEquals(client.getPassword(),"password");
    }
    @Test
    void differentPasswordShouldntBeEquals() {
        assertNotEquals(client.getPassword(),"password1");
    }

    @Test
    void UsersWithDifferentNameAndSamePasswordAndPhoneShoulBeNotEqualt() {
        assertNotEquals(new Client("client2", "password", 1234,b), client);
    }
}