package org.dsi.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
    private static Connection connection = null;

    public static Connection getConnection () {
        if (connection != null) {
            return connection;
        }

        try {

            InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("/database.properties");
            Properties properties = new Properties();
            properties.load(inputStream);

            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");

            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void closeConnection(Connection con) {
        if (con == null) {
            return;
        }

        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
