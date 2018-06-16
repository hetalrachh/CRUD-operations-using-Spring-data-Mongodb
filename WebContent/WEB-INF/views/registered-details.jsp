<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registered details</title>
</head>
<body>
  <form action="saveedit.html" method="post">
	<h1>Your details are saved in the database</h1>

	<!-- Passing static value -->
	<a href="${pageContext.request.contextPath}/view-registered-details/5">View
		your registered details</a>
		
	<br/><br/>
		
	<!-- View all registered details -->
    <a href="${pageContext.request.contextPath}/view-all-registered-details">View
		all registered details</a>
		
	<h2>Edit details</h2>
	<p>
		Student name : <input type="text" name="name" />
	</p>
	<p>
		Student id : <input type="text" name="id" />
	</p>
	<p>
	    Address : <input type="text" name="address" />
	</p>
	<p>
	  <input type="submit" name="submit" value="Save edit" />
	</p>
</form>
</body>
</html>