<%@page import="model.Libro"%>
<jsp:include page="/headerInterno.jsp"></jsp:include>

<div class="container">
  <div class="popprezzo bg-white">
<%
	Libro l = (Libro)request.getAttribute("libro");
%>




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

        <i class="fas fa-cart-arrow-down fa-7x mt-5 mr-5"></i>
        <i class="fas fa-long-arrow-alt-right fa-7x" style="color: #06A500;"></i>
        <i class="fas fa-people-carry fa-7x ml-5 "></i>
        <p class="mt-5 mb-5"><b>PAGAMENTO E RITIRO ALLA CASSA</b></p>
        <h4>PREZZO: <%=l.getPrezzo() %></h4>
        <p class="mt-3 mb-5">Nei prossimi minuti le sarà inviata un email <br>con il codice del suo ordine e le istruzioni per il ritiro</p>


        <form action="PrenotazioneUtente" method="post">
        <input type="hidden" name="isbn" value="<%=l.getIsbn() %>">
        <button type="submit" class="col-3 p-2 text-white shadow p-1 mb-2 "><%=l.getQuantita()>0?"PRENOTA":"IN CODA"%></button></form>

      </div>
    </div>

  </div>
</div>


<jsp:include page="/footer.jsp"></jsp:include>