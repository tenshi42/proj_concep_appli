package com.Tournevice.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by mercier on 13/04/2017.
 */
public class Database {
    private static Database instance;
    private Connection connection;

    public static Connection GetConnection() throws Exception {
        instance = new Database();
        return instance.connection;
    }

    public static void close() throws SQLException {
        instance.connection.close();
    }

    private Database() throws Exception {
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException ignored) {
            throw new Exception("No driver !");
        }

        String url = "jdbc:mysql://localhost:3306/projet_dev?useSSL=false";
        String user = "root";
        String password = "toor";

        try {
            connection = DriverManager.getConnection( url, user, password);
        } catch ( SQLException ignored) {
            throw new Exception("No connection !!!!");
        }
    }
}
