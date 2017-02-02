<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3> Add organization</h3>

<!-- From the add event page do the following:
Show the form from edit event, but completely empty. None of the event orgs should be checked and User is not selected.
Redirect to the newly created Event detailed page once it is created -->

<form action="Add_Organization" method="Post">
	  <h1>Add Organization</h1>
	
	  <fieldset>
    	<legend>Type of this Organization</legend>
 
			<label for="category" >Category:</label>
			<select id="category" name="category" required>
			<!-- each option value is the category enum value -->
				<c:forEach items="${categories}" var="category">
					<option value="${category}"> ${category}</option>
				</c:forEach>
				</select>
		</fieldset>
		
		
		
		
		<fieldset>
			<legend>Organizations' Information</legend>
		<div>
		<label for="user" >Choose a president:</label>
			<select id="user" name="user" required>
				<c:forEach items="${user}" var="user">
					<option value="${user.user_Id}">${user.user_Name}</option>
				</c:forEach>
			</select>
			</div>
			
			<div>
		<label for="user1" >Choose a Secretary:</label>
			<select id="user1" name="user1" required>
				<c:forEach items="${user}" var="user1">
					<option value="${user1.user_Id}">${user1.user_Name}</option>
				</c:forEach>
			</select>
			</div>
			
		<div>
				<label for="name">Organization Name:</label>
				<input type="text" id="name" name="name" value="${event.event_Name}" required>
			</div>
			
				<label for="description">Organization Description:</label>
				<textarea id="description" name="description"  required>${event.event_Description}</textarea>
			
			<div>
				<label for="attendance">Number of attendance:</label>
				<input type="number" id="attendance" name="attendance" value="${event.event_Attendance}" required>
			</div>
			
			
		</fieldset>
		
		
			<button type="submit" class="btn btn-default">Submit Question</button>
		
		
		
	</form>



</body>
</html>