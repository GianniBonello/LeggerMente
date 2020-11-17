<%@page import="java.time.LocalDate"%>
<%@page import="Util.UtilityRicerca"%>
<%@page import="model.Utente"%>
<%@page import="model.Prenotazione"%>
<%@page import="java.util.List"%>

<jsp:include page="/view/headerstaff.jsp"></jsp:include>
<%
	List<Prenotazione> listaPrenotazioni = (List<Prenotazione>) request.getAttribute("listaPrenotazioni");
%>




<div class="container-fluid utenti sfondostaff">
	<main role="main" class="col-md-7 ml-sm-auto col-xl-10 pt-3 px-4 ">
		<div class="container-fluid">
		<h1 class="pt-5 text-center text-light pb-5"><b>Gestione Prenotazioni</b></h1>
			<form action="ListaPrenotazioniStaff" method="get">
	  			<div class="row pb-5 justify-content-center">
	    			<div class=" col-sm-12 col-md-12 col-lg-5 col-xl-5 pt-3">
	      				<div class="input-group">
	                                <span class="input-group-append">
	                                    <p class="input-group-text py-2 shadow" style="z-index:2;"><i class="fa fa-search"></i></p>
	                                 </span>
	                                <input class="form-control py-2 bg-light border-radius-5 shadow " name="ricerca" type="search" placeholder="Inserisci il codice della prenotazione" id="example-search-input" >  
	                            </div> 
	    			</div>
	    			<div class=" col-sm-12 col-md-5 col-lg-5 col-xl-3 pt-3">
	      				<select class="custom-select" name="campo">
	  						<option selected disabled>Filtra per : </option>
	  						<option value="idprenotazione">Id prenotazione</option>
	  						<option value="titolo">Titolo</option>
	  						<option value="isbn">Codice isbn</option>
	  						<option value="username">Username</option>
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
						<th scope="col" class="text-center">Codice Prenotazione</th>
						<th scope="col" class="text-center">Utente</th>
						<th scope="col" class="text-center">Titolo</th>
						<th scope="col" class="text-center">Codice ISBN</th>
						<th scope="col" class="text-center">Data di Prenotazione</th>
						<th scope="col" class="text-center stondadue">Ritirato</th>
					</tr>
				</thead>
				<tbody>

					<%
						for (Prenotazione p : listaPrenotazioni) {
							if((!p.getInCorso() && p.getData()==null) || (p.getInCorso() && p.getData() != null)){
					%>

					<tr class="chiaro nero">
						<td class="text-center pt-4"><%=listaPrenotazioni.indexOf(p)+1%></td>
						<td class="text-center pt-4"><%=p.getIdprenotazione()%></td>
						<td class="text-center pt-4"><%=p.getU().getNome()+" "+p.getU().getCognome()%></td>
						<td class="text-center pt-4"><%=p.getLib().getTitolo()%></td>
						<td class="text-center pt-4"><%=p.getLib().getIsbn()%></td>
						<td class="text-center pt-4"><%=p.getData()!=null?LocalDate.parse(UtilityRicerca.dataString(p.getData())):"In Coda" %></td>
						<td class="text-center pt-4">
					<%if(p.getData()!=null) {%>
						<a href="<%=request.getContextPath() %>/ListaPrenotazioniStaff?idPrenotazione=<%=p.getIdprenotazione()%>"><i class="fas fa-check-square fa-2x verde" style="cursor:pointer;"></i></a>
						<%} %>
					<% 	if(request.getSession().getAttribute("utenteLoggato")!= null && ((Utente)request.getSession().getAttribute("utenteLoggato")).getUsername().equals("Admin"))	{%>
							<a href="<%=request.getContextPath() %>/ListaPrenotazioniStaff?elimina=<%=p.getIdprenotazione()%>"><i class="fas fa-minus-square fa-2x magenta" style="cursor:pointer;"></i></a>
							<%} %>
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