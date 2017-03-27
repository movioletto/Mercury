<div class="col-lg-6 col-lg-offset-3" style="margin-top: 90px;">
    <div class="panel panel-primary">
        <div class="panel-heading" style="text-align:center">
            <style>
                /* CSS */
                .errorAlert{background:blue;color:#fff;padding:10px 20px;margin-bottom:20px}

            </style>

            <b>Accedi


            </b></div>
        <div class="panel-body">
            <center>

                <%
                    if (request.getParameter("error") != null) {
                        if (request.getParameter("error").equals("1")) {
                            out.println("<div class=\"errorAlert\">Username o password errati</div>");
                        } else if (request.getParameter("error").equals("2")) {
                            out.println("<div class=\"errorAlert\">Login non effettuato</div>");
                        }
                    }


                %>

                <h2>Login</h2>

                <form action="Controller" method="post" name="accesso">
                    <table cellpadding="10px">
                        <tr>
                            <td>Username</td>
                            <td> <input type="text" name="mail" placeholder="E-mail" required></td>
                        </tr><tr>  

                            <td>Password</td>
                            <td> <input type="password" name="pass" placeholder="Password" required></td>

                        </tr>
                    </table>
                    <br>
                    <table>
                        <td><tr><button class="btn btn-primary" type="submit" style='margin-right:3px'>Accedi</button></tr>

                        <!--campo nascosto-->
                        <input type="hidden" name="codice" value="2">
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

