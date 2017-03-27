<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>
            div.carousel-caption {
                height: 0px;
                ovewflow: hidden;
                background-color: rgba(86, 116, 185, 0.8);
                right: 20px;
                left: 20px;
                bottom: 25px;
                padding: 0px;
                transition: height 0.2s;
                z-index: 1;
            }
            div.carousel-caption h2 {
                font-size: 0px;
                padding: 0px;
                margin: 0px
            }  
            div.carousel-caption h2 p {
                font-size: 0px;
            }
            .thumbnail:hover div.carousel-caption {
                height: 88.9%;
                ovewflow: hidden;
                padding: 38px;
            }
            .thumbnail:hover div.carousel-caption h2 {
                font-size: 30px;
                padding: inherit;
                margin: inherit;
                transition: font-size 0.1s;
                transition-delay: 0.1s;
            }            
            .thumbnail:hover div.carousel-caption h2 p {
                font-size: 15px;
                transition: font-size 0.1s;
                transition-delay: 0.1s;
            }
            body, html {
                background-color: transparent;
            }
        </style>
    </head>
    <body>

    <div>
        <br><br><br><br>
        <!-- Riquadri con le tipologie di eventi. Per il momento statico.-->
        <% String intest = "<p>Guarda gli eventi</p>";%>
        <div class="col-lg-10 col-lg-offset-1">
            <div class="col-md-4">
                <a class="thumbnail" href="?pag=3&tipoEvento=1">
                    <img class="img-responsive" src="img/cinemaMercury.jpg" width="100%" alt="">
                    <div class="carousel-caption">
                        
                        <h2><%= intest%>Cinema</h2>
                    </div>
                </a>

            </div>



            <div class="col-md-4">
                <a class="thumbnail" href="?pag=3&tipoEvento=2">
                    <img class="img-responsive" src="img/teatroMercury.jpg" width="100%" alt="">
                    <div class="carousel-caption">
                        <h2><%= intest%>Teatro</h2>
                    </div>
                </a>

            </div>



            <div class="col-md-4">
                <a class="thumbnail" href="?pag=3&tipoEvento=3">
                    <img class="img-responsive" src="img/eventiCulturali.jpg" width="100%" alt="">
                    <div class="carousel-caption">
                        <h2><%= intest%>Culturali</h2>
                    </div>
                </a>

            </div>



            <div class="col-md-4">
                <a class="thumbnail" href="?pag=3&tipoEvento=4">
                    <img class="img-responsive" src="img/concertiMercury.jpg" width="100%" alt="">
                    <div class="carousel-caption">
                        <h2><%= intest%>Concerti</h2>
                    </div>
                </a>

            </div>



            <div class="col-md-4">
                <a class="thumbnail" href="?pag=3&tipoEvento=5">
                    <img class="img-responsive" src="img/eventiSportivi.jpg" width="100%" alt="">
                    <div class="carousel-caption">
                        <h2><%= intest%>Sportivi</h2>
                    </div>
                </a>

            </div>



            <div class="col-md-4">
                <a class="thumbnail" href="?pag=3&tipoEvento=6">
                    <img class="img-responsive" src="img/fiereMercury.jpg" width="100%" alt="">
                    <div class="carousel-caption">
                        <h2><%= intest%>Fiere</h2>
                    </div>
                </a>
            </div>
        </div>
    </div>
</body>
</html>
