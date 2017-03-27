/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mercury.model;

import com.mercury.dao.DAO;
import java.beans.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emanuele
 */
public class EnteDAO implements Serializable {
    
    private Connection connection;
    
    public EnteDAO() {
        this.connection = DAO.getConnection();
    }   
    //new Ente(0, mail, pass, attivo, nomeEnte, pIva, nTelefono, indirizzo);
    public void inserisciEnte(Ente e) {
        String user = e.getMail();
        String pass = e.getPass();
        int attivo = e.getAttivo();
        String nomeEnte = e.getNomeEnte();
        String pIva = e.getpIva();
        String nTelefono = e.getnTelefono();
        String indirizzo = e.getIndirizzo();
        try {
            
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO ente (mail,pass,attivo, nomeEnte, pIva, nTelefono, indirizzo) VALUES (?,?,?,?,?,?,?)");
            stmt.setString(1, user);
            stmt.setString(2, pass);
            stmt.setInt(3, attivo);
            stmt.setString(4, nomeEnte);
            stmt.setString(5, pIva);
            stmt.setString(6, nTelefono);
            stmt.setString(7, indirizzo);
            stmt.executeUpdate();
        }
        catch (SQLException ex) {
            //errore
        }
    }
    
    public void modificaEnte(int id, Ente e) {
        
        String user = e.getMail();
        String pass = e.getPass();
        int attivo = e.getAttivo();
        String nomeEnte = e.getNomeEnte();
        String pIva = e.getpIva();
        String nTelefono = e.getnTelefono();
        String indirizzo = e.getIndirizzo();
        try {
            
            PreparedStatement stmt = connection.prepareStatement("UPDATE ente SET mail=?, pass=?, attivo=?, nomeEnte=?, pIva=?, nTelefono=?, indirizzo=? WHERE idEnte=?");
            stmt.setString(1, user);
            stmt.setString(2,pass);
            stmt.setInt(3, attivo);
            stmt.setString(4, nomeEnte);
            stmt.setString(5, pIva);
            stmt.setString(6, nTelefono);
            stmt.setString(7, indirizzo);
            stmt.setInt(8, id);
            stmt.executeUpdate();
        }
        catch (SQLException ex) {
            //errore
        }
    }
    
    public void eliminaEnte(int id) {
        try {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM ente WHERE idEnte=?");
            stmt.setInt(1, id);
            stmt.executeQuery();
        }
        catch (SQLException ex) {
            //errore
        }
    }
    
    /**
     * Metodo per ottenere un ente tramite id
     * @param id id dell'ente
     * @return null se l'ente non viene trovato
     */
    public Ente getEnte(int id) {
        Ente e = null;
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ente WHERE idEnte=?");
            stmt.setInt(1, id);
            ResultSet set = stmt.executeQuery();
            //idEnte, pass, mail, attivo, nomeEnte, pIva, nTelefono, indirizzo)
            set.next();
            e = new Ente(set.getInt("idente"), set.getString("mail"), set.getString("pass"), set.getInt("attivo"), 
                set.getString("nomeEnte"), set.getString("pIva"), set.getString("nTelefono"), set.getString("indirizzo"));
        }
        catch (SQLException ex) {
            //errore
        }
        return e;
    }
    
    public List<Ente> getEnti() {
        List<Ente> list = new ArrayList<Ente>();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ente");
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                list.add(new Ente(set.getInt("idente"), set.getString("mail"), set.getString("pass"), set.getInt("attivo"),
                        set.getString("nomeEnte"), set.getString("pIva"), set.getString("nTelefono"), set.getString("indirizzo")));
            }
        }
        catch (SQLException ex) {
            //errore
        }
        return list;
    }
    
    public void aggiornaEnte(int id) {
        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE ente SET attivo=1 WHERE idEnte=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
        catch (SQLException ex) {
            //errore
        }
    }
    
}
