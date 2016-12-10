<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Menus </title>
	 <link rel="stylesheet" href="css/main.css">
	 

</head>
<body>

<h1>Menus From Database</h1>

	<table>
	<tr><th>id</th><th>name</th><th>Action</th><th>Description</th></tr>
	<c:forEach items="${menus}" var="menus" varStatus="loop">
      <tr >
      	<td>${menus.menu_id}</td>
		<td><a href="Each_Menu?id=${menus.menu_id}">${menus.menu_name}</a></td>
		<td><a href="Edit_Menu?id=${menus.menu_id}">Edit</a>/<a href="Delete?id=${menus.menu_id}">Delete</a></td>
		<td>${menus.menu_description}</td>
      </tr>
	</c:forEach>
	</table>

        
	    <a href="Add_Menu">Add Menu</a>

	<a href="Logout">Logout</a>
	

</body>
</html>