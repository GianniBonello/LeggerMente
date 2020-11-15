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
 
            <nav class="navbar navbar-expand-lg navbar-light bg-light shadow mb-3">
                <div class="container">
                <a class="navbar-brand logo " href="<%=request.getContextPath()%>/ControlloIniziale"><img src="<%=request.getContextPath()%>/res/Logo-nero.png"></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active"><a class="nav-link" href="<%=request.getContextPath()%>/ControlloIniziale"><b>HOME</b>
                                <span class="sr-only">(current)</span>
                        </a></li>
                        <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/ListaLibri"><b>LISTA LIBRI</b></a></li> 
                    </ul>
                      <% 
                            if(request.getSession().getAttribute("utenteLoggato")==null) { 
                         %> 
                         
                        <button class=" login mr-3" id="login" onclick="login()" > LOGIN </button>
                        <a href="<%=request.getContextPath()%>/Registrazione"><button type="submit">REGISTRAZIONE</button></a> <!-- PAGINA REGISTRAZIONE -->
                        
                     <% }else{
                            Utente u = (Utente) request.getSession().getAttribute("utenteLoggato"); %> 
                            
                         <div class="dropdown">
                           		 <p class=" text-dark pr-3 pt-2 float-left "><b>Ciao <%= u.getNome() + " "+ u.getCognome()  %> </b></p> 
                           		 <button class="text-white dropdown-toggle" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user-cog float-left mr-2 my-auto " ></i></button>
                                  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <a class="dropdown-item" href="<%=request.getContextPath()%>/ModificaProfilo"><i class="fas fa-user pr-2"></i> Il mio profilo</a> 
                                    <a class="dropdown-item" href="<%=request.getContextPath()%>/CancellaPrenotazioneUtente"><i class="fas fa-list-ul pr-2"></i> Storico prenotazioni</a> 
                                    <a class="dropdown-item" href="<%=request.getContextPath()%>/NoleggiEffettuatiUtente""><i class="fas fa-receipt pr-2"></i> Noleggi effettuati</a> 
                                    <a class="dropdown-item" href="<%=request.getContextPath()%>/Logout"><i class="fas fa-sign-out-alt"></i> Logout</a>  
                                 </div>
                        </div> 
                   
                      <% } %>  
                    </div>
                </div>
            </nav>
            <div class="container">
            <div class="bg-light offset-xl-8 col-xl-4 px-5 d-none " id="loginform" style="position:absolute;z-index:3; right:500px;">
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