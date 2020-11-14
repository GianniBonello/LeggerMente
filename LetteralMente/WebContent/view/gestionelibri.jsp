<jsp:include page="/view/headerstaff.jsp"></jsp:include>

<div class="container-fluid libri sfondostaff" style="background: linear-gradient(45deg, rgba(190, 56, 123, 0.7),rgba(21, 169, 189, 0.7)) ,url(<%=request.getContextPath()%>/res/bgstaff.jpg) no-repeat center center fixed">

        <h1 class="offset-2 pt-5 text-center text-light"><b>Gestione libri</b></h1>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 m-auto w-50 text-light">
            <div class="row ">
                <!-- CERCA LIBRI  -->
                <form action="listalibri.jsp" method="post">
                    <div class="cercaLibro pt-5 pl-5 col-xl-7">
                        <!-- CERCA LIBRI HOME -->
                            <div class="input-group">
                                <span class="input-group-append">
                                    <p class="input-group-text py-2 shadow" style="z-index: 2;"><i class="fa fa-search"></i></p>
                                   </span>
                                <input class="form-control py-2 bg-light border-radius-5 shadow " name="cercaLibro" type="search" placeholder="Inserisci il titolo del libro" id="example-search-input" >  
                            </div> 
                    </div>
                    <div class="filtraLibro pt-5 pl-3 col-xl-5">
                        <div class="input-group mb-3">
                            <p class="pt-2 pr-3">Filtra per :</p>
                            <select class="custom-select bg-light shadow " id="inputGroupSelect01">
                                <option selected value="titolocresc">Titolo : dalla A alla Z</option>
                                <option value="titolodecr">Titolo : dalla Z alla A</option>
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
        </div>
      </main>


        <div class="row">
            <div class="pt-5 pb-5 col-9 offset-3">
                <table class="table">
                    <thead class="bg-dark text-white">
                        <tr>
                            <th scope="col" class="text-center stonda">#</th>
                            <th scope="col" class="text-center">Titolo libro</th>
                            <th scope="col" class="text-center">Autore</th>
                            <th scope="col" class="text-center">Codice ISBN</th>
                            <th scope="col" class="text-center">Qt</th>
                            <th scope="col" class="text-center stondadue">Comandi</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="chiaro nero">
                            <td class="text-center pt-4">1</td>
                            <td class="text-center pt-4">Harry Potter</td>
                            <td class="text-center pt-4">Gigi Marzullo</td>
                            <td class="text-center pt-4">12-345-678-555-77</td>
                            <td class="text-center pt-4">4
                            </td>
                            <td class="text-center pt-4">
                                <a data-toggle="collapse" data-target="#demo2" role="button" aria-expanded="false"
                                    aria-controls="collapseExample">

                                    <i class="fas fa-pencil-alt fa-lg text-white"></i></a>

                                <i class="fas fa-check-circle fa-lg verde"></i>
                                <i class="fas fa-times-circle fa-lg text-danger"></i>
                            </td>
                        <tr>
                            <td colspan="6" class="hiddenRow bgcoll">
                                <div id="demo2" class="collapse">
                                    <form method="post">
                                        <div class="form-row ">

                                            <div class="col-8 offset-2 pt-4">
                                                <form action="Registrazione" method="post">
                                                    <div class="form-row">
                                                        <div class="form-group col-md-12 pt-1">


                                                            <label for="titoloid">Titolo </label>
                                                            <input type="text" name="titolo"
                                                                class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                                                id="titoloid" value="l.getNome" required>
                                                        </div>
                                                    </div>

                                                    <div class="form-row">
                                                        <div class="form-group col-xl-9 pt-1">
                                                            <label for="casaid">Casa editrice</label>
                                                            <input type="text" name="casaeditrice"
                                                                class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                                                id="casaid" value="l.getCasaEditrice" required>
                                                        </div>
                                                        <div class="form-group col-xl-3 pt-1">
                                                            <label for="annoid">Anno</label>
                                                            <input type="number" name="anno"
                                                                class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                                                id="annoid" value="l.getAnno" required>
                                                        </div>
                                                    </div>


                                                    <div class="form-row">
                                                        <div class="form-group col-xl-6 pt-1">
                                                            <label for="genereid">Genere </label>
                                                            <input type="text" name="genere"
                                                                class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                                                id="genereid" value="l.getGenere" required>
                                                        </div>

                                                        <div class="form-group col-xl-6 pt-1">
                                                            <label for="isbnid">Codice ISBN</label>
                                                            <input type="number" name="isbn"
                                                                class="cazzo form-control pl-4 shadow p-1 mb-1"
                                                                id="isbnid value="l.getCodiceIsbn" required>
                                                        </div>
                                                    </div>

                                                    <div class="form-row">
                                                        <div class="form-group col-xl-6 pt-1">
                                                            <label for="qtid">Quantita</label>
                                                            <input type="number" name="quantita"
                                                                class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                                                id="qtid" value="l.getQuantita" required>
                                                        </div>


                                                        <div class="form-group col-xl-6 pt-1">
                                                            <label for="prezzoid">Prezzo </label>
                                                            <input type="number" name="prezzo"
                                                                class="form-control pl-4 shadow p-1 mb-1 bg-white"
                                                                id="prezzoid" value="l.getPrezzo" required>
                                                        </div>


                                                    </div>

                                                    <div class="form-row">
                                                        <label for="prezzoid">Trama</label>
                                                        <textarea name="trama" class="col-xl-12 p-3 b-none" value="l.getTrama" required></textarea>
                                                    </div>

                                                    <div class="form-row pt-4">
                                                    
                                                    	<div class="col-xl-2 pt-5">    
                                                            <span class="spy pr-3">Usato</span>
                                                            <label class="switch"> 
                                                                <input type="checkbox">
                                                             <span class="slider round"></span></label>
                                                    	</div>
                                                    
                                                    	<div class="offset-xl-1 col-xl-9">  
                                                        	<label for="imgid" class="col-2 pt-2">Immagine </label>
                                                        	<input type="file" name="immagine"
                                                            	class="form-control imm shadow mb-1 bg-white col-xl-12 pl-5 "
                                                            	id="imgid" placeholder="" alt="Submit">
                                                    	</div>
                                                    	
                                                    </div>
                                                
                                                <div class="text-center pt-4">
                                                    <button type="submit" class="mt-2 py-2 pl-5 pr-5 text-white shadow p-1 mb-5" id="bottone" type="submit">MOFIDICA</button>
                                                </div>
                                                
                                              </form>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table> 
                
            </div>
        </div>
        

<jsp:include page="/view/footerstaff.jsp"></jsp:include> 