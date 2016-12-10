<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu Details</title>
</head>
<body>


 	<c:forEach items="${dishes}" var="dishes" varStatus="loop"> 
       <ul>
	      	<li>Dish number ${dishes.dish_id}</li>
	      	<li>${dishes.dish_name}</li>
			<li>In menu number ${dishes.dish_menu_id}</li>
       </ul>
	</c:forEach> 

	<c:forEach items="${ingredients}" var="ingredients" varStatus="loop"> 
      	<ul>
			<li>Ingredient number ${ingredients.ingredient_id}</li>
	      	<li>${ingredients.ingredient_name}</li>
			<li>price is ${ingredients.ingredient_price}</li> 
		</ul>
	
	</c:forEach> 
	
	<a href="Add_Dish">add dish</a>


</body>
</html>