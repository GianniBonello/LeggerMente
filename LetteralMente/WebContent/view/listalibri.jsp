<%@page import="model.Libro"%>
<%@page import="java.util.List"%>

<jsp:include page="/view/headerInterno.jsp"></jsp:include>

<div class="container">
    <main>
        <div class="mt-5" id="listalibri">
            <h1 class=" pt-5 pl-4" id="serv"><b>Lista Libri</b></h1>
            <h6 id="trattdue"><img class="pr-3" src="<%=request.getContextPath()%>/res/trattino.png" alt="trattino">Il nostro catalogo</h6>
        
            <div class="row ">
                <!-- CERCA LIBRI  -->
                <form action="listalibri.jsp" method="post"></form>
                    <div class="cercaLibro pt-5 pl-5 col-md-12 col-xl-5">
                        <!-- CERCA LIBRI HOME -->
                            <div class="input-group">
                                <span class="input-group-append">
                                    <p class="input-group-text py-2 shadow" style="z-index: 2;"><i class="fa fa-search"></i></p>
                                   </span>
                                <input class="form-control py-2 bg-light border-radius-5 shadow " name="cercaLibro" type="search" placeholder="Inserisci il titolo del libro" id="example-search-input" >  
                            </div> 
                    </div>
                    <div class="filtraLibro pt-5 pl-5 col-md-12 col-xl-3">
                        <div class="input-group mb-3">
                            <p class="pt-2 pr-3">Cerca per :</p>
                            <select class="custom-select bg-light shadow " id="inputGroupSelect01">
                                <option selected value="titolo">Titolo</option>
                                <option value="genere">Genere</option>
                                <option value="autore">Autore</option>
                                <option value="casaeditrice">Casa Editrice</option>
                            </select>
                        </div>
                    </div>
                    <div class="ordinaLibro pt-5 pl-5 col-md-12 col-xl-4">
                        <div class="input-group mb-3">
                            <p class="pt-2 pr-3">Ordina per :</p>
                            <select class="custom-select bg-light shadow " id="inputGroupSelect01">
                            	<option selected value="ultimi-arrivi">Ultimi arrivi</option>
                                <option value="autore-cresc">Autore : dalla A alla Z</option>
                                <option value="autore-decr">Autore : dalla Z alla A</option>
                                <option value="prezzo-cresc">Prezzo : crescente</option>
                                <option value="prezzo-decr">Prezzo : decrescente</option>
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
                                    <img src="<%=l.getImmagine_path() %>"  class="w-75" style="height:375px;">
                                   <a href="DettaglioLibro?idLibro=<%=l.getId_libro()%>"><button id="bott" class="btn btn-dark w-75 text-center botcollapse" style="height:50px;background: #C80258; border: none;"><b style="font-size:14pt;">INFO</b></button></a>                      
                            </div>
  
					<% 		} 
								} %>
           			   
                </div>
            </div>
    </main>

</div>

<jsp:include page="/view/footer.jsp"></jsp:include>