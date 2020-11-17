<%@page import="model.Libro"%>
<%@page import="java.util.List"%>

<jsp:include page="/view/headerInterno.jsp"></jsp:include>

<div class="container">
    <main>
        <div class="mt-5" id="listalibri">
            <h1 class=" pt-5 pl-4" id="serv"><b>Lista Libri</b></h1>
            <h6 id="trattdue"><img class="pr-3" src="<%=request.getContextPath()%>/res/trattino.png" alt="trattino">Il nostro catalogo</h6>
        <form action="<%=request.getContextPath()%>/ListaLibri" method="post">
            <div class="row ">
                <!-- CERCA LIBRI  -->
                
                    <div class="cercaLibro pt-5 col-md-12 col-xl-5">
                        <!-- CERCA LIBRI HOME -->
                            <div class="input-group">
                                	<span class="input-group-append">
                                    	<p class="input-group-text py-2 shadow" style="z-index: 2;"><button type="submit" style="padding:0px!important"><i class="fa fa-search" ></i></button></p>
                                 	</span>
                                <input class="form-control py-2 bg-light border-radius-5 shadow " name="ricerca" type="search" placeholder="Inserisci il titolo del libro" id="example-search-input" >  
                            </div> 
                    </div>
                    <div class="filtraLibro pt-5  col-md-12 col-xl-2">
                        <div class="input-group mb-3">
                            <select name ="campo" class="custom-select bg-light shadow " id="inputGroupSelect01">
                            	<option selected disabled>Cerca per :</option>
                                <option value="titolo">Titolo</option>                         
                                <option value="autore">Autore</option>
                                 <option value="casaeditrice">Casa Editrice</option>
                                 <option value="genere">Genere</option>
                               
                            </select>
                        </div>
                    </div>
                    <div class="ordinaLibro pt-5  col-md-12 col-xl-3">
                        <div class="input-group mb-3">
                            <select class="custom-select bg-light shadow " id="inputGroupSelect01">
                            	<option selected disabled>Ordina per :</option>
                            	<option id="ultimiarrivi" value="ultimi-arrivi">Ultimi arrivi</option>
                                <option id="aut-cres" value="autore-cresc" >Autore : dalla A alla Z</option>
                                <option id="aut-decr" value="autore-decr">Autore : dalla Z alla A</option>
                                <option id="prezzo-cres" value="prezzo-cresc">Prezzo : crescente</option>
                                <option id="prezzo-decr" value="prezzo-decr">Prezzo : decrescente</option>
                            </select>
                        </div>
                    </div>
                    <div class="tipoLibro pt-5 col-md-12 col-xl-2">
                    <div class="input-group mb-3">
                            <select class="custom-select bg-light shadow " id="inputGroupSelect01">
                            	<option selected disabled>Stato :</option>
                            	<option id="tutti" value="tutti">Tutti i libri</option>
                                <option id="nol" value="nol" >Noleggiabili</option>
                                <option id="acq" value="acq">Acquistabili</option>
                            </select>
                        </div>
                    </div>         
                </form>
            </div>

                <div class="row text-center pt-5 pb-5">
                                      
					<%                                               
						List<Libro> lista= (List<Libro>)request.getAttribute("listaLibri");                         
							if(lista!=null){	
								for(Libro l : lista){
						//if(l!=null){
					%>
                            <div class="libro col-xl-4 pt-5">
                            		<div class="d-none">
                            			<div class="isbn">		<%= l.getIsbn() %>		</div>
                            			<div class="autore">	<%= l.getAutore() %>	</div>
                            			<div class="editore">	<%= l.getCasaEditrice()%></div>
                            			<div class="genere">	<%= l.getGenere() %>	</div>
                            			<div class="isUsato">	<%= l.getIsUsato() %>	</div>
                            			<div class="prezzo">	<%= l.getPrezzo() %>	</div>
                            			<div class="quantita">	<%= l.getQuantita() %>	</div>
                            			<div class="titolo">	<%= l.getTitolo() %>	</div>
                            			<div class="trama">		<%= l.getTrama() %>		</div>
                            		</div>                      		
                                    <img src="<%=l.getImmagine_path() %>"  class="immaginepath w-75 img-fluid" style="height:375px;" >
                                   <a class="idLibro" href="DettaglioLibro?idLibro=<%=l.getId_libro()%>"><button id="bott" class="btn btn-dark w-75 text-center botcollapse" style="height:50px;background: #C80258; border: none;"><b style="font-size:14pt;">INFO</b></button></a>                      
                            </div>
  
					<% 		} 
								} %>
           			   
                </div>
            </div>
    </main>

</div>

<jsp:include page="/view/footer.jsp"></jsp:include>