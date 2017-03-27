<%@page import="java.sql.ResultSet"%>
<jsp:useBean class="com.mercury.model.LuogoDAO" id="jspProvider2" scope="session"></jsp:useBean>


<% ResultSet regioniRS2 = jspProvider2.getRegioni("Nome", "ASC"); 
%>
<!-- Form di ricerca avanzata, integrato in menu.jsp tramite @include-->
<div id="search" class="bg bg col-md-5">
    <a href="#"><i class="fa fa-search" aria-hidden="true"></i> 

        Ricerca Avanzata 
        <i class="fa fa-angle-down" aria-hidden="true"></i></a>
    <div class="col-md-12" style="text-align: left; padding-top: 30px;">

        <form class="formSearch" style="font-size: 12px" action="Controller">
            <div class='col-md-3 filtri'>
                <h5>Categoria:</h5>
                <input type="radio" value="1" name="tipoEvento" checked> Cinema <br>
                <input type="radio" value="2" name="tipoEvento"> Teatro <br>
                <input type="radio" value="4" name="tipoEvento"> Concerti <br>
                <input type="radio" value="5" name="tipoEvento"> Sportivi <br>
                <input type="radio" value="3" name="tipoEvento"> Fiere <br>
                <input type="radio" value="6" name="tipoEvento"> Culturali
            </div>
            <div class='col-md-4 filtri'>
                <h5>Data Inizio:</h5>
                <input type="text" id="dataInizio" name="dataInizio"><br>
                <h5 style="margin-top: 14px;">Data Fine:</h5>
                <input type="text" id="dataFine" name="dataFine"><br><br>
                <input type="checkbox" id="delGiorno" name="delGiorno" value="1" style="margin-top: 9px"> Solo del Giorno
            </div>
            <div class='col-md-5 filtroLuoghi'>
                <h5>Regione:</h5>                
                
            <select name="regione2" id="regione2" style="margin-top: 10px;">
                <option>Scegli la Regione</option>
                <% while(regioniRS2.next()) { 
                String regVal2 = regioniRS2.getString("idRegione");%>
                <option value="<%=regVal2%>">
                        <%=regioniRS2.getString("nome")%>
            </option>
       
            <%} %>
            </select>
                <h5>Provincia:</h5>                                
                <select name="provincia2" id="provincia2" >
                   <option> Scegli la Provincia</option>
                </select>
                <h5>Comune:</h5>                               
                <select name="comune2" id="comune2">                   
                    <option> Scegli il Comune </option>
                </select>
            </div>
            <div style="text-align: right; padding: 200px 15px 0px 0px">
                            <hr style="border-top-color: gray;">
                <input type="submit" value="Avvia Ricerca" style="padding: 5px 10px; font-size: 12px; font-weight: bold">
            </div>
        </form>
        
    </div>
</div>
            
   