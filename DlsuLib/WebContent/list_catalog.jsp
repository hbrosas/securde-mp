<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
					<li><a href="#">Reserve Meeting Room</a></li>
					<li class="active"><a href="list_catalog.html"> Catalog List <span class="sr-only">(current)</span></a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="#" id="enable-search"><span class="glyphicon glyphicon-search"></span> Search</a></li>
					<li><button id="btncart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</button></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${profile.lastname}, ${profile.firstname}&nbsp;<span class="caret"></span></a>
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
		<div class="container">
			<table class="table table-striped table-bordered table-hover">
				<c:forEach var = "c" items = "${allCatalog}">
					<tr class="catalog-row">
						<td class="catalog-info">
							<h4 class="catalog-title">${c.title}</h4>
							<p>${c.author} | ${c.year}</p>
							<p>${c.publisher}</p>
						</td>
						<td class="catalog-status">
							<div class="catalog-status-cont">
									<c:if test="${c.statusId == 0}">
										<div class="status-cont" style="background-color:#ef5350;">
											<span class="status">Out</span>
										</div>
									</c:if>
									<c:if test="${c.statusId == 1}">
										<div class="status-cont" style="background-color:#81c784;">
											<span class="status">Available</span>
											<!-- <span class="date">Reservation Date: ${reservationDate}</span>
											<span class="date">Anticipated Return Date: ${anticipatedReturnDate}</span> -->
										</div>
									</c:if>
									<br>
								</div>
								<button class="btn btn-block" id="viewdetails" data-userid="${account.accountId}" data-id="${c.catalogId}" data-status="${c.statusId}" 
										data-type="${c.typeId}" data-borrowId="${c.currentBorrowId}" data-loc="${c.location}" data-title="${c.title}"
										data-author="${c.author}" data-publisher="${c.publisher}" data-year="${c.year}" data-tags="${c.tags}">
										View Details
								</button>
							</div>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade modal-book" id="bookModal">
		<div class="modal-dialog">
			<input type="hidden" id="modal-id">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h1 class="modal-title" id = "modal-title">How to be badass</h1>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-3">
							<img src="images/book.png" class="img-responsive" alt="Responsive image">
						</div>
						<div class="col-md-9">
							<p id="modal-author">John Wick</p>
							<p style="font-style: italic;" id="modal-type">type: book</p>
							<span class="label label-success" id="modal-status">Available</span></div>
					</div>

					<h2>Catalog Details</h2>
					<h4>Publisher</h4>
					<p id="modal-publisher">I am Publisher</p>
					<h4>Year</h4>
					<p id="modal-year">2017</p>
					<h4>Location</h4>
					<p id="modal-loc">1234</p>
					<h4>Tags</h4>
					<p id="modal-tags">Hello, Hello2, Hello3</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-success" id="reserveButton">Reserve</button>
				</div>
			</div>
		</div>

	</div>
	</div>
	
	<form action="ReservationServlet" method="POST" id="reserveForm">
		<input type="hidden" id="brwid" name="borrowedIDs">
		<input type="hidden" id="accountid" name="accountid" value="${account.accountId}">
	</form>

	<!-- Scripts -->
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/navbar.js"></script>

	<!-- Sweet Alert -->
	<script type="text/javascript" src="js/sweetalert.min.js"></script>

	<!-- List Catalog Script -->
	<script type="text/javascript" src="js/list-catalog.js">
	</script>
	
	<script type="text/javascript">
		var borrowIDs = "";
		var id, title, statusID, typeID, accountid;
		var loc, author, publisher, year, tags;
		
		var modalTitle = $("#modal-title");
		var modalAuthor = $("#modal-author");
		var modalLocation = $("#modal-loc");
		var modalPublisher = $("#modal-publisher");
		var modalYear = $("#modal-year");
		var modalTags = $("#modal-tags");
		var modalId = $("#modal-id");
		var modalType = $("#modal-type");
		var modalStatus = $("#modal-status");
		var catalogModal = $("#bookModal");
	
		$(document).on("click", "#viewdetails", function () {
			console.log("clicked");
			var element = $(this);
			
			accountid = element.data("userid");
			id = element.data("id");
	        title = element.data("title");
			statusID = element.data("status");
			typeID = element.data("type");
			loc = element.data("loc");
			author = element.data("author");
			publisher = element.data("publisher");
			year = element.data("year");
			tags = element.data("tags");
			
			modalTitle.text(title);
			modalAuthor.text(author);
			modalLocation.text(loc);
			modalPublisher.text(publisher);
			modalYear.text(year);
			modalTags.text(tags);
			modalId.text(id);
			
			if(typeID == 1)
				modalType.text("Type: Book");
			else if(typeID == 2)
				modalType.text("Type: Magazine");
			else if(typeID == 3)
				modalType.text("Type: Thesis");
			
			if(statusID == 0){
				modalStatus.text("Out");
				$('#reserveButton').prop("disabled", true);
			}
			else if (statusID == 1){
				modalStatus.text("Available");
				$('#reserveButton').prop("disabled", false);
			}
			
			catalogModal.modal('toggle');
	    });
		
		$(document).on("click", "#reserveButton", function(){
			borrowIDs = $("#brwid").val();
			borrowIDs += id+" ";
			$("#brwid").val(borrowIDs);
			swal(title, "has been added to your cart", "success");
		});
		
		$(document).on("click", "#btncart", function(){
			$("#reserveForm").submit();
		});
	</script>
</body>

</html>
