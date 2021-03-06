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
	<link rel="stylesheet" href="  css/borrow-history-style.css">
	<link rel="stylesheet" href="css/room-reservation.css">
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
				<a class="navbar-brand" href="#">DLSU SHS Online Library</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Reserve Meeting Room<span class="sr-only">(current)</span></a></li>
					<li><a href="list_catalog.html"> Catalog List </a></li>
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
						<button type="submit" class="btn btn-default" style="width: 100px;">Submit</button>
					</form>
				</li>
			</ul>
		</div>
		<!-- /.container-fluid -->
	</nav>

	<div class="main-container">
		<div class="panel panel-default">
			<div class="panel-heading" style="font-size:2em;">Room Reservation</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-md-4">
						<label for="accountRole"	><h4>Select Room</h4></label>
						<select class="form-control" id="accountRole">
							<option value="1">Michaelangelo</option>
							<option value="2">Leonardo</option>
							<option value="3">Donatello</option>
							<option value="4">Raphael</option>
						</select>
						<img src="images/room.jpg" alt="" class="img-thumbnail">
					</div>
					<div class="col-md-8">
							<h4>Select Time Slots</h4>
							<div class="wrapper">
								<table class="table table-timeslot">
									<thead>
										<tr>
											<th>7:00-7:30</th>
											<th>7:30-8:00</th>
											<th>8:00-8:30</th>
											<th>8:30-9:00</th>
											<th>9:00-9:30</th>
											<th>9:30-10:00</th>
											<th>10:00-10:30</th>
											<th>10:30-11:00</th>
											<th>11:00-11:30</th>
											<th>11:30-12:00</th>
											<th>12:00-12:30</th>
											<th>12:30-13:00</th>
											<th>13:00-13:30</th>
											<th>13:30-14:00</th>
											<th>14:00-14:30</th>
											<th>14:30-15:00</th>
											<th>15:00-15:30</th>
											<th>15:30-16:00</th>
											<th>16:00-16:30</th>
											<th>16:30-17:00</th>
											<th>17:00-17:30</th>
											<th>17:30-18:00</th>
											<th>18:00-18:30</th>
											<th>18:30-19:00</th>
											<th>19:00-19:30</th>
											<th>19:30-20:00</th>
										</tr>
										<tr>
											<td><input id="700-730" type="checkbox"></td>
											<td><input id="700-730" type="checkbox"></td>
											<td><input id="700-730" type="checkbox"></td>
											<td><input id="700-730" type="checkbox"></td>
											<td><input id="700-730" type="checkbox"></td>
											<td><input id="700-730" type="checkbox"></td>
											<td><input id="700-730" type="checkbox"></td>
											<td><input id="700-730" type="checkbox"></td>
											<td><input id="700-730" type="checkbox"></td>
											<td><input id="700-730" type="checkbox"></td>
											<td><input id="700-730" type="checkbox"></td>
											<td><input id="700-730" type="checkbox"></td>
											<td><input id="700-730" type="checkbox"></td>
											<td><input id="700-730" type="checkbox"></td>
											<td><input id="700-730" type="checkbox"></td>
											<td><input id="700-730" type="checkbox"></td>
											<td><input id="700-730" type="checkbox"></td>
											<td><input id="700-730" type="checkbox"></td>
											<td><input id="700-730" type="checkbox"></td>
											<td><input id="700-730" type="checkbox"></td>
											<td><input id="700-730" type="checkbox"></td>
											<td><input id="700-730" type="checkbox"></td>
											<td><input id="700-730" type="checkbox"></td>
											<td><input id="700-730" type="checkbox"></td>
											<td><input id="700-730" type="checkbox"></td>
											<td><input id="700-730" type="checkbox"></td>
										</tr>
									</thead>
								</table>
							</div>
							<br><br><br><br>
							<button type="submit" href="" class="btn btn btn-primary btn-block register-input" style="background-color: #1b5e20; border-color: #1b5e20;">Reserve</button>
					</div>
				</div>



			</div>
			<!-- end of panel body -->
		</div>
	</div>

	<!-- Scripts -->
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/navbar.js"></script>



</body>

</html>
