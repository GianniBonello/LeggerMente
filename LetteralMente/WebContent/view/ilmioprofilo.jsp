
<%@page import="Util.UtilityRicerca"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="model.Utente"%>
<jsp:include page="/view/headerInterno.jsp"/>
<%
	Utente u = (Utente)request.getSession().getAttribute("utenteLoggato"); 
	System.out.println(request.getAttribute("modifica"));
	// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	System.out.println(">--------------------------------------------------------------------------------------------<");
	 
	 LocalDate ld= LocalDate.parse(UtilityRicerca.dataString(u.getDataDiNascita()));
	 System.out.println(ld);
	 System.out.println(LocalDate.now());
	 System.out.println(">--------------------------------------------------------------------------------------------<");
%>

<div class="registrazione pt-5">

    <h1 class=" pt-5 pb-3 text-center"><b>Il mio profilo</b></h1>
    
    
    <div class="carta">
    	<div class="centercard">
            <div class="card">
              <div class="flip">
                <div class="frontcard">
                  <div class="strip-top"></div>
                  <div class="card-holder">Carta Utente</div>
                  <i class="fas fa-book fa-2x logocard" style="transform: rotate(-35deg); color:#ffffff;"></i>
                  <div class="investor"><b>Legger</b>Mente<br><span class="logo-text">Libreria di Roma </span></div>
                  <div class="chip">
                    <div class="chip-line"></div>
                    <div class="chip-line"></div>
                    <div class="chip-line"></div>
                    <div class="chip-line"></div>
                    <div class="chip-main"></div>
                  </div>
                  <svg class="wave" viewBox="0 3.71 26.959 38.787" width="26.959" height="38.787" fill="white">
                    <path d="M19.709 3.719c.266.043.5.187.656.406 4.125 5.207 6.594 11.781 6.594 18.938 0 7.156-2.469 13.73-6.594 18.937-.195.336-.57.531-.957.492a.9946.9946 0 0 1-.851-.66c-.129-.367-.035-.777.246-1.051 3.855-4.867 6.156-11.023 6.156-17.718 0-6.696-2.301-12.852-6.156-17.719-.262-.317-.301-.762-.102-1.121.204-.36.602-.559 1.008-.504z"></path>
                    <path d="M13.74 7.563c.231.039.442.164.594.343 3.508 4.059 5.625 9.371 5.625 15.157 0 5.785-2.113 11.097-5.625 15.156-.363.422-1 .472-1.422.109-.422-.363-.472-1-.109-1.422 3.211-3.711 5.156-8.551 5.156-13.843 0-5.293-1.949-10.133-5.156-13.844-.27-.309-.324-.75-.141-1.114.188-.367.578-.582.985-.542h.093z"></path>
                    <path d="M7.584 11.438c.227.031.438.144.594.312 2.953 2.863 4.781 6.875 4.781 11.313 0 4.433-1.828 8.449-4.781 11.312-.398.387-1.035.383-1.422-.016-.387-.398-.383-1.035.016-1.421 2.582-2.504 4.187-5.993 4.187-9.875 0-3.883-1.605-7.372-4.187-9.875-.321-.282-.426-.739-.266-1.133.164-.395.559-.641.984-.617h.094zM1.178 15.531c.121.02.238.063.344.125 2.633 1.414 4.437 4.215 4.437 7.407 0 3.195-1.797 5.996-4.437 7.406-.492.258-1.102.07-1.36-.422-.257-.492-.07-1.102.422-1.359 2.012-1.075 3.375-3.176 3.375-5.625 0-2.446-1.371-4.551-3.375-5.625-.441-.204-.676-.692-.551-1.165.122-.468.567-.785 1.051-.742h.094z"></path>
                  </svg>
                  <div class="end"><span class="end-text">codice : </span><span class="end-date pl-2">    <%=u.getIdUtente()%></span></div>
                  
                </div>
                <div class="backcard">
                  <div class="strip-black"></div>
                  <div class="ccv">
                    <label>Firma</label>
                    <div><%=u.getNome()%>  <%=u.getCognome()%></div>
                  </div>
                  <div class="terms">
                    <p>Questa card è di proprieta di LeggerMente, Libreria di Roma. L'utilizzo della card implica l'accettazione del regolamento, disponibile sul sito web www.leggermente.it.</p>
                    <p>Se ritrovata, restituire la carta al proprietario o alla nostra libreria.</p>
                  </div>
                </div>
              </div>
            </div>
          </div>
    </div>
    
 <%if(request.getAttribute("modifica") != null && (((String)request.getAttribute("modifica")).equals("passwordErrata") || ((String)request.getAttribute("modifica")).equals("passwordNonInserita"))){ %>
<h3 class=" pt-5 pb-3 text-center text-danger">MODIFICA FALLITA</h3>
<h4 class=" pb-3 text-center text-danger"><%=((String)request.getAttribute("modifica")).equals("passwordErrata")?"Password inserita incorretta!": "Inserisci la password per modificare i tuoi dati" %></h4>
<%}else if(request.getAttribute("modifica") != null && ((String)request.getAttribute("modifica")).equals("giaEsistenti")){%>
<h3 class=" pt-5 pb-3 text-center text-danger">MODIFICA FALLITA</h3>
<h4 class=" pb-3 text-center text-danger">Username o Email già esistenti!</h4>
<%}else if(request.getAttribute("modifica") != null && ((String)request.getAttribute("modifica")).equals("successo")) {%>
<h3 class=" pt-5 pb-3 text-center text-success">DATI MODIFICATI!</h3>
<%} else if (request.getAttribute("modifica") != null && ((String)request.getAttribute("modifica")).equals("campiNonModificabili")){
%>
<h3 class=" pt-5 pb-3 text-center text-danger">MODIFICA FALLITA</h3>
<h4 class=" pb-3 text-center text-danger">Per modificare Nome, Cognome e Codice Fiscale contattaci per email a:<br> leggermente.roma@gmail.com</h4>
<%} %>   
    
  <form class="needs-validation" novalidate action="<%=request.getContextPath()%>/ModificaProfilo" method="post" >
    <div class="col-8 offset-2">
    
      <div class="form-row">
        <div class="form-group col-md-12 pt-1" >
          <label for="nomeid">Nome </label>
          <input type="text" name="nome" maxlength="45" class="disabled form-control pl-4 shadow p-1 mb-1" id="nomeid" value="<%=u.getNome()%>" disabled>
		        
        </div>
        
        <div class="form-group col-md-12 pt-1">
          <label for="cognomeid">Cognome </label>
          <input type="text" maxlength="45" name="cognome" class="disabled form-control pl-4 shadow p-1 mb-1 bg-white" id="cognomeid" value="<%=u.getCognome()%>" disabled>
        </div>
      </div>
      
      <div class="form-row">
          <div class="form-group col-xl-6 pt-1">
        	 <label for="cfid">Codice Fiscale </label>
        	 <input type="text" pattern=".{16}" minlength="16" maxlength="16" pattern="([a-zA-Z]|[a-zA-Z]|[a-zA-Z]|[a-zA-Z]|[a-zA-Z]|[a-zA-Z]|[0-9]|[0-9]|[a-zA-Z]|[0-9]|[0-9]|[a-zA-Z]|[0-9]|[0-9]|[0-9]|[a-zA-Z])" name="cf" class="disabled form-control pl-4 shadow p-1 mb-1 bg-white" id="cfid" value="<%=u.getCf()%>" disabled>
          </div>
    
      	  <div class="form-group col-xl-6 pt-1">		
        	<label for="nascitaid">Data di nascita</label>											
        	<input  name="datadinascita" type="date" class=" disabled form-control pl-4 shadow p-1 mb-1 bg-white" id="nascitaid" value="<%=ld %>" disabled="disabled">
      	</div>
      </div> 
       
      
        
      <div class="form-row">
          <div class="form-group col-xl-5 pt-1">
        	<label for="indirizzoid">Indirizzo </label>
        	<input type="text" name="indirizzo" maxlength="45" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="indirizzoid" value="<%=u.getIndirizzo()%>">
          <div class="invalid-feedback">Inserisci un'indirizzo valido!</div>
          <div class="valid-feedback">Ok!</div>
          </div>
    
          <div class="form-group col-xl-5 pt-1">
            <label for="comuneid">Comune </label>
            <input type="text" name="comune" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="comuneid" value="<%=u.getComune()%>">
          <div class="invalid-feedback">Inserisci un comune valido!</div>
          <div class="valid-feedback">Ok!</div>
          </div>
          
          <div class="form-group col-xl-2 pt-1">
            <label for="capid">CAP </label>
            <input id="capid" type="number" maxlength="5" pattern="([0-9]|[0-9]|[0-9]|[0-9]|[0-9])" 
            oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" 
            name="cap" class="form-control pl-4 shadow p-1 mb-1 bg-white"  value="<%=u.getCap()%>">
         <div class="invalid-feedback">Inserisci un CAP valido!</div>
          <div class="valid-feedback">Ok!</div>
          </div>
       </div>
        
       <div class="form-row">
        	<div class="form-group col-xl-6 pt-1">
        		<label for="userid">Username </label>
        		<input type="text" name="username" maxlength="45" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="userid" value="<%=u.getUsername()%>">
       		 <div class="invalid-feedback">Inserisci un'username valido!</div>
       		 <div class="valid-feedback">Ok!</div>
       		</div>
        
          	<div class="form-group col-xl-6 pt-1">
        		<label for="pwid">Email</label>
        		<input type="email" name="email" maxlength="45" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="emailid" value="<%=u.getEmail()%>">
          	<div class="invalid-feedback">Inserisci un'email valida!</div>
          	 <div class="valid-feedback">Ok!</div>
          	</div>
        </div>
    	<br>
    	<hr>
      	<br>
      	
      	  <%//TODO INSERIRE SCRITTA "iNSERISCI LA TUA PASSWORD PER CONFERMARE LA MODIFICA" %>
       <%//TODO cambiare tutti i campi: name %>
      <div class="form-row">
        <div class="form-group col-xl-6 pt-1 justify-content-center m-auto text-center">
        	<p>Inserisci la password per confermare la modifica</p>
        	<input type="password" name="password" minlength="8" maxlength="20" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="pwid">
        	<div class="invalid-feedback">Inserisci una password valida!</div>
          	<div class="valid-feedback">Ok!</div>
       	</div>
      </div>
      <div class="text-center pt-4">
      	  	<button type="submit" class="mt-2 py-2 pl-5 pr-5 text-white shadow p-1 mb-5 mr-5" id="bottone" >MODIFICA</button>
      	  	<a href="<%=request.getContextPath()%>/ControlloIniziale" class="button mt-2 py-2 pl-5 pr-5 text-white shadow p-1 mb-5">ANNULLA</a>
      </div>
    
   	 </div>
   </form>
</div>



<jsp:include page="/view/footer.jsp"></jsp:include>