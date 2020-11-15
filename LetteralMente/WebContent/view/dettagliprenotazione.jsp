<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="model.Libro"%>
<jsp:include page="/view/headerInterno.jsp"></jsp:include>

<% 
Libro l = (Libro) request.getAttribute("libro");

if(l!=null){
	
	%>


<div class="popprezzo bg-white margini">
<div class="container">

    <div class="row ">
      <div class="copertina col-xl-4 pt-3 text-center">
        <img src="<%=l.getImmagine_path() %>" height="375px" alt="" class="w-75 mb-5">
        <p class="text-left inter"><b>AUTORE:</b></p>
        <hr class="w-75">
        <p class="text-left interdue"><%= l.getAutore()%></p>
        <br>

        <p class="text-left inter"><b>CASA EDITRICE:</b></p>
        <hr class="w-75">
        <p class="text-left interdue"><%= l.getCasaEditrice()%></p>

      </div>
      <div class="col-xl-7 offset-1 pt-3 ">
        <h2 class="mb-3 "><%= l.getTitolo()%></h2>
        <% DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); %>
        <p class="price">PREZZO:   <%= l.getPrezzo()%> &euro;</p>
        <hr class=" text-left mardue">
        Da ritirare entro:<br>
        <b><%= LocalDate.now().plusDays(7).format(formatter) %></b><br>
        <hr class=" text-left">
        <p class="mt-3 mardue">Una volta ricevuta l'email di conferma non si potrà<br> più annullare la prenotazione.</p>

        <form action="<%=request.getContextPath()%>/PrenotazioneUtente" method="post"><input type="hidden" name="idLibro" value="<%= l.getId_libro() %>">
        <button type="submit" class="mt-5 mr-3 col-3 text-white shadow">CONFERMA</button></form>
        <a href="<%=request.getContextPath()%>/ListaLibri"><button type="submit" class="mt-5 col-3 text-white shadow ">ANNULLA</button></a>

      </div>
    </div>

  </div>
</div>

<% } %>

<jsp:include page="/view/footer.jsp"></jsp:include>