<!doctype html>
<html lang="en" >
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
 
<!--  <link rel="stylesheet" href="/LeggerMente/WebContent/css/style.css">-->
<style type="text/css">

<%@ include file="../css/style.css" %>
</style>

<link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500&display=swap" rel="stylesheet">

<title>LeggerMente - Libreria di Roma</title>
<script src="https://kit.fontawesome.com/8565ef3487.js" crossorigin="anonymous"></script>

</head>
<body style="background: linear-gradient(45deg, rgba(190, 56, 123, 0.7),rgba(21, 169, 189, 0.7)) center center fixed ,url(<%=request.getContextPath()%>/res/bgstaff.jpg) no-repeat center center fixed">


<div class="container-fluid" style="padding-right:0px!important; padding-left:0px!important">
  
    <nav id="sidebarMenu" class="hidden-sm hidden-md col-md-4 col-lg-3 col-xl-2 d-md-none d-lg-block bg-dark sidebar collapse">
      <div class="sidebar-sticky pt-3">
      
        <ul class="nav flex-column text-center m-auto w-100 h-100" style="justify-content:center" >
        
        
          <li class="nav-item">
            <a class="navbar-brand logo text-center pb-5" href="<%=request.getContextPath()%>/view/homestaff.jsp"><img src="<%=request.getContextPath()%>/res/logo-grigio.png"></a>
          </li>

          <li class="nav-item">
          	<div class="row">
            	<a class="nav-link text-center " href="<%=request.getContextPath()%>/view/homestaff.jsp"><i class="fas fa-home pr-5" style="width:68px;" ></i><b>HOME </b></a>
            </div>
          </li>
          
          <li class="nav-item">
          	<div class="row">
            	<a class="nav-link text-center" href="<%=request.getContextPath()%>/ListaUtenti"><i class="fas fa-user-cog pr-5" style="width:68px;"></i>GESTIONE UTENTI</a>
            </div>
          </li>
          
          <li class="nav-item">
          	<div class="row">
            	<a class="nav-link text-center" href="<%=request.getContextPath()%>/ListaLibri"><i class="fas fa-atlas pr-5" style="width:68px;"></i>GESTIONE LIBRI</a>
            </div>
          </li>
          
          <li class="nav-item">
          	<div class="row">
            	<a class="nav-link text-center"  href="<%=request.getContextPath()%>/ListaPrenotazioniStaff"><i class="fas fa-dolly-flatbed pr-5" style="width:68px;"></i>GESTIONE PRENOTAZIONI</a>
            </div>
          </li>
          
          <li class="nav-item">
        		<div class="row">
            		<a class="nav-link text-center" href="<%=request.getContextPath()%>/ListaNoleggiStaff"><i class="fas fa-clipboard-list pr-5" style="width:68px;"></i>GESTIONE NOLEGGI</a>
            	</div>
          </li>
          
          <li class="nav-item">
        		<a href="<%=request.getContextPath()%>/Logout"><button class="bottoneamministrativo shadow mt-5">LOGOUT</button></a>
          </li>
        </ul>
    </nav>
  
  
   <nav class="d-lg-none d-sm-block  navbar navbar-expand-lg navbar-dark bg-dark shadow mb-3 text-center">
                <div class="container">
                <a class="navbar-brand logo" href="<%=request.getContextPath()%>/ControlloIniziale"><img src="<%=request.getContextPath()%>/res/Logo-grigio.png"></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="nav flex-column text-center m-auto w-100 h-100" style="justify-content:center" >
        
          <li class="nav-item">
            <a class="navbar-brand logo text-center pb-5" href="<%=request.getContextPath()%>/view/homestaff.jsp"><img src="<%=request.getContextPath()%>/res/logo-grigio.png"></a>
          </li>

          <li class="nav-item">
          	<div class="row">
            	<a class="nav-link text-center " href="<%=request.getContextPath()%>/view/homestaff.jsp"><i class="fas fa-home pr-5" style="width:68px;" ></i><b>HOME </b></a>
            </div>
          </li>
          
          <li class="nav-item">
          	<div class="row">
            	<a class="nav-link text-center" href="<%=request.getContextPath()%>/ListaUtenti"><i class="fas fa-user-cog pr-5" style="width:68px;"></i>GESTIONE UTENTI</a>
            </div>
          </li>
          
          <li class="nav-item">
          	<div class="row">
            	<a class="nav-link text-center" href="<%=request.getContextPath()%>/ListaLibri"><i class="fas fa-atlas pr-5" style="width:68px;"></i>GESTIONE LIBRI</a>
            </div>
          </li>
          
          <li class="nav-item">
          	<div class="row">
            	<a class="nav-link text-center"  href="<%=request.getContextPath()%>/ListaPrenotazioniStaff"><i class="fas fa-dolly-flatbed pr-5" style="width:68px;"></i>GESTIONE PRENOTAZIONI</a>
            </div>
          </li>
          
          <li class="nav-item">
        		<div class="row">
            		<a class="nav-link text-center" href="<%=request.getContextPath()%>/ListaNoleggiStaff"><i class="fas fa-clipboard-list pr-5" style="width:68px;"></i>GESTIONE NOLEGGI</a>
            	</div>
          </li>
          
          <li class="nav-item">
        		<a href="<%=request.getContextPath()%>/Logout"><button class="bottoneamministrativo shadow mt-5">LOGOUT</button></a>
          </li>
        </ul>
                    </div>
                </div>
            </nav>
  
  
  
  
   