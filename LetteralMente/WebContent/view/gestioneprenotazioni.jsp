<jsp:include page="/view/headerstaff.jsp"></jsp:include>

<div class="container-fluid prenotazioni sfondostaff">

        <h1 class="offset-2 pt-5 text-center text-light"><b>Gestione prenotazioni</b></h1>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 m-auto w-50 text-light">
            <div class="row ">
                <!-- CERCA LIBRI  -->
                <form action="listalibri.jsp" method="post"></form>
                    <div class="cercaLibro pt-5 pl-5">
                        <!-- CERCA LIBRI HOME -->
                            <div class="input-group">
                                <span class="input-group-append">
                                    <p class="input-group-text py-2 shadow" style="z-index: 2;"><i class="fa fa-search"></i></p>
                                   </span>
                                <input class="form-control py-2 bg-light border-radius-5 shadow " name="cercaPrenotazione" type="search" placeholder="Inserisci il numero di prenotazione" id="example-search-input" >  
                            </div> 
                    </div>
                    <div class="filtraLibro pt-5 pl-5">
                        <div class="input-group mb-3">
                            <p class="pt-2 pr-3">Filtra per :</p>
                            <select class="custom-select bg-light shadow " id="inputGroupSelect01">
                                <option selected value="titolocresc">Titolo : dalla A alla Z</option>
                                <option value="titolodecr">Titolo : dalla Z alla A</option>
                                <option value="prezzocresc">Prezzo : crescente</option>
                                <option value="prezzodecr">Prezzo : decrescente</option>
                                <option value="isbn">Codice ISBN</option>
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
                            <th scope="col" class="text-center">Libro</th>
                            <th scope="col" class="text-center">Utente</th>
                            <th scope="col" class="text-center">Codice prenotazione</th>
                            <th scope="col" class="text-center stondadue">Comandi</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="chiaro">
                            <td class="text-center">1</td>
                            <td class="text-center">Le cronache di Narnia</td>
                            <td class="text-center">Marzullo</td>
                            <td class="text-center">abcdefg54678</td>
                            <td class="text-center"><a href=""><i class="fas fa-times-circle fa-lg text-danger"></i></a>
                            </td>
                        <tr>

                        
                    </tbody>
                </table>
            </div>
        </div>

    </div>



<jsp:include page="/view/footerstaff.jsp"></jsp:include> 