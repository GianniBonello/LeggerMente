<!doctype html>
<%@page import="model.Utente"%> 
<%@page import="model.Libro"%>

<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<title>LeggerMente - Libreria di Roma</title>

<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/8565ef3487.js" crossorigin="anonymous"></script>

<style type="text/css">

<%@ include file="../css/style.css" %>
</style>


</head>
<body>

 <header style=" background:  linear-gradient(45deg, rgba(190, 56, 123, 0.6),rgba(21, 169, 189, 0.6)) , url(<%=request.getContextPath()%>/res/bg.jpg) no-repeat center center fixed;"> 
        <div class="container">  
        <nav class="navbar navbar-expand-lg navbar-dark bg-transparent text-light mb-3">
            <a class="navbar-brand logo " href="ControlloIniziale"><img src="<%=request.getContextPath()%>/res/logo.png"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                    	<a class="nav-link" href="#"><b>HOME</b><span class="sr-only">(current)</span></a>
                    </li> 
                    <li class="nav-item">
                    	<a class="nav-link" href="#inostriservizi"><b>I NOSTRI SERVIZI</b></a>
                    </li> 
                    <li class="nav-item">
                    	<a class="nav-link" href="#chisiamo"><b>CHI SIAMO</b></a>
                    </li> 
                    <li class="nav-item">
                    	<a class="nav-link" href="#listalibri"><b>LISTA LIBRI</b></a>
                    </li> 
                </ul>
                  <% 
                        if(request.getSession().getAttribute("utenteLoggato")==null) { 
                     %> 
						
                    <button class="buttonHead login mr-3 " id="login" onclick="login()"> LOGIN </button>
                    <a href="<%=request.getContextPath()%>/Registrazione"><button class="buttonHead" type="submit"> REGISTRAZIONE </button></a> <!-- PAGINA REGISTRAZIONE -->

                    <% }else{
                        Utente u= (Utente) request.getSession().getAttribute("utenteLoggato"); %> 
                        
                           <div class="dropdown">
                           		 <p class="pr-3 pt-2 float-left "><b>Ciao <%= u.getNome() + " "+ u.getCognome()  %> </b></p> 
                           		 <button class="buttonHead dropdown-toggle" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user-cog float-left mr-2 my-auto " ></i></button>     
                                  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <a class="dropdown-item" href="<%=request.getContextPath()%>/ModificaProfilo"><i class="fas fa-user pr-2"></i>Il mio profilo</a> 
                                    <a class="dropdown-item" href="<%=request.getContextPath()%>/CancellaPrenotazioneUtente"><i class="fas fa-list-ul pr-2"></i>Storico prenotazioni</a> 
                                    <a class="dropdown-item" href="<%=request.getContextPath()%>/NoleggiEffettuatiUtente"><i class="fas fa-receipt pr-2"></i>Noleggi effettuati</a> 
                                    <a class="dropdown-item" href="Logout"><i class="fas fa-sign-out-alt"></i>Logout</a>  
                                  </div>
                        </div> 
                         
                      <% } %>  
                    </div>
                </div>
            </nav>
            
            <div class="container">
               <div class="row pt-5">
                <div class="intro col-xl-5 pt-5">
                    <h2 class="testohome"><span class="mente">Legger</span>Mente</h2>
                    <h4 class="testohome"><img class="pr-3" src="<%=request.getContextPath()%>/res/trattino.png" alt="trattino"><i>Libreria di Roma</i></h4>
                    <p class="testohome">LeggerMente e' una libreria smart, viene fondata nel 2020 ed e' un posto magico
                                        dove le persone possono noleggiare e leggere con la testa fra le nuvole tutti i libri
                                        che desiderano.</p>
                    <span class="cercahome">CERCA UN LIBRO</span>
                    <div class="pt-2">
                      <form action="ListaLibri" method="post"> 
                        <div class="input-group">
                            <span class="input-group-append">
                                <p class="input-group-text bg-light py-2"><i class="fa fa-search"></i></p>
                               </span>
                            <input class="form-control py-2 bg-light border-radius-5 " name="cercaLibro" type="search" placeholder="Inserisci il titolo del libro" id="example-search-input" >  
                        </div> 
                      </form>
                    </div>	
                </div> 
                <!-- LOGIN -->
                <div class="bg-light offset-xl-3 col-xl-4 px-5 d-none " id="loginform">
                    <h2 class="pt-5 text-center">Login</h2>
                    <form action="login" method="post">
                    	<div class="pt-2 text-center">
                        	<input class="form-control py-2 bg-light border-radius-5 mt-5 pl-4 shadow " type="text" name="username" placeholder="Username">
                        	<input class="form-control py-2 bg-light border-radius-5 mt-5 mb-4 pl-4 shadow " type="password" name="password" placeholder="Password">    
                    	</div>
                    	<small ><a class="text-dark text-left pl-2" href="" >Non sei ancora registrato ?</a>
                    	<br>
                    	<a class="text-dark text-left pl-2" href="" >Username o password dimenticati ?</a>
                    	<br>
                    	<div class="text-center">
                     		<button class="mt-5" type="submit">LOGIN</button></small>
                    	</div>
                    </form>
				</div>
              </div>
</header> 