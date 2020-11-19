
<%@ page contentType="text/html; charset=ISO-8859-1" %>
<div class="container">


	<h1 class=" pt-5 pb-3 my-5 text-center mb-5"><b>Recupero dati</b></h1>
	
	
	<p class="text-center font-italic">Inserisci l'indirizzo email usato per registrarti al sito : riceverai un' email con la procedura per modificare i dati di accesso.</p>
	
	 <%if(request.getAttribute("recupero") != null &&  ((String)request.getAttribute("recupero")).equals("error")){ %>
<h4 class=" pt-5 pb-3 text-center text-danger">Errore!</h4>
<h5 class=" pb-5 text-center text-danger">L'email inserita non è associata a nessun utente registrato!</h5>
<%}else if(request.getAttribute("recupero") != null && ((String)request.getAttribute("recupero")).equals("successo")) { %>
<h4 class=" pt-5 pb-3 text-center text-success">Perfetto!</h4>
<h5 class=" pb-5 text-center text-success">Controlla la tua email, ti abbiamo inviato le istruzioni per modificare i tuoi dati!</h5>
<% } %>
	
	
	<div class="col-8 offset-2 text-center pt-3">
		<form class="needs-validation" action="<%=request.getContextPath()%>/RecuperoPassword" method="post" novalidate>
			<div class="form-row">
				<div class="form-group col-md-12 pt-1 mb-5">
					<input placeholder="Inserisci la tua email"
						type="email" name="email"
						class="form-control pl-4 shadow p-1 mb-1" id="nomeid" required>
					<div class="invalid-feedback">Inserisci l'email corretta!</div>
					<div class="valid-feedback">Perfetto ! Controlla la tua email, ti abbiamo inviato le istruzioni per modificare i tuoi dati!</div>
				</div>
			</div>
		
		<button type="submit"
			class="my-2 py-2 pl-5 pr-5 text-white shadow p-1 mb-5" id="bottone"
			type="submit">INVIA</button>
</form>
<br>
<br>

	</div>
</div>
<div class="spazio" style="padding-top:150px;"></div>
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