<%@page import="model.Noleggio"%>
<%@page import="model.Libro"%>
<jsp:include page="/view/headerInterno.jsp"></jsp:include>

<div class="popcoda bg-white margini">
    <div class="container">
<%Libro l = (Libro)request.getAttribute("libro");
	Noleggio n= (Noleggio)request.getAttribute("noleggio");
if(l!=null&n!=null){%>
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
      <div class="col-xl-7 offset-1 pt-3 text-center">
        <h2 class="mb-5"><%=l.getTitolo() %></h2>

            <i class="fas fa-cart-arrow-down fa-7x mb-5"></i>
            <i class="fas fa-long-arrow-alt-right fa-7x mx-4" style="color: #06A500;"></i>
            <i class="fas fa-people-carry fa-7x mb-5"></i><br>
            <b style="color: #06A500;">NOLEGGIO EFFETTUATO CON SUCCESSO</b><br>
            <p class="mb-5">Ordine n* <%=n.getIdNoleggio() %><br></p>
            <b>RITIRO ALLA CASSA</b><br>
            <p class="mt-3">Nei prossimi minuti le sar� inviata un email <br>con il codice del suo ordine e le istruzioni per il ritiro</p>
        
        <button type="submit" class="mt-5 col-3 text-white shadow ">CONTINUA</button>

      </div>
    </div>

  </div>
</div>
<%}%>
<jsp:include page="/view/footer.jsp"></jsp:include>