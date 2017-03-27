
package com.mercury.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 *
 * @author Giuseppe - Guillermo
 */
public class DAO {

    private static Connection connection;

    private DAO() {

    }

    // Blocco statico del Singleton
    static {
        try {
            // Obtain our environment naming context
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");

            // Look up our data source
            DataSource ds = (DataSource) envCtx.lookup("jdbc/MercuryDB");

            // Allocate and use a connection from the pool
            connection = ds.getConnection();

//            connection.close();

        } catch (NamingException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() {

        // if per garantire che soltanto
        // un’unica istanza della classe stessa possa essere creata
        if (connection == null) {
            new DAO();
        }

        return connection;
    }

}
