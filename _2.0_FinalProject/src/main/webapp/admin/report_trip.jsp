<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%//prevent Caching of JSP Pages
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires",0);
//get session and check if session null, go to login page
if(session.getAttribute("currentSessionUser")==null)
	response.sendRedirect("index.html");%>
<%int id = (Integer) session.getAttribute("currentSessionUser");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap -->
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.1/examples/sidebars/">
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/css/sidebars.css" rel="stylesheet">
<link href="assets/css/menu_student.css" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> 
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-2021.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-2020.css">

<title>Report of Trips</title>
</head>
<body style="height: 100%;" class="w3-2020-brilliant-white">

<!-- Navbar -->
<nav class="navbar navbar-expand-lg" style="margin: 5px">
  <!-- Container wrapper -->
  <div class="container-fluid">
    <!-- Toggle button -->
    <button
      class="navbar-toggler"
      type="button"
      data-mdb-toggle="collapse"
      data-mdb-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <i class="fas fa-bars"></i>
    </button>

    <!-- Collapsible wrapper -->
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <!-- Navbar brand -->
      <a class="navbar-brand mt-2 mt-lg-0" href="AdminMenuController">
        <img
          src="assets/images/MyBus Logo.png"
          height="40"
          alt="MDB Logo"
        />
        <small>MyBus Management</small>
      </a>

    </div>
    <!-- Collapsible wrapper -->

    <!-- Right elements -->
    <div class="d-flex align-items-center">

      <!-- Avatar -->
      <div>
        <a
          class=" d-flex align-items-center px-4"
          href="AdminMenuController"
          id="navbarDropdownMenuAvatar"
          role="button"
			
        >
          <img
            src="assets/images/img_avatar.png"
            class="rounded-circle"
            height="25" />
        </a>
      </div>
      
      <!-- Icon -->
      <a class="btn btn-dark px-4" href="LogoutController">
        <small>Logout</small>
      </a>
    </div>
    <!-- Right elements -->
  </div>
  <!-- Container wrapper -->
</nav>
<!-- Navbar -->

<!--  Content -->
<div class="backg">
			<div class="card" style="width: 80%; margin-left:10%; margin-right:10%;">
				<div class="bg-soft-primary">
					<div class="card-body">
						<h4 class="card-title">Report of Trips<br></h4>
						
						<form action="" method="post"><br>
						<label for="tripid">Trip ID</label>				
							<select class="form-control" id="tripid" name="tripid">
							<c:forEach items="${trips}" var="trip">
							<option value="<c:out value="${trip.tripid}"/>"><c:out value="${trip.tripid}"/></option>
							</c:forEach>
							</select>
							<div
								style="display: flex; justify-content: center; align-items: center;">
								<button type="submit" class="btn btn-success"
									style="margin: 10px; padding: 5px 50px 5px 50px; border-radius: 10px;">SUBMIT</button>
								<button type="reset" class="btn btn-secondary"
									style="margin: 10px; padding: 5px 50px 5px 50px; border-radius: 10px;">RESET</button>
							</div>
							<br><br>
						</form>
					</div>
					<br>
					<div class="card-body">
						<h4 class="card-title">Informations of Trip<br></h4>
						
						<table class="table">
						  <thead>
						    <tr>
						      <th class="table-primary" scope="col">Trip ID</th>
						      <th class="table-primary" scope="col">Bus ID</th>
						      <th class="table-primary" scope="col">Departure</th>
						      <th class="table-primary" scope="col">Destination</th>
						      <th class="table-primary" scope="col">Date</th>
						      <th class="table-primary" scope="col">Time</th>		      
						      <th class="table-primary" scope="col">Admin ID</th>
						    </tr>
						  </thead>
						  <c:forEach items="${trip}" var="trip">
						  <tr>
						   
						      <td scope="row">${trip.tripid}</td>
						      <td>${trip.busid}</td>
						      <td>${trip.departure}</td>
						      <td>${trip.destination}</td>
						      <td>${trip.date}</td>
						      <td>${trip.time}</td>
						      <td>${trip.adminid}</td>
						      
						  </tr>
						  </c:forEach>
						</table>	
					</div>
			</div>
			<div class="bg-soft-primary">
					<div class="card-body">
						<h4 class="card-title">List of Booking Trips Details<br></h4>
						<table class="table">
						  <thead>
						    <tr>
						      <th class="table-primary" scope="col">User Id</th>
						      <th class="table-primary" scope="col">User Name</th>
						      <th class="table-primary" scope="col">User Phone No</th>
						      <th class="table-primary" scope="col">User Email</th>
						    </tr>
						  </thead>
						  <c:forEach items="${users}" var="user">
						  <tr>						   
						      <td scope="row">${users.id}</td>
						      <td scope="row">${users.name}</td>
						      <td scope="row">${users.phoneno}</td>
						      <td scope="row">${users.email}</td>
						  </tr>
						  </c:forEach>
						</table>	
					</div>
			</div>
	</div>
</div>