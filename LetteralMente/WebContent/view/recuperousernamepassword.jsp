<jsp:include page="/view/headerInterno.jsp"></jsp:include>



 <div class="container-fluid recuperopassword ">
 
 <%if(request.getAttribute("recupero") != null && ((String)request.getAttribute("recupero")).equals("errore")){ %>
<h3 class=" pt-5 pb-3 text-center text-danger">Errore!</h3>
<h4 class=" pb-3 text-center text-danger">L'email inserita non è associata a nessun utente registrato!</h4>
<%}else if(request.getAttribute("recupero") != null && ((String)request.getAttribute("recupero")).equals("successo")){ %>
<h3 class=" pt-5 pb-3 text-center text-success">Perfetto!</h3>
<h4 class=" pb-3 text-center text-success">Riceverai una mail con le istruzioni!</h4>
<%} %>

        
        <div class="recupero p-5 mb-2 text-center">
            <h1 class=" pb-5 pt-3 text-center"><b>Recupero Username / Password</b></h1>

            <form method="post">
                <div class="form-row ">

                    <div class="col-8 offset-2 pt-4">
                        <form class="was-validated" action="Registrazione" method="post">
                            <div class="form-row justify-content-center m-auto">
                                
                                <div class="form-group pt-3">
                                    <label for="email">Email </label>
                                    <input type="email" name="email"
                                        class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                        id="email" placeholder="Inserisci la tua email">
                                </div>
                            </div>
                            <div class="form-row justify-content-center m-auto">
                                <div class="custom-control custom-radio mb-3 mt-3 ">
								    <input type="radio" class="custom-control-input" id="customControlValidation2" name="radio-stacked" required>
								    <label class="custom-control-label" for="customControlValidation2">Username</label>
								</div>
								<div class="custom-control custom-radio mt-3 mb-3 ml-5">
								    <input type="radio" class="custom-control-input" id="customControlValidation3" name="radio-stacked" required>
								    <label class="custom-control-label" for="customControlValidation3">Password</label>
								<div class="invalid-feedback">More example invalid feedback text</div>
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


<jsp:include page="/view/footer.jsp"></jsp:include>