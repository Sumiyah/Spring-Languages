<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Languages</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-around mb-5 text-center">
			<h1>Welcome to Languages!</h1>
			<h6>
				<a href="/new">new language</a></h6>
		
			</div>
		<div class="row">
			<table class="table border">
				<thead class="bg-info">
					<tr>
						<th>Name</th>
						<th>Creator</th>
						<th>Version</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${languages}" var="languages">
						<tr>
							<td><a href="/${ languages.id }"><c:out value="${languages.name}" /></a></td>
							<td><c:out value="${languages.creator}" /></td>
							<td><c:out value="${languages.currentVersion}" /></td>
							<td><div class="row justify-content-center">
									<form id="delete-form" action="/${languages.id}" method="post"> <input
											type="hidden" name="_method" value="delete"><input
											type="submit" value="Delete" class="btn btn-sm btn-danger">
									</form> <a class="btn btn-sm btn-success ml-2"
										href="/${ languages.id }/edit">Edit</a>
								</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>