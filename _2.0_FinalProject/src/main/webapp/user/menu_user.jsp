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
<meta charset="ISO-8859-1">
<!-- Bootstrap -->
<link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/sidebars/">
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/css/sidebars.css" rel="stylesheet">
<link href="assets/css/menu_student.css" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> 
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-2021.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-2020.css">
<title>Menu of User</title>
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
		      <a class="navbar-brand mt-2 mt-lg-0" href="UserMenuController">
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
		          href="UserMenuController"
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
	<!--  <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark"
	style="width: 15%; min-width: 200px; overflow: hidden; height: 100%;" >
	<a href="AdminMenuController"
				class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
				<span class="fs-4">Admin Menu</span>
	</a>
	<a href="ListAllTripController" class="nav-link active"> 
				<i class="bi bi-justify"></i> List Trip</a>

	</div>
	-->
	<div class="backg">
		<br>
			<div class="card" style="width: 90%; margin: auto;">
				<div class="tile_div" style="text-align: center;">
				    <a style="margin-right:10px; text-decoration:none" href="SearchTripController">BOOK A TRIP</a>
				    <a style="margin-right:10px; text-decoration:none" href="ListBookingByIdController">VIEW BOOKING</a>		
				    <div class="clear"></div>
				</div>
			</div>
		<br>
	</div>
	
	<!--  Content -->
		<div class="backg">
			<div class="card" style="width: 80%; margin-left:10%; margin-right:10%;">
				<div class="bg-soft-primary">
					<div class="card-body">
						<h4 class="card-title">USER PROFILE</h4>
						<!--start div table   -->
						<div class="table-responsive mt-4">
							<table class="table table-centered table-nowrap">
								<tbody>
									<tr>
										<td style="width: 20%">
											<p class="mb-0">USER ID</p>
										</td>
										<td style="width: 30%">
											<h5 class="mb-0">${user.id}</h5>
										</td>
									</tr>
									<tr>
										<td>
											<p class="mb-0">NAME</p>
										</td>
										<td>
											<h5 class="mb-0">${user.name}</h5>
										</td>
									</tr>
									<tr>
										<td>
											<p class="mb-0">CONTACT NUMBER</p>
										</td>
										<td>
											<h5 class="mb-0">${user.phoneno}</h5>
										</td>
									</tr>
									<tr>
										<td>
											<p class="mb-0">EMAIL</p>
										</td>
										<td>
											<h5 class="mb-0">${user.email}</h5>
										</td>
									</tr>
								</tbody>
							</table>
							<div style= "display:flex; justify-content:center">
						       
						        <button type="button" class="btn btn-success me-3 col-6" onclick="document.location='UpdateUserController?id=${u.id}'">UPDATE</button>
						        
						        <input type="hidden" id="id-${user.id}" value="<c:out value="${user.id}"/>">
								<button type="button" class="btn btn-danger me-3 col-6" onclick="confirmDelete('${user.id}')">DELETE ACCOUNT</button>
      						</div>		
						</div>
					</div>				
				</div>
			</div>
			<br>
		</div>
		
		<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
		<script>
			function confirmDelete(index) {
				var id = $("#id-" + index).val();
				var r = confirm("Are you sure want to delete this account?");
				if (r == true) {
					location.href = 'DeleteUserController?id='+ id;
					alert("Successfull delete account!");
				} else {
					return false;
				}
			}
		</script>
</body>
</html>