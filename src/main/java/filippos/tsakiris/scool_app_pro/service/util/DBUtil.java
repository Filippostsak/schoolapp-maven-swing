package filippos.tsakiris.scool_app_pro.service.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Utility class for managing database connections.
 * This class uses the Apache Commons DBCP library for connection pooling.
 * Database connection parameters are read from environment variables.
 */
public class DBUtil {

    private static BasicDataSource ds = new BasicDataSource();
    private static Connection connection;

    // Static initializer to configure the connection pool
    static {
        ds.setUrl(System.getenv("DB_URL"));
//        ds.setUrl("jdbc:mysql://localhost:3306/SchoolDBPro?serverTimezone=UTC");
        ds.setUsername(System.getenv("DB_USER"));
//        ds.setUsername("SchoolDBPro");
        ds.setPassword(System.getenv("DB_PASSWORD"));
//        ds.setPassword("245588671aS!");
        ds.setInitialSize(10);
        ds.setMaxTotal(32);
        ds.setMinIdle(8);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    /**
     * Retrieves a database connection from the connection pool.
     *
     * @return a {@link Connection} object
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        connection = ds.getConnection();
        return connection;
    }

    /**
     * Closes the current database connection.
     *
     * @throws SQLException if a database access error occurs during closing
     */
    public static void closeConnection() throws SQLException {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Re-throw the exception to notify the caller
        }
    }

    /**
     * Private constructor to prevent instantiation.
     * This utility class is not meant to be instantiated.
     */
    private DBUtil() {
    }
}
