<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.1/examples/sign-in/">
<!-- Bootstrap core CSS -->
<link href="../assets/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap Icon -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.0/font/bootstrap-icons.css">
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<link href="../assets/css/signin.css" rel="stylesheet">
</head>
<body class="text-center">
<div class="modal modal-signin position-static d-block bg-secondary py-5"
	tabindex="-1" role="dialog" id="modalSignin">
	<img src="../assets/images/6287.jpeg" style="position: absolute; top: 0px; left: 0px; height: 100%; width:1920px; object-fit: cover; overflow-y:hidden;" 
	alt= "background">
	<div class="modal-dialog" role="document">
			<div class="modal-content rounded-5 shadow">
				<main class="form-signin">
					<form action="../LoginUserController" method="post">
						<img class="mb-4" src="../assets/images/MyBus Logo1.svg" alt="" width="300" height="100">
						<ul class="nav nav-pills navtab-bg nav-justified">
							<li class="nav-item"><a href="../user/signin_user.jsp" 
							data-toggle="tab" aria-expanded="true" class="nav-link active">User</a></li>
							<li class="nav-item"><a href="../admin/signin_admin.jsp" 
							data-toggle="tab" aria-expanded="false" class="nav-link">Admin</a></li>
						</ul><br><br>
						<h1 class="h3 mb-3 fw-normal">User Login</h1>
						<!-- Input for admin id and password -->
						<div class="mb-3">
							<input class="form-control" type="email" placeholder="User Email" name="email" required>
						</div>
						<div class="mb-3">
							<input class="form-control" type="password" placeholder="Password" name="password" required>
						</div>
						<button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button><br><br>
						<button class="w-100 btn btn-lg btn-primary" onclick="document.location='register_user.jsp'">Register Account</button><br><br>
						<div class="checkbox mb-3">
							<a target="_blank" href="#" class="text-muted"><i class="bi-lock"></i> Forget Password?</a>
						</div>
						<button onclick="document.location='../index.html'" type="button" class="btn btn-success "><i class="bi bi-arrow-left"></i>Home</button>
						<p class="mt-5 mb-3 text-muted">&copy; 2021–2022</p>
					</form>
				</main>
			</div>
		</div>
	
	
	


</div>

</body>
</html>