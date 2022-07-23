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
	response.sendRedirect("index.html");
%>
<%
int id = (Integer) session.getAttribute("currentSessionUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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

<title>List of Buses</title>
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
<form action="#" method="post">
<div class="backg">
	<div class="card" style="width: 80%; margin-left:10%; margin-right:10%;">
		<div class="bg-soft-primary">
			<div class="card-body">
				<button type="button" class="btn btn-outline-danger" onclick="document.location='AdminMenuController'">
<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left-square-fill" viewBox="0 0 16 16">
<path d="M16 14a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12zm-4.5-6.5H5.707l2.147-2.146a.5.5 0 1 0-.708-.708l-3 3a.5.5 0 0 0 0 .708l3 3a.5.5 0 0 0 .708-.708L5.707 8.5H11.5a.5.5 0 0 0 0-1z"></path>
</svg> BACK </button>
				<h4 class="card-title">LIST OF BUSES  <br></h4>
				<div class="d-grid gap-2 d-md-flex justify-content-md-end">
				<a href="AddBusController"
								data-toggle="tab" aria-expanded="false" class="nav-link"
								style="border-radius: 15px; margin: 10px; color: black">ADD NEW BUS
				</a>

				</div>
				<table class="table">
				  <thead>
				    <tr>
				     
				      <th class="table-primary" scope="col">Bus ID</th>
				      <th class="table-primary" scope="col">Bus Company</th>
				      <th class="table-primary" scope="col">Driver Name</th>
						<th class="table-primary" scope="col">Actions</th>
				    </tr>
				  </thead>
				  <c:forEach items="${bus}" var="bus" >
				  <tr>
				   
				      <td scope="row">${bus.busid}</td>
				      <td>${bus.buscompany}</td>
				      <td>${bus.drivername}</td>
				      
				      <td>
						<button type="button" class="btn btn-success"
							style="margin: 10px; padding: 5px 50px 5px 50px; border-radius: 10px;"
							onclick="document.location='UpdateBusController?busid=${bus.busid}'">UPDATE</button>
						<input type="hidden" id="busid-${bus.busid}" value="<c:out value="${bus.busid}"/>">
						<a class="btn btn-danger" onclick="confirmDelete('${bus.busid}')">Delete</a>
					</td>
					
				  </tr>
				  </c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>
</form>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
	<script>
		function confirmDelete(index) {
			var busid = $("#busid-" + index).val();
			var r = confirm("Are you sure want to delete bus " + busid + "?");
			if (r == true) {
				location.href = 'DeleteBusController?busid='+ busid;
				alert("Bus deleted!");
			} else {
				return false;
			}
		}
	</script>

</body>
</html>