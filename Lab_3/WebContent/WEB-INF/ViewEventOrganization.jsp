<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<p> Hello Org </p>
	
	<h2> Page generated at: <fmt:formatDate value="${date}" pattern="yyy-MM-dd hh:mm:ss a" /> </h2>
	
	
	<ul>
	<li><c:out value="${org_List.org_Type}" /></li>
	
	<li><c:out value="${the_president_user_List.user_Name}" /></li>
	
	<li><c:out value="${the_secretary_user_List.user_Name}"/></li>

	
	<!--  How to loop though the list of members  -->
	<%-- <c:forEach items="${list}" var="ListEvents" varStatus="loop" >
	
	<li><c:out value="${loop.index}"/></li>
	
	</c:forEach> --%>
	
	
	
	<li><a href="Users_Info?id=${id}">Users_Info?id=${id}</a></li>
	</ul>

</body>
</html>