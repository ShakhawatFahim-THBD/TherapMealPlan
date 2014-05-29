package net.therap.dao;

import net.therap.domain.User;
import net.therap.util.QueryExecutor;
import net.therap.util.ResultSetProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 4/27/14
 * Time: 9:53 AM
 */
public class UserDao {

    public User getUser(User user) {
        String query = "SELECT id, name, password, is_admin FROM user WHERE user.id = ? AND user.is_admin = ?";

        List<User> userList = QueryExecutor.executeSelectQuery(query, new ResultSetProcessor<User>() {
            @Override
            public User getObjectFromResultSet(ResultSet resultSet) throws SQLException {
                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setAdmin(resultSet.getBoolean("is_admin"));
                return user;
            }
        }, user.getId(), user.isAdmin());

        if (userList.size() > 0)
            return userList.get(0);

        return null;
    }
}
