<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="Util.UtilityRicerca"%>
<%@page import="java.time.LocalDate"%>
<%@page import="model.Prenotazione"%>
<%@page import="java.util.List"%>
<jsp:include page="/view/headerInterno.jsp"></jsp:include>

<%List<Prenotazione>listaPrenotazioni= (List<Prenotazione>)request.getAttribute("listaPrenotazioni"); %>
 <div class="container-fluid storicoprenotazioni ">

        <h1 class="mt-5 pt-5 text-center"><b>Storico prenotazioni</b></h1>


        <div class="row pb-5">
            <div class="pt-5 pb-5 col-8 offset-2">
                <table class="table">
                    <thead class="bg-dark text-white">
                        <tr>
                            <th scope="col" class="text-center stonda">#</th>
                            <th scope="col" class="text-center">Titolo</th>
                            <th scope="col" class="text-center">Data prenotazione</th>
                            <th scope="col" class="text-center stondadue">Cancella prenotazione</th>
                        </tr>
                    </thead>
                    <tbody>
                    
                    <%DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                    for(Prenotazione p : listaPrenotazioni){ %>
                        <tr class="chi">
                            <td class="text-center"><%=listaPrenotazioni.indexOf(p)+1%></td>
                            <td class="text-center"><%=p.getLib().getTitolo()%></td>
                            <td class="text-center"><%=p.getData()!=null? LocalDate.parse(UtilityRicerca.dataString(p.getData())).format(formatter) : "in coda"%></td>
                                                       
                            <td class="text-center">
                            
                            <%if(p.getData()==null){ %>
                            
                            <a href="<%=request.getContextPath()%>/CancellaPrenotazioneUtente?cancella=<%=p.getIdprenotazione()%>"><i class="fas fa-times-circle fa-lg text-danger"></i></a>
                            
                            <%}%>
                           
                            </td>
                        <tr>
                        
                        <%} %>

                    </tbody>
                </table>
            </div>
        </div>
	<div class="spazio" style="margin-top:250px;"></div>
    </div>


<jsp:include page="/view/footer.jsp"></jsp:include>