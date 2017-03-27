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
<jsp:useBean class="com.mercury.dao.LoginDAO" id="jb" scope="session"></jsp:useBean>
<% 
if (session.getAttribute("mail")==null){
    response.sendRedirect("./?pag=1&error=2");
} else if ((session.getAttribute("mail").equals("admin")))
    response.sendRedirect("./?pag=1&error=3");

%>
<!DOCTYPE html>
<html>
    
    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <head>
    <br><br><br>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard Ente</title>
        <style>
            
            td{
            padding:7px;    
                
            }
            
        </style>
    </head>
    <body>
        

<div class="col-lg-6 col-lg-offset-3">
    <div class="panel panel-primary">
        <div class="panel-heading" style="text-align:center"><b>Dashboard


</b></div>
  <div class="panel-body">
      <center>
      
        <% String username = (String)session.getAttribute("mail"); %>
          
          <h3>Ente Dashboard</h3><br><br>
          
          <h4>Benvenuto, <%out.println(username); %>!</h4>
        
        <table cellpadding="10px">
            <ul class="list-group">
                <li style="list-style-type: none;"><button type="button"><a href="./view/newevento.jsp">Inserisci Evento</a></button></li><br>
          
               
            </ul>
    
        </center>
<br><br><br><br>
<center> <img class="img-responsive" src="images/LogoMercury2.png" width="40%" alt=""><br>
    <br><br>
    
    <table>
        <tr><td><form action="Controller" method="post" >
        <input type="hidden" name="codice" value="19">
        <button class="btn btn-primary">Log Out</button></td>
        
    </form>
        <td><form action="index.jsp">
          <button class="btn btn-primary">Home</button>
        </form></tr></td>
    </table>
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
