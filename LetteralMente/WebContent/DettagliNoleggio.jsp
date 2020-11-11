<jsp:include page="/headerInterno.jsp"></jsp:include>

<div class="poplibro confine shadow p-5 mb-2 bg-white">
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
        <h2 class="mb-5 ">Harry Potter e la pietra filosofale</h2>
        <form method="post ">
          <div class="form-row pt-5 mb-5">
            <div class="form-group col-md-11 pt-1 mb-2">
              <label for="inizio">Data inizio noleggio </label>
              <input type="text" name="nome" class="form-control pl-4 shadow p-1 mb-1" id="inizio" placeholder="">
            </div>
            <div class="form-group col-md-11 pt-1 mt-5 mb-5">
              <label for="fine">Data fine noleggio </label>
              <input type="text" name="nome" class="form-control pl-4 shadow p-1 mb-1" id="fine" placeholder="">
            </div>
          </div>
        </form>

        <button type="submit" class=" altcol-3 p-2 text-white shadow p-1 mb-2 ">NOLEGGIA</button>

        <button type="submit" class=" col-3 offset-1 p-2 text-white shadow p-1 mb-2 " data-dismiss="modal">ANNULLA</button>
      </div>
    </div>


<jsp:include page="/footer.jsp"></jsp:include>