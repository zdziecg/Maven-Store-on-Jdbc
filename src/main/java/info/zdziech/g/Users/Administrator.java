package info.zdziech.g.Users;

public class Administrator extends User {

    public Administrator(String name, String password, int phone){
        type = "Admin";
        this.name=name;
        super.password=password;
        super.phone=phone;
    }



    @Override
    public User createUser() {
        return new Administrator(name, password, phone);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Administrator{");
        sb.append("type='").append(type).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", email='").append(phone).append('\'');
        sb.append('}');
        return sb.toString();
    }




}


