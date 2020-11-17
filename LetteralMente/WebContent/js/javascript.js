function login(){
      if($("#loginform").hasClass("d-none")){
        $("#loginform").fadeToggle(1500).removeClass("d-none")
      }else{
        $("#loginform").fadeToggle(1500)
      }
    }

    function info(autore,casaEditrice,genere,isbn,isUsato,prezzo,quantita,titolo,trama,immagine_path,riga){		
	alert(autore+" "+casaEditrice+" "+genere+" "+isbn+" "+isUsato+" "+prezzo+" "+quantita+" "+titolo+" "+trama+" "+immagine_path+" "+riga);
			//$("#immagine").setAttribute("src",immagine_path);
			/*esaurito acquisto*/ 
			if(!isUsato && quantita <= 0){
				alert("esaurito acquisto "+isUsato);
				document.getElementById("prezzoEsaurito"+riga+"").innerHTML=prezzo;
				document.getElementById("divEsauritoAcquisto"+riga+"").style.display="initial";
				document.getElementById("divDisponibileAcquisto"+riga+"").style.display="none";
				document.getElementById("divDisponibileNoleggio"+riga+"").style.display="none";
				document.getElementById("divEsauritoNoleggio"+riga+"").style.display="none";
				document.getElementById("bottvar"+riga+"").innerHTML="IN CODA";
				document.getElementById("bottvar"+riga+"").style.display="initial";
				/*disponilibe acquisto*/ 
			}else if(!isUsato && quantita > 0){
				alert("disponilibe acquisto "+isUsato);
				document.getElementById("divEsauritoAcquisto"+riga+"").style.display="none";
				document.getElementById("divDisponibileAcquisto"+riga+"").style.display="initial";
				document.getElementById("divDisponibileNoleggio"+riga+"").style.display="none";
				document.getElementById("divEsauritoNoleggio"+riga+"").style.display="none";
				document.getElementById("prezzoDisponibile"+riga+"").innerHTML=prezzo;
				document.getElementById("bottvar"+riga+"").innerHTML="PRENOTA";
				document.getElementById("bottvar"+riga+"").style.display="initial";
				/*esaurito noleggio*/ 
			}else if(isUsato && quantita <= 0){
				alert("esaurito noleggio "+isUsato);
				document.getElementById("divEsauritoAcquisto"+riga+"").style.display="none";
				document.getElementById("divDisponibileAcquisto"+riga+"").style.display="none";
				document.getElementById("divDisponibileNoleggio"+riga+"").style.display="none";
				document.getElementById("divEsauritoNoleggio"+riga+"").style.display="initial";
				document.getElementById("bottvar"+riga+"").style.display="none";
				/*disponilibe noleggio*/ 
			}else if(isUsato && quantita > 0){
				alert("dispnibile noleggio "+isUsato);
				document.getElementById("divEsauritoAcquisto"+riga+"").style.display="none";
				document.getElementById("divDisponibileAcquisto"+riga+"").style.display="none";
				document.getElementById("divDisponibileNoleggio"+riga+"").style.display="initial";
				document.getElementById("divEsauritoNoleggio"+riga+"").style.display="none";/*("display","none");*/
				document.getElementById("bottvar"+riga+"").innerHTML="NOLEGGIA";
				document.getElementById("bottvar"+riga+"").style.display="initial";
			}
			
			document.getElementById("titolo"+riga+"").innerHTML=titolo;
			document.getElementById("autore"+riga+"").innerHTML=autore;
			document.getElementById("casaEditrice"+riga+"").innerHTML=casaEditrice;
			document.getElementById("trama"+riga+"").innerHTML=trama;
			document.getElementById("immagine"+riga+"").setAttribute("src",immagine_path);	
			
		$(".botcollapse").parent().parent().find(".descrcollapse"+riga+"").fadeToggle(1000).removeClass("d-none");
		
		}  
		 
	/*	$(".botcollapse").click(function(){
			$(this).parent().parent().find(".descrcollapse").fadeToggle(1000).removeClass("d-none");
			
		})*/

    $(function scrollTop() {

      $(window).scroll(function() {
        if($(this).scrollTop() != 0) {
          $('#go_top').fadeIn();
        } else {
          $('#go_top').fadeOut();
        }
        
      })
        
      $('#go_top').click(function() {
        $('body,html').animate({scrollTop:0},800);  
      });
        
    });


$("#capid").keyup(function() {
    $("#capid").val(this.value.match(/[0-9]*/));
});


$(document).ready(function(){
  $("nav a").on('click', function(event) {
    if (this.hash !== "") {
      event.preventDefault();
      var hash = this.hash;
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 800, function(){
        window.location.hash = hash;
      });
    } 
  });
});


$('#pwid, #cpwid').on('keyup', function () {
  if ($('#pwid').val() == $('#cpwid').val() ) {
    $('#message').html('Ok!').css({"color" : "green" , "font-size" : "80%" });
  } else if ( $('#pwid').val()== "" && $('#cpwid').val() == ""){
	$('#message').html('Prego inserisca le password!').css({"color" : "black" , "font-size" : "80%" });
}else{
    $('#message').html('Inserisca la stessa password!').css({"color" : "red" , "font-size" : "80%" });}
});





function validate(modulo) {
var ck_password = /^[A-Za-z0-9]{8,20}$/;


  // definizione delle variabili
  var password = modulo.password.value;
  var confermapassword = modulo.passwordConfermata.value;
  var confermapassword1 = modulo.confpassword.value;
  // controllo sugli input
  if (!ck_password.test(password)) {
    alert( "La password deve contenere almeno 8 e massimo 20 caratteri alfanumerici.");
  }

  if (confermapassword != password) {
 	alert("Le password non coincidono."); 
  }

  // controllo sugli input
  if (!ck_password.test(password)) {
    alert( "La password deve contenere almeno 8 e massimo 20 caratteri alfanumerici.");
  }

  if (confermapassword1 != password) {
 	alert("Le password non coincidono."); 
  }


}


function validate(modulo2) {
var ck_password = /^[A-Za-z0-9]{8,20}$/;

var ck_email =  /^(([^<>;()[].,;:s@"]+(.[^<>()[].,;:s@"]+)*)|(".+"))@(([[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}])|(([a-zA-Z-0-9]+.)+[a-zA-Z]{3,}))$/;

  // definizione delle variabili
  var password = modulo2.password.value;
  var confermapassword1 = modulo2.confpassword.value;
  var email= modulo2.email.value;

 if (!ck_email.test(email)) {
    alert( "Inserisci un email valida. (es. mario@rossi.com)");
  }

  // controllo sugli input
  if (!ck_password.test(password)) {
    alert( "La password deve contenere almeno 8 e massimo 20 caratteri alfanumerici.");
  }

  if (confermapassword1 != password) {
 	alert("Le password non coincidono."); 
  }

}
