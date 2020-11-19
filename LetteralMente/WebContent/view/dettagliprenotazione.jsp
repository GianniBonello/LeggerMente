<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="model.Libro"%>

<%@ page contentType="text/html; charset=ISO-8859-1" %>
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
        <p class="price" style="font-size:16pt; font-weight:300;">PREZZO:<span class="pl-2"><%= l.getPrezzo()%></span> &euro;</p>
        <hr class=" text-left mardue">
        <p class="pb-3" style="font-size:16pt">Da ritirare entro il:<br>
        <b><%= LocalDate.now().plusDays(7).format(formatter) %></b><br></p>
        <hr class=" text-left">
        <p class="mt-3 mardue" style="font-style:italic;">Una volta ricevuta l'email di conferma non si potrà<br> più annullare la prenotazione.</p>

        <form action="<%=request.getContextPath()%>/PrenotazioneUtente" method="post">
        	<input type="hidden" name="idLibro" value="<%= l.getId_libro() %>">
        	<button type="submit" class="mt-3 mr-3 col-3 text-white shadow">CONFERMA</button>
        	<a href="<%=request.getContextPath()%>/ListaLibri" class="button mt-3 col-3 text-white shadow ">ANNULLA</a>
        </form>
        

      </div>
    </div>

  </div>
</div>

<% } %>

<jsp:include page="/view/footer.jsp"></jsp:include>