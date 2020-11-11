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
<link rel="stylesheet" href="css\style.css">
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/8565ef3487.js" crossorigin="anonymous"></script>



</head>
<body>
 
            <nav class="navbar navbar-expand-lg navbar-light bg-light shadow mb-3">
                <div class="container">
                <a class="navbar-brand logo " href="#"><img src="res/Logo-nero.png"></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active"><a class="nav-link" href="header.jsp">HOME
                                <span class="sr-only">(current)</span>
                        </a></li>
                        <li class="nav-item"><a class="nav-link" href="listalibri.jsp">LISTA LIBRI</a></li> 
                    </ul>
                      <% 
                            if(request.getSession().getAttribute("utenteLoggato")==null) { 
                         %> 
                         
                        <button class=" login mr-3" id="login" onclick="login()" > LOGIN </button>
                        <a href="Registrazione"><button type="submit">REGISTRAZIONE</button></a> <!-- PAGINA REGISTRAZIONE -->
                        
                     <% }else{
                            Utente u = (Utente) request.getSession().getAttribute("utenteLoggato"); %> 
                            
                         <div class="dropdown">
                            <button class="dropdown-toggle" style="color:white" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user-cog fa-2x" ></i></button> <p><b>Ciao <%= u.getNome() + " "+ u.getCognome()  %> </b></p>
                                  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <a class="dropdown-item" href="#"><i class="fas fa-user pr-2"></i> Il mio profilo</a> 
                                    <a class="dropdown-item" href="#"><i class="fas fa-list-ul pr-2"></i> Storico prenotazioni</a> 
                                    <a class="dropdown-item" href="#"><i class="fas fa-receipt pr-2"></i> Noleggi effettuati</a> 
                                    <a class="dropdown-item" href="Logout"><i class="fas fa-sign-out-alt"></i> Logout</a>  
                                 </div>
                        </div> 
                   
                      <% } %>  
                    </div>
                </div>
            </nav>