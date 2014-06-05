package net.therap.service;

import net.therap.dao.UserDao;
import net.therap.domain.User;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 5/19/14
 * Time: 12:04 PM
 */
public class LoginService {

    public boolean isValidUser(User user) {
        boolean isValidUser = false;

        UserDao userDao = new UserDao();
        User retrievedUser = userDao.getUser(user);

        if (retrievedUser != null && retrievedUser.getPassword().equals(user.getPassword())) {
            isValidUser = true;
        }
        return isValidUser;
    }
}
