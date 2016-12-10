<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="Add_Dish" method="post">
	  <h1>Add Dish</h1>
		<fieldset>
			<legend>Dish Info</legend>
			<div>
				<label for="name">Dish Name:</label>
				<input type="text" id="name" name="name" required>
			</div>
			
	<c:forEach items="${ingredients}" var="ingredients" varStatus="loop">	     
	     <input type="checkbox" name="ingredient" value="${ingredients.ingredient_name}"> ${ingredients.ingredient_name} / ${ingredients.ingredient_price}<br>
	</c:forEach>
			

			
		</fieldset>
		<div class="button">
			<button type="submit">Submit Info</button>
		</div>
		
	</form>


</body>
</html>