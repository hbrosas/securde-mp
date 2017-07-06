<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1">
	<title>Search - De La Salle University - SHS Online Library</title>

	<!-- Fonts -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans|Lato" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Slabo+27px" rel="stylesheet">

	<!-- Stylesheets -->
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="css/list-catalog-style.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="css/sweetalert.css">
  <link rel="stylesheet" href="css/jquery.dataTables.min.css">
</head>

<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				<a class="navbar-brand" href="list_catalog.html">DLSU SHS Online Library</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="room_reservation.html">Reserve Meeting Room</a></li>
					<li><a href="list_catalog.html"> Catalog List <span class="sr-only">(current)</span></a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="#" id="enable-search"><span class="glyphicon glyphicon-search"></span> Search</a></li>
					<li><a href="cart.html"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Hazel Brosas <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="borrow_history.html">Borrow History</a></li>
							<li><a href="#">Reservation History</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="edit_profile.html">Edit Profile</a></li>
							<li><a href="#">Logout</a></li>
						</ul>
					</li>
				</ul>


			</div>
			<!-- /.navbar-collapse -->
			<ul class="nav navbar-nav" id="search-navbar">
				<li>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<select class="form-control">
										<option value="Title">Title</option>
					 					<option value="Location">Location</option>
					 					<option value="Author">Author</option>
					 					<option value="Publisher">Publisher</option>
					 					<option value="Tags">Tags</option>
					 				</select>
							<input type="text" class="form-control" placeholder="Keyword" style="width: 800px;">
							<select class="form-control">
					 					<option value="Books">Books</option>
					 					<option value="Magazines">Magazines</option>
					 					<option value="Thesis">Thesis</option>
					 				</select>
						</div>
						<a href="search_catalog.html" type="button" class="btn btn-default" style="width: 100px;">Submit</a>
					</form>
				</li>
			</ul>
		</div>
		<!-- /.container-fluid -->
	</nav>

	<div class="main-container container" style="border:solid;">
    <h2>Displaying results for 'Singing'</h2>
    <br>
    <table id="search-table" class="display" cellspacing="0" width="100%">
      <thead>
        <tr>
          <th>Title</th>
          <th>Author</th>
          <th>Category</th>
          <th>Availability</th>
          <th> </th>
        </tr>
      </thead>

      <tbody>
        <tr>
          <td>Singing in the rain</td>
          <td>Rihanna</td>
          <td>Magazine</td>
          <td><span class="label label-primary">Available</span></td>
          <td><button class="btn btn-block" data-toggle="modal" data-target="#bookModal">View Details</button></td>
        </tr>
      </tbody>
    </table>
	</div>

	<!-- Modal -->
	<div class="modal fade modal-book" id="bookModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h1 class="modal-title">How to be badass</h1>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-3">
							<img src="images/book.png" class="img-responsive" alt="Responsive image">
						</div>
						<div class="col-md-9">
							<p>by John Wick</p>
							<p style="font-style: italic;">type: book</p>
							<span class="label label-success">Available</span></div>
					</div>

					<h2>Overview</h2>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure
						dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-success" id="reserveButton">Reserve</button>
				</div>
			</div>
		</div>

	</div>
	</div>

	<!-- Scripts -->
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/navbar.js"></script>

	<!-- Sweet Alert -->
	<script type="text/javascript" src="js/sweetalert.min.js"></script>

  <!-- JQuery Data Tables -->
  <script type="text/javascript" src="js/jquery.dataTables.min.js"></script>

  <!-- Search Catalog Script -->
  <script type="text/javascript" src="js/search-catalog.js"></script>
</body>

</html>
