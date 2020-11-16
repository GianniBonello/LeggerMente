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
	
	<p class="pb-5 text-center font-italic">Compila il form per ultimare la modifica della tua password! </p>
	<div class="col-8 offset-2 text-center">
		<form class="needs-validation" novalidate
			action="<%=request.getContextPath()%>/ModificaPassword"
			method="post">
			<div class="form-row">
				<div class="form-group col-md-12 pt-1">
					<input placeholder="Inserisci la tua email..."
						type="email" name="email"
						class="form-control pl-4 shadow p-1 mb-1" id="nomeid" required>
					<div class="invalid-feedback">Inserisci la mail!</div>
				</div>
			</div>
			<br>
			<input type="hidden" name="id" value="<%=request.getParameter("id")%>">
			<p class="pb-5 text-center">Inserisci la tua nuova password! </p>
			<div class="form-row">
				<div class="form-group col-md-7 pt-1">
					<input placeholder="Inserisci la nuova password..."
						type="password" name="password"
						class="form-control pl-4 shadow p-1 mb-1" id="nomeid" required>
					<div class="invalid-feedback">Inserisci la tua nuova Password!</div>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-7 pt-1">
					<input placeholder="Conferma la nuova password..."
						type="password" name="passwordConfermata"
						class="form-control pl-4 shadow p-1 mb-1" id="nomeid" required>
					<div class="invalid-feedback">Conferma la tua nuova Password!</div>
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





<jsp:include page="/view/footer.jsp"></jsp:include>