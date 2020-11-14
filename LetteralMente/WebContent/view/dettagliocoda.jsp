  <%@page import="model.Libro"%>
<jsp:include page="/view/headerInterno.jsp"></jsp:include>
<div class="popprezzo bg-white margini">
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
      <div class="col-xl-7 offset-1 pt-3 ">
        <h2 class="mb-3 "><%=l.getTitolo() %></h2>
        
        <p class="price">PREZZO:   <%=l.getPrezzo() %> &euro;</p>
        <hr class="mar text-left mb-5">
        Sarai il <b><%=attesa==0?"Primo": attesa+1 %></b> in coda<br>
        <hr class=" text-left">
        <p class="mt-3 mar">Quando il libro sara' disponibile al ritiro sara' inviata <br> via email una notifica di conferma.</p>

       <a href="<%=request.getContextPath()%>/PrenotazioneUtente?idLibro=<%=l.getId_libro()%>"><button type="submit" class="mt-5 mr-3 col-3 text-white shadow ">CONFERMA</button></a> 
        <button type="submit" class="mt-5 col-3 text-white shadow ">ANNULLA</button>

      </div>
    </div>

  </div>
</div>
<%} %>
  <jsp:include page="/view/footer.jsp"></jsp:include>