<div class="col-lg-6 col-lg-offset-3" style="margin-top: 90px;">
    <div class="panel panel-primary">
        <div class="panel-heading" style="text-align:center"><b>Registrazione


            </b></div>
        <div class="panel-body">
            <center>



                <h2>Registrati</h2>

                <form action="Controller" method="post" name="registrazione">
                    <table>
                        <tr>
                            <td>E-mail</td>
                            <td><input type="text" name="nome" placeholder="E-mail" required></td>

                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input type="password" name="password" placeholder="Password" required></td>

                        </tr>
                        <tr>
                            <td>Nome Ente</td>
                            <td><input type="text" name="nomeEnte" placeholder="Nome Ente" required></td>

                        </tr>
                        <tr>
                            <td>P.Iva / Codice Fiscale</td>
                            <td><input type="text" name="pIva" placeholder="Partita Iva / Codice Fiscale" required></td>

                        </tr>
                        <tr>
                            <td>Numero Telefono</td>
                            <td><input type="number" name="telefono" placeholder="Numero Telefono" required></td>

                        </tr>
                        <tr>
                            <td>Indirizzo</td>
                            <td><input type="text" name="indirizzo" placeholder="Indirizzo" required></td>

                        </tr>

                    </table>
                    <br>





                    <table>
                        <td><tr><button class="btn btn-primary" type="submit" style='margin-right:3px'>Registrati</button></tr>

                        <!--campo nascosto-->
                        <input type="hidden" name="codice" value="1">
                        </form> 



                        <tr><button class="btn btn-primary" onclick="goBack()" style='margin-left:3px'>Go Back</button></tr></td>
                    </table>
            </center>

            <script>
                function goBack() {
                    window.history.back();
                }
            </script>
        </div>
    </div>
</div>
