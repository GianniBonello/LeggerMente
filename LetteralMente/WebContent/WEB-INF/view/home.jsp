<%@page import="model.Utente"%>
<%@page import="java.util.List"%>
<%@page import="model.Libro"%>
<jsp:include page="/view/header.jsp"></jsp:include>

<main>

	<div class="container">
		<div class="bgindex"></div>
		<!-- I NOSTRI SERVIZI -->
		<div id="inostriservizi" class=" mt-5 mb-5" style="padding-top: 50px;"></div>
		<div class="row ">
			<div class="col-lg-12 col-xl-6 offset-lg-1 offset-xl-3 pt-5">
				<h1 class="text-center" id="serv">
					<b>I nostri servizi</b>
				</h1>
				<h6 id="tratt">
					<img class="pr-3"
						src="<%=request.getContextPath()%>/res/trattino.png"
						alt="trattino"><i>Come funziona</i>
				</h6>
			</div>
		</div>


		<div class="row mt-5 mb-5">
			<div class="col-lg-12 col-xl-4 text-center pt-5">
				<i class="fas fa-desktop fa-7x"></i>
				<h5 class="mt-5">SCEGLI</h5>
				<div class="col-8 offset-2 pt-3">
					<p>Naviga tra una vasta scelta di libri e scegli quello che
						preferisci.</p>
				</div>
			</div>

			<div class="col-lg-12 col-xl-4 text-center pt-5">
				<i class="fas fa-cart-arrow-down fa-7x"></i>
				<h5 class="mt-5">PRENOTA</h5>
				<div class="col-8 offset-2 pt-3">
					<p>Quando avrai scelto il libro che fa per te, decidi se
						prenotare un acquisto o un noleggio.</p>
				</div>
			</div>

			<div class="col-lg-12 col-xl-4 text-center pt-5 ">
				<i class="fas fa-people-carry fa-7x"></i>
				<h5 class="mt-5 ">RITIRA</h5>
				<div class="col-8 offset-2 pt-3 ">
					<p>Vieni a trovarci in negozio per ritirare e pagare il tuo
						libro.</p>
				</div>
			</div>
		</div>
		<div class=" mt-5 mb-5" style="padding-top: 100px;"></div>

		<!-- CHI SIAMO -->

		<div class="row" id="chisiamo" style="padding-top: 100px;">
			<div id="chisiamo" class="spazio mt-5 mb-5"></div>
			<div class="col-md-12 col-lg-6 col-xl-6 mt-5 ">

				<div class="bg-white mt-4 box" id="boxbianco">
					<h1 class=" pt-5 pl-4" id="serv">
						<b>Chi siamo</b>
					</h1>
					<h6 id="trattdue">
						<img class="pr-3 img-fluid"
							src="<%=request.getContextPath()%>/res/trattino.png"
							alt="trattino">La nostra libreria
					</h6>

					<p class="mt-3 apici">''</p>
					<p class=" pl-4" id="staff">Lo scopo di LeggerMente è ridare
						valore alle librerie indipendenti facendo incontrare i più
						innovativi strumenti di internet con la migliore tradizione
						libraia. La nostra forza è una rete di persone che abbraccia e
						sostiene il mondo dei libri: dall'editore, passando per il libraio
						e raggiungendo infine il lettore.</p>
					<p class=" text-right apicidue">''</p>
				</div>
			</div>

			<div class="col-md-12 col-xl-6">
				<img id="spostaASinistra"
					src="<%=request.getContextPath()%>/res/chisiamo.jpg" width="600px"
					height="600px" alt="">
			</div>
		</div>

		<!-- LISTA LIBRI -->

		<div class="mt-5" id="listalibri">
			<h1 class=" pt-5 pl-4" id="serv">
				<b>Lista Libri</b>
			</h1>
			<h6 id="trattdue">
				<img class="pr-3"
					src="<%=request.getContextPath()%>/res/trattino.png" alt="trattino">Il
				nostro catalogo
			</h6>


			<%                                               
List<Libro> lista= (List<Libro>)request.getAttribute("listaLibri");                         
if(lista!=null){
%>
			<div class="row text-center pt-5 pb-5">
				<%		
		for(Libro l : lista){
			//if(l!=null){
%>
				<div class="libro col-xl-4 pt-5">
					<img src="<%=l.getImmagine_path() %>" class="w-75 img-fluid"
						style="height: 375px;"> <a
						href="DettaglioLibro?idLibro=<%=l.getId_libro()%>"><button
							id="bott" class="btn btn-dark w-75 text-center botcollapse"
							style="height: 50px; background: #C80258; border: none;">
							<b style="font-size: 14pt;">INFO</b>
						</button></a>
				</div>

				<%          }                     %>
				<%       }                        %>
			</div>
			
			<hr>
			
			<a href="<%=request.getContextPath()%>/ListaLibri">
				<button class="col-md-12 offset-md-0 offset-xl-1 col-xl-10 mt-5" style="background-color:#1C1C1C;font-size:14pt;">TUTTI I LIBRI</button>
			</a>
			
		</div>
	</div>

</main>


<!-- SCROLL TO THE TOP -->

<div id="go_top">
	<a href="#" onclick="scrollTop()"><i
		class="far fa-arrow-alt-circle-up"></i></a>
</div>

<!-- GOOGLE MAPS -->

<div class="spazio pt-5"></div>

<div class="googlemaps"
	style="-webkit-filter: grayscale(100%); filter: grayscale(100%);">
	<iframe
		src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2497.026635377596!2d12.547151487822997!3d41.90399947302919!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x132f63cbb13acd2b%3A0x53d00747ea90d2e2!2sELIS!5e0!3m2!1sit!2sit!4v1604617465139!5m2!1sit!2sit"
		width="100%" height="400px" frameborder="0"
		style="border: 0; background: rgba(0, 0, 0, 0.8);" allowfullscreen=""
		aria-hidden="false" tabindex="0"></iframe>
</div>

<jsp:include page="/view/footer.jsp"></jsp:include>

