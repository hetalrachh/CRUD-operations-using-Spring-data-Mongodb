<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All registered details</title>
<script type="text/javascript"> 
   function deleteUser() {
	   alert("Details are deleted");
   }
</script>
</head>
<body>
	<h2>All registered details are</h2>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Address</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${allDetails}" var="details">
			<tr>
				<td><c:out value="${details.id}"></c:out></td>
                <td><c:out value="${details.name}"></c:out></td>
                <td><c:out value="${details.address}"></c:out></td>
				<td><a href="${pageContext.request.contextPath}/delete-a-user/${details.id}" onclick="deleteUser()">Delete details</a></td>
			</tr>
		</c:forEach>


	</table>
</body>
</html>