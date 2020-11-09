
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
                            
                        <div class="row text-center pt-5 pb-5">
                        <!--  
                            
                            for(Libro l : Libro.findAll){

                        -->
                            <div class="libro col-xl-4 pt-5">
                                    <img src="res\libro1.jpg"  class="w-75" style=" height:375px;">
                                    <button class="btn btn-dark w-75 text-center" style="height:50px;background: #C80258; border: none;"  onclick="info()"><b style="font-size:14pt;">INFO</b></button>                        
                            </div>

                        <!-- } -->
                            <div class="libro col-xl-4 pt-5">
                                <img src="res\libro1.jpg"  class="w-75" style=" height:375px;">
                                <button class="btn btn-dark w-75 text-center " style="height:50px;background: #C80258; border: none" onclick="info()" ><b style="font-size:14pt;">INFO</b></button>                        
                            </div>

                            <div class="libro col-xl-4 pt-5">
                                <img src="res\libro1.jpg"  class="w-75" style=" height:375px;">
                                <button class="btn btn-dark w-75 text-center " style="height:50px;background: #C80258; border: none" onclick="info()" ><b style="font-size:14pt;">INFO</b></button>                        
                            </div>

                           

                            <div class=" col-xl-12 poplibro confine shadow p-5 mb-2 bg-white d-none mt-5" id="descr">
                                <div class="row ">
                                  <div class="copertina col-xl-4 pt-3 text-center">
                                    <img src="res/libro1.jpg" height="375px" alt="" class="w-75 mb-5">
                                    <p class="text-left inter"><b>AUTORE:</b></p>
                                    <hr class="w-75">
                                    <p class="text-left interdue">J.K. Rowling</p>
                                    <br>
                            
                                    <p class="text-left inter"><b>CASA EDITRICE:</b></p>
                                    <hr class="w-75">
                                    <p class="text-left interdue">Bloomsbury Publishing Pic</p>
                            
                                  </div>
                                  <div class="col-xl-7 offset-1 pt-3">
                                    <h2 class="mb-5 text-left ">Harry Potter e la pietra filosofale</h2>
                                      <div class="descrizioneinfo">
                                        <p class="text-left  pt-3" style="font-size: 16pt;"><b>DESCRIZIONE</b></p>
                                        <p class="text-left justify-content pt-3">Harry Potter è un ragazzo normale, o quantomeno è convinto di esserlo, anche se a volte provoca strani fenomeni, come farsi ricrescere i capelli inesorabilmente tagliati dai perfidi zii. Vive con loro al numero 4 di Privet Drive: una strada di periferia come tante, dove non succede mai nulla fuori dall’ordinario. Finché un giorno, poco prima del suo undicesimo compleanno, riceve una misteriosa lettera che gli rivela la sua vera natura: Harry è un mago e la Scuola di Magia e Stregoneria di Hogwarts è pronta ad accoglierlo...</p>

<!--Se la quantità del libro è maggiore di 0 allora
 si vedra il  pallino verde con disponibile e il 
tasto prenota 
senno pallino rosso esaurito e
con il bottone mettiti in coda
                                        <!-- if() %>     
                                      
                                      
                                      
                                      
                                      -->
                                        <div class="row pt-5 pb-5">
                                          <i class="fas fa-circle fa-2x" style="color:#06A500"></i><p class="col-xl-5 text-left" style="font-size: 16pt;"><b>DISPONIBILE</b></p>
                                                                    <!--SCRIPTLET PREZZO-->
                                          <p class="col-xl-6 pl-3" style="font-size: 16pt;"><b>PREZZO :</b></p>
                                        </div>
                                      </div>                        
                                    <button type="submit" class="float-left text-white shadow mb-2 ">PRENOTA</button>  
                                    <button type="submit" class="float-left text-white shadow mb-2 ml-5 ">NOLEGGIA</button>
                                  </div>
                                </div> 
                            </div>

                            

                            <div class="libro col-xl-4 pt-5">
                                    <img src="res\libro1.jpg"  class="w-75" style=" height:375px;">
                                    <button class="btn btn-dark w-75 text-center " style="height:50px;background: #C80258; border: none" onclick="info()" ><b style="font-size:14pt;">INFO</b></button>                        
                            </div>
    
                            <div class="libro col-xl-4 pt-5">
                                <img src="res\libro1.jpg"  class="w-75" style=" height:375px;">
                                <button class="btn btn-dark w-75 text-center " style="height:50px;background: #C80258; border: none" onclick="info()" ><b style="font-size:14pt;">INFO</b></button>                        
                            </div>
    
                            <div class="libro col-xl-4 pt-5">
                                <img src="res\libro1.jpg"  class="w-75" style=" height:375px;">
                                <button class="btn btn-dark w-75 text-center" style="height:50px; background: #C80258; border: none" onclick="info()" ><b style="font-size:14pt;">INFO</b></button>                        
                        </div>

                    </div>
            </div>
        </div>
            
    </main>

</div>

<!-- SCROLL TO THE TOP -->

<div id="go_top">
    <a href="#" onclick="scrollTop()"><i class="far fa-arrow-alt-circle-up"></i></a>
</div>

            <!-- GOOGLE MAPS -->

<div class="pt-5"></div>

 <div class="googlemaps" style="-webkit-filter: grayscale(100%); filter: grayscale(100%);">
    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2497.026635377596!2d12.547151487822997!3d41.90399947302919!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x132f63cbb13acd2b%3A0x53d00747ea90d2e2!2sELIS!5e0!3m2!1sit!2sit!4v1604617465139!5m2!1sit!2sit" width="100%" height="400px" frameborder="0" style="border:0; background:rgba(0,0,0,0.8);" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
 </div>

 
