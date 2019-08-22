package info.zdziech.g.Clients;

import java.util.InputMismatchException;

public class Users  {


    public void createUser(User user) throws InputMismatchException {

        if (user.getName() == (null)) {
            throw new NullPointerException("User name is nesessary");
        }
        if (user.getPhone() <= 0) {
            throw new IllegalArgumentException(String.format("Illegal quantity %d!", user.getPhone()));
        }

    }

    public boolean checkUser(String name, String userName) {

        if (name.equals(userName)) { //user is exist
            return true;

        }
        return false; //user is not exist
    }

    public boolean checkPassword(String password, String userPassword) {
        if (password.equals(userPassword)) {
            return true;
        }
        return false;
    }
    public boolean loginToStore ( boolean checkUser, boolean checkPassword){

        if (checkUser && checkPassword){
            System.out.println("Login succesfull");
            return true;
        }

        return false;


    };


}