<jsp:include page="/view/headerInterno.jsp"></jsp:include>

<div class="container">

	<h1 class=" pt-5 pb-3 my-5 text-center mb-5">
		<b>Recupero dati</b>
		
	</h1>
	
	<p class="pb-5 text-center font-italic">inserisci l'indirizzo email usato per registrarti al sito: riceverai una mail con la procedura per modificare i dati di accesso.</p>
	<div class="col-8 offset-2 text-center">
		<form class="needs-validation" novalidate
			action="<%=request.getContextPath()%>/RecuperoPassword"
			method="post">
			<div class="form-row">
				<div class="form-group col-md-12 pt-1">
					<input placeholder="Inserisci la tua email"
						type="text" name="email"
						class="form-control pl-4 shadow p-1 mb-1" id="nomeid" required>
					<div class="invalid-feedback">Inserire la mail!</div>
				</div>
			</div>
		</form>

		<button type="submit"
			class="my-2 py-2 pl-5 pr-5 text-white shadow p-1 mb-5" id="bottone"
			type="submit">INVIA</button>

	</div>
</div>







<jsp:include page="/view/footer.jsp"></jsp:include>