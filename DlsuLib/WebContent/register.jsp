<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1">
	<title>De La Salle University - SHS Online Library</title>

	<!-- Fonts -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans|Lato" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Slabo+27px" rel="stylesheet">

	<!-- Stylesheets -->
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="css/register-style.css" rel="stylesheet" type="text/css" />
</head>

<body class="the-body">
	<div class="main-container">
		<form role="form">
			<div class="main-title">Registration</div>

			<div class="row">
				<div class="col-md-6 col-xs-12 registration-form">
					<div class="form-inline">
						<div class="form-group">
							<label for="inputFirstName" style="font-family: 'Open Sans'; font-weight: 100;">First Name</label><br>
							<input type="text" class="form-control" id="inputFirstName">
						</div>
						&nbsp; &nbsp;
						<div class="form-group">
							<label for="inputMiddleInitial" style="font-family: 'Open Sans'; font-weight: 100;">M.I.</label><br>
							<input type="text" class="form-control" id="inputMiddleInitial" style="width: 40px;">
						</div>
					</div>

					<br>

					<div class="form-group">
						<label for="inputLastName" style="font-family: 'Open Sans'; font-weight: 100;">Last Name</label>
						<input type="text" class="form-control register-input" id="inputLastName">
					</div>
					<div class="form-group">
						<label for="inputEmail" style="font-family: 'Open Sans'; font-weight: 100;">Email</label>
						<input type="text" class="form-control register-input" id="inputEmail">
					</div>
					<div class="form-group">
						<label for="inputStudentNo" style="font-family: 'Open Sans'; font-weight: 100;">Student Number</label>
						<input type="text" class="form-control register-input" id="inputStudentNo">
					</div>
				</div>
				<div class="col-md-6 col-xs-12 registration-form">
					<div class="form-inline">
						<div class="form-group">
							<label for="input" style="font-family: 'Open Sans'; font-weight: 100;">Birthday</label><br>
							<input type="text" placeholder="DD" class="form-control" id="inputDay" style="width:60px"> &nbsp;&nbsp; <span style="font-size: 1.5em">/</span> &nbsp;&nbsp;
							<input type="text" placeholder="MM" class="form-control" id="inputMonth" style="width:60px"> &nbsp;&nbsp; <span style="font-size: 1.5em">/</span> &nbsp;&nbsp;
							<input type="text" placeholder="YYYY" class="form-control" id="inputYear" style="width:90px">
						</div>
					</div>

					<br>

					<div class="form-group">
						<label for="inputPassword" style="font-family: 'Open Sans'; font-weight: 100;">Password</label>
						<input type="password" class="form-control register-input" id="inputPassword">
					</div>
					<div class="form-group">
						<label for="inputConfirmPassword" style="font-family: 'Open Sans'; font-weight: 100;">Confirm Password</label>
						<input type="password" class="form-control register-input" id="inputConfirmPassword">
					</div>

						<div class="form-group">
							<label for="accountRole" style="font-family: 'Open Sans'; font-weight: 100;"	>Account Role</label>
							<select class="form-control" id="accountRole">
								<option>Student</option>
								<option>Library Manager</option>
								<option>Library Staff</option>
							</select>
						</div>
					<br>
					<button type="submit" href="" class="btn btn btn-primary btn-block register-input" style="background-color: #1b5e20; border-color: #1b5e20;">Register</button>
					<br>
				</div>
			</div>



		</form>
	</div>

	</div>
	<!-- body -->

	<!-- Scripts -->
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>


</body>

</html>
