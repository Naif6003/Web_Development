<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users</title>
</head>
<body>

<p> Hello Org </p>
	
	<h2> Page generated at: <fmt:formatDate value="${date}" pattern="yyy-MM-dd hh:mm:ss a" /> </h2>
	
	
	<ul>
	<li><c:out value="${the_User_List.user_Name}" /></li>
	
	<li><c:out value="${the_User_List.user_CIN}" /></li>
	
	<li><c:out value="${the_User_List.user_Gender}"/></li>
	</ul>
	
</body>
</html>