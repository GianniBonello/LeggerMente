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
			<form>
	  			<div class="row pb-5">
	    			<div class="offset-xl-1 col-sm-12 col-md-12 col-lg-6 col-xl-7 pt-3">
	      				<div class="input-group">
	                                <span class="input-group-append">
	                                    <p class="input-group-text py-2 shadow" style="z-index: 2;"><i class="fa fa-search"></i></p>
	                                 </span>
	                                <input class="form-control py-2 bg-light border-radius-5 shadow " name="cercaNoleggio" type="search" placeholder="Inserisci il codice del noleggio" id="example-search-input" >  
	                            </div> 
	    			</div>
	    			<div class=" col-sm-12 col-md-5 col-lg-5 col-xl-3 pt-3">
	      				<select class="custom-select">
	  						<option selected>Filtra per : </option>
	  						<option value="1">Codice ISBN</option>
	  						<option value="2">Username</option>
	  						<option value="3">Data fine noleggio</option>
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