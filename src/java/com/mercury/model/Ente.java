/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mercury.model;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author emanuele
 */
public class Ente implements Serializable {
    
    private int id;
    private String mail;
    private String pass;
    private int attivo;
    private String nomeEnte;
    private String pIva;
    private String nTelefono;
    private String indirizzo;
    
    public Ente() {
    }

    public Ente(int id, String mail, String pass, int attivo, String nomeEnte, String pIva, String nTelefono, String indirizzo) {
        this.id = id;
        this.mail = mail;
        this.pass = pass;
        this.attivo = attivo;
        this.nomeEnte = nomeEnte;
        this.pIva = pIva;
        this.nTelefono = nTelefono;
        this.indirizzo = indirizzo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }    

    public int getAttivo() {
        return attivo;
    }

    public void setAttivo(int attivo) {
        this.attivo = attivo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNomeEnte() {
        return nomeEnte;
    }

    public void setNomeEnte(String nomeEnte) {
        this.nomeEnte = nomeEnte;
    }

    public String getpIva() {
        return pIva;
    }

    public void setpIva(String pIva) {
        this.pIva = pIva;
    }

    public String getnTelefono() {
        return nTelefono;
    }

    public void setnTelefono(String nTelefono) {
        this.nTelefono = nTelefono;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    
}
