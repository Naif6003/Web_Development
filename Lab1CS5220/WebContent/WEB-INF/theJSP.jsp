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

<form action="mainServlet" method="Post" >
<table border="1" cellpadding="5" width="300">

<thead>
              <tr>
              	<th> Id </th>
                <th>Quantity</th>
                <th>Unit 1</th>
                <th>  </th>
                <th>Quantity</th>
                <th>Unit 2</th>
                <th>   </th>
              </tr>
            </thead>
 	<tbody>
 			<c:forEach items="${theUnits}" var="theUnits" varStatus="loop" >
 				<tr>
 					<td> ${theUnits.id}</td>
					<td>${theUnits.quantity}</td>
					<td>${theUnits.units}</td>
					<td> = </td>
					<td>${theUnits.quantity2}</td>
					<td>${theUnits.units2}</td>
					<td> <a href="EditUnits?id=${theUnits.id}" > edit </a> </td>
				</tr>
			</c:forEach>
			
				<tr>
					<td>  </td>
					<td> 1 </td>
					<td> <input type="text" id="unit1" name="unit1"> </td>
					<td> = </td>
					<td><input type="text" id="quantity2" name="quantity2"> </td>
					<td><input type="text" id="unit2" name="unit2"> </td>
					<td><button type="submit" > add </button> </td>
				</tr>
	</tbody>
</table>
<!--  hidden field to pass the id for editing  -->
<input type="hidden" id="id" name="id" value="${id}">
</form>


</body>
</html>