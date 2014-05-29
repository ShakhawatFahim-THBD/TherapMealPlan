package net.therap.util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 4/29/14
 * Time: 2:27 PM
 */
public interface ResultSetProcessor<E> {
    public E getObjectFromResultSet(ResultSet resultSet) throws SQLException;
}
