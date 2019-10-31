package info.zdziech.g.Users;

import info.zdziech.g.ShopProducts.Basket;

public class UserFactory   {


 public User createUser(String type, String name, String password, int phone){
        if("Client".equalsIgnoreCase(type)) {
            Basket basket = null;
            return new Client (name, password, phone, basket);
            }
        else if("Admin".equalsIgnoreCase(type)) {
            return new Administrator( name,  password,  phone);
        }
        return null;

    }
}
