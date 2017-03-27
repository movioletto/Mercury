/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mercury.model;



import com.mercury.dao.DAO;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.beans.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Edoardo
 */
public class LuogoDAO {
    
   
    
    private ResultSet rs;
    private Connection con;

    
      public LuogoDAO() throws SQLException, ClassNotFoundException {
        rs = null;
        con = DAO.getConnection();
    }
     public ResultSet getRegioni(String orderbyField, String direction) {
        try {
            Statement p = (Statement) con.createStatement();
            return p.executeQuery(
                    "SELECT * FROM regioni");
        } catch (Exception e) {
            return null;
        }
    }
     
     public ArrayList<String> getProvince(String idregione){
         
         ArrayList<String> listaProvince = new ArrayList<String>();
        //   ArrayList<String> listaProvinceID = new ArrayList<String>();
         try {
            Statement pp = (Statement) con.createStatement();
          ResultSet rs = pp.executeQuery(
                  //  "SELECT * FROM province WHERE idRegione='"+idregione+"'"
                  "SELECT * FROM province WHERE idRegione= '"+idregione+"'"
            );
          
          while(rs.next()){
              listaProvince.add(rs.getString("nome"));
              
          }
         
          return listaProvince;
          
          
        } catch (Exception e) {
            e.getMessage();
            ArrayList<String> listaNULL = new ArrayList<String>();
            listaNULL.add("No, non va");
                    return listaNULL;
        }
     }
     
     public ArrayList<String> getIDProvince(String idregione){
         ArrayList<String> listaProvinceID = new ArrayList<String>();
         try {
            Statement pp = (Statement) con.createStatement();
          ResultSet rs = pp.executeQuery(
                  //  "SELECT * FROM province WHERE idRegione='"+idregione+"'"
                  "SELECT * FROM province WHERE idRegione= '"+idregione+"'"
            );
          
          while(rs.next()){
             
              listaProvinceID.add(rs.getString("idProvincia"));
          }
         
          return listaProvinceID;
          
          
        } catch (Exception e) {
            e.getMessage();
            ArrayList<String> listaNULL = new ArrayList<String>();
            listaNULL.add("No non va");
                    return listaNULL;
        }
     }
     
     
     
     
     public ArrayList<String> getComuni(String idprovincia){
          
         ArrayList<String> listaComuni = new ArrayList<String>();
         try {
            Statement pp = (Statement) con.createStatement();
          ResultSet rs = pp.executeQuery(
                  //  "SELECT * FROM province WHERE idRegione='"+idregione+"'"
                  "SELECT * FROM comuni WHERE idProvincia= '"+idprovincia+"'"
            );
          
          while(rs.next()){
              listaComuni.add(rs.getString("nome"));
          }
         
          return listaComuni;
          
          
        } catch (Exception e) {
            e.getMessage();
            ArrayList<String> listaNULL = new ArrayList<String>();
            listaNULL.add("NO");
                    return listaNULL;
        }
     }
     
     
}