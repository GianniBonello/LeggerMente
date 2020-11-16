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
							<i class="fas fa-minus-square fa-2x magenta" style="cursor:pointer;"></i>
						</td>
					</tr>
					<tr>
                            <td colspan="6" class="hiddenRow bgcoll">
                                <div id="demo<%=listaLibri.indexOf(l)%>" class="collapse">
                                        <div class="form-row">

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
                                                                id="isbnid" value="<%=l.getIsbn()%>" required>
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
                                                        <textarea name="trama" class="col-xl-12 p-3 b-none" required><%=l.getTrama()%></textarea>
                                                    </div>

                                                    <div class="form-row pt-4">
                                                    
                                                    	<div class="col-xl-12">  
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
                                
                                </div>
                            </td>
                        </tr>
					
						<%
						}
					%>
					</tbody>
					
				</table>
										
										<div class="m-auto justify-content-center"  >
											<i class="fas fa-plus-square fa-3x mb-5 mt-3" style="color:white; opacity:0.9; cursor:pointer;" data-toggle="collapse" href="#aggiungicollapse" aria-expanded="false" aria-controls="aggiungicollapse"></i>
										</div>
										
                                            <div class="col-xl-12 pt-4 collapse mb-5" style="background-color: rgba(255,255,255,0.6); border-radius:25px" id="aggiungicollapse">
                                                <h1 class="pt-5 text-center text-dark pb-5"><b>Aggiungi Libro</b></h1>
                                                
                                                <form action="<%=request.getContextPath()%>/GestioneLibri" method="post">
                                                    <div class="form-row">
                                                        <div class="form-group col-xl-6 pt-1 ">


                                                            <label for="titoloid" class="text-dark">Titolo </label>
                                                            <input type="text" name="titolo"
                                                                class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                                                id="titoloid">
                                                        </div>
                                                        <div class="form-group col-xl-6 pt-1">
                                                            <label for="casaid" class="text-dark">Casa editrice</label>
                                                            <input type="text" name="casaeditrice"
                                                                class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                                                id="casaid">
                                                        </div>
                                                    </div>


                                                    <div class="form-row">
                                                        <div class="form-group col-xl-6 pt-1">
                                                            <label for="genereid" class="text-dark">Genere </label>
                                                            <input type="text" name="genere"
                                                                class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                                                id="genereid">
                                                        </div>

                                                        <div class="form-group col-xl-6 pt-1">
                                                            <label for="isbnid" class="text-dark">Codice ISBN</label>
                                                            <input type="number" name="isbn"
                                                                class="cazzo form-control pl-4 shadow p-1 mb-1"
                                                                id="isbnid" >
                                                        </div>
                                                    </div>

                                                    <div class="form-row">
                                                        <div class="form-group col-xl-6 pt-1">
                                                            <label for="qtid" class="text-dark">Quantita</label>
                                                            <input type="number" name="quantita"
                                                                class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                                                id="qtid" required>
                                                        </div>


                                                        <div class="form-group col-xl-6 pt-1">
                                                            <label for="prezzoid" class="text-dark">Prezzo </label>
                                                            <input type="number" name="prezzo"
                                                                class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                                                id="prezzoid" >
                                                        </div>


                                                    </div>

                                                    <div class="form-row">
                                                        <label for="prezzoid" class="text-dark">Trama</label>
                                                        <textarea name="trama" class="col-xl-12 p-3 b-none" ></textarea>
                                                    </div>

                                                    <div class="form-row pt-4">
                                                    
                                                    <form enctype="multipart/form-data">
                                                    	<div class="col-xl-12">  
                                                        	<label for="imgid" class="col-2 pt-2 text-dark" >Immagine </label>
                                                        	<input type="file" name="immagine"
                                                            	class="form-control imm shadow mb-1 bg-white col-xl-12 pl-5 "
                                                            	id="imgid" alt="Submit">
                                                    	</div>
                                                    </form>
                                                    	
                                                    </div>
                                                
                                                <div class="text-center pt-4">
													<button type="submit" class="mt-2 py-2 pl-5 pr-5 mr-5 text-white shadow p-1 mb-5 " id="bottone">AGGIUNGI</button>
												</div>
                                                
                                              </form>
                                            </div>
                                        </div>
			</div>
		</div>
	  </div>
	</main>
</div>

        

<jsp:include page="/view/footerstaff.jsp"></jsp:include> 