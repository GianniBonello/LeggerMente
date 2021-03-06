<%@page import="java.util.List"%>
<%@page import="model.Libro"%>
<jsp:include page="/view/header.jsp"></jsp:include>
<%@ page contentType="text/html; charset=ISO-8859-1" %> 
   
    <main>
        
        <div class="container">
            <div class="bgindex"></div>
        <!-- I NOSTRI SERVIZI -->

            <div class="row ">
                <div class="col-6 offset-3 " id="inostriservizi">
                    <h1 class="text-center" id="serv"><b>I nostri servizi</b></h1>
                    <h6 id="tratt" ><img class="pr-3" src="res/trattino.png" alt="trattino"><i>Come funziona</i></h6>
                </div>
            </div>
            
            
            <div class="row mt-5 mb-5">
                <div class="col-4 text-center pt-5">
                    <i class="fas fa-desktop fa-7x"></i>
                    <h5 class="mt-5">SCEGLI</h5>
                    <div class="col-8 offset-2 pt-3"><p> Naviga tra una vasta scelta di libri e scegli quello che preferisci.</p></div>
                </div>
                    
                <div class="col-4 text-center pt-5">
                    <i class="fas fa-cart-arrow-down fa-7x"></i>
                    <h5 class="mt-5">PRENOTA</h5>
                    <div class="col-8 offset-2 pt-3"><p> Quando avrai scelto il libro che fa per te, decidi se prenotare un acquisto o un noleggio. </p></div>
                </div>
                    
                <div class="col-4 text-center pt-5">
                    <i class="fas fa-people-carry fa-7x"></i>
                    <h5 class="mt-5">RITIRA</h5>
                    <div class="col-8 offset-2 pt-3"><p> Vieni a trovarci in negozio per ritirare e pagare il tuo libro.</p></div>
                </div>
            </div>
            
            <!-- CHI SIAMO -->
        
            <div class="row spazio">
            
                <div class="col-6 mt-5 " id="chisiamo">
            
                    <div class="bg-white mt-4 box" id="boxbianco">
                        <h1 class=" pt-5 pl-4" id="serv"><b>Chi siamo</b></h1>
                        <h6 id="trattdue"><img class="pr-3" src="res/trattino.png" alt="trattino">La nostra libreria</h6>
             
                        <p class="mt-3 apici">''</p>
                        <p class=" pl-4" id="staff">Lo scopo di LeggerMente è ridare valore alle librerie indipendenti facendo incontrare i più innovativi strumenti di internet con la migliore tradizione libraia. La nostra forza è una rete di persone che abbraccia e sostiene il mondo dei libri: dall'editore, passando per il libraio e raggiungendo infine il lettore.</p>
                        <p class=" text-right apicidue">''</p>
                    </div>
                </div>
            
                <div  class="col-6">
                    <img id="spostaASinistra" src="res/chisiamo.jpg" width="600px" height="600px" alt="">
                </div>
            </div>            
            
            <!-- LISTA LIBRI -->
            
                    <div class="mt-5" id="listalibri">
                        <h1 class=" pt-5 pl-4" id="serv"><b>Lista Libri</b></h1>
                        <h6 id="trattdue"><img class="pr-3" src="res/trattino.png" alt="trattino">Il nostro catalogo</h6>
                            
                                      
