/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mercury.model;

import com.mercury.dao.DAO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fabio
 */
public class NewsletterDAO implements Serializable {
    
    private Connection connection;
    
    public NewsletterDAO() {
        this.connection = DAO.getConnection();
    }
    
    public void inserisciNewsletter(Newsletter n) {
        int id;
        String mail = n.getEmail();
        String idLuogo = n.getIdLuogo();
        int cadenza = n.getCadenza();
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO newsletter (mail,idLuogo,cadenza) VALUES (?,?,?)");
            stmt.setString(1, mail);
            stmt.setString(2, idLuogo);
            stmt.setInt(3, cadenza);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            id = rs.getInt("idNewsletter");
            for (int i=0; i<n.getPreferenze().size(); i++) {
                PreparedStatement stmt2 = connection.prepareStatement("INSERT INTO preferenze ( idNewsletter, idTipo) VALUES (?,?)");
                stmt2.setInt(1, id);
                stmt2.setInt(2, n.getPreferenze().get(i));
                stmt2.execute();
            }
        }
        catch (SQLException ex) {
            //errore
        }
        
    }
    
    /**
    public void modificaNewsletter(int id, Newsletter n) {
        int idNewsletter = n.getId();
        String mail = n.getEmail();
        String idLuogo = n.getIdLuogo();
        int cadenza = n.getCadenza();
        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE newsletter SET mail=?, idLuogo=?, cadenza=? WHERE idNewsletter=?");
            stmt.setString(1, mail);
            stmt.setString(2,idLuogo);
            stmt.setInt(3, cadenza);
            stmt.setInt(4, idNewsletter);
            stmt.executeQuery();
        }
        catch (SQLException ex) {
            //errore
        }
        
    }
    public void eliminaNewsletter(int id) {
        try {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM newsletter WHERE idNewsletter=?");
            stmt.setInt(1, id);
            stmt.executeQuery();
        }
        catch (SQLException ex) {
            //errore
        }
        
    }
   
   
    */
    public List<Newsletter> getNewsletter(int cadenza) {
        List<Newsletter> list = null;
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM newsletter WHERE cadenza=?");
            stmt.setInt(1, cadenza);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                list.add(new Newsletter(set.getInt("idnewsletter"), set.getString("mail"), set.getString("idluogo"), set.getInt("cadenza"), new ArrayList<Integer>()));
            }
            
            for(Newsletter n : list) {
                
                PreparedStatement stmt2 = connection.prepareStatement("SELECT p.idTipo FROM preferenze p WHERE p.idNewsletter=?");
                stmt2.setInt(1, n.getId());
                ResultSet rs = stmt2.executeQuery();
                rs.next();
                n.getPreferenze().add(rs.getInt("idTipo"));
                
            }
        }
        catch (SQLException ex) {
            //errore
        }
        return list;
    }
    
//     public Newsletter getNewsletter(int id) {
//        Newsletter n = null;
//        try {
//            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM newsletter WHERE idNewsletter=?");
//            stmt.setInt(1, id);
//            ResultSet set = stmt.executeQuery();
//            set.next();
//            n = new Newsletter(set.getInt("idnewsletter"), set.getString("mail"), set.getString("idluogo"), set.getInt("cadenza"));
//        }
//        catch (SQLException ex) {
//            //errore
//        }
//        return n;
//    }
}
