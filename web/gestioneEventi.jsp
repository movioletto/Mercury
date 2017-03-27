<%-- 
    Document   : dashboardAdmin
    Created on : 24-ott-2016, 14.13.29
    Author     : Giuseppe
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.mercury.model.Ente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="com.mercury.model.EnteDAO" id="dash" scope="session"></jsp:useBean>

<!DOCTYPE html>
<html>
    
    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <head>
        <script src="https://use.fontawesome.com/5fe36adac7.js"></script>
    <br><br><br>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestione</title>
        <style>
            
            h2 > a:hover {text-decoration: none}
            
            td{
            padding:7px;    
                
            }
            
        </style>
    </head>
    <body>
        

<div class="col-lg-6 col-lg-offset-3">
    <div class="panel panel-primary">
        <div class="panel-heading" style="text-align:center"><b>Gestione


</b></div>
  <div class="panel-body">
      <center>
      
        
          
          <h2><a style="float: left;" class="fa fa-chevron-left" aria-hidden="true" href="./dashboardAdmin.jsp"></a>Gestione Eventi</h2>
        
        <table cellpadding="10px">
            <ul class="list-group">
                
            <% List<Ente> ente = dash.getEnti(); %>
            <% for (int i = 0; i < ente.size(); i++ ) { %><li class="list-group-item"> <%= ente.get(i).getUser()%></li><% } %>
               
            </ul>
    
        </center>
<br><br><br><br>
<center> <img class="img-responsive" src="images/LogoMercury2.png" width="40%" alt=""><br>
    <br>
</center>
  </div>
    </div>
    </div>
        
    </body>
</html>
