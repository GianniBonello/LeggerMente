<%@page import="model.Utente"%>
<jsp:include page="/view/headerstaff.jsp"></jsp:include>
 <%if(request.getSession().getAttribute("utenteLoggato")==null || !((Utente)request.getSession().getAttribute("utenteLoggato")).getIsStaff()){
	 request.getRequestDispatcher("../ControlloIniziale").forward(request, response);
	} %>
	
 <main role="main" class="sfondostaff col-lg-12 pt-3 px-4" >
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3">
   			<div class="intro offset-xl-5 col-lg-4 pt-5 text-center"  style="position:absolute; top: 20%;">
   				<i class="fas fa-book fa-10x mb-5 " style="transform: rotate(-35deg); color:#ffffff;"></i><br>
          		<h2 class="testohome"><span class="mente">Legger</span>Mente</h2>
          		<h4 class="testohome"><img class="pr-3" src="<%=request.getContextPath()%>/res/trattino.png" alt="trattino"><i>Libreria di Roma</i></h4>
          		<p class="testohome">LeggerMente e' una libreria smart, viene fondata nel 2020 ed è un posto magico
                              	 	 dove le persone possono noleggiare e leggere con la testa fra le nuvole tutti i libri
                              	 	 che desiderano.</p>
      		</div>	
      </div>
  </main> 


<jsp:include page="/view/footerstaff.jsp"></jsp:include> 