<%@page import="model.Utente"%>
<%@page import="java.util.List"%>
<%@page import="model.Libro"%>
<jsp:include page="/view/headerstaff.jsp"></jsp:include>



<%
	List<Libro> listaLibri = (List<Libro>) request.getAttribute("listaLibri");
%>




<div class="container-fluid libri sfondostaff">
	<main role="main" class="col-md-7 ml-sm-auto col-xl-10 pt-3 px-4 ">
		<div class="container-fluid">
		<h1 class="pt-5 text-center text-light pb-5"><b>Gestione Libri</b></h1>
			<form action="<%=request.getContextPath()%>/ListaLibri" method="post">
	  			<div class="row pb-5 justify-content-center">
	    			<div class="col-sm-12 col-md-12 col-lg-5 col-xl-5 pt-3">
	      				<div class="input-group">
	                                <span class="input-group-append">
	                                    <p class="input-group-text py-2 shadow" style="z-index: 2;"><i class="fa fa-search"></i></p>
	                                 </span>
	                                <input class="form-control py-2 bg-light border-radius-5 shadow " name="ricerca" type="search" placeholder="Inserisci il titolo del libro" id="example-search-input" >  
	                            </div> 
	    			</div>
	    			<div class=" col-sm-12 col-md-5 col-lg-5 col-xl-3 pt-3">
	      				<select name="campo" class="custom-select">
	  							<option selected disabled>Filtra per : </option>
	  							<option value="titolo">Titolo</option>
                                <option value="genere">Genere</option>
                                <option value="autore">Autore</option>
                                <option value="isbn">Codice ISBN</option>
                                <option value="casaeditrice">Casa Editrice</option>
						</select>
	    			</div>
	    			<a href="#piu"><i class="fas fa-book-medical fa-2x pt-3" style="color:white;"></i><a>
	    			<button type="submit" class="ml-3" style="margin-top:12px;">CERCA</button>
	  			</div>
			</form>
	
	
		<div class="col-xl-12 table-responsive">
			<div class="row justify-content-center mr-5 ml-5">
			<table class="table">
				<thead class="bg-dark text-white">
					<tr>
						<th scope="col" class="text-center stonda pr-5 pl-5">#</th>
                            <th scope="col" class="text-center">Titolo libro</th>
                            <th scope="col" class="text-center">Autore</th>
                            <th scope="col" class="text-center">Codice ISBN</th>
                            <th scope="col" class="text-center">Qt</th>
                            <th scope="col" class="text-center stondadue">Comandi</th>
					</tr>
				</thead>
				<tbody>
							
					<%
						for (Libro l : listaLibri) {
					%>

					<tr class="chiaro nero">
						<td class="text-center pt-4 pr-5 pl-5"><%=listaLibri.indexOf(l)%></td>
						<td class="text-left pt-4 pl-5"><%=l.getTitolo()%></td>
						<td class="text-center pt-4"><%=l.getAutore()%></td>
						<td class="text-center pt-4"><%=l.getIsbn()%></td>
						<td class="text-center pt-4"><%=l.getQuantita()%></td>
						<td class="text-center pt-4">
							<a data-toggle="collapse" data-target="#demo<%=listaLibri.indexOf(l)%>" role="button" aria-expanded="false" aria-controls="collapseExample"> 
								<i class="fas fa-pen-square fa-2x text-white" style="cursor:pointer;"></i>
							</a> 
							<%if(request.getSession().getAttribute("utenteLoggato")!=null && ((Utente)request.getSession().getAttribute("utenteLoggato")).getIsStaff() && ((Utente)request.getSession().getAttribute("utenteLoggato")).getUsername().equals("Admin")){ %>
							<a href="<%=request.getContextPath() %>/EliminaLibri?elimina=<%=l.getId_libro()%>"><i class="fas fa-minus-square fa-2x magenta" style="cursor:pointer;"></i></a>
							<%} %>
						</td>
					</tr>
					<tr>
                            <td colspan="6" class="hiddenRow bgcoll">
                                <div id="demo<%=listaLibri.indexOf(l)%>" class="collapse">
                                        <div class="form-row">
                                        
                                        <!-- modifica -->

                                            <div class="col-8 offset-2 pt-4">
                                                <form  class="needs-validation" action="<%=request.getContextPath() %>/GestioneLibri" method="post" enctype="multipart/form-data" novalidate>
                                                    <div class="form-row">
                                                        <div class="form-group col-xl-6 pt-1">


                                                            <label for="titoloid">Titolo </label>
                                                            <input type="text" name="titolo" maxlength="45"
                                                                class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                                                id="titoloid" value="<%=l.getTitolo()%>" required>
                                                                <div class="invalid-feedback">Inserisci un titolo valido!</div>
          														<div class="valid-feedback">Ok!</div>
                                                        </div>
                                                        <div class="form-group col-xl-6 pt-1">
                                                            <label for="casaid">Editore</label>
                                                            <input type="text" name="casaeditrice" maxlength="45"
                                                                class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                                                id="casaid" value="<%=l.getCasaEditrice()%>" required>
                                                                <div class="invalid-feedback">Inserisci un editore valido!</div>
          														<div class="valid-feedback">Ok!</div>
                                                        </div>
                                                    </div>


                                                    <div class="form-row">
                                                    
                                                    <div class="form-group col-xl-6 pt-1">
                                                            <label for="autore">Autore</label>
                                                            <input type="text" name="autore" maxlength="45"
                                                                class="cazzo form-control pl-4 shadow p-1 mb-1"
                                                                id="autore" value="<%=l.getAutore()%>" required>
                                                                <div class="invalid-feedback">Inserisci un autore valido!</div>
          														<div class="valid-feedback">Ok!</div>
                                                        </div>
                                                        
     
                                                        
                                                        <div class="form-group col-xl-6 pt-1">
                                                        	<label for="campo">Genere</label>
                                                        	
                                                            <select name ="campo" class="custom-select bg-light shadow " id="inputGroupSelect01" required>
                            									<option selected disabled>Seleziona un Genere</option>
                            									<%for(Libro g : listaLibri){ %>
                                									<option value="<%=g.getGenere()%>"><%=g.getGenere() %></option>   
                                								<% } %>                         
                            								</select>
                                                                <div class="invalid-feedback">Inserisci un genere!</div>
          														<div class="valid-feedback">Ok!</div>
                                                        </div>

                                                    </div>

                                                    <div class="form-row">
                                                    
                                                    <div class="form-group col-xl-8 pt-1">
                                                            <label for="isbnid">Codice ISBN</label>
                                                            <input type="text" name="isbn" maxlength="17"
                                                                class="cazzo form-control pl-4 shadow p-1 mb-1"
                                                                id="isbnid" value="<%=l.getIsbn()%>" required>
                                                                <div class="invalid-feedback">Inserisci un codice ISBN valido!</div>
          														<div class="valid-feedback">Ok!</div>
                                                        </div>
                                                        
                                                        <div class="form-group col-xl-2 pt-1">
                                                            <label for="qtid">Quantita</label> 
                                                            <input type="number" name="quantita" maxlength="5" oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"
                                                                class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                                                id="qtid" value="<%=l.getQuantita()%>" required>
                                                                <div class="invalid-feedback">Inserisci una quantita' valida!</div>
          														<div class="valid-feedback">Ok!</div>
                                                        </div>


                                                        <div class="form-group col-xl-2 pt-1">
                                                            <label for="prezzoid">Prezzo </label>
                                                            <input type="number" name="prezzo" maxlength="6" oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"
                                                                class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                                                id="prezzoid" value="<%=l.getPrezzo()%>" required>
                                                                <div class="invalid-feedback">Inserisci un prezzo valido!</div>
          														<div class="valid-feedback">Ok!</div>
                                                        </div>


                                                    </div>

                                                    <div class="form-row">
                                                        <label for="prezzoid">Trama</label>
                                                        <textarea name="trama" class="col-xl-12 p-3 b-none" required><%=l.getTrama()%></textarea>
                                                    	<div class="invalid-feedback">Inserisci una trama valida!</div>
          												<div class="valid-feedback">Ok!</div>
                                                    </div>

                                                    <div class="form-row pt-4">
                                                    
                                                    	<div class="col-xl-12">  
                                                        	<label for="imgid" class="col-2 pt-2">Immagine </label>
                                                        	<input type="file" name="immagine"
                                                            	class="form-control imm shadow mb-1 bg-white col-xl-12 pl-5 "
                                                            	id="imgid" alt="Submit" required>
                                                            	<div class="invalid-feedback">Inserisci un immagine valida!</div>
          														<div class="valid-feedback">Ok!</div>
                                                    	</div>
                                                    	
                                                    </div>
                                                    <input type="hidden" name="idLibro" value="<%=l.getId_libro() %>">
                                                
                                                <div class="text-center pt-4">
													<button type="submit" class="mt-2 py-2 pl-5 pr-5 mr-5 text-white shadow p-1 mb-5 " id="bottone">MODIFICA</button>
													<a data-toggle="collapse" data-target="#demo<%=listaLibri.indexOf(l)%>" role="button" aria-expanded="false" aria-controls="collapseExample">
														<button class="mt-2 py-2 pl-5 pr-5 text-white shadow p-1 mb-5" id="bottone" >ANNULLA</button>
													</a>

												</div>
                                                
                                              </form>
                                            </div>
                                        </div>
                                
                                </div>
                            </td>
                        </tr>
					
						<%
						}
					%>
					</tbody>
					
				</table>
				           <!-- inserimento libri -->
										
										<div class="row m-auto justify-content-center"  >
											<i class="fas fa-plus-square fa-3x mb-5 mt-3" style="color:white; opacity:0.9; cursor:pointer;" data-toggle="collapse" href="#aggiungicollapse" aria-expanded="false" aria-controls="aggiungicollapse" id="piu"></i>
										</div>
										
                                            <div class="col-xl-12 pt-4 collapse mb-5  pr-5 pl-5" style="background-color: rgba(255,255,255,0.4); border-radius:25px" id="aggiungicollapse">
                                                <h1 class="pt-5 text-center text-dark pb-5"><b>Aggiungi Libro</b></h1>
                                                
                                                <form class="needs-validation" action="<%=request.getContextPath()%>/GestioneLibri" method="post" enctype="multipart/form-data" novalidate>
                                                    <div class="form-row">
                                                    
                                                        <div class="form-group col-xl-6 pt-1 ">
                                                            <label for="titoloid" class="text-dark">Titolo </label>
                                                            <input type="text" name="titolo" maxlength="45" class=" cazzo form-control pl-4 shadow p-1 mb-1 bg-white" id="titoloid" required>
                                                                <div class="invalid-feedback">Inserisci un titolo valido!</div>
          														<div class="valid-feedback">Ok!</div>
                                                        </div>
                                                        
                                                        <div class="form-group col-xl-6 pt-1">
                                                            <label for="casaid" class="text-dark">Editore</label>
                                                            <input type="text" name="casaeditrice" maxlength="45" class="cazzo form-control pl-4 shadow p-1 mb-1 bg-white" id="casaid" required>
                                                                <div class="invalid-feedback">Inserisci un editore valido!</div>
          														<div class="valid-feedback">Ok!</div>
                                                        </div>
                                                        
                                                    </div>


                                                    <div class="form-row">
                                                    
                                                    <div class="form-group col-xl-6 pt-1">
                                                            <label for="autore">Autore</label>
                                                            <input type="text" name="autore" maxlength="45"
                                                                class="cazzo form-control pl-4 shadow p-1 mb-1"
                                                                id="autore"  required>
                                                                <div class="invalid-feedback">Inserisci un autore valido!</div>
          														<div class="valid-feedback">Ok!</div>
                                                        </div>
                                                        
                                                        <div class="form-group col-xl-6 pt-1">
                                                            <label for="genereid">Genere </label>
                                                            <input type="text" name="genere" maxlength="45"
                                                                class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                                                id="genereid" required>
                                                                <div class="invalid-feedback">Inserisci un genere valido!</div>
          														<div class="valid-feedback">Ok!</div>
                                                        </div>

                                                    </div>

                                                    <div class="form-row">
                                                    
                                                    	<div class="form-group col-xl-8 pt-1">
                                                            	<label for="isbnid">Codice ISBN</label>
                                                            	<input type="text" name="isbn" maxlength="17"
                                                                class="cazzo form-control pl-4 shadow p-1 mb-1"
                                                                id="isbnid" required>
                                                                <div class="invalid-feedback">Inserisci un codice ISBN valido!</div>
          														<div class="valid-feedback">Ok!</div>
                                                     	</div>
                                                        
                                                        <div class="form-group col-xl-2 pt-1">
                                                            <label for="qtid">Quantita</label>
                                                            <input type="number" name="quantita" maxlength="5" oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"
                                                                class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                                                id="qtid" required>
                                                                <div class="invalid-feedback">Inserisci una quantita' valida!</div>
          														<div class="valid-feedback">Ok!</div>
                                                        </div>


                                                        <div class="form-group col-xl-2 pt-1">
                                                            <label for="prezzoid">Prezzo </label>
                                                            <input type="number" name="prezzo" maxlength="6" pattern="[0-9,.,0-9]"  oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"
                                                                class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                                                id="prezzoid" required>
                                                                <div class="invalid-feedback">Inserisci un prezzo valido!</div>
          														<div class="valid-feedback">Ok!</div>
                                                        </div>


                                                    </div>
                                                    
                                                    <div class="form-row">
                                                        <label for="prezzoid" class="text-dark">Trama</label>
                                                        <textarea name="trama" class="col-xl-12 p-3 b-none" required></textarea>
                                                        <div class="invalid-feedback">Inserisci una trama valida!</div>
          												<div class="valid-feedback">Ok!</div>
                                                    </div>

                                                    <div class="form-row pt-4">
                                                   
                                                    	<div class="col-xl-2 pt-2"> 
                                                    	<p class="pl-5">Usato</p>
                                                    		<label class="switch ml-5">
                                                    		<input type="checkbox" name="isUsato"><span class="slider round "></span>
															</label>
														</div>

                                                    	<div class="col-xl-10 pt-1"> 
                                                    	
                                                    		 
                                                    		
                                                        	<label for="imgid" class="col-2 pt-1 pb-1 text-dark" >Immagine </label>
                                                        	<input type="file" name="immagine"
                                                            	class="form-control imm shadow mb-1 bg-white col-xl-12 pl-5 "
                                                            	id="imgid" alt="Submit" required>
                                                            	<div class="invalid-feedback">Inserisci un'immagine valida!</div>
          														<div class="valid-feedback">Ok!</div>
                                                    	</div>
                                                   
                                                    </div>
                                                
                                                <div class="text-center pt-4">
													<button type="submit" class="mt-2 py-2 pl-5 pr-5 mr-5 text-white shadow p-1 mb-5 " id="bottone">AGGIUNGI</button>
													<a data-toggle="collapse" href="#aggiungicollapse" aria-expanded="false" aria-controls="aggiungicollapse">
														<button class="mt-2 py-2 pl-5 pr-5 text-white shadow p-1 mb-5" id="bottone" >ANNULLA</button>
													</a>
												</div>
                                                
                                              </form>
                                            </div>
                                        
			</div>
		</div>
	  </div>
	</main>
</div>

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

<jsp:include page="/view/footerstaff.jsp"></jsp:include> 