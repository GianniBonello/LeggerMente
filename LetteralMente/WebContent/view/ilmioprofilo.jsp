
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="model.Utente"%>
<jsp:include page="/view/headerInterno.jsp"></jsp:include>

<%Utente u = (Utente)request.getSession().getAttribute("utenteLoggato"); %>

<div class="registrazione pt-5">

    <h1 class=" pt-5 pb-3 text-center"><b>Il mio profilo</b></h1>
    
    
    <div class="carta">
    
    </div>
    
    
    
  <form action="<%=request.getContextPath()%>/ModificaProfilo" method="post" >
    <div class="col-8 offset-2">
    
      <div class="form-row">
        <div class="form-group col-md-12 pt-1" >
          <label for="nomeid">Nome </label>
          <input type="text" name="nome" class="form-control pl-4 shadow p-1 mb-1" id="nomeid" value="<%=u.getNome()%>">
        </div>
        
        <div class="form-group col-md-12 pt-1">
          <label for="cognomeid">Cognome </label>
          <input type="text" name="cognome" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="cognomeid" value="<%=u.getCognome()%>">
        </div>
      </div>
      
      <div class="form-row">
          <div class="form-group col-xl-6 pt-1">
        	 <label for="cfid">Codice Fiscale </label>
        	 <input type="text" maxlength="16" name="cf" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="cfid" value="<%=u.getCf()%>">
          </div>
    
      	  <div class="form-group col-xl-6 pt-1">		<%DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");%>
        	<label for="nascitaid">Data di nascita: <%=u.getDataDiNascita().toGMTString()%> </label>											
        	<input type="date" name="datadinascita" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="nascitaid" value="<%=/*(LocalDate.parse(*/u.getDataDiNascita()/*.toString())).format(formatter)*/%>">
      	</div>
      </div>
       
      <div class="form-row">
        <div class="form-group col-xl-12 pt-1">
        	<label for="emailid">Email </label>
        	<input type="email" name="email" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="emailid" value="<%=u.getEmail()%>">
       	</div>
      </div>
        
      <div class="form-row">
          <div class="form-group col-xl-5 pt-1">
        	<label for="indirizzoid">Indirizzo </label>
        	<input type="text" name="indirizzo" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="indirizzoid" value="<%=u.getIndirizzo()%>">
          </div>
    
          <div class="form-group col-xl-5 pt-1">
            <label for="comuneid">Comune </label>
            <input type="text" name="comune" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="comuneid" value="<%=u.getComune()%>">
          </div>
          
          <div class="form-group col-xl-2 pt-1">
            <label for="capid">CAP </label>
            <input id="capid" type="number" maxlength="5" pattern="([0-9]|[0-9]|[0-9]|[0-9]|[0-9])" name="cap" class="form-control pl-4 shadow p-1 mb-1 bg-white"  value="<%=u.getCap()%>">
          </div>
       </div>
        
       <div class="form-row">
        	<div class="form-group col-xl-6 pt-1">
        		<label for="userid">Username </label>
        		<input type="text" name="username" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="userid" value="<%=u.getUsername()%>">
       		</div>
        
          	<div class="form-group col-xl-6 pt-1">
        		<label for="pwid">Email</label>
        		<input type="email" name="email" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="emailid" value="<%=u.getEmail()%>">
          	</div>
        </div>
    
    
      	  <div class="text-center pt-4">
      	  	<button type="submit" class="mt-2 py-2 pl-5 pr-5 text-white shadow p-1 mb-5 mr-5" id="bottone" >MODIFICA</button>
          	<a href="<%=request.getContextPath()%>/ControlloIniziale"><button type="submit" class="mt-2 py-2 pl-5 pr-5 text-white shadow p-1 mb-5" id="bottone" >ANNULLA</button></a>
      	  </div>
      	  <br>
      	  <%//TODO INSERIRE SCRITTA "iNSERISCI LA TUA PASSWORD PER CONFERMARE LA MODIFICA" %>
       <%//TODO cambiare tutti i campi: name %>
      <div class="form-row">
        <div class="form-group col-xl-12 pt-1">
        	<label for="emailid">INSERISCI LA PASSWORD </label>
        	<input type="email" name="password" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="pwid" value="<%=u.getEmail()%>">
       	</div>
      </div>
    
   	 </div>
   </form>
</div>



<jsp:include page="/view/footer.jsp"></jsp:include>