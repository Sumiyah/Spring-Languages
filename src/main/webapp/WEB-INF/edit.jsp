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
	<div class ="row justify-content-between text-center mt-4 mb-3">
		<h1>Edit the ${language.name} Language</h1>
		<h6>
				<a href="/">Home</a></h6>
	</div>
		<form:form action="/${ language.id }" method="post" modelAttribute="language">
			<input type="hidden" name="_method" value="put">
		    <div class="form-group">
		        <form:label path="name">Language Name</form:label>
		        <form:errors path="name"/>
		        <form:input class="form-control" path="name"/>
		    </div>
		    <div class="form-group">
		        <form:label path="creator">Creator</form:label>
		        <form:errors path="creator"/>
		        <form:input class="form-control" path="creator"/>
		    </div>
			<div class="form-group">
		        <form:label path="currentVersion">Current Version</form:label>
		        <form:errors path="currentVersion"/>
		        <form:input class="form-control" path="currentVersion"/>
		    </div>
		    <input class="btn btn-sm btn-success" type="submit" value="Edit"/>
		</form:form>
	</div>
</body>
</html>