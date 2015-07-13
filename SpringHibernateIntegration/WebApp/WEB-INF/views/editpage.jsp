<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit page</title>
<style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
	<c:url var="addAction" value="/editpage/add"></c:url>

	<form:form action="${addAction}" commandName="people">
		<table>
			<c:if test="${!empty people.name}">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8"
							disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="name">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="surname">
						<spring:message text="Surname" />
					</form:label></td>
				<td><form:input path="surname" /></td>
			</tr>
			<tr>
				<td><form:label path="age">
						<spring:message text="Age" />
					</form:label></td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td><form:label path="email">
						<spring:message text="Email" />
					</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="messages">
						<spring:message text="Messages" />
					</form:label></td>
				<td><form:input path="messages" /></td>
			</tr>

			<tr>
				<td colspan="2"><c:if test="${!empty people.name}">
						<input type="submit" value="<spring:message text="Edit People"/>" />
					</c:if> <c:if test="${empty people.name}">
						<input type="submit" value="<spring:message text="Add People"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>Persons List</h3>
	<c:if test="${!empty listPeople}">
		<table class="tg">
			<tr>
				<th width="80">ID</th>
				<th width="120">Name</th>
				<th width="120">Surname</th>
				<th width="60">Age</th>
				<th width="100">Email</th>
				<th width="120">People Messages</th>  
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listPeople}" var="people">
				<tr>
					<td>${people.id}</td>
					<td>${people.name}</td>
					<td>${people.surname}</td>
					<td>${people.age}</td>
					<td>${people.email}</td>
					<td>${people.messages}</td>

					<td><a href="<c:url value='/edit/${people.id}' />">Edit</a></td>
					<td><a href="<c:url value='/remove/${people.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>


</body>
</html>