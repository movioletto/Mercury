<%@page import="java.sql.ResultSet"%>
<jsp:useBean class="com.mercury.model.LuogoDAO" id="jspProvider" scope="session"></jsp:useBean>


<% ResultSet regioniRS = jspProvider.getRegioni("Nome", "ASC"); 
%>

<div class="col-md-10 newsletter">
    <h3 style="margin-top: 25px;">Iscriviti alla Newsletter</h3>
    <form action="Controller">
        <div class="col-md-3" style="padding: 0px; margin-right: -10px;">
            <h4 style="margin-top: 20px;">Inserisci la tua e-mail</h4>
            <input type="text" name="mail" placeholder="E-mail"><br>
            <h4 style="margin-top: 20px;">Quando vuoi riceverla?</h4>
            <input type="radio" value="0" name="cadenzaEvento"> Ogni Giorno<br>
            <input type="radio" value="1" name="cadenzaEvento" checked> Ogni Settimana<br>
            <input type="radio" value="2" name="cadenzaEvento"> Ogni Mese<br>
        </div>
        <div class="col-md-3" style="padding: 0px; margin-right: -60px;">
            <h4 style="margin-top: 20px;">Cosa ti interessa?</h4>
            <input type="checkbox" value="1" name="tipoEvento1"> Cinema <br>
            <input type="checkbox" value="2" name="tipoEvento2"> Teatro <br>
            <input type="checkbox" value="4" name="tipoEvento3"> Concerti <br>
            <input type="checkbox" value="5" name="tipoEvento4"> Sportivi <br>
            <input type="checkbox" value="3" name="tipoEvento5"> Fiere <br>
            <input type="checkbox" value="6" name="tipoEvento6"> Culturali
        </div>
        <div class="col-md-3" style="padding: 0px; margin-right: -65px;">
            <h4 style="margin-top: 20px;">Per quale zona?</h4>
            
            
            <select name="regione" id="regione" style="margin-top: 10px;">
                <option>Scegli la Regione</option>
                <% while(regioniRS.next()) { 
                String regVal = regioniRS.getString("idRegione");%>
                <option value="<%=regVal%>">
                        <%=regioniRS.getString("nome")%>
            </option>
       
            <%} %>
            </select><br>
            
            
            
            <select name="provincia" id="provincia" style="margin-top: 20px;">
                
                <option> Scegli la Provincia</option>
            </select><br>
            
            
            <select name="comune" id="comune" style="margin-top: 20px;">                   
                <option> Scegli il Comune </option>
            </select>
        </div>
       <a name="newsletter"> <div class="col-md-3" style="padding: 165px 0px 0px 0px;">
            <input type="submit" value="Registrati">
        </div>        
        <!-- input nascosto-->
        <input type="hidden" value="3">

    </form>
</div>
</a> 
   