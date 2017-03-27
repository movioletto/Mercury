<%-- 
    Document   : header
    Created on : 21-ott-2016, 10.54.02
    Author     : domenico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
        <!-- Questo è un codice per l'utilizzo veloce di icone. Dettagli sul sito Font Awesome -->
        <script src="https://use.fontawesome.com/5fe36adac7.js"></script>  
        <style>
            #center {text-align: center; padding-top: 5px;}
            #header .bg {background-color: #333; color: white;}
            #headercontent div {height: 80px;}
            #imgLogo {height: 140px;}
            #imgLogo2 {height: 50px; margin-top: -3px; margin-bottom: -12px; margin-left: -3px;}
            #hiddenItem {width: 1px; overflow: hidden; display: inline-block;}
            #divLogo {
                padding: 5px;        
                width: 140px;
                height: 145px;                      
                position: absolute;
                top: 10px;
                margin-right: auto;
                margin-left: auto;
                left: 0px;
                right: 0px;
                text-align: center;
                overflow: hidden;
            }
            #left{
                padding: 30px;
            }
            #left div a {
                color: white;
            }         
            #search a {
                color: white;
                text-decoration: none;
            }   
            #right {
                padding: 30px;
                text-align: right;
            }
            #ricAvanzata{display: inline;
            }

            #search{                 
                position: absolute;
                top: 0px;
                right: 20px;
                padding: 30px;
                padding-right: 10px;
                text-align: right;
                height: 50px;            
                width: 152px;
                padding-left: 0px;
                padding-bottom: 0px;
                border-radius: 0px 0px 10px 10px;
                overflow: hidden;
                transition: height 0.2s, width 0s, padding-left 0s;
                transition-delay: 0s, 0.2s, 0.2s;
                z-index: 9999;
            }           
            #search:hover{
                transition: height 0.2s, width 0s;
                height: 385px;
            }
            input, select{color: black;}
            #search input[type=text]{width: 100%;}
            .filtri {padding: 0px;}
            .filtroLuoghi {padding-left: 30px;}
            .filtroLuoghi select{width: 100%;}
            #search input[type=submit]{
                background-image: linear-gradient(to bottom,#5674b9 0,#4463a9 100%);
                border: 1px solid #4463a9;
                border-radius: 5px;
                color: white;
            }
            #search input[type=submit]:hover{
                background-image: linear-gradient(to bottom,#4463a9 0,#314e90 100%);
                border: 1px solid #314e90;
                border-radius: 5px;
                color: white;
            }            
        </style>
        <!-- Script del menù a scomparsa per la ricerca avanzata -->
        <script>
            $(document).ready(function () {
                $("div#ui-datepicker-div").mouseover(function () {
                    $("div#search").css("height", "385px");
                    $("div#search").css("padding-left", "30px");
                    $("div#search").css("width", "500px");
                });
                $("div#search").mouseover(function () {
                    $("div#search").css("height", "385px");
                    $("div#search").css("padding-left", "30px");
                    $("div#search").css("width", "500px");
                });
                $("div#search").mouseout(function () {
                    $("div#search").css("height", "50px");
                    $("div#search").css("padding-left", "0px");
                    $("div#search").css("width", "152px");
                });
            });
        </script>
    </head>
    <body id="header" style="background-color: lightgray;">
        <div id="headercontent">
            <div id="left" class="bg col-md-5">

                <% if (session.getAttribute("mail") != null){
                    
                    if (session.getAttribute("mail").equals("admin")) {%><div>
                    <i class="fa fa-home" aria-hidden="true"></i> <a href="index.jsp">Home</a> 
                    &nbsp;&#8226;&nbsp; 
                    <i class="fa fa-envelope" aria-hidden="true"></i> <a href="#newsletter">Newsletter</a>
                    &nbsp;&#8226;&nbsp;       
                    <a href="dashboardAdmin.jsp"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Dashboard</a> 
                    &nbsp;&#8226;&nbsp;                    
                    <a href="Controller?codice=19"><i class="fa fa-sign-out" aria-hidden="true"></i> Disconnetti</a>
                </div><% } else { %>
                <div>
                    <i class="fa fa-home" aria-hidden="true"></i> <a href="index.jsp">Home</a> 
                    &nbsp;&#8226;&nbsp; 
                    <i class="fa fa-envelope" aria-hidden="true"></i> <a href="#newsletter">Newsletter</a>
                    &nbsp;&#8226;&nbsp;       
                    <a href="dashboardEnte.jsp"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Dashboard</a> 
                    &nbsp;&#8226;&nbsp;                    
                    <a href="Controller?codice=19"><i class="fa fa-sign-out" aria-hidden="true"></i> Disconnetti</a>
                </div>                 
                <% }} else {%><div>
                    <i class="fa fa-home" aria-hidden="true"></i> <a href="index.jsp">Home</a> 
                    &nbsp;&#8226;&nbsp; 
                    <i class="fa fa-user" aria-hidden="true"></i> <a href="accedi">Accedi</a> 
                    &nbsp;&#8226;&nbsp; 
                    <i class="fa fa-user-plus" aria-hidden="true"></i> <a href="registrazione">Registrati</a>
                    &nbsp;&#8226;&nbsp; 
                    <i class="fa fa-envelope" aria-hidden="true"></i> <a href="#newsletter">Newsletter</a>
                </div> 

                <%}  %>

            </div>
            <div id="center" class="bg col-md-2"></div>      
            <div id="right" class="bg col-md-5">                      
            </div>            
            <!-- Ricerca avanzata (ricerca per filtri) -->    
            <%@include file="filtro.jsp" %>
            <!-- Codice del Logo -->    
        </div>
        <a href="./index.jsp" title="Vai all'Home Page"><div id="divLogo">
                <img src="img/LogoMercury.png" id="imgLogo"><div id="hiddenItem"><img src="img/LogoMercuryTesto.png" id="imgLogo2"></div>
            </div></a>
    </body>
</html>
