package info.zdziech.g.Users;

public abstract class User  {
    String type;
    String name;
    String password;
    Integer phone;
    public abstract User createUser();


    public String getName() {
        return name;
    }



    public String getPassword() {
        return password;
    }



    public Integer getPhone() {
        return phone;
    }




}

