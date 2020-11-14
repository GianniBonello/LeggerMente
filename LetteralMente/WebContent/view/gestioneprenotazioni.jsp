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
			<form>
	  			<div class="row pb-5">
	    			<div class="offset-xl-1 col-sm-12 col-md-12 col-lg-6 col-xl-7 pt-3">
	      				<div class="input-group">
	                                <span class="input-group-append">
	                                    <p class="input-group-text py-2 shadow" style="z-index: 2;"><i class="fa fa-search"></i></p>
	                                 </span>
	                                <input class="form-control py-2 bg-light border-radius-5 shadow " name="cercaPrenotazione" type="search" placeholder="Inserisci il codice della prenotazione" id="example-search-input" >  
	                            </div> 
	    			</div>
	    			<div class=" col-sm-12 col-md-5 col-lg-5 col-xl-3 pt-3">
	      				<select class="custom-select">
	  						<option selected>Filtra per : </option>
	  						<option value="1">Username</option>
	  						<option value="2">Utente</option>
	  						<option value="3">Email</option>
						</select>
	    			</div>
	  			</div>
			</form>
	
	
		<div class="col-xl-12 table-responsive">
			<div class="row mr-5 ml-5">
			<table class="table">
				<thead class="bg-dark text-white">
					<tr>
						<th scope="col" class="text-center stonda">#</th>
						<th scope="col" class="text-center">Codice ISBN</th>
						<th scope="col" class="text-center">Titolo Libro</th>
						<th scope="col" class="text-center">Utente</th>
						<th scope="col" class="text-center">Codice Prenotazione</th>
						<th scope="col" class="text-center stondadue">Comandi</th>
					</tr>
				</thead>
				<tbody>

					<%
						for (Prenotazione p : listaPrenotazioni) {
					%>

					<tr class="chiaro nero">
						<td class="text-center pt-4"><%=listaPrenotazioni.indexOf(p)%></td>
						<td class="text-center pt-4"><%=p.getLib().getIsbn()%></td>
						<td class="text-center pt-4"><%=p.getLib().getTitolo()%></td>
						<td class="text-center pt-4"><%=p.getU().getNome()+" "+p.getU().getCognome()%></td>
						<td class="text-center pt-4"><%=p.getIdprenotazione()%></td>
						<td class="text-center pt-4"> 
							<a href=""><i class="fas fa-minus-square fa-2x magenta" style="cursor:pointer;"></i></a>
						</td>
					</tr>
					
						<%
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