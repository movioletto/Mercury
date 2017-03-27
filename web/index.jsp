<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Bootstrap: Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Bootstrap: Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <!-- Bootstrap: Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>        
        <!-- Aggiungo JQuery -->
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>  
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <!-- Aggiungo lo script JQuery UI e il css di JQuery UI-->
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <!-- Ajax -->
        <script src="js/ajaxNewsletter.js"></script>
        <script src="js/ajaxFiltro.js"></script>       
        <!-- Script di JQuery UI per usare un calendario negli input delle date -->
        <script src="js/calendario.js"></script>
        <!-- Codice per cambiare css al logo a seconda dello scroll (animazione del logo) -->
        <script src="js/logo.js"></script>
        <!-- Script per disattivare la scelta data nella ricerca se "solo del giorno" è checkato -->
        <script src="js/eventoDelGiorno.js"></script>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mercury - Scopri gli eventi intorno a te!</title>
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <style>
            /* CSS */
            .errorAlert{background:blue;color:#fff;padding:10px 20px;margin-bottom:20px}

        </style>
        <style type="text/css">
            .header {
                padding: 0px;
                position: fixed;
                top: 0px;
                background-color:#fff;
                z-index: 9999;
            }           
            .body {
                padding: 0px;
                margin: 0px;
            }
            .contentenuto {
                margin-top: 85px;                     
            }
            .footer{
                height: 305px;
                background-color: #333;
                margin-top: 20px;
                box-shadow: inset 0px 2px 5px #161616;
                color: white;
            }             
            .panel-body td{
                padding:7px;               
            }
            .panel-primary{
                border-color: #5674b9;
            }
            .panel-primary > .panel-heading {
                background-image: linear-gradient(to bottom,#5674b9 0,#4463a9 100%);
            }
            .newsletter input[type=submit]{
                background-image: linear-gradient(to bottom,#5674b9 0,#4463a9 100%);
                border: 1px solid #4463a9;
                border-radius: 5px;
                color: white;
                padding: 10px 25px;
                font-size: 16px;
                font-weight: bold;
            }
            .newsletter input[type=submit]:hover{
                background-image: linear-gradient(to bottom,#4463a9 0,#314e90 100%);
                border: 1px solid #314e90;
                border-radius: 5px;
                color: white;
            }   
            
            .alert-info{
                margin-bottom:-35px;
            }
            
            .alert-success{
                margin-bottom:-35px;
            }
           
        </style>
    </head>


    <body>
        <br><br><br><br>
        <%
            if (request.getParameter("error") != null) {
                if (request.getParameter("error").equals("3")) {%>
                
                <div class="alert alert-info">
            <a href="index.jsp" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <strong>Attenzione!</strong><br> Non hai i permessi necessari
        </div><%}
            }
        %>
          <%
            if (request.getParameter("signin") != null) {
                if (request.getParameter("signin").equals("1")) {%>
                
                <div class="alert alert-success">
            <a href="index.jsp" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <strong>Benvenuto in Mercury</strong> <br>Registrazione effettuata con successo ! <br>
        </div><%}
            }
        %>
         <%
            if (request.getParameter("signin") != null) {
                if (request.getParameter("signin").equals("2")) {%>
                
                <div class="alert alert-success">
            <a href="index.jsp" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <strong>Arrivederci</strong> <br>Log-out effettuato con successo ! <br>
        </div><%}
            }
        %>
        <div class="contenuto">

            <%
                // indirizzo i link alle varie pagine a seconda del parametro "page" che gli arriva.
                // non ho usato lo Switch perché in java 6 non accetta stringe.
                String pag = "0";
                try {
              
                    if(config.getInitParameter("pag")==null)
                        pag = request.getParameter("pag");
                    else
                        pag = config.getInitParameter("pag");
                    if (pag == null) {
            %>
            <%@include file="view/home.jsp" %>
            <%} else if (pag.equals("0")) {
            %>
            <%@include file="view/home.jsp" %>                    
            <%} else if (pag.equals("1")) {%>
            <%@include file="view/accesso.jsp" %>
            <%} else if (pag.equals("2")) { %>
            <%@include file="view/registrazione.jsp" %>            
            <%} else if (pag.equals("3")) {%>
            <%@include file="view/content.jsp" %>
            <%} else if (pag.equals("4")) { %>
            <%@include file="view/evento.jsp" %>
            <% } else {
            %>
            <%@include file="view/home.jsp" %>
            <%}
                } catch (Exception e) {
                    if (pag == null) {
                        pag = "0";
                    }
                }%>
        </div>
        <!-- Div che include la newsletter (newsletter.jsp) -->
        <div class="col-md-12 footer">
            <%@include file="view/newsletter.jsp" %>
        </div>
        <!-- Div che include l'header (menu.jsp) -->
        <div class="col-md-12 header">
            <%@include file="view/menu.jsp" %>
        </div>
    </body>
</html>
