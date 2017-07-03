<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Search - De La Salle University - SHS Online Library</title>

	<!-- Fonts -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans|Lato" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Slabo+27px" rel="stylesheet">
	
	<!-- Stylesheets -->
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="css/list-catalog-style.css" rel="stylesheet" type="text/css"/>
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
			 		<li class="active"><a href="#">Reserve Meeting Room <span class="sr-only">(current)</span></a></li>
			 		<li><a href="#" id="enable-search">Search Catalog</a></li>
				 </ul>

				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Hazel Brosas <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Borrow History</a></li>
							<li><a href="#">Reservation History</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Edit Profile</a></li>
							<li><a href="#">Logout</a></li>
						</ul>
					</li>
				</ul>

				<ul class="nav navbar-nav" id="search-navbar">
					<li><a class="navbar-brand" href="#">Search Catalog</a></li>
			 		<li>
				 		<form class="navbar-form navbar-left" role="search">
				 			<div class="form-group">
				 				<select class="form-control">
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
   			</div><!-- /.navbar-collapse -->
 			</div><!-- /.container-fluid -->
	</nav>

</body>
</html>