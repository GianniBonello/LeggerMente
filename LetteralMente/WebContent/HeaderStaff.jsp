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

<link rel="stylesheet" href="css/style.css">
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500&display=swap"
	rel="stylesheet">

<title>Hello, world!</title>
<script src="https://kit.fontawesome.com/8565ef3487.js" crossorigin="anonymous"></script>
</head>
<body>


<div class="container-fluid">
  <div class="row">
  
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-dark sidebar collapse">
      <div class="sidebar-sticky pt-3">
        <ul class="nav flex-column text-center">
        
          <li class="nav-item">
            <a class="navbar-brand logo text-center pb-5" href="ControlloIniziale"><img src="res/logo-grigio.png"></a>
          </li>

          <li class="nav-item">
          	<div class="row">
            	<a class="nav-link active text-center" href="#"><i class="fas fa-home pr-5"></i><b>HOME </b><span class="sr-only">(current)</span></a>
            </div>
          </li>
          
          <li class="nav-item">
          	<div class="row">
            	<a class="nav-link text-center" href="#"><i class="fas fa-user-cog pr-5"></i>GESTIONE UTENTI</a>
            </div>
          </li>
          
          <li class="nav-item">
          	<div class="row">
            	<a class="nav-link text-center" href="#"><i class="fas fa-atlas pr-5"></i>GESTIONE LIBRI</a>
            </div>
          </li>
          
          <li class="nav-item">
          	<div class="row">
            	<a class="nav-link text-center" href="#"><i class="fas fa-dolly-flatbed pr-5"></i>GESTIONE PRENOTAZIONI</a>
            </div>
          </li>
          
          <li class="nav-item">
        		<button class="bottoneamministrativo shadow mt-5 mb-3">HOMEPAGE</button>
          </li>
          
          <li class="nav-item">
        		<button class="bottoneamministrativo shadow">LOGOUT</button>
          </li>
        </ul>
        
        	
        	
        	

    </nav>
    
<jsp:include page="/footerStaff.jsp"></jsp:include>    