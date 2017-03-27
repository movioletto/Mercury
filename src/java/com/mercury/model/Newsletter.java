/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mercury.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author fabio
 */
public class Newsletter implements Serializable {
    
    private int id;
    private String email;
    private String idLuogo;
    private int cadenza;
    private List<Integer> preferenze;

    public Newsletter(){
        
    }
    
    public Newsletter(int id, String email, String idLuogo, int cadenza, List<Integer> preferenze) {
        this.id = id;
        this.email = email;
        this.idLuogo = idLuogo;
        this.cadenza = cadenza;
        this.preferenze = preferenze;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdLuogo() {
        return idLuogo;
    }

    public void setIdLuogo(String idLuogo) {
        this.idLuogo = idLuogo;
    }

    public int getCadenza() {
        return cadenza;
    }

    public void setCadenza(int cadenza) {
        this.cadenza = cadenza;
    }

    public List<Integer> getPreferenze() {
        return preferenze;
    }

    public void setPreferenze(List<Integer> preferenze) {
        this.preferenze = preferenze;
    }
       
}
