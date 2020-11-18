<%@page import="model.Noleggio"%>
<%@page import="java.util.List"%>
<jsp:include page="/view/headerInterno.jsp"></jsp:include>

<%List<Noleggio>listaNoleggi= (List<Noleggio>)request.getAttribute("listaNoleggi"); 
if(listaNoleggi != null){
%>

<div class="container-fluid noleggi ">

        <h1 class="mt-5 pt-5 text-center"><b>Noleggi effettuati</b></h1>


        <div class="row pb-5">
            <div class="pt-5 pb-5 col-8 offset-2">
                <table class="table">
                    <thead class="bg-dark text-white">
                        <tr>
                            <th scope="col" class="text-center stonda">#</th>
                            <th scope="col" class="text-center">Titolo</th>
                            <th scope="col" class="text-center">Data inizio noleggio</th>
                            <th scope="col" class="text-center stondadue">Data fine noleggio</th>
                        </tr>
                    </thead>
                    <tbody>
                    
                    <%for(Noleggio n : listaNoleggi){ %>
                        <tr class="chi">
                            <td class="text-center"><%=listaNoleggi.indexOf(n)+1 %></td>
                            <td class="text-center"><%=n.getLib().getTitolo() %></td>
                            <td class="text-center"><%=n.getDataInizio() %></td>
                            <td class="text-center"><%=n.getDataFine() %></td>
                           
                            </td>
                        <tr>
					<%} %>
                      
                    </tbody>
                </table>
            </div>
        </div>

    </div>
<%} %>
<div class="spazio" style="margin-top:250px;"></div>
<jsp:include page="/view/footer.jsp"></jsp:include>