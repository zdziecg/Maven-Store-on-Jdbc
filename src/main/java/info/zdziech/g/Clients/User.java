package info.zdziech.g.Clients;

public class User {
    private int id;
    private String name;
    private String password;
    private int phone;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public User(int id, String name, String password, int phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || !(otherObject instanceof User)) {
            return false;
        }
        User user = (User) otherObject;

        return name.equals(user.name);
    }

}


