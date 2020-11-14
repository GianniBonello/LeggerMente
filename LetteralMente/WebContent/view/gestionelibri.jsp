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
			<form>
	  			<div class="row pb-5">
	    			<div class="offset-xl-1 col-sm-12 col-md-12 col-lg-6 col-xl-7 pt-3">
	      				<div class="input-group">
	                                <span class="input-group-append">
	                                    <p class="input-group-text py-2 shadow" style="z-index: 2;"><i class="fa fa-search"></i></p>
	                                 </span>
	                                <input class="form-control py-2 bg-light border-radius-5 shadow " name="cercaLibro" type="search" placeholder="Inserisci il titolo del libro" id="example-search-input" >  
	                            </div> 
	    			</div>
	    			<div class=" col-sm-12 col-md-5 col-lg-5 col-xl-3 pt-3">
	      				<select class="custom-select">
	  							<option selected>Filtra per : </option>
	  							<option value="titolocresc">Titolo : dalla A alla Z</option>
                                <option value="titolodecr">Titolo : dalla Z alla A</option>
                                <option value="prezzocresc">Prezzo : crescente</option>
                                <option value="prezzodecr">Prezzo : decrescente</option>
                                <option value="genere">Genere</option>
                                <option value="autore">Autore</option>
                                <option value="casaeditrice">Casa Editrice</option>
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
						<td class="text-center pt-4"><%=listaLibri.indexOf(l)%></td>
						<td class="text-center pt-4"><%=l.getTitolo()%></td>
						<td class="text-center pt-4"><%=l.getAutore()%></td>
						<td class="text-center pt-4"><%=l.getIsbn()%></td>
						<td class="text-center pt-4">
							<i class="fas fa-check-square fa-2x verde"></i> 
							<i class="fas fa-minus-square fa-2x magenta"></i>
							<a data-toggle="collapse" data-target="#demo<%=listaLibri.indexOf(l)%>" role="button" aria-expanded="false" aria-controls="collapseExample"> 
								<i class="fas fa-pen-square fa-2x text-white"></i>
							</a> 
							
						</td>
					</tr>
					<tr>
                            <td colspan="6" class="hiddenRow bgcoll">
                                <div id="demo2" class="collapse">
                                    <form method="post">
                                        <div class="form-row ">

                                            <div class="col-8 offset-2 pt-4">
                                                <form action="GestioneLibri" method="post">
                                                    <div class="form-row">
                                                        <div class="form-group col-xl-6 pt-1">


                                                            <label for="titoloid">Titolo </label>
                                                            <input type="text" name="titolo"
                                                                class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                                                id="titoloid" value="<%=l.getTitolo()%>" required>
                                                        </div>
                                                        <div class="form-group col-xl-6 pt-1">
                                                            <label for="casaid">Casa editrice</label>
                                                            <input type="text" name="casaeditrice"
                                                                class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                                                id="casaid" value="<%=l.getCasaEditrice()%>" required>
                                                        </div>
                                                    </div>


                                                    <div class="form-row">
                                                        <div class="form-group col-xl-6 pt-1">
                                                            <label for="genereid">Genere </label>
                                                            <input type="text" name="genere"
                                                                class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                                                id="genereid" value="<%=l.getGenere()%>" required>
                                                        </div>

                                                        <div class="form-group col-xl-6 pt-1">
                                                            <label for="isbnid">Codice ISBN</label>
                                                            <input type="number" name="isbn"
                                                                class="cazzo form-control pl-4 shadow p-1 mb-1"
                                                                id="isbnid value="<%=l.getIsbn()%>" required>
                                                        </div>
                                                    </div>

                                                    <div class="form-row">
                                                        <div class="form-group col-xl-6 pt-1">
                                                            <label for="qtid">Quantita</label>
                                                            <input type="number" name="quantita"
                                                                class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                                                id="qtid" value="<%=l.getQuantita()%>" required>
                                                        </div>


                                                        <div class="form-group col-xl-6 pt-1">
                                                            <label for="prezzoid">Prezzo </label>
                                                            <input type="number" name="prezzo"
                                                                class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                                                id="prezzoid" value="<%=l.getPrezzo()%>" required>
                                                        </div>


                                                    </div>

                                                    <div class="form-row">
                                                        <label for="prezzoid">Trama</label>
                                                        <textarea name="trama" class="col-xl-12 p-3 b-none" value="<%=l.getTrama()%>" required></textarea>
                                                    </div>

                                                    <div class="form-row pt-4">
                                                    
                                                    	<div class="col-xl-2 pt-5">    
                                                            <span class="spy pr-3">Usato</span>
                                                            <label class="switch"> 
                                                                <input type="checkbox">
                                                             <span class="slider round"></span></label>
                                                    	</div>
                                                    
                                                    	<div class="offset-xl-1 col-xl-9">  
                                                        	<label for="imgid" class="col-2 pt-2">Immagine </label>
                                                        	<input type="file" name="immagine"
                                                            	class="form-control imm shadow mb-1 bg-white col-xl-12 pl-5 "
                                                            	id="imgid" alt="Submit">
                                                    	</div>
                                                    	
                                                    </div>
                                                
                                                <div class="text-center pt-4">
													<button type="submit" class="mt-2 py-2 pl-5 pr-5 mr-5 text-white shadow p-1 mb-5 " id="bottone">MODIFICA</button>
													<a data-toggle="collapse" data-target="#demo<%=listaLibri.indexOf(l)%>" role="button" aria-expanded="false" aria-controls="collapseExample">
														<button class="mt-2 py-2 pl-5 pr-5 text-white shadow p-1 mb-5" id="bottone" >ANNULLA</button>
													</a>

												</div>
                                                
                                              </form>
                                            </div>
                                        </div>
                                    </form>
                                </div>
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