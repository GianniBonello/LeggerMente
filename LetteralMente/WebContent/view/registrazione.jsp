
<%@ page contentType="text/html; charset=ISO-8859-1" %>
<div class="registrazione pt-5">

<h1 class=" pt-5 pb-3 text-center"><b>Registrazione</b></h1>


<%if(request.getAttribute("registrazione") != null && ((String)request.getAttribute("registrazione")).equals("errore")){ %>
<h3 class=" pt-5 pb-3 text-center text-danger">REGISTRAZIONE FALLITA</h3>
<h4 class=" pb-3 text-center text-danger">Dati inseriti gi� esistenti!</h4>
<%}else if(request.getAttribute("registrazione") != null && ((String)request.getAttribute("registrazione")).equals("erroreData")){ %>
<h3 class=" pt-5 pb-3 text-center text-danger">REGISTRAZIONE FALLITA</h3>
<h4 class=" pb-3 text-center text-danger">Data di nascita inserita non valida!</h4>
<%}else if(request.getAttribute("registrazione") != null && ((String)request.getAttribute("registrazione")).equals("passwordcorta")){ %>
<h3 class=" pt-5 pb-3 text-center text-danger">REGISTRAZIONE FALLITA</h3>
<h4 class=" pb-3 text-center text-danger">Inserisci una password di minimo 8 caratteri!</h4>
<%} %>
    
   
    <div class="col-8 offset-2">
    <form class="needs-validation"  action="<%=request.getContextPath()%>/Registrazione" name="modulo2" method="post" onsubmit="return validate(this)" novalidate>
      <div class="form-row">
        <div class="form-group col-md-12 pt-1" >
          <label for="nomeid">Nome </label>
          <input type="text" name="nome" maxlength="45" class="form-control pl-4 shadow p-1 mb-1" id="nomeid" required >
          <div class="invalid-feedback">Inserisci un nome valido!</div>
          <div class="valid-feedback">Ok!</div>
        </div>
        <div class="form-group col-md-12 pt-1">
          <label for="cognomeid">Cognome </label>
          <input type="text" name="cognome" maxlength="45" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="cognomeid" required>
          <div class="invalid-feedback">Inserisci un cognome valido!</div>
          <div class="valid-feedback">Ok!</div>   
        </div>
      </div>
      
      <div class="form-row">
          <div class="form-group col-xl-6 pt-1">
        	 <label for="cfid">Codice fiscale </label>
        	 <input type="text" name="cf" pattern=".{16}" minlength="16" maxlength="16" pattern="([a-zA-Z]|[a-zA-Z]|[a-zA-Z]|[a-zA-Z]|[a-zA-Z]|[a-zA-Z]|[0-9]|[0-9]|[a-zA-Z]|[0-9]|[0-9]|[a-zA-Z]|[0-9]|[0-9]|[0-9]|[a-zA-Z])" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="cfid" style="text-transform:uppercase"  required >
        	 <div class="invalid-feedback">Inserisci un codice fiscale valido!</div>
        	 <div class="valid-feedback">Ok!</div>
          </div>
    
      <div class="form-group col-xl-6 pt-1">
        <label for="nascitaid">Data di nascita </label>
        <input type="date" name="dataDiNascita"  class="form-control pl-4 shadow p-1 mb-1 bg-white" id="nascitaid"  required >
      <div class="invalid-feedback">Inserisci una data di nascita valida!</div>
      <div class="valid-feedback">Ok!</div>
      </div>
       </div>
       
           <div class="form-row">
        <div class="form-group col-md-12 pt-1">
        <label for="emailid">Email </label>
        <input type="email" name="email" maxlength="100" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="emailid" required >
      	<div class="invalid-feedback">Inserisci un'email valida!</div>
      	<div class="valid-feedback">Ok!</div>
		</div>
        </div>
        
        <div class="form-row">
          <div class="form-group col-xl-5 pt-1">
        <label for="indirizzoid">Indirizzo </label>
        <input type="text" name="indirizzo" maxlength="45"  class="form-control pl-4 shadow p-1 mb-1 bg-white" id="indirizzoid" required >
          <div class="invalid-feedback">Inserisci un'indirizzo valido!</div>
          <div class="valid-feedback">Ok!</div>
          </div>
    
          <div class="form-group col-xl-5 pt-1">
            <label for="comuneid">Comune </label>
            <input type="text" name="comune" maxlength="45" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="comuneid" required >
          <div class="invalid-feedback">Inserisci un comune valido!</div>
          <div class="valid-feedback">Ok!</div>
          </div>
          
          <div class="form-group col-xl-2 pt-1">
            <label for="capid">CAP </label>
            <input type="number" maxlength="5" pattern="([0-9]|[0-9]|[0-9]|[0-9]|[0-9])" oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" name="cap" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="capid" required >
          <div class="invalid-feedback">Inserisci un CAP valido!</div>
          <div class="valid-feedback">Ok!</div>
          </div>
           </div>
        
              <div class="form-row">
        <div class="form-group col-md-12 pt-1">
        <label for="userid">Username </label>
        <input type="text" name="username" maxlength="45" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="userid" required>
       <div class="invalid-feedback">Inserisci un'username valido!</div>
       <div class="valid-feedback">Ok!</div>
       </div>
        </div>
        
        <div class="form-row">
          <div class="form-group col-xl-6 pt-1">
        <label for="pwid">Password </label>
        <input type="password" name="password" minlength="8" maxlength="20" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="pwid" onkeyup="validate()"  required>
          <div class="invalid-feedback">Inserisci una password valida!</div>
          <div class="valid-feedback">Ok!</div>
          </div>
    
      <div class="form-group col-xl-6 pt-1">
        <label for="cpwid">Conferma Password </label>
        <input type="password" name="confpassword" minlength="8" maxlength="20" class="form-control pl-4 shadow p-1 mb-1 bg-white" id="cpwid" onkeyup="validate()" required> <!--onkeyup="function()"-->
      	<span id='message'></span>
      </div>
       </div>
       
	     <a href="<%=request.getContextPath()%>/ControlloIniziale">Sei gia registrato?</a>
	      <div class="text-center pt-4">
	      	  <button type="submit" class="mt-2 py-2 pl-5 pr-5 text-white shadow p-1 mb-5" id="bottone" type="submit" onclick="return Validate()">REGISTRATI</button>
	         <!--   <button type="submit" class="btn col-2 offset-5 py-2 pl-5 pr-5 text-white shadow p-1 mb-1 text-center" id="bottone"><b>REGISTRATI</b></button>-->
	      </div>
    </form>    
    
    </div>
    
</div>


<script>


function Validate() {
    var password = document.getElementById("pwid").value;
    var confirmPassword = document.getElementById("cpwid").value;
    if (password != confirmPassword) {
        alert("Passwords non coincidono.");
        return false;
    }
    return true;
}

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


      <jsp:include page="/view/footer.jsp"></jsp:include>