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
        <ul class="nav flex-column">
        
        <li class="nav-item text-center">
            <a class="navbar-brand logo " href="ControlloIniziale"><img src="res/logo-grigio.png"></a>
          </li>

          <li class="nav-item text-center">
            <a class="nav-link active" href="#">
              <span data-feather="home"></span>
              HOME <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item text-center">
            <a class="nav-link" href="#">
              <span data-feather="users"></span>
              GESTIONE UTENTI
            </a>
          </li>
          <li class="nav-item text-center">
            <a class="nav-link" href="#">
              <span data-feather="users"></span>
              GESTIONE LIBRI
            </a>
          </li>
          <li class="nav-item text-center">
            <a class="nav-link" href="#">
              <span data-feather="users"></span>
              GESTIONE PRENOTAZIONI
            </a>
          </li>
        </ul>
        <div class="text-center comandi">
        	<div class="row">
        		<button class="bottoneamministrativo shadow">HOMEPAGE</button>
        	</div>
        	
        	<div class="row">
        		<button class="bottoneamministrativo shadow">LOGOUT</button>
        	</div>
      	</div>
    </nav>
    
<jsp:include page="/footerStaff.jsp"></jsp:include>    