<jsp:include page="/view/headerInterno.jsp"></jsp:include>

<%@page import="model.Libro"%>
<%if(request.getAttribute("libro")==null){
	response.sendRedirect("ControlloIniziale");
}else{

Libro l = (Libro)request.getAttribute("libro"); %>
<div class="container">

                <div class=" col-xl-12 poplibro mt-5" id="descr">

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
                                              <div class="col-xl-7 offset-1 pt-3">
                                        
                                                <h2 class="mb-5 text-left "><%=l.getTitolo() %></h2>
                                                  <div class="descrizioneinfo">
                                                    <p class="text-left  pt-3" style="font-size: 16pt;"><b>DESCRIZIONE</b></p>
                                                    <p class="text-left justify-content pt-3"><%=l.getTrama() %></p>
            
                                                    <div class="row pt-5 pb-5">
                                                    <% if(l.getQuantita()>0){ %>
                                                      <i class="fas fa-circle fa-2x" style="color:#06A500"></i><p class="col-xl-5 text-left" style="font-size: 16pt;"><b>DISPONIBILE</b></p>
                                                            <%}else{ %>                    
                                                        <i class="fas fa-circle fa-2x" style="color:#FF0000"></i><p class="col-xl-5 text-left" style="font-size: 16pt;"><b>ESAURITO</b></p>
                                                                        <%} %>         
                                                                              <!--SCRIPTLET PREZZO-->
                                                      <p class="col-xl-6 pl-3" style="font-size: 16pt;"><b><%=!l.getIsUsato()?"PREZZO :"+ l.getPrezzo() +"&euro;" :" " %> </b></p>
                                                    </div>
                                                  </div>   
                                                 
                                                    <% if(request.getSession().getAttribute("utenteLoggato") != null){
		                                                    if(!l.getIsUsato()){ %>                     
		                                              		 	<a href="<%=request.getContextPath()%>/DettagliPrenotazione?idLibro=<%=l.getId_libro()%>"><button class="float-left text-white shadow mb-2"><%=l.getQuantita()>0?"PRENOTA":"IN CODA"%></button></a>  
		                                               	   <%}else {%>
		                                              			 <%=l.getQuantita()> 0 ? "  <a href=\""+request.getContextPath()+"/DettagliNoleggio?idLibro="+l.getId_libro()+"\"><button  class=\"float-left text-white shadow mb-2 ml-5\">NOLEGGIA</button></a> " : ""%>
		                                           		   <%}
                                                    }%> 
                                              </div>
                                             
                                         </div> 
                </div>
            </div>
      <%} %>
      
           <jsp:include page="/view/footer.jsp"></jsp:include>