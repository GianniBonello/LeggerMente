<%@page import="java.time.LocalDate"%>
<%@page import="java.sql.Date"%>
<%@page import="model.Utente"%>
<%@page import="java.util.List"%>
<%@page import="model.Noleggio"%>
<jsp:include page="/view/headerstaff.jsp"></jsp:include>



<%
	List<Noleggio> listaNoleggi = (List<Noleggio>) request.getAttribute("listaNoleggi");
%>




<div class="container-fluid prenotazioni sfondostaff">
	<main role="main" class="col-md-7 ml-sm-auto col-xl-10 pt-3 px-4 ">
		<div class="container-fluid">
		<h1 class="pt-5 text-center text-light pb-5"><b>Gestione Noleggi</b></h1>
			<form action="ListaNoleggiStaff" method="get">
	  			<div class="row pb-5 justify-content-center">
	    			<div class="col-sm-12 col-md-12 col-lg-5 col-xl-5 pt-3">
	      				<div class="input-group">
	                                <span class="input-group-append">
	                                    <p class="input-group-text py-2 shadow" style="z-index: 2;"><i class="fa fa-search"></i></p>
	                                 </span>
	                                <input class="form-control py-2 bg-light border-radius-5 shadow " name="ricerca" type="search" placeholder="Inserisci il codice del noleggio" id="example-search-input" >  
	                            </div> 
	    			</div>
	    			<div class=" col-sm-12 col-md-5 col-lg-5 col-xl-3 pt-3">
	      				<select class="custom-select" name="campo">
	  						<option selected disabled>Filtra per : </option>
	  						<option value="id_noleggio">Id noleggio</option>
	  						<option value="isbn">Codice isbn</option>
	  						<option value="titolo">Titolo</option>
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
						<th scope="col" class="text-center">Libro</th>
						<th scope="col" class="text-center">Utente</th>
						<th scope="col" class="text-center">Codice noleggio</th>
						<th scope="col" class="text-center ">In Corso</th>
						<th scope="col" class="text-center stondadue">Comandi</th>
					</tr>
				</thead>
				<tbody>

					<%
						for (Noleggio n : listaNoleggi) {
							if(n.getDataFine().after(Date.valueOf(LocalDate.now()))){
					%>

					<tr class="chiaro nero">
						<td class="text-center pt-4"><%=listaNoleggi.indexOf(n)%></td>
						<td class="text-center pt-4"><%=n.getLib().getTitolo() %></td>
						<td class="text-center pt-4"><%=n.getU().getNome()+" "+n.getU().getCognome()%></td>
						<td class="text-center pt-4"><%=n.getIdNoleggio()%></td>
						<td class="text-center pt-4">
							<label class="switch"> 
							<a href=""></a>	<input type="checkbox" name="inCorso" value="" <%=n.getInCorso()?"checked":"" %>> <span class="slider round"></span>
							</label>
						</td>
						<td class="text-center pt-4">
							<i class="fas fa-check-square fa-2x verde" style="cursor:pointer;"></i>
							<%if(request.getSession().getAttribute("utenteLoggato") != null & ((Utente)request.getSession().getAttribute("utenteLoggato")).getUsername().equals("Admin")) {%>
							<i class="fas fa-minus-square fa-2x magenta" style="cursor:pointer;"></i>
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