<%                                               
Libro[][]fedetrice= (Libro[][])request.getAttribute("matriceLibri");                         
Libro libroCollapse=new Libro();
if(fedetrice!=null){
	for(int i = 0; i < fedetrice.length ; i++) {
%>		
						<div class="row text-center pt-5 pb-5">
<%		
		for(int k = 0; k < fedetrice[i].length ; k++){
			Libro l = fedetrice[i][k];
			if(l!=null){
%>
                            <div class="libro col-xl-4 pt-5">
                                    <img src="<%=l.getImmagine_path() %>"  class="w-75" style=" height:375px;">
                                    <button id="bott" class="btn btn-dark w-75 text-center botcollapse" style="height:50px;background: #C80258; border: none;"  onclick="info('<%=l.getAutore()%>','<%=l.getCasaEditrice()%>','<%=l.getGenere()%>','<%=l.getIsbn()%>','<%=l.getIsUsato()%>','<%=l.getPrezzo()%>','<%=l.getQuantita()%>','<%=l.getTitolo()%>','<%=l.getTrama()%>','<%=l.getImmagine_path()%>','<%=i%>')"><b style="font-size:14pt;">INFO</b></button>                        
                            </div>
  
<%          }                     %>
<%       }                        %>
                        
                            <div class=" col-xl-12 poplibro confine shadow p-5 mb-2 bg-white d-none mt-5 descrcollapse<%=i %>" id="descr"> 
                            
                            <!-- ------------------------------------------ -->    
                            
                             `<div class="row ">
		                                  <div class="copertina col-xl-4 pt-3 text-center">
		                                    <img id="immagine<%=i %>" src="`+immagine_path+`" height="375px" alt="" class="w-75 mb-5">
		                                    <p class="text-left inter"><b>AUTORE:</b></p>
		                                    <hr class="w-75">
		                                    <p id ="autore<%=i %>" class="text-left interdue autore">`+autore+`</p>
		                                    <br>
		                                    <p class="text-left inter"><b>CASA EDITRICE:</b></p>
		                                    <hr class="w-75">
		                                    <p id ="casaEditrice<%=i %>" class="text-left interdue casaEditrice">`+casaEditrice+`</p>
		                            
		                                  </div>
		                                  <div class="col-xl-7 offset-1 pt-3">
		                                    <h2 id ="titolo<%=i %>" class="mb-5 text-left titolo">`+titolo+`</h2>
		                                      <div class="descrizioneinfo">
		                                        <p class="text-left  pt-3" style="font-size: 16pt;"><b>DESCRIZIONE</b></p>
		                                        <p id ="trama<%=i %>" class="text-left justify-content pt-3 trama">`+trama+`</p>
											</div>
										  </div>
										  <!-- disponibile acquisto --> 
											<div id="divDisponibileAcquisto<%=i %>" class="row pt-5 pb-5 divDisponibileAcquisto">
												<i class="fas fa-circle fa-2x" style="color:#06A500"></i><p class="col-xl-5 text-left" style="font-size: 16pt;"><b>DISPONIBILE</b></p>							
												<p class="col-xl-6 pl-3" style="font-size: 16pt;"><b id="prezzoDisponibile<%=i %>">PREZZO : 0.0 &euro;</b></p>
											</div>
											 <!-- esaurito acquisto --> 
											<div id="divEsauritoAcquisto<%=i %>" class="row pt-5 pb-5 divEsauritoAcquisto">
												 <i class="fas fa-circle fa-2x" style="color:#FF0000"></i><p class="col-xl-5 text-left" style="font-size: 16pt;"><b>ESAURITO</b></p>
												 <p class="col-xl-6 pl-3" style="font-size: 16pt;"><b id="prezzoEsaurito<%=i %>">PREZZO : 0.0 &euro;</b></p>
											</div>
											 <!-- disponibile noleggio --> 
											 <div id="divDisponibileNoleggio<%=i %>" class="row pt-5 pb-5 divDisponibileNoleggio">
												<i class="fas fa-circle fa-2x" style="color:#06A500"></i><p class="col-xl-5 text-left" style="font-size: 16pt;"><b>DISPONIBILE</b></p>							
											</div>
											  <!-- esaurito noleggio --> 
											  <div id="divEsauritoNoleggio<%=i %>" class="row pt-5 pb-5 divEsauritoNoleggio">
												 <i class="fas fa-circle fa-2x" style="color:#FF0000"></i><p class="col-xl-5 text-left" style="font-size: 16pt;"><b>ESAURITO</b></p>
											</div>
										
											<button id="bottvar<%=i %>" type="submit" class="float-left text-white shadow mb-2 bottvar">PRENOTA</button>
																		
                                </div>
                              <!-- -------------------------------------------------- -->                                   
                            </div>
           			</div>
<%    }                     %>
<%}                        %>
                    
            </div>
        </div>
            
    </main>


<!-- SCROLL TO THE TOP -->

<div id="go_top">
    <a href="#" onclick="scrollTop()"><i class="far fa-arrow-alt-circle-up"></i></a>
</div>

            <!-- GOOGLE MAPS -->

<div class="pt-5"></div>

 <div class="googlemaps" style="-webkit-filter: grayscale(100%); filter: grayscale(100%);">
    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2497.026635377596!2d12.547151487822997!3d41.90399947302919!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x132f63cbb13acd2b%3A0x53d00747ea90d2e2!2sELIS!5e0!3m2!1sit!2sit!4v1604617465139!5m2!1sit!2sit" width="100%" height="400px" frameborder="0" style="border:0; background:rgba(0,0,0,0.8);" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
 </div>

 <jsp:include page="/view/footer.jsp"></jsp:include>
