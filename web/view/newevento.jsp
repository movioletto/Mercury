<%-- 
    Document   : newevento
    Created on : 24-ott-2016, 10.23.49
    Author     : Alessandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<jsp:useBean class="com.mercury.model.LuogoDAO" id="jspProvider3" scope="session"></jsp:useBean>

       

<% ResultSet regioniRS3 = jspProvider3.getRegioni("Nome", "ASC"); 
%>
<!DOCTYPE html>
<html>
    
 <!-- Bootstrap: Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Bootstrap: Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <!-- Bootstrap: Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>        
        <!-- Aggiungo JQuery -->
        
        
    <script src="js/jquery-3.1.1.min.js"></script>
        
             
        <!-- Script di JQuery UI per usare un calendario negli input delle date -->
        <script src="js/calendario.js"></script>
        
              
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserisci l'Evento</title>
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet"> 
        
        
    
     <style>
            
            td{
            padding:7px;    
                
            }
            
        </style>
        
          

    <body>
        <br><br>
<div class="col-lg-6 col-lg-offset-3">
    <div class="panel panel-primary">
        <div class="panel-heading" style="text-align:center"><b>Accedi


</b></div>
  <div class="panel-body">
      <center>
      
        
          
          <h3>Inserisci evento</h3>
        
        <form action="#" name="form" metod="post" onsubmit="return Controlla(this)">
            <table>
                <tr>
                    <td>Nome Evento :</td>
                    <td><input type="text" name="nomeEvento" placeholder=" Nome Evento.." required="true"></td>
                    
                </tr>
                <tr>
                    <td>Data Inizio Evento :</td>
                    <td><input type="date" name="dataInizio" placeholder=" Data Inizio Evento.." required="true" style="width:175px;"></td>
                    
                </tr>
                <tr>
                    <td>Data Fine Evento :</td>
                    <td><input type="date" name="dataFine" placeholder=" Data Fine Evento.." required="true" style="width:175px;"></td>
                    
                </tr>
                <tr>
                    <td>Tipologia Evento :</td>
                <tr><td><input type="radio" name="tipoEvento"  required="true" value="1" checked> Cinema</td>
                <td><input type="radio" name="tipoEvento"  required="true" value="2" > Teatro</td></tr>
                <tr><td><input type="radio" name="tipoEvento"  required="true" value="3" > Concerti</td>
                <td><input type="radio" name="tipoEvento"  required="true" value="4" > Fiere</td></tr>
                <tr><td><input type="radio" name="tipoEvento"  required="true" value="5" > Eventi Culturali</td>
                <td><input type="radio" name="tipoEvento"  required="true" value="6" > Eventi Sportivi</td></tr>
                </tr>
            </table>
            
            <div class="panel">
            <h4 style="margin-top: 20px;">Per quale zona?</h4>
            
            
            <select name="regione3" id="regione3" style="margin-top: 10px;">
                <option>Scegli la Regione</option>
                <% while(regioniRS3.next()) { 
                String regVal3 = regioniRS3.getString("idRegione");%>
                <option value="<%=regVal3%>">
                        <%=regioniRS3.getString("nome")%>
            </option>
       
            <%} %>
            </select><br>
            
            
            
            <select name="provincia3" id="provincia3" style="margin-top: 20px;">
                
                <option> Scegli la Provincia</option>
            </select><br>
            
            
            <select name="comune3" id="comune3" style="margin-top: 20px;">                   
                <option> Scegli il Comune </option>
            </select>
            </div><br>
            
            <br>
            Descrizione : <br>
            (Max 240 Caratteri)<br>
            <br><textarea type="text" name="descrizione" maxlength="240" autocomplate="on" required="true" style="height:150px; width:300px;"></textarea>
                    
                    <br><br>
                   
                        <br> <button class="btn-primary" type="submit">Inserisci</button>
                
                
        </form>
        </center>
<br>
<center> <img class="img-responsive" src="../img/LogoMercury2.png" width="40%" alt=""><br>
    
<button class="btn-primary" onclick="goBack()">Go Back</button>

<script>
function goBack() {
    window.history.back();
}
</script>
</center>
  </div>
    </div>
    </div>
        
    </body>
</html>

<script src="js/porco.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>  
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>


