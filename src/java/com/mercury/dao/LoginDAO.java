package com.mercury.dao;

import com.mercury.dao.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.HashSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginDAO {

    DAO dao;

    public LoginDAO() {

    }

    public ResultSet result;
    PreparedStatement stmt;

    public boolean effettuaLogin(String mail, String pass)
            throws Exception {
        boolean login = false;

        try {

            
            stmt = dao.getConnection().prepareStatement("SELECT * FROM ente WHERE mail =  ? AND pass = ?");
            stmt.setString(1, mail);
            stmt.setString(2, pass);
            result = stmt.executeQuery();

            if (result.next()) {

                login = true;
                System.out.println("Login effettuato con successo!");

            } else {

                System.out.println("Username o Password errati!");
            }
        } catch (Exception e) {
            System.out.println("Problema sul DB");
            e.printStackTrace();

        }
        return login;
    }

}
