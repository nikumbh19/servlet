<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>YMSLI Trainee Application</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}
tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
<br><br>
Welcome ${user.username}&nbsp;&nbsp;&nbsp;<a href="LogoutController">Logout</a>
<br><br>

	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>trainee name</th>
				<th>branch</th>
				<th>percentage</th>
				<th>update</th>
				<th>delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${trainees}" var="trainee">
				<tr>
					<td>${trainee.id}</td>
					<td>${trainee.name}</td>
					<td>${trainee.branch}</td>
					<td>${trainee.percentage}</td>
					<td><a href="TraineeController.do?action=update&id=${trainee.id}">update</a></td>
					<td><a href="TraineeController.do?action=delete&id=<c:out value="${trainee.id}"/>">delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<br>
<a href="TraineeController.do?action=addtrainee">Add new trainee</a>
</body>
</html>