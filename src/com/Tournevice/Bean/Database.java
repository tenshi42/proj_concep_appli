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

    public static Database GetInstance(){
        if(instance == null)
            instance = new Database();
        return instance;
    }

    private Database(){
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
            /* Gérer les éventuelles erreurs ici. */
        }

        /* Connexion à la base de données */
        String url = "jdbc:mysql://localhost:3306/projet_dev";
        String user = "root";
        String password = "toor";

        try {
            connection = DriverManager.getConnection( url, user, password);
        } catch ( SQLException e ) {
            /* Gérer les éventuelles erreurs ici */
        }
        finally {
            if ( connection != null ) {
                try {
                    connection.close();
                } catch (SQLException ignore) {
                    /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
                }
            }
        }
    }
}
