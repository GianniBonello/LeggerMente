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
          $('#go_top').fadeIn(); //faccio apparire il bottone
        } else {
          $('#go_top').fadeOut();//Il bottone scompare
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
  // Add smooth scrolling to all links
  $("nav a").on('click', function(event) {

    // Make sure this.hash has a value before overriding default behavior
    if (this.hash !== "") {
      // Prevent default anchor click behavior
      event.preventDefault();

      // Store hash
      var hash = this.hash;

      // Using jQuery's animate() method to add smooth page scroll
      // The optional number (800) specifies the number of milliseconds it takes to scroll to the specified area
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 800, function(){
   
        // Add hash (#) to URL when done scrolling (default click behavior)
        window.location.hash = hash;
      });
    } // End if
  });
});


$('#pwid, #cpwid').on('keyup', function () {
  if ($('#pwid').val() == $('#cpwid').val() && $('#pwid').val() != ""&& $('#cpwid').val() != "" ) {
    $('#message').html('Ok!').css({"color" : "green" , "font-size" : "80%" });
  } else if ( $('#pwid').val()== "" && $('#cpwid').val() == ""){
	$('#message').html('Prego inserire le password!').css({"color" : "black" , "font-size" : "80%" });
}else{
    $('#message').html('Inserire la stessa password!').css({"color" : "red" , "font-size" : "80%" });}
});