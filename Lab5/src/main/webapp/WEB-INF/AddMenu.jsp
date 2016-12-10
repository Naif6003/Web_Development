<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new</title>
</head>
<body>


<form action="Add_Menu" method="post">
	  <h1>Add Menu</h1>
		<fieldset>
			<legend>Menu Info</legend>
			<div>
				<label for="name">Menu Name:</label>
				<input type="text" id="name" name="name" required>
			</div>
			<div>
				<label for="description">Menu Description:</label>
				<input type="text" id="description" name="description" required>
			</div>
			
		</fieldset>
		<div class="button">
			<button type="submit">Submit Info</button>
		</div>
		
	</form>

</body>
</html>