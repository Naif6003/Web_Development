<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

<h2> Page generated at: <fmt:formatDate value="${date}" pattern="yyy-MM-dd hh:mm:ss a" /> </h2>
	
	
	<h1> Page to show each event </h1>
	
	
	<ul>
	<li><c:out value="${event.event_Name}" /></li>
	
	<li><c:out value="${event.event_Description}" /></li>
	
	<%-- <li><c:out value="${event.start_Date}"/></li>
	
	<li><c:out value="${event.end_Date}"/></li> --%>
	
	<li><c:out value="${event.event_Attendance}"/></li>
	
	<li><c:out value="${the_user_List.user_Name}" /></li>
	
	
	<li><a href="Users_Info?id=${id}" > user contact info </a></li>
	
	<li><a href="ViewEachOrganization?id=${id}">ViewEachOrganization?id=${id}</a></li>
	
	<%-- <c:forEach items="${event.list_of_Members}" var="members">
	<li>${members}</li>
	</c:forEach> --%>
	</ul>
	
	
</body>
</html>