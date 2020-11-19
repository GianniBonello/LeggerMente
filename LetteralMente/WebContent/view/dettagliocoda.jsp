  <%@page import="model.Libro"%>

<%@ page contentType="text/html; charset=ISO-8859-1" %>
<div class="popprezzo bg-white margini">
<div class="container">
<% 
Libro l = (Libro)request.getAttribute("libro");
if(l!=null && request.getAttribute("attesa")!= null) {
int attesa = (Integer)request.getAttribute("attesa");%>
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
      <div class="col-xl-7 offset-1 pt-3 ">
        <h2 class="mb-3 "><%=l.getTitolo() %></h2>
        
        <p class="price" style="font-size:16pt; font-weight:300;">PREZZO: <span class="pl-2"><%=l.getPrezzo()%></span> &euro;</p>
        <hr class="mar text-left mb-5">
        <p style="font-size:18pt;">Sarai il <b><%=attesa==0?"1": attesa+1 %></b> in coda<br></p>
        <hr class=" text-left">
        <p class="mt-3 mar" style="font-style:italic;">Quando il libro sarà disponibile al ritiro sarà inviata <br> via email una notifica di conferma.</p>

       <form action="<%=request.getContextPath()%>/PrenotazioneUtente" method="post">
        	<input type="hidden" name="idLibro" value="<%= l.getId_libro() %>">
        	<button type="submit" class="mt-5 mr-3 col-3 text-white shadow">CONFERMA</button>
        	<a href="<%=request.getContextPath()%>/ListaLibri" class="button mt-5 col-3 text-white shadow ">ANNULLA</a>
        </form>

      </div>
    </div>

  </div>
</div>
<%} %>
  <jsp:include page="/view/footer.jsp"></jsp:include>