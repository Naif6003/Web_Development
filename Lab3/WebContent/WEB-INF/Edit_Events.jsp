<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Home Page</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="bootstrap/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="theme.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="bootstrap/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>

 <!-- Fixed navbar -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="http://www.calstatela.edu/">CSULA</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="Events">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="Logout">Logout</a></li>
            <li><a href="#contact">Contact</a></li>
          </ul>
        </div>
      </div>
    </nav>

 <!-- <div class="container theme-showcase" role="main"> -->

      <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1 align="center" >Naif's Student Union</h1>
        <p align="center">In here, you will find all the student union's events.</p>
        <p align="center"><fmt:formatDate value="${date}" pattern="yyy-MM-dd hh:mm:ss a" /> </p>
      </div>






<form action="Edit_Events" method="Post">
	  <h1>Add Event</h1>
	  <fieldset>
	  
    	<legend>Type of this event</legend>
    	
	    <div class="form-group">
			<label for="category" >Category:</label>
			<select id="category" name="category" value="${event.organization}" required>
			<!-- each option value is the category enum value -->
				<c:forEach items="${categories}" var="category">
					<option value="${category}">${category}</option>
				</c:forEach>
			</select>
		</div>				
		</fieldset>
		<fieldset>
			<legend>Events' Information</legend>
		
		<div class="form-group"> 
				<label for="name">Event Name:</label>
				<input type="text" id="name" name="name" value="${event.event_Name}" required>
			</div>
			<div >
				<label for="description">Event Description:</label>
				<textarea id="description" name="description"  required>${event.event_Description}</textarea>
			</div>
			<div class="form-group">
				<label for="attendance">Number of attendance:</label>
				<input type="number" id="attendance" name="attendance" value="${event.event_Attendance}" required>
			</div>
			
			<!--  I have done the droplist instead of the checkbox -->
		<div>
			<c:forEach items="${the_Org}" var="the_Org">
			<input type="checkbox" name="the_Org" value="${the_Org.org_Name}"> ${the_Org.org_Name }<br>
			</c:forEach>
			</div> 
		</fieldset>
		<div class="button">
			<button type="submit" class="btn btn-default">Submit Question</button>
		</div>
		
		<!-- hidden field to pass id so doPost knows which quiz to edit -->
		<input type="hidden" name="id" value="${event.id}">
	</form>

<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <script src="../../assets/js/docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>


</body>
</html>