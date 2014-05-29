package net.therap.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 5/20/14
 * Time: 4:13 PM
 */

public class ConnectionManager {
//    private static final Logger log = LoggerFactory.getLogger(ConnectionManager.class);

    private static final String DATA_SOURCE_URL = "java:/comp/env/jdbc/MealPlanDB";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup(DATA_SOURCE_URL);
            connection = dataSource.getConnection();
    //        log.debug("new database connection created");
        } catch (NamingException | SQLException e) {
  //          log.debug("failed to create database connection");
            e.printStackTrace();
        }
        return connection;
    }

}

