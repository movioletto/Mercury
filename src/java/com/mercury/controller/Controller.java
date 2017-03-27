package com.mercury.controller;

import com.mercury.model.Ente;
import com.mercury.model.EnteDAO;
import com.mercury.dao.LoginDAO;
import com.mercury.model.LuogoDAO;
import com.mercury.model.Newsletter;
import com.mercury.model.NewsletterDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author emanuele
 */
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        PrintWriter out = response.getWriter();
        try {
            int codice = Integer.parseInt(request.getParameter("codice"));
            HttpSession session = request.getSession();
            switch (codice) {
                case 1: //registrazione
                    String mail = request.getParameter("nome");
                    String pass = request.getParameter("password");
                    int attivo = 0;
                    String nomeEnte = request.getParameter("nomeEnte");
                    String pIva = request.getParameter("pIva");
                    String nTelefono = request.getParameter("telefono");
                    String indirizzo = request.getParameter("indirizzo");
                    Ente e = new Ente(0, mail, pass, attivo, nomeEnte, pIva, nTelefono, indirizzo);
                    EnteDAO edao = new EnteDAO();
                    edao.inserisciEnte(e);
                    response.sendRedirect("./?pag=0&signin=1");
                    break;
                case 2: //login
                    String user = request.getParameter("mail");
                    String passL = request.getParameter("pass");
                    String adminUser = (String) this.getServletConfig().getInitParameter("username");
                    String adminPass = (String) this.getServletConfig().getInitParameter("password");
                    if (user.equals(adminUser) && passL.equals(adminPass)) {
                        session.setAttribute("mail", user);
                        session.setAttribute("pass", passL);
                        response.sendRedirect("dashboardAdmin.jsp");

                    } else {
                        LoginDAO lgd = new LoginDAO();
                        if (lgd.effettuaLogin(user, passL)) {
                            response.sendRedirect("dashboardEnte.jsp");
                            session.setAttribute("mail", user);
                            session.setAttribute("pass", passL);
                        } else {
                            response.sendRedirect("./?pag=1&error=1");
                        }
                    }
                    break;
                case 3: //iscrizione alla newsletter
                    String mailN = request.getParameter("mail");
                    int cadenza = Integer.parseInt(request.getParameter("cadenzaEvento"));
                    String idluogo = request.getParameter("");      //TODO
                    List<Integer> preferenze = new ArrayList<Integer>();

                    if (request.getParameter("tipoEvento1") != null) {
                        preferenze.add(Integer.parseInt(request.getParameter("tipoEvento1")));
                    }
                    if (request.getParameter("tipoEvento2") != null) {
                        preferenze.add(Integer.parseInt(request.getParameter("tipoEvento2")));
                    }
                    if (request.getParameter("tipoEvento3") != null) {
                        preferenze.add(Integer.parseInt(request.getParameter("tipoEvento3")));
                    }
                    if (request.getParameter("tipoEvento4") != null) {
                        preferenze.add(Integer.parseInt(request.getParameter("tipoEvento4")));
                    }
                    if (request.getParameter("tipoEvento5") != null) {
                        preferenze.add(Integer.parseInt(request.getParameter("tipoEvento5")));
                    }
                    if (request.getParameter("tipoEvento6") != null) {
                        preferenze.add(Integer.parseInt(request.getParameter("tipoEvento6")));
                    }

                    Newsletter news = new Newsletter(0, mailN, idluogo, cadenza, preferenze);
                    NewsletterDAO ndao = new NewsletterDAO();
                    ndao.inserisciNewsletter(news);
                    response.sendRedirect("index.jsp");
                    break;
//                case 4: 
//                    //inserimento evento
//                    String nomeA = request.getParameter("nomeEvento");
//                    int cadenza = Integer.parseInt(request.getParameter("cadenzaEvento"));
//                    String idluogo = request.getParameter("");      //TODO
//                    List<Integer> preferenze = new ArrayList<Integer>();
//
//                    if (request.getParameter("tipoEvento1") != null) {
//                        preferenze.add(Integer.parseInt(request.getParameter("tipoEvento1")));
//                    }
//                    if (request.getParameter("tipoEvento2") != null) {
//                        preferenze.add(Integer.parseInt(request.getParameter("tipoEvento2")));
//                    }
//                    if (request.getParameter("tipoEvento3") != null) {
//                        preferenze.add(Integer.parseInt(request.getParameter("tipoEvento3")));
//                    }
//                    if (request.getParameter("tipoEvento4") != null) {
//                        preferenze.add(Integer.parseInt(request.getParameter("tipoEvento4")));
//                    }
//                    if (request.getParameter("tipoEvento5") != null) {
//                        preferenze.add(Integer.parseInt(request.getParameter("tipoEvento5")));
//                    }
//                    if (request.getParameter("tipoEvento6") != null) {
//                        preferenze.add(Integer.parseInt(request.getParameter("tipoEvento6")));
//                    }
//
//                    Newsletter news = new Newsletter(0, mailN, idluogo, cadenza, preferenze);
//                    NewsletterDAO ndao = new NewsletterDAO();
//                    ndao.inserisciNewsletter(news);
//                    response.sendRedirect("index.jsp");
//                    break;
                case 19://logout
                    session.invalidate();
                    response.sendRedirect("./?pag=0&signin=2");
                    break;
                case 69:
                    String id = request.getParameter("id");
                    EnteDAO entedao = new EnteDAO();
                    //entedao.eliminaEnte(Integer.parseInt(id));
                    response.sendRedirect("index.jsp");
                case 101: //chiamata ajax
                    LuogoDAO dao = new LuogoDAO();
                    ArrayList<String> listaProvince2 = new ArrayList<String>();
                    ArrayList<String> listaProvinceID2 = new ArrayList<String>();
                    // listaProvince2 = (ArrayList<String>) dao.getProvince(request.getParameter("regione"));
                    listaProvince2 = (ArrayList<String>) dao.getProvince(request.getParameter("idregione"));
                    listaProvinceID2 = (ArrayList<String>) dao.getIDProvince(request.getParameter("idregione"));

                    String output = "<option>" + "Scegli la provincia</option><br>";

                    for (int i = 0; i < listaProvince2.size(); i++) {
                        output += "<option value=\"" + listaProvinceID2.get(i) + "\">" + listaProvince2.get(i) + "</option>";
                    }
                    try {
                        out.println(output);
                    } catch (Exception e2) {
                    }

                    break;

                case 102:
                    LuogoDAO dao2 = new LuogoDAO();
                    ArrayList<String> listaComuni2 = new ArrayList<String>();

                    listaComuni2 = (ArrayList<String>) dao2.getComuni(request.getParameter("idprovincia"));

                    String output2 = "<option>" + "Scegli il "
                            + "Comune" + "</option><br>";

                    for (int i = 0; i < listaComuni2.size(); i++) {
                        output2 += "<option>" + listaComuni2.get(i) + "</option>";
                    }
                    try {
                        out.println(output2);
                    } catch (Exception e3) {
                    }

                    break;
                case 999:
                    //codice di ciò che vi serve
                    break;
                default:
                    //state usando un codice ancora non definito
                    break;
            }
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
