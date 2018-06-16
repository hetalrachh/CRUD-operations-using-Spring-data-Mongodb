<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <h2>Updated details are</h2>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Address</th>
		</tr>
		<tr>
			<td><c:out value="${updatedDetails.id}"></c:out></td>
			<td><c:out value="${updatedDetails.name}"></c:out></td>
			<td><c:out value="${updatedDetails.address}"></c:out></td>
		</tr>
    </table>
</body>
</html>