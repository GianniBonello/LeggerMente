function login(){
      if($("#loginform").hasClass("d-none")){
        $("#loginform").fadeToggle(1500).removeClass("d-none")
      }else{
        $("#loginform").fadeToggle(1500)
      }
    }

    function info(autore,casaEditrice,genere,isbn,isUsato,prezzo,quantita,titolo,trama,immagine_path){		
		if(isUsato&&quantita>0){
			$(".descrcollapse").innerHTML=`<div class="row ">
		                                  <div class="copertina col-xl-4 pt-3 text-center">
		                                    <img src="`+immagine_path+`" height="375px" alt="" class="w-75 mb-5">
		                                    <p class="text-left inter"><b>AUTORE:</b></p>
		                                    <hr class="w-75">
		                                    <p class="text-left interdue">`+autore+`</p>
		                                    <br>
		                                    <p class="text-left inter"><b>CASA EDITRICE:</b></p>
		                                    <hr class="w-75">
		                                    <p class="text-left interdue">`+casaEditrice+`</p>
		                            
		                                  </div>
		                                  <div class="col-xl-7 offset-1 pt-3">
		                                    <h2 class="mb-5 text-left ">`+titolo+`</h2>
		                                      <div class="descrizioneinfo">
		                                        <p class="text-left  pt-3" style="font-size: 16pt;"><b>DESCRIZIONE</b></p>
		                                        <p class="text-left justify-content pt-3">`+trama+`</p>
											</div>
										  </div>							
									<div class="row pt-5 pb-5">
										 <i class="fas fa-circle fa-2x" style="color:#06A500"></i><p class="col-xl-5 text-left" style="font-size: 16pt;"><b>DISPONIBILE</b></p>
									</div>
									<button type="submit" class="float-left text-white shadow mb-2 ml-5 ">NOLEGGIA</button>									
                                </div>	`;			
		}else if(!isUsato&&quantita>0){
			$(".descrcollapse").innerHTML=`<div class="row ">
		                                  <div class="copertina col-xl-4 pt-3 text-center">
		                                    <img src="`+immagine_path+`" height="375px" alt="" class="w-75 mb-5">
		                                    <p class="text-left inter"><b>AUTORE:</b></p>
		                                    <hr class="w-75">
		                                    <p class="text-left interdue">`+autore+`</p>
		                                    <br>
		                                    <p class="text-left inter"><b>CASA EDITRICE:</b></p>
		                                    <hr class="w-75">
		                                    <p class="text-left interdue">`+casaEditrice+`</p>
		                            
		                                  </div>
		                                  <div class="col-xl-7 offset-1 pt-3">
		                                    <h2 class="mb-5 text-left ">`+titolo+`</h2>
		                                      <div class="descrizioneinfo">
		                                        <p class="text-left  pt-3" style="font-size: 16pt;"><b>DESCRIZIONE</b></p>
		                                        <p class="text-left justify-content pt-3">`+trama+`</p>
											</div>
										  </div>
										<div class="row pt-5 pb-5">
											<i class="fas fa-circle fa-2x" style="color:#06A500"></i><p class="col-xl-5 text-left" style="font-size: 16pt;"><b>DISPONIBILE</b></p>							
											<p class="col-xl-6 pl-3" style="font-size: 16pt;"><b>PREZZO : `+prezzo+` &euro;</b></p>
										</div>
										<button type="submit" class="float-left text-white shadow mb-2 ">PRENOTA</button>																			
                                </div>
		`;}else if(!isUsato&&quantita<=0){
			$(".descrcollapse").innerHTML=`<div class="row ">
		                                  <div class="copertina col-xl-4 pt-3 text-center">
		                                    <img src="`+immagine_path+`" height="375px" alt="" class="w-75 mb-5">
		                                    <p class="text-left inter"><b>AUTORE:</b></p>
		                                    <hr class="w-75">
		                                    <p class="text-left interdue">`+autore+`</p>
		                                    <br>
		                                    <p class="text-left inter"><b>CASA EDITRICE:</b></p>
		                                    <hr class="w-75">
		                                    <p class="text-left interdue">`+casaEditrice+`</p>
		                            
		                                  </div>
		                                  <div class="col-xl-7 offset-1 pt-3">
		                                    <h2 class="mb-5 text-left ">`+titolo+`</h2>
		                                      <div class="descrizioneinfo">
		                                        <p class="text-left  pt-3" style="font-size: 16pt;"><b>DESCRIZIONE</b></p>
		                                        <p class="text-left justify-content pt-3">`+trama+`</p>
											</div>
										  </div>
										<div class="row pt-5 pb-5">
											<i class="fas fa-circle fa-2x" style="color:#FF0000"></i><p class="col-xl-5 text-left" style="font-size: 16pt;"><b>ESAURITO</b></p>
											<button type="submit" class="float-left text-white shadow mb-2 ">IN CODA</button>
											<p class="col-xl-6 pl-3" style="font-size: 16pt;"><b>PREZZO : `+prezzo+` &euro;</b></p>										
										</div>
                                </div>
			
		`;}else{
			$(".descrcollapse").innerHTML=`<div class="row ">
		                                  <div class="copertina col-xl-4 pt-3 text-center">
		                                    <img src="`+immagine_path+`" height="375px" alt="" class="w-75 mb-5">
		                                    <p class="text-left inter"><b>AUTORE:</b></p>
		                                    <hr class="w-75">
		                                    <p class="text-left interdue">`+autore+`</p>
		                                    <br>
		                                    <p class="text-left inter"><b>CASA EDITRICE:</b></p>
		                                    <hr class="w-75">
		                                    <p class="text-left interdue">`+casaEditrice+`</p>
		                            
		                                  </div>
		                                  <div class="col-xl-7 offset-1 pt-3">
		                                    <h2 class="mb-5 text-left ">`+titolo+`</h2>
		                                      <div class="descrizioneinfo">
		                                        <p class="text-left  pt-3" style="font-size: 16pt;"><b>DESCRIZIONE</b></p>
		                                        <p class="text-left justify-content pt-3">`+trama+`</p>
											</div>
										  </div>							
									<div class="row pt-5 pb-5">
										 <i class="fas fa-circle fa-2x" style="color:#FF0000"></i><p class="col-xl-5 text-left" style="font-size: 16pt;"><b>ESAURITO</b></p>
									</div>								
                                </div>	`;}			
		//$("#descr").fadeToggle(1000).removeClass("d-none");
		$(".botcollapse").parent().parent().hasClass("descrcollapse").fadeToggle(1000).removeClass("d-none");

		
		}   

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