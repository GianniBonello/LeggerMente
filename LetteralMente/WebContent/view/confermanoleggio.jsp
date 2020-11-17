<%@page import="model.Noleggio"%>
<%@page import="model.Libro"%>
<jsp:include page="/view/headerInterno.jsp"></jsp:include>

<div class="popcoda bg-white margini">
    <div class="container">
<%
	Noleggio n= (Noleggio)request.getSession().getAttribute("noleggio");
if(n!=null){%>
    <div class="row ">
      <div class="copertina col-xl-4 pt-3 text-center">
        <img src="<%=n.getLib().getImmagine_path() %>" height="375px" alt="" class="w-75 mb-5">
        <p class="text-left inter"><b>AUTORE:</b></p>
        <hr class="w-75">
        <p class="text-left interdue"><%=n.getLib().getAutore() %></p>
        <br>

        <p class="text-left inter"><b>CASA EDITRICE:</b></p>
        <hr class="w-75">
        <p class="text-left interdue"><%=n.getLib().getCasaEditrice() %></p>

      </div>
      <div class="col-xl-7 offset-1 pt-3 text-center">
        <h2 class="mb-5"><%=n.getLib().getTitolo() %></h2>

            <i class="fas fa-cart-arrow-down fa-7x mb-5"></i>
            <i class="fas fa-long-arrow-alt-right fa-7x mx-4" style="color: #06A500;"></i>
            <i class="fas fa-people-carry fa-7x mb-5"></i><br>
            <b style="color: #06A500; font-size:16pt;" class="pt-5">NOLEGGIO EFFETTUATO CON SUCCESSO</b><br>
            <p class="mb-3" style="font-size:14pt;">Ordine n° <%=n.getIdNoleggio() %><br></p>
            <b style="font-size:16pt;">RITIRO ALLA CASSA</b><br>
            <p class="mt-3" style="font-style:italic;">Nei prossimi minuti le sarà inviata un email <br>con il codice del suo ordine e le istruzioni per il ritiro</p>
        
        <a href="<%=request.getContextPath()%>/ListaLibri"><button type="submit" class="mt-5 col-3 text-white shadow ">CONTINUA</button></a>

      </div>
    </div>

  </div>
</div>
<%}%>
<jsp:include page="/view/footer.jsp"></jsp:include>