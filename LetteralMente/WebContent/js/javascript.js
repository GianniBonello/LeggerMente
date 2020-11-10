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
				alert("esaurito acquisto");
				$('#prezzoEsaurito').innerHTML=prezzo;
				document.getElementById("divEsauritoAcquisto").style.display="initial";
				document.getElementById("divDisponibileAcquisto").style.display="none";
				document.getElementById("divDisponibileNoleggio").style.display="none";
				document.getElementById("divEsauritoNoleggio").style.display="none";
				document.getElementById("bottvar").innerHTML="IN CODA";
				document.getElementById("bottvar").style.display="initial";
				/*disponilibe acquisto*/ 
			}else if(!isUsato && quantita > 0){
				alert("disponilibe acquisto");
				document.getElementById("divEsauritoAcquisto").style.display="none";
				document.getElementById("divDisponibileAcquisto").style.display="initial";
				document.getElementById("divDisponibileNoleggio").style.display="none";
				document.getElementById("divEsauritoNoleggio").style.display="none";
				document.getElementById("prezzoDisponibile").innerHTML=prezzo;
				document.getElementById("bottvar").innerHTML="PRENOTA";
				document.getElementById("bottvar").style.display="initial";
				/*esaurito noleggio*/ 
			}else if(isUsato && quantita <= 0){
				alert("esaurito noleggio");
				document.getElementById("divEsauritoAcquisto").style.display="none";
				document.getElementById("divDisponibileAcquisto").style.display="none";
				document.getElementById("divDisponibileNoleggio").style.display="none";
				document.getElementById("divEsauritoNoleggio").style.display="initial";
				document.getElementById("bottvar").style.display="none";
				/*disponilibe noleggio*/ 
			}else {
				alert("dispnibile noleggio");
				document.getElementById("divEsauritoAcquisto").style.display="none";
				document.getElementById("divDisponibileAcquisto").style.display="none";
				document.getElementById("divDisponibileNoleggio").style.display="initial";
				document.getElementById("divEsauritoNoleggio").style.display="none";/*("display","none");*/
				document.getElementById("bottvar").innerHTML="NOLEGGIA";
				document.getElementById("bottvar").style.display="initial";
			}
			
			document.getElementById("titolo").innerHTML=titolo;
			document.getElementById("autore").innerHTML=autore;
			document.getElementById("casaEditrice").innerHTML=casaEditrice;
			document.getElementById("trama").innerHTML=trama;
			document.getElementById("immagine").setAttribute("src",immagine_path);	
			
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