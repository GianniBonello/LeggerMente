<jsp:include page="/HeaderStaff.jsp"></jsp:include>

<div class="container-fluid prenotazioni bg-danger ">

        <h1 class="offset-5 pt-5 "><b>Gestione prenotazioni</b></h1>

        <div class="row offset-5 mt-3 mb-3">
            <!-- CERCA LIBRI  -->
            <form action="listalibri.jsp" method="post">
                <div class="cercaLibro pt-5 pl-5">
                    <!-- CERCA LIBRI HOME -->
                    <div class="input-group">
                        <span class="input-group-append">
                            <p class="input-group-text py-2 shadow" style="z-index: 2;"><i class="fa fa-search"></i></p>
                        </span>
                        <input class="form-control py-2 bg-light border-radius-5 shadow " name="cercaLibro"  size="33"
                            type="search" placeholder="Inserisci il codice della prenotazione " id="example-search-input">
                    </div>
                </div>
            </form>

        </div>


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



<jsp:include page="/footerStaff.jsp"></jsp:include> 