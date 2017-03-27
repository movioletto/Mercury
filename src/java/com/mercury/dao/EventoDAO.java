/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mercury.dao;

import com.mercury.model.Evento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventoDAO {

    // Dichiarazione variabili
    private DAO dao;
    private Evento e = new Evento();
    private Statement stmt;
    private ResultSet rs;

    public Evento getEvento(int id) throws SQLException {
        // Preparo la query di selezione
        String selectQuery = "SELECT * FROM evento e INNER JOIN tipoevento t "
                + "ON e.idTipo=t.idTipo INNER JOIN ente a ON a.idEnte=e.idEnte  "
                + "WHERE e.idEvento=" + id;

        try {
            stmt = dao.getConnection().createStatement();
            rs = stmt.executeQuery(selectQuery);

            rs.first();
            // Creo un nuovo oggetto Evento
            e = new Evento();
            // Assegno le proprietà all'oggetto
            e.setId(id);
            e.setNome(rs.getString("nome"));
            e.setDataFine(rs.getString("timeEnd"));
            e.setDataInizio(rs.getString("timeStart"));
            e.setDescrizione(rs.getString("descrizione"));
            e.setIdTipo(rs.getInt("idTipo"));
            e.setIdLuogo(rs.getString("idLuogo"));
            e.setIdEnte(rs.getInt("idEnte"));
        } //end try 
        catch (SQLException sqle) {
        } //end catch 
        finally {
            // chiudo la connessione
            //dao.getConnection().close();
        }
        return e;
    }

    public ArrayList<Evento> getEventi() throws SQLException {
        // Istanzio un'arraylist da riempire con oggetti Evento
        ArrayList<Evento> eventi = new ArrayList<Evento>();
        // Preparo la query di selezione
        String selectQuery = "SELECT * FROM evento";

        try {
            stmt = dao.getConnection().createStatement();
            rs = stmt.executeQuery(selectQuery);

            while (rs.next()) {
                // Creo un nuovo oggetto Evento
                e = new Evento();
                // Assegno le proprietà all'oggetto
                e.setId(rs.getInt("idEvento"));
                e.setNome(rs.getString("nome"));
                e.setDataFine(rs.getString("timeEnd"));
                e.setDataInizio(rs.getString("timeStart"));
                // Faccio un controllo sull'unico campo nullable
                if (ifStringIsValid(rs.getString("descrizione"))) {
                    e.setDescrizione(rs.getString("descrizione"));
                } else {
                    e.setDescrizione("");
                }

                e.setIdTipo(rs.getInt("idTipo"));
                e.setIdLuogo(rs.getString("idLuogo"));
                e.setIdEnte(rs.getInt("idEnte"));
                // Inserisco l'evento nell'arraylist da stampare
                eventi.add(e);
            }
        } //end try
        catch (SQLException sqle) {
        } //end catch
        finally {
            // chiudo la connessione
            //dao.getConnection().close();
        }
        return eventi;
    }

    public ArrayList<Evento> getEventi(String idLuogo, int idTipoEvento, String data) throws SQLException {
        // Istanzio un'arraylist da riempire con oggetti Evento
        ArrayList<Evento> eventi = new ArrayList<Evento>();
        // Preparo la query di selezione

        String selectQuery = controlloTipoLuogoByDate(idLuogo, idTipoEvento, data);

        try {
            stmt = dao.getConnection().createStatement();
            rs = stmt.executeQuery(selectQuery);

            while (rs.next()) {
                // Creo un nuovo oggetto Evento
                e = new Evento();
                // Assegno le proprietà all'oggetto
                e.setId(rs.getInt("idEvento"));
                e.setNome(rs.getString("nome"));
                e.setDataFine(rs.getString("timeEnd"));
                e.setDataInizio(rs.getString("timeStart"));

                // Faccio un controllo sull'unico campo nullable
                if (ifStringIsValid(rs.getString("descrizione"))) {
                    e.setDescrizione(rs.getString("descrizione"));
                } else {
                    e.setDescrizione("");
                }

                e.setIdTipo(rs.getInt("idTipo"));
                e.setIdLuogo(rs.getString("idLuogo"));
                e.setIdEnte(rs.getInt("idEnte"));
                // Inserisco l'evento nell'arraylist da stampare
                eventi.add(e);
            }
        } //end try
        catch (SQLException sqle) {
        } //end catch
        finally {
            // chiudo la connessione
            //dao.getConnection().close();
        }
        return eventi;
    }

    public ArrayList<Evento> getEventi(String idLuogo, int idTipoEvento, String dataInizio, String dataFine) throws SQLException {
        // Istanzio un'arraylist da riempire con oggetti Evento
        ArrayList<Evento> eventi = new ArrayList<Evento>();
        // Preparo la query di selezione

        String selectQuery = controlloTipoLuogoBetweenDate(idLuogo, idTipoEvento, dataInizio, dataFine);

        try {
            stmt = dao.getConnection().createStatement();
            rs = stmt.executeQuery(selectQuery);

            while (rs.next()) {
                // Creo un nuovo oggetto Evento
                e = new Evento();
                // Assegno le proprietà all'oggetto
                e.setId(rs.getInt("idEvento"));
                e.setNome(rs.getString("nome"));
                e.setDataFine(rs.getString("timeEnd"));
                e.setDataInizio(rs.getString("timeStart"));

                // Faccio un controllo sull'unico campo nullable
                if (ifStringIsValid(rs.getString("descrizione"))) {
                    e.setDescrizione(rs.getString("descrizione"));
                } else {
                    e.setDescrizione("");
                }

                e.setIdTipo(rs.getInt("idTipo"));
                e.setIdLuogo(rs.getString("idLuogo"));
                e.setIdEnte(rs.getInt("idEnte"));
                // Inserisco l'evento nell'arraylist da stampare
                eventi.add(e);
            }
        } //end try
        catch (SQLException sqle) {
        } //end catch
        finally {
            // chiudo la connessione
            //dao.getConnection().close();
        }
        return eventi;
    }

    public void inserisciEvento(Evento e) {

    }

    public ArrayList<Evento> getEventi(String nome, String idLuogo, Integer idTipo, String dataInizio, String dataFine, Integer idEnte) {
        String selectQuery = "SELECT * FROM evento e ";
        ArrayList<Evento> eventi = new ArrayList<Evento>();

        try {
            if (ifStringIsValid(idLuogo)) {
                selectQuery += controlloTipoLuogo(idLuogo);
            } else {
                selectQuery += " WHERE 1 ";
            }
            if (ifStringIsValid(nome)) {
                selectQuery += " AND e.nome LIKE '%" + nome + "%'";
            }

            if ((Integer) idTipo != null) {
                selectQuery += " AND e.idTipo = " + idTipo;
            }
            if (ifStringIsValid(dataInizio) && ifStringIsValid(dataFine)) {
                selectQuery += " AND e.timeStart>= '"
                        + dataInizio + "' AND e.timeStart<= '"
                        + dataFine + "'";
            } else if (ifStringIsValid(dataInizio) && !ifStringIsValid(dataFine)) {
                selectQuery += " AND e.timeStart>= '"
                        + dataInizio + "'";
            }
            if ((Integer) idEnte != null) {
                selectQuery += " AND e.idEnte= " + idEnte;
            }

            stmt = dao.getConnection().createStatement();
            rs = stmt.executeQuery(selectQuery);
            while (rs.next()) {
                // Creo un nuovo oggetto Evento
                e = new Evento();
                // Assegno le proprietà all'oggetto
                e.setId(rs.getInt("idEvento"));
                e.setNome(rs.getString("nome"));
                e.setDataFine(rs.getString("timeEnd"));
                e.setDataInizio(rs.getString("timeStart"));

                // Faccio un controllo sull'unico campo nullable
                if (ifStringIsValid(rs.getString("descrizione"))) {
                    e.setDescrizione(rs.getString("descrizione"));
                } else {
                    e.setDescrizione("");
                }

                e.setIdTipo(rs.getInt("idTipo"));
                e.setIdLuogo(rs.getString("idLuogo"));
                e.setIdEnte(rs.getInt("idEnte"));
                // Inserisco l'evento nell'arraylist da stampare
                eventi.add(e);
            }

        } catch (Exception e) {
        }
        return eventi;
    }

    private boolean ifStringIsValid(String f) {
        return (f != null && !f.equals(""));
    }

    private String controlloTipoLuogo(String idLuogo) {
        if (idLuogo.length() == 3) {
            return "LEFT JOIN regioni r ON e.idLuogo=r.idRegione "
                    + "LEFT JOIN province p ON e.idLuogo=p.idProvincia "
                    + "LEFT JOIN comuni c ON e.idLuogo=c.idComune "
                    + "WHERE "
                    + "(r.idRegione= '" + idLuogo + "' OR "
                    + "p.idRegione= '" + idLuogo + "' OR "
                    + "c.idProvincia IN (SELECT p.idProvincia FROM province p "
                    + "WHERE  p.idRegione= '" + idLuogo + "' GROUP BY p.idProvincia)) ";
        } else if (idLuogo.length() == 2) {
            return "LEFT JOIN province p ON e.idLuogo=p.idProvincia "
                    + "LEFT JOIN comuni c ON e.idLuogo=c.idComune "
                    + "WHERE "
                    + "(p.idProvincia= '" + idLuogo + "' OR "
                    + "c.idProvincia IN (SELECT p.idProvincia FROM province p "
                    + "WHERE  p.idProvincia= '" + idLuogo + "' GROUP BY p.idProvincia)) ";
        }
        return "LEFT JOIN comuni c ON e.idLuogo=c.idComune "
                + "WHERE c.idComune= '" + idLuogo;
    }

    private String controlloTipoLuogoByDate(String idLuogo, int idTipoEvento, String data) {
        if (idLuogo.length() == 3) {
            return "SELECT * FROM evento e LEFT JOIN regioni r ON e.idLuogo=r.idRegione "
                    + "LEFT JOIN province p ON e.idLuogo=p.idProvincia "
                    + "LEFT JOIN comuni c ON e.idLuogo=c.idComune "
                    + "WHERE "
                    + "(r.idRegione= '" + idLuogo + "' OR "
                    + "p.idRegione= '" + idLuogo + "' OR "
                    + "c.idProvincia IN (SELECT p.idProvincia FROM province p "
                    + "WHERE  p.idRegione= '" + idLuogo + "' GROUP BY p.idProvincia)) "
                    + "AND e.timeStart= '"
                    + data + "' AND e.idTipo= " + idTipoEvento;
        } else if (idLuogo.length() == 2) {
            return "SELECT * FROM evento e "
                    + "LEFT JOIN province p ON e.idLuogo=p.idProvincia "
                    + "LEFT JOIN comuni c ON e.idLuogo=c.idComune "
                    + "WHERE "
                    + "(p.idProvincia= '" + idLuogo + "' OR "
                    + "c.idProvincia IN (SELECT p.idProvincia FROM province p "
                    + "WHERE  p.idProvincia= '" + idLuogo + "' GROUP BY p.idProvincia)) "
                    + "AND e.timeStart= '"
                    + data + "' AND e.idTipo= " + idTipoEvento;
        }
        return "SELECT * FROM evento e LEFT JOIN comuni c ON e.idLuogo=c.idComune "
                + "WHERE c.idComune= '" + idLuogo + "' AND e.timeStart= '"
                + data + "' AND e.idTipo= " + idTipoEvento;
    }

    private String controlloTipoLuogoBetweenDate(String idLuogo, int idTipoEvento, String dataInizio, String dataFine) {
        if (idLuogo.length() == 3) {
            return "SELECT * FROM evento e LEFT JOIN regioni r ON e.idLuogo=r.idRegione "
                    + "LEFT JOIN province p ON e.idLuogo=p.idProvincia "
                    + "LEFT JOIN comuni c ON e.idLuogo=c.idComune "
                    + "WHERE "
                    + "(r.idRegione= '" + idLuogo + "' OR "
                    + "p.idRegione= '" + idLuogo + "' OR "
                    + "c.idProvincia IN (SELECT p.idProvincia FROM province p "
                    + "WHERE  p.idRegione= '" + idLuogo + "' GROUP BY p.idProvincia)) "
                    + "AND e.timeStart>= '"
                    + dataInizio + "' AND e.timeStart<= '"
                    + dataFine + "' AND e.idTipo= " + idTipoEvento;
        } else if (idLuogo.length() == 2) {
            return "SELECT * FROM evento e "
                    + "LEFT JOIN province p ON e.idLuogo=p.idProvincia "
                    + "LEFT JOIN comuni c ON e.idLuogo=c.idComune "
                    + "WHERE "
                    + "(p.idProvincia= '" + idLuogo + "' OR "
                    + "c.idProvincia IN (SELECT p.idProvincia FROM province p "
                    + "WHERE  p.idProvincia= '" + idLuogo + "' GROUP BY p.idProvincia)) "
                    + "AND e.timeStart>= '"
                    + dataInizio + "' AND e.timeStart<= '"
                    + dataFine + "' AND e.idTipo= " + idTipoEvento;
        }
        return "SELECT * FROM evento e LEFT JOIN comuni c ON e.idLuogo=c.idComune "
                + "WHERE c.idComune= '" + idLuogo + "' AND e.timeStart>= '"
                + dataInizio + "' AND e.timeStart<= '"
                + dataFine + "' AND e.idTipo= " + idTipoEvento;
    }

    public void inserisciEvento(String nome, String timeStart, String timeEnd, String descrizione, String idLuogo, Integer idTipo, Integer idEnte) {

        String query = "INSERT INTO evento (nome,timeStart,timeEnd,descrizione,idLuogo,idTipo,idEnte) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = dao.getConnection().prepareStatement(query);
            stmt.setString(1, nome);
            stmt.setString(2, timeStart);
            stmt.setString(3, timeEnd);
            stmt.setString(4, descrizione);
            stmt.setString(5, idLuogo);
            stmt.setInt(6, idTipo);
            stmt.setInt(7, idEnte);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminaEvento(int idEvento) {
        try {
            
            stmt = dao.getConnection().createStatement();
            String query = "DELETE FROM evento WHERE idEvento= " + idEvento;
            stmt.executeUpdate(query);
            
        } catch (Exception e) {
        }

    }
}
