<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Edit_Menu" method="post">
	<div >
				<label for="name">Menu name:</label>
				<textarea id="name" name="name"  required>${menu.menu_name}</textarea>
	</div>
	<div >
				<label for="description">Description:</label>
				<textarea id="description" name="description"  required>"${menu.menu_description}" </textarea>
	</div>

	<div >
			<button type="submit" class="btn btn-default">Submit Question</button>
	</div>
	
	<input type="hidden" name="id" value="${menu.menu_id - 1}">
	
	</form>
</body>
</html>