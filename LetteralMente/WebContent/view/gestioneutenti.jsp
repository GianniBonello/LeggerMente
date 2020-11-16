<%@page import="model.Utente"%>
<%@page import="java.util.List"%>

<jsp:include page="/view/headerstaff.jsp"></jsp:include>

<%
	List<Utente> listaUtenti = (List<Utente>) request.getAttribute("listaUtenti");
%>




<div class="container-fluid utenti sfondostaff">
	<main role="main" class="col-md-7 ml-sm-auto col-xl-10 pt-3 px-4 ">
		<div class="container-fluid">
		<h1 class="pt-5 text-center text-light pb-5"><b>Gestione utenti</b></h1>
		<%if(request.getAttribute("utenteModificato")!= null && ((String)request.getAttribute("utenteModificato")).equals("errore")) {%>
		<h5 class="text-center text-light pb-5">Non e' possibile registrare un utente con questa data di nascita</h5>
		<%}else if(request.getAttribute("utenteModificato")!= null && ((String)request.getAttribute("utenteModificato")).equals("successo")){ %>
		<h5 class="text-center text-light pb-5">Dati modificati con successo</h5>
		<%} %>
			<form action="ListaUtenti" method="get">
	  			<div class="row pb-5 justify-content-center">
	    			<div class="col-sm-12 col-md-12 col-lg-5 col-xl-5 pt-3">
	      				<div class="input-group">
	                                <span class="input-group-append">
	                                    <p class="input-group-text py-2 shadow" style="z-index: 2;"><i class="fa fa-search"></i></p>
	                                 </span>
	                                <input class="form-control py-2 bg-light border-radius-5 shadow " name="ricerca" type="search" placeholder="Inserisci il testo da ricercare" id="example-search-input" >  
	                            </div> 
	    			</div>
	    			<div class=" col-sm-12 col-md-5 col-lg-5 col-xl-3 pt-3">
	      				<select class="custom-select" name="campo">
	  						<option selected disabled>Filtra per : </option>
	  						<option value="username">Username</option>
	  						<option value="nome">Nome</option>
	  						<option value="cognome">Cognome</option>
	  						<option value="email">Email</option>
						</select>
	    			</div>
	    		  <button type="submit" class="ml-3" style="margin-top:12px;" >CERCA</button>
	  			</div>
			</form>
	
	
		<div class="col-xl-12 table-responsive">
			<div class="row mr-5 ml-5">
			<table class="table">
				<thead class="bg-dark text-white">
				
				
					<tr>
						<th scope="col" class="text-center stonda">#</th>
						<th scope="col" class="text-center">Username</th>
						<th scope="col" class="text-center">Utente</th>
						<th scope="col" class="text-center">Email</th>
						<th scope="col" class="text-center">Staff</th>
						<th scope="col" class="text-center stondadue">Comandi</th>
					</tr>
				</thead>
				<tbody>

					<%
						for (Utente u : listaUtenti) {
							if((u.getIsStaff() && request.getSession().getAttribute("utenteLoggato")!=null && ((Utente)request.getSession().getAttribute("utenteLoggato")).getUsername().equals("Admin")) ||
									(!u.getIsStaff() && request.getSession().getAttribute("utenteLoggato")!=null && !((Utente)request.getSession().getAttribute("utenteLoggato")).getUsername().equals("Admin"))){
					%>

					<tr class="chiaro nero">
						<td class="text-center pt-4"><%=listaUtenti.indexOf(u)%></td>
						<td class="text-center pt-4"><%=u.getUsername()%></td>
						<td class="text-center pt-4"><%=u.getNome()+ " " + u.getCognome()%></td>
						<td class="text-center pt-4"><%=u.getEmail()%></td>
						<td class="text-center pt-4"><label class="switch"> <input
								type="checkbox"> <span class="slider round"></span>
						</label></td>

						<td class="text-center pt-4">
							<a data-toggle="collapse" data-target="#demo<%=listaUtenti.indexOf(u)%>" role="button" aria-expanded="false" aria-controls="collapseExample"> 
								<i class="fas fa-pen-square fa-2x text-white" style="cursor:pointer;"></i>
							</a> 
							<a href="<%=request.getContextPath() %>/ListaUtenti?elimina=<%=u.getIdUtente()%>"><i class="fas fa-minus-square fa-2x magenta" style="cursor:pointer;"></i></a>
						</td>
					</tr>

					<tr>
					<td colspan="6" class="hiddenRow bgcoll">
						<div id="demo<%=listaUtenti.indexOf(u)%>" class="collapse">



							<div class="col-8 offset-2 pt-4">
								<form action="<%=request.getContextPath() %>/ListaUtenti" method="post">
									<div class="form-row">
										<div class="form-group col-md-12 pt-1">
											<label for="nomeid">Nome </label> <input type="text"
												name="nome" class="cazzo form-control pl-4 shadow p-1 mb-1"
												id="nomeid" value="<%=u.getNome()%>" required>
										</div>
										<div class="form-group col-md-12 pt-1">
											<label for="cognomeid">Cognome </label> 
											<input type="text"
												name="cognome"
												class="form-control pl-4 shadow p-1 mb-1 bg-white"
												id="cognomeid" value="<%=u.getCognome()%>" required>
										</div>
									</div>

									<div class="form-row">
										<div class="form-group col-xl-6 pt-1">
											<label for="cfid">Codice fiscale </label> <input type="text"
												name="cf" class="form-control pl-4 shadow p-1 mb-1 bg-white"
												id="cfid" value="<%=u.getCf()%>" required>
										</div>

										<div class="form-group col-xl-6 pt-1">
											<label for="nascitaid">Data di nascita </label> <input
												type="date" name="dataDiNascita"
												class="form-control pl-4 shadow p-1 mb-1 bg-white"
												id="nascitaid" value="<%=u.getDataDiNascita()%>" required>
										</div>
									</div>

									<div class="form-row">
										<div class="form-group col-md-12 pt-1">
											<label for="emailid">Email </label> <input type="email"
												name="email"
												class="form-control pl-4 shadow p-1 mb-1 bg-white"
												id="emailid" value="<%=u.getEmail()%>" required>
										</div>
									</div>

									<div class="form-row">
										<div class="form-group col-xl-5 pt-1">
											<label for="indirizzoid">Indirizzo </label> <input
												type="text" name="indirizzo"
												class="form-control pl-4 shadow p-1 mb-1 bg-white"
												id="indirizzoid" value="<%=u.getIndirizzo()%>" required>
										</div>

										<div class="form-group col-xl-5 pt-1">
											<label for="comuneid">Comune </label> <input type="text"
												name="comune"
												class="form-control pl-4 shadow p-1 mb-1 bg-white"
												id="comuneid" value="<%=u.getComune()%>" required>
										</div>
										<div class="form-group col-xl-2 pt-1">
											<label for="capid">CAP </label> <input type="number"
												maxlength="5" pattern="([0-9]|[0-9]|[0-9]|[0-9]|[0-9])"
												name="cap"
												class="form-control pl-4 shadow p-1 mb-1 bg-white"
												id="capid" value="<%=u.getCap()%>" required>
										</div>
									</div>

									<div class="form-row">
										<div class="form-group col-xl-6 pt-1">
											<label for="pwid">Username </label> <input type="text"
												name="username"
												class="form-control pl-4 shadow p-1 mb-1 bg-white" id="pwid"
														value="<%=u.getUsername()%>" required>
										</div>

										<div class="form-group col-xl-6 pt-1">
											<label for="cpwid">Password </label> <input type="password"
												name="password"
												class="form-control pl-4 shadow p-1 mb-1 bg-white"
												id="cpwid" value="<%=u.getPassword()%>" required>
										</div>
									</div>

									<input type="hidden" name="idUtente" value="<%=u.getIdUtente()%>">


									<div class="text-center pt-4">
										<button type="submit" class="mt-2 py-2 pl-5 pr-5 mr-5 text-white shadow p-1 mb-5 " id="bottone">MODIFICA</button>
										<a data-toggle="collapse" data-target="#demo<%=listaUtenti.indexOf(u)%>" role="button" aria-expanded="false" aria-controls="collapseExample">
											<button class="mt-2 py-2 pl-5 pr-5 text-white shadow p-1 mb-5" id="bottone" >ANNULLA</button>
										</a>

									</div>
								</form>
							</div>


						</div>
						</td>
					</tr>
						<%
						}
						}
					%>

					</tbody>
				</table>

			</div>
		</div>
	  </div>
	</main>
</div>


<jsp:include page="/view/footerstaff.jsp"></jsp:include>
