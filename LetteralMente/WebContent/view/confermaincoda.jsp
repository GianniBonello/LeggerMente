  <%@page import="model.Libro"%>
<jsp:include page="/view/headerInterno.jsp"></jsp:include>
  
<div class="popcoda bg-white margini">
<div class="container">
<% 
Libro l = (Libro)request.getAttribute("libro");
if(l!=null && request.getAttribute("attesa")!= null) {
int attesa = (Integer)request.getAttribute("attesa");%>
    <div class="row ">
      <div class="copertina col-xl-4 pt-3 text-center">
        <img src="res/libro1.jpg" height="375px" alt="" class="w-75 mb-5">
        <p class="text-left inter"><b>AUTORE:</b></p>
        <hr class="w-75">
        <p class="text-left interdue"><%=l.getAutore() %></p>
        <br>

        <p class="text-left inter"><b>CASA EDITRICE:</b></p>
        <hr class="w-75">
        <p class="text-left interdue"><%=l.getCasaEditrice() %></p>

      </div>
      <div class="col-xl-7 offset-1 pt-3 text-center">
        <h2 class="mb-5 text-center"><%=l.getTitolo() %></h2>
        <i class="fas fa-people-arrows fa-7x mb-5 mt-5"></i><br>
        <b style="color: #06A500;">SEI STATO MESSO IN CODA</b><br>
        Sei il <b><%=attesa==0?"Primo": attesa+1 %></b> in coda<br>
        <p class="mt-3 mb-5">Quando il libro sarà disponibile al ritiro sarà inviata <br> via email una notifica di conferma.</p>

        <button type="submit" class="mt-5 col-3 text-white shadow">CONTINUA</button>

      </div>
    </div>

  </div>
</div>

  <%} %>
  <jsp:include page="/view/footer.jsp"></jsp:include>