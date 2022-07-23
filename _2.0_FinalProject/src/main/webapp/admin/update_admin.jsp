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

<title>Menu of User</title>
</head>
<body style="height: 100%;" class="w3-2020-brilliant-white" >

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
			<div class="card" style="width: 97%;">
				<div class="bg-soft-primary">
					<div class="card-body">
						<h4 class="card-title">ADMIN PROFILE</h4>
						
						<!--start div table   -->
						<form action="UpdateAdminController" method="post"><br>
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="adminid">Admin ID</label>
									<input class="form-control" type="text" id="adminid" name="adminid" value="${admin.adminid}" required >
								</div>
								<div class="col-md-6 mb-3">
									<label for="adminname">Name</label>
									<input class="form-control" type="text" id="adminname" name="adminname" value="${admin.adminname}" required >
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="adminphoneno">Contact No</label>
									<input class="form-control" type="text" id="adminphoneno" name="adminphoneno" value="${admin.adminphoneno}" required >
								</div>
								<div class="col-md-6 mb-3">
									<label for="adminemail">Email</label>
									<input class="form-control" type="text" id="adminemail" name="adminemail" value="${admin.adminemail}" required >
								</div>
							</div>
						<div
								style="display: flex; justify-content: center; align-items: center;">
								<button type="submit" class="btn btn-success"
									style="margin: 10px; padding: 5px 50px 5px 50px; border-radius: 10px;" onclick="UpdateSuccess()">SUBMIT</button>
							</div>
						
						</form>
								
					</div>
				</div>
			</div>
		</div>
	<script>
	function UpdateSuccess() {
	  alert("Successfully Update Admin Profile!");
	}
	</script>
</body>
</html>