<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>
            .thumbnail{
                height:450px;
            }
            .btn-success{
                position:absolute;
            }
            .container .content{
                 margin-top: 0px;
            }
        </style>
    </head>
    <body>

        <br><br><br><br>
    <div class="container" style="margin-top: 5px;">
        <div class="row">
            <% 
                //EventoDao eventi;
                //List<Evento> listEventi = eventi.getEventi();<c:forEach var="row" items="${rs.rows}">   
                %>
                

               
            <div class="col-sm-3 col-md-3" style="padding: 10px; margin-top: -15px;">
                <div class="thumbnail" style="width: 100%">
                <div class="post" style="height:100%">


                    <table style="height:100%; width:100%">
                        <tr>
                            <td style="vertical-align:top">
                                <div class="post-img-content">
                                    <%
                String val = "0";
                try {
                    val = request.getParameter("tipoEvento");
                    if (val == null) { %>
                                    <img src="img/eventiCulturali.jpg" class="img-responsive" />
                    <%} else if (val.equals("1")) { %>
                                    <img src="img/cinemaMercury.jpg" class="img-responsive" />
                    <%} else if (val.equals("2")) { %>
                                    <img src="img/teatroMercury.jpg" class="img-responsive" />
                    <%} else if (val.equals("3")) { %>
                                    <img src="img/eventiCulturali.jpg" class="img-responsive" />
                    <%} else if (val.equals("4")) { %>
                                    <img src="img/concertiMercury.jpg" class="img-responsive" />
                    <%} else if (val.equals("5")) { %>
                                    <img src="img/eventiSportivi.jpg" class="img-responsive" />
                    <%} else if (val.equals("6")) { %>
                                    <img src="img/fiereMercury.jpg" class="img-responsive" />                                    
            <% } else { %>
                                    <img src="img/eventiCulturali.jpg" class="img-responsive" />
            <%}
                } catch (Exception e) {
                    if (val == null) {
                            val = "1";
                        }
                    }%>
                                    <h4><span class="post-title"><b>
                                    <!-- TITOLO-->
                                    ${row.nome}
                                    </b></span></h4><br>
                                    <b>Luogo:</b> ${row.luogo}
                                    <!-- LUOGO -->
                                        <br>                                    
                                </div>
                                <div class="content">
                                    <div class="author">
                                        <b>Data inizio:</b> ${row.timeStart}
                                    <!-- DATA INIZIO -->                                    
                                        <br>
                                        <b>Data Fine:</b> ${row.timeEnd}
                                    <!-- DATA FINE-->                                        
                                    </div> <br>  
                                    <p>
                                    ${row.descrizione}                                           
                                    </p>
                                </div></td>
                        </tr>
                        <tr>
                            <td style="height:30px">
                                <div>
                                    <a href="?pag=4&id=" class="btn btn-primary btn-sm">Read more</a>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
                </div>
            </div>
            <!--<div class="col-sm-3 col-md-3" style="padding: 10px;">
                <div class="thumbnail" style="width: 100%">
                <div class="post" style="height:100%">
                    <table style="height:100%; width:100%">
                        <tr>
                            <td style="vertical-align:top">
                                <div class="post-img-content">
                                    <img src="img/fiereMercury.jpg" class="img-responsive" />
                                    <span class="post-title"><b><h4>Titolo Evento</h4></b><br />
                                        <b>Ente Organizzatore :</b><br></span>
                                </div>
                                <div class="content">
                                    <div class="author">
                                        <b>Data inizio :</b><br>
                                        <b>Data Fine :</b>
                                        <time datetime="2014-01-20">January 20th, 2014</time>
                                    </div><br> 
                                    <p>
                                        Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem

                                    </p>
                                </div></td>
                        </tr>
                        <tr>
                            <td style="height:30px">
                                <div>
                                    <a href="#" class="btn btn-primary btn-sm">Read more</a>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
                </div>
            </div>
            <div class="col-sm-3 col-md-3" style="padding: 10px;">
                <div class="thumbnail" style="width: 100%">
                <div class="post" style="height:100%">
                    <table style="height:100%; width:100%">
                        <tr>
                            <td style="vertical-align:top">
                                <div class="post-img-content">
                                    <img src="img/cinemaMercury.jpg" class="img-responsive" />
                                    <span class="post-title"><b><h4>Titolo Evento</h4></b><br />
                                        <b>Ente organizzatore :</b><br></span>
                                </div>
                                <div class="content">
                                    <div class="author">
                                        <b>Data inizio :</b><br>
                                        <b>Data Fine :</b>
                                        <time datetime="2014-01-20">January 20th, 2014</time>
                                    </div><br> 
                                    <p>
                                        Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem

                                    </p>
                                </div></td>
                        </tr>
                        <tr>
                            <td style="height:30px">
                                <div>
                                    <a href="#" class="btn btn-primary btn-sm">Read more</a>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
                </div>
            </div>
            <div class="col-sm-3 col-md-3" style="padding: 10px;">
                <div class="thumbnail" style="width: 100%">
                <div class="post" style="height:100%">
                    <table style="height:100%; width:100%">
                        <tr>
                            <td style="vertical-align:top">
                                <div class="post-img-content">
                                    <img src="img/concertiMercury.jpg" class="img-responsive" />
                                    <span class="post-title"><b><h4>Titolo Evento</h4></b><br />
                                        <b>Ente Organizzatore :</b><br></span>
                                </div>
                                <div class="content">
                                    <div class="author">
                                        <b>Data inizio :</b><br>
                                        <b>Data Fine :</b>
                                        <time datetime="2014-01-20">January 20th, 2014</time>
                                    </div><br> 
                                    <p>
                                        Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem

                                    </p>
                                </div></td>
                        </tr>
                        <tr>
                            <td style="height:30px">
                                <div>
                                    <a href="#" class="btn btn-primary btn-sm">Read more</a>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
                </div>
            </div>-->
        </div>
    </div>
        
        <br><br><center>
<button onclick="goBack()">Go Back</button>

<script>
function goBack() {
    window.history.back();
}
</script>
        </center>
</body>
</html>
