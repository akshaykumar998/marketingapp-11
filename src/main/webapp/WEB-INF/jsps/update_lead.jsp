<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Lead</title>
</head>
<body>
	<h2>Update New Lead</h2>
	<form action="updateLead" method="post">
		<pre>
			<input type = "hidden" name="id" value="${leads.id}"/>
			First Name<input type = "text" name="firstName" value="${leads.firstName}"/>
			Last Name<input type = "text" name="lastName" value="${leads.lastName}"/>
			Email<input type = "text" name="email" value="${leads.email}"/>
			Mobile<input type = "text" name="mobile" value="${leads.mobile}"/>
			<input type = "submit" value="Save"/>
		</pre>
	</form>
	${msg}
</body>
</html>