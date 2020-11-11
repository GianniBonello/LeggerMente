<jsp:include page="/headerInterno.jsp"></jsp:include>

 <div class="container-fluid recuperopassword ">

        
        <div class="recupero confine shadow p-5 mb-2 bg-white">
            <h1 class=" pb-5 pt-3 text-center"><b>Recupero password/username</b></h1>

            <form method="post">
                <div class="form-row ">

                    <div class="col-8 offset-2 pt-4">
                        <form action="Registrazione" method="post">
                            <div class="form-row">
                                
                                <div class="form-group col-xl-6 pt-1">
                                    <label for="userid">Username </label>
                                    <input type="text" name="username"
                                        class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                        id="userid" placeholder="">
                                </div>
                                <div class="form-group col-xl-6 pt-1">
                                    <label for="mailid">Email </label>
                                    <input type="email" name="email"
                                        class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                        id="mailid" placeholder="">
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-xl-6 pt-1">
                                    <label for="passid">Password </label>
                                    <input type="text" name="password"
                                        class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                        id="passid" placeholder="">
                                </div>

                                <div class="form-group col-xl-6 pt-1">
                                    <label for="confid">Conferma password </label>
                                    <input type="email" name="confermapassword"
                                        class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                        id="confid" placeholder="">
                                </div>
                            </div>
                        </form>
                        <div class="text-center pt-4">
                            <button type="submit"
                                class="mt-2 py-2 pl-5 pr-5 mr-5 text-white shadow p-1 mb-5 "
                                id="bottone" type="submit">CONFERMA</button>
                            <button type="submit"
                                class="mt-2 py-2 pl-5 pr-5 text-white shadow p-1 mb-5"
                                id="bottone" type="submit">ANNULLA</button>

                        </div>

                    </div>
                </div>
            </form>
        </div>
    </div>


<jsp:include page="/footer.jsp"></jsp:include>