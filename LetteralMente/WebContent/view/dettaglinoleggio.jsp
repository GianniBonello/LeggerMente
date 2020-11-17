<%@page import="java.time.LocalDate"%>
<%@page import="model.Libro"%>
<jsp:include page="/view/headerInterno.jsp"></jsp:include>

<div class="poplibro bg-white">
<%Libro l = (Libro)request.getAttribute("libro"); 
if(l!=null){%>
<div class="container">
    <div class="row ">
      <div class="copertina col-xl-4 pt-3 text-center">
        <img src="<%=l.getImmagine_path() %>" height="375px" alt="" class="w-75 mb-5">
        <p class="text-left inter"><b>AUTORE:</b></p>
        <hr class="w-75">
        <p class="text-left interdue"><%=l.getAutore() %></p>
        <br>

        <p class="text-left inter"><b>CASA EDITRICE:</b></p>
        <hr class="w-75">
        <p class="text-left interdue"><%=l.getCasaEditrice() %></p>

      </div>
      <div class="col-xl-7 offset-1 pt-3">
        <h2 class="mb-5 "><%=l.getTitolo() %></h2>
        <form action="<%=request.getContextPath()%>/NoleggioUtente" method="post">
          <div class="form-row pt-5 mb-5">
            <div class="form-group col-md-11 pt-1 mb-2">
              <label for="inizio">Data inizio noleggio</label>
              <input type="date" name="immodificabile" class="form-control pl-4 shadow p-1 mb-1" id="inizio" value="<%=LocalDate.now() %>" disabled>
            </div>
            <div class="form-group col-md-11 pt-1 mt-5 mb-5">
              <label for="fine">Data fine noleggio</label>
              <input type="date" name="dataFine" class="form-control pl-4 shadow p-1 mb-1" id="fine" value="<%=LocalDate.now().plusMonths(2)%>" disabled>
            </div>
          </div>
		<input type="hidden" name="idLibro" value="<%=l.getId_libro()%>">


        <button type="submit" class="text-white shadow">CONFERMA</button>
        <a href="<%=request.getContextPath()%>/ListaLibri" class="button text-white shadow ml-5">ANNULLA</a>
        </form>
		
      </div>
    </div>
</div>
</div>
<%} %>
<jsp:include page="/view/footer.jsp"></jsp:include>