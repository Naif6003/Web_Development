<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View User Obj</title>


<link rel="stylesheet" href="css/main.css">

</head>
<body>


<h2> Page generated at: <fmt:formatDate value="${date}" pattern="yyy-MM-dd hh:mm:ss a" /> </h2>
<table>
<tr><th>The events</th> <th>Event info</th> <th>Link<th></tr>
<c:forEach items="${events}" var="ViewEvent" varStatus="loop" >
<tr>
<td>${ViewEvent.event_Name}</td>
<td>${ViewEvent.event_Description}</td>
<td><a href="ViewEachEvent?id=${loop.index}"> Event Details </a></td>
</tr>
</c:forEach>
</table>

</body>
</html>