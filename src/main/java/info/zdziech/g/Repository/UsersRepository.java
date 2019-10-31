package info.zdziech.g.Repository;

import info.zdziech.g.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsersRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getuserDataName(String name) {
        try {
            String sql = "SELECT NAME from USERS where NAME=?";
            return jdbcTemplate.queryForObject(sql, String.class, name);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    public String getpassword(String name) {
        try {
            String sql = "SELECT PASSWORD FROM USERS WHERE NAME=?";
            return jdbcTemplate.queryForObject(sql, String.class, name);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void addUser(User user) {
        String SQL_ADD_USER = "INSERT INTO USERS (ID, NAME, PASSWORD, PHONE)VALUES (?,?,?,?)";
        String username = user.getName();
        String password = user.getPassword();
        Integer phone = user.getPhone();
        if (getuserDataName(username) == (null)) {
            jdbcTemplate.update(SQL_ADD_USER, usersNumber() +1, username, password, phone);
        }
        else System.out.println("User is exist");
    }

    public int usersNumber() {
        try {
            return jdbcTemplate.queryForObject("Select count (*) from Users", Integer.class);
        } catch (NullPointerException e) {
            return 0;
        }

    }
}
