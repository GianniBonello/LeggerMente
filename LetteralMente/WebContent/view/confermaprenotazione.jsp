<%@page import="model.Prenotazione"%>

<%@ page contentType="text/html; charset=ISO-8859-1" %>
<div class="popcoda bg-white margini">
    <div class="container">
<%Prenotazione p = (Prenotazione)request.getSession().getAttribute("prenotazione");
if(p!=null){%>
    <div class="row ">
      <div class="copertina col-xl-4 pt-3 text-center">
        <img src="<%=p.getLib().getImmagine_path() %>" height="375px" alt="" class="w-75 mb-5">
        <p class="text-left inter"><b>AUTORE:</b></p>
        <hr class="w-75">
        <p class="text-left interdue"><%=p.getLib().getAutore() %></p>
        <br>

        <p class="text-left inter"><b>CASA EDITRICE:</b></p>
        <hr class="w-75">
        <p class="text-left interdue"><%=p.getLib().getCasaEditrice() %></p>

      </div>
      <div class="col-xl-7 offset-1 pt-3 text-center">
        <h2 class="mb-5 text-center"><%=p.getLib().getTitolo() %></h2>
        <i class="fas fa-id-badge fa-7x mb-5 mt-5"></i><br>
        <b style="color: #06A500; font-size:16pt;">PRENOTAZIONE EFFETTUATA</b><br>
        <p style="font-size:16pt;">Prenotazione n� <%=p.getIdprenotazione() %><br></p>
        <p class="mt-3 mb-5" style="font-style:italic;">Nei prossimi minuti le sar� inviata un email <br> con il codice del suo ordine e le istruzioni per il ritiro.</p>
	<%//TODO AGGIUNGERE LINK ALLA LISTA LIBRI!!!! %>
        <a href="<%=request.getContextPath()%>/ListaLibri"><button type="submit" class="mt-5 col-3 text-white shadow">CONTINUA</button></a>

      </div>
    </div>

  </div>
</div>
<%} %>
<jsp:include page="/view/footer.jsp"></jsp:include>