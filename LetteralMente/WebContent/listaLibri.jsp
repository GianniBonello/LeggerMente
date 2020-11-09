       
<div class="container">
    <main>
        <div class="mt-5" id="listalibri">
            <h1 class=" pt-5 pl-4" id="serv"><b>Lista Libri</b></h1>
            <h6 id="trattdue"><img class="pr-3" src="res/trattino.png" alt="trattino">Il nostro catalogo</h6>
        
            <div class="row ">
                <!-- CERCA LIBRI  -->
                <form action="listalibri.jsp" method="post"></form>
                    <div class="cercaLibro pt-5 pl-5">
                        <!-- CERCA LIBRI HOME -->
                            <div class="input-group">
                                <span class="input-group-append">
                                    <p class="input-group-text py-2 shadow" style="z-index: 2;"><i class="fa fa-search"></i></p>
                                   </span>
                                <input class="form-control py-2 bg-light border-radius-5 shadow " name="cercaLibro" type="search" placeholder="Inserisci il titolo del libro" id="example-search-input" >  
                            </div> 
                    </div>
                    <div class="filtraLibro pt-5 pl-5">
                        <div class="input-group mb-3">
                            <p class="pt-2 pr-3">Filtra per :</p>
                            <select class="custom-select bg-light shadow " id="inputGroupSelect01">
                                <option selected value="titolo">Titolo : dalla A alla Z</option>
                                <option value="prezzocresc">Prezzo : crescente</option>
                                <option value="prezzodecr">Prezzo : decrescente</option>
                                <option value="genere">Genere</option>
                                <option value="autore">Autore</option>
                                <option value="casaeditrice">Casa Editrice</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>

                <div class="row text-center pt-5 pb-5">
                <!--  
                    
                    for(Libro l : Libro.findAll){

                -->
                    <div class="libro col-xl-4 pt-5">
                            <img src="res\uno.jpg"  class="w-75" style=" height:375px;">
                            <button class="btn btn-dark w-75 text-center" style="height:50px;background: #C80258; border: none;"  onclick="info()"><b style="font-size:14pt;">INFO</b></button>                        
                    </div>

                <!-- } -->
                    <div class="libro col-xl-4 pt-5">
                        <img src="res\uno.jpg"  class="w-75" style=" height:375px;">
                        <button class="btn btn-dark w-75 text-center " style="height:50px;background: #C80258; border: none" onclick="info()" ><b style="font-size:14pt;">INFO</b></button>                        
                    </div>

                    <div class="libro col-xl-4 pt-5">
                        <img src="res\uno.jpg"  class="w-75" style=" height:375px;">
                        <button class="btn btn-dark w-75 text-center " style="height:50px;background: #C80258; border: none" onclick="info()" ><b style="font-size:14pt;">INFO</b></button>                        
                    </div>

                

                    <div class=" col-xl-12 poplibro confine shadow p-5 mb-2 bg-white d-none mt-5" id="descr">
                        <div class="row ">
                        <div class="copertina col-xl-4 pt-3 text-center">
                            <img src="res/uno.jpg" height="375px" alt="" class="w-75 mb-5">
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
                                <!-- if() -->
                            
                            
                            
                            
                            -->
                                <div class="row pt-4 pb-5">
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
                            <img src="res\uno.jpg"  class="w-75" style=" height:375px;">
                            <button class="btn btn-dark w-75 text-center " style="height:50px;background: #C80258; border: none" onclick="info()" ><b style="font-size:14pt;">INFO</b></button>                        
                    </div>

                    <div class="libro col-xl-4 pt-5">
                        <img src="res\uno.jpg"  class="w-75" style=" height:375px;">
                        <button class="btn btn-dark w-75 text-center " style="height:50px;background: #C80258; border: none" onclick="info()" ><b style="font-size:14pt;">INFO</b></button>                        
                    </div>

                    <div class="libro col-xl-4 pt-5">
                        <img src="res\uno.jpg"  class="w-75" style=" height:375px;">
                        <button class="btn btn-dark w-75 text-center" style="height:50px; background: #C80258; border: none" onclick="info()" ><b style="font-size:14pt;">INFO</b></button>                        
                    </div>

                </div>
            </div>
        </div>

    </main>
