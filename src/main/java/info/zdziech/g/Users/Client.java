package info.zdziech.g.Users;

import info.zdziech.g.ShopProducts.Basket;

public class Client extends User {

    private Basket basket;

    public Client(String name, String password, int phone, Basket basket){
        type = "Client";
        super.name=name;
        this.password=password;
        this.phone=phone;
        this.basket = basket;
    }


    @Override
    public User createUser() {
        return new Client(name, password, phone, basket);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Client{");
        sb.append("name='").append(name).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", emailAdress='").append(phone).append('\'');
        sb.append(", basket='").append(basket).append('\'');
        sb.append('}');
        return sb.toString();
    }

}



