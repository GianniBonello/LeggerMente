<jsp:include page="/view/headerInterno.jsp"></jsp:include>

<div class="container">
 <%if(request.getAttribute("successo") != null && ((String)request.getAttribute("successo")).equals("modificata")) { %>
<br> <br> 
<h2 class=" pt-5 pb-3 text-center text-success">Password Modificata!</h2>
<br> <br> <br>
<h4 class=" pb-3 text-center text-success">Ora puoi effettuare il login con la tua nuova password!</h4>
<br> <br> <br>
<%}else{ if(request.getAttribute("errore") != null && ((String)request.getAttribute("errore")).equals("pswDiverse")) { %>
<h3 class=" pt-5 pb-3 text-center text-danger">Attenzione!</h3>
<h4 class=" pb-3 text-center text-danger">Le password inserite non corrispondono!</h4>
<%}else if(request.getAttribute("errore") != null &&  ((String)request.getAttribute("errore")).equals("email")){ %>
<h3 class=" pt-5 pb-3 text-center text-danger">Errore!</h3>
<h4 class=" pb-3 text-center text-danger">Email inserita non associata a nessun utente registrato!</h4>
<%} %>
	<h1 class=" pt-5 pb-3 my-5 text-center mb-5">
		<b>Modifica Password</b>
		
	</h1>
	
	<p class="pb-3 text-center font-italic">Compila il form per ultimare la modifica della tua password! </p>
	<div class="col-8 offset-2 text-center">
		<form class="needs-validation" novalidate
			action="<%=request.getContextPath()%>/ModificaPassword"
			method="post">
			<div class="form-row justify-content-center">
				<div class="form-group col-xl-10">
					<input placeholder="Inserisci la tua email..."
						type="email" name="email"
						class="form-control pl-4 shadow p-1 mb-1" id="nomeid" required>
					<div class="invalid-feedback">Inserisci un email valida!</div>
					<div class="valid-feedback">Ok!</div>
				</div>
			</div>
			<br>
			<input type="hidden" name="id" value="<%=request.getParameter("id")%>">
			<p class="pb-2 pt-5 text-center">Inserisci la tua nuova password! </p>
			<div class="form-row  m-auto justify-content-center">
				<div class="form-group col-md-12 col-xl-7 pt-1">
					<input placeholder="Inserisci la nuova password..."
						type="password" name="password"
						class="form-control pl-4 shadow p-1 mb-1" id="pwid" required>
					<div class="invalid-feedback">Inserisci una password valida!</div>
         			<div class="valid-feedback">Ok!</div>
				</div>
			</div>
			<div class="form-row m-auto justify-content-center">
				<div class="form-group col-md-12 col-xl-7 pt-1">
					<input placeholder="Conferma la nuova password..."
						type="password" name="passwordConfermata"
						class="form-control pl-4 shadow p-1 mb-1" id="cpwid" required>
					<span id='message'></span>
				</div>
			</div>
			<br>
		
		<button type="submit"
			class="my-2 py-2 pl-5 pr-5 text-white shadow p-1 mb-5" id="bottone"
			type="submit">MODIFICA</button>
</form>
<br>
<br>

	</div>
	<%} %>
</div><!-- container -->


<script>
// Example starter JavaScript for disabling form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();
</script>



<jsp:include page="/view/footer.jsp"></jsp:include>