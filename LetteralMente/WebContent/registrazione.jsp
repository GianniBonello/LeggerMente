<jsp:include page="/headerInterno.jsp"></jsp:include>
<div class="registrazione pt-5">
<%if(request.getAttribute("registrazione") != null && ((String)request.getAttribute("registrazione")).equals("errore")){ %>
<h3 class=" pt-5 pb-3 text-center text-danger">REGISTRAZIONE FALLITA</h3>
<h4 class=" pb-3 text-center text-danger">dati già esistenti</h4>
<%} %>
    <h1 class=" pt-5 pb-3 text-center"><b>Registrazione</b></h1>
   
    <div class="col-8 offset-2">
    <form action="Registrazione" method="post" >
      <div class="form-row">
        <div class="form-group col-md-12 pt-1" >
          <label for="nomeid">Nome </label>
          <input type="text" name="nome" class="form-control pl-4 shadow p-1 mb-1" id="nomeid" required >
        </div>
        <div class="form-group col-md-12 pt-1">
          <label for="cognomeid">Cognome </label>
          <input type="text" name="cognome" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="cognomeid" placeholder="" required >
        </div>
      </div>
      
      <div class="form-row">
          <div class="form-group col-xl-6 pt-1">
        	 <label for="cfid">Codice fiscale </label>
        	 <input type="text" name="cf" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="cfid" placeholder="" required >
          </div>
    
      <div class="form-group col-xl-6 pt-1">
        <label for="nascitaid">Data di nascita </label>
        <input type="date" name="dataDiNascita" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="nascitaid" placeholder="" required >
      </div>
       </div>
       
           <div class="form-row">
        <div class="form-group col-md-12 pt-1">
        <label for="emailid">Email </label>
        <input type="text" name="email" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="emailid" placeholder="" required >
       </div>
        </div>
        
        <div class="form-row">
          <div class="form-group col-xl-5 pt-1">
        <label for="indirizzoid">Indirizzo </label>
        <input type="text" name="indirizzo" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="indirizzoid" placeholder="" required >
          </div>
    
          <div class="form-group col-xl-5 pt-1">
            <label for="comuneid">Comune </label>
            <input type="text" name="comune" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="comuneid" placeholder="" required >
          </div>
          
          <div class="form-group col-xl-2 pt-1">
            <label for="capid">CAP </label>
            <input type="number" name="cap" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="capid" placeholder="" required >
          </div>
           </div>
        
              <div class="form-row">
        <div class="form-group col-md-12 pt-1">
        <label for="userid">Username </label>
        <input type="text" name="username" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="userid" placeholder="" required >
       </div>
        </div>
        
        <div class="form-row">
          <div class="form-group col-xl-6 pt-1">
        <label for="pwid">Password </label>
        <input type="password" name="password" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="pwid" placeholder="" required >
          </div>
    
      <div class="form-group col-xl-6 pt-1">
        <label for="cpwid">Conferma Password </label>
        <input type="password" name="confpassword" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="cpwid" placeholder="" required >
      </div>
       </div>
       
	     <a href="home">Sei gia registrato?</a>
	      <div class="text-center pt-4">
	      	  <button type="submit" class="mt-2 py-2 pl-5 pr-5 text-white shadow p-1 mb-5" id="bottone" type="submit">REGISTRATI</button>
	         <!--   <button type="submit" class="btn col-2 offset-5 py-2 pl-5 pr-5 text-white shadow p-1 mb-1 text-center" id="bottone"><b>REGISTRATI</b></button>-->
	      </div>
    </form>
    
       
    
    </div>
    
</div>
      <jsp:include page="/footer.jsp"></jsp:include>