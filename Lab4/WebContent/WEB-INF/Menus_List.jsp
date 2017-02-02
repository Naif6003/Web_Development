<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  
<!DOCTYPE html >
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Student Union Menu</title>
	 <link rel="stylesheet" href="css/main.css">
	 

</head>
<body>

<h1>Menus From Database</h1>
	<table>
	<tr><th>id</th><th>name</th><th>Description</th></tr>
	<c:forEach items="${menus}" var="menus" varStatus="loop">
      <tr>
      	<td>${menus.menu_id}</td>
		<td>     ${menus.menu_name}</td>
		<td>     ${menus.menu_description}</td>
      </tr>
	</c:forEach>
	</table>
	<br><br>
	<a href="AddEmployee">Add Employee</a>

</body>
</html>