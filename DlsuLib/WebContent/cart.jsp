<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1">
    <title>Cart - De La Salle University - SHS Online Library</title>

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans|Lato" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Slabo+27px" rel="stylesheet">

    <!-- Stylesheets -->
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="  css/borrow-history-style.css">
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
                    <li><a href="list_catalog.html"> Catalog List</a></li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#" id="enable-search"><span class="glyphicon glyphicon-search"></span> Search</a></li>
                    <li class="active"><a href="/" onclick="return false;"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
                    <li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
						<c:if test="${account.roleId != 6}">
							${profile.lastname}, ${profile.firstname}
							&nbsp;<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="borrow_history.html">Borrow History</a></li>
								<li><a href="#">Reservation History</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="edit_profile.html">Edit Profile</a></li>
								<li><a href="#">Logout</a></li>
							</ul>
						</c:if>
						<c:if test="${account.roleId == 6}">
							Guest
							&nbsp;<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li role="separator" class="divider"></li>
								<li><a href="#">Login</a></li>
							</ul>
						</c:if>
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
      <div class="row">
      <div class="col-sm-12 col-md-10 col-md-offset-1">
          <table class="table table-hover">
              <thead>
                  <tr>
                      <th>Product</th>
                      <th> </th>
                      <th class="text-center"> </th>
                      <th class="text-center"> </th>
                      <th> </th>
                  </tr>
              </thead>
              <tbody>
              	<c:forEach var = "rc" items = "${reservedCatalogs}">
              		<tr class="reservedCatalogs" id="${rc.catalogId}">
                      <td class="col-sm-8 col-md-6">
                      <div class="media">
                          <a class="thumbnail pull-left" href="#"> <img class="media-object" src="images/book.png" style="width: 72px; height: 72px;"> </a>
                          <div class="media-body">
                              <h4 class="media-heading"><a href="#">${rc.title}</a></h4>
                              <h5 class="media-heading"> by <a href="#">${rc.author}</a></h5>
                              <c:if test="${rc.typeId == 1}">
                              	<span>Category: </span><span class="text-success"><strong>Book</strong></span>
                              </c:if>
                              <c:if test="${rc.typeId == 2}">
                              	<span>Category: </span><span class="text-success"><strong>Magazine</strong></span>
                              </c:if>
                              <c:if test="${rc.typeId == 3}">
                              	<span>Category: </span><span class="text-success"><strong>Thesis</strong></span>
                              </c:if>
                          </div>
                      </div></td>
                      <td class="col-sm-1 col-md-1" style="text-align: center"></td>
                      <td class="col-sm-1 col-md-1 text-center"> </td>
                      <td class="col-sm-1 col-md-1 text-center"> </td>
                      <td class="col-sm-1 col-md-1">
                      <button type="button" class="btn btn-danger" id="removebtn" data-id="${rc.catalogId}">
                          <span class="glyphicon glyphicon-remove"></span> Remove
                      </button></td>
                  </tr>
              	</c:forEach>

                  <tr>
                      <td>   </td>
                      <td>   </td>
                      <td><h3>Return by</h3></td>
                      <td class="text-right"><h5><${dateExpectReturn}</h5></td>
                  </tr>
                  <tr>
                      <td>   </td>
                      <td>   </td>
                      <td>   </td>
                      <td>
                      <button type="button" class="btn btn-success" id="confirmbtn">
                          Confirm Reservation <span class="glyphicon glyphicon-play"></span>
                      </button></td>
                  </tr>
              </tbody>
          </table>
      </div>
  </div>
    </div>
    
    <form action="ConfirmReservation" method="POST" id="confirm">
    	<input type="hidden" id="borrowedIDs" name = "borrowedIDs">
    </form>

    <!-- Scripts -->
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/navbar.js"></script>
	
	<script type="text/javascript">
		var catalogs = "";
		$(document).on("click", "#removebtn", function() {
			var id = $(this).data("id");
			$("#"+id).remove();
		});
		
		$(document).on("click", "#confirmbtn", function() {
			$("tr.reservedCatalogs").each(function() {
				catalogs += this.id + " ";
			});
			$("#borrowedIDs").val(catalogs);
			console.log(catalogs);
			$("#confirm").submit();
		});
	</script>
</body>

</html>
