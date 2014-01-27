<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.10.2.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/resources/css/jumbotron-narrow.css" rel="stylesheet">

<script type="text/javascript">
	$(document).ready(function(){
		var elementText = $("div#successMessage");
		if($.trim(elementText.text()).length > 0){
			elementText.fadeOut(3000);	
		}else{
			elementText.hide();
		}
	});
</script>
	
<title>Home page</title>
</head>
<body>

<div class="container">
<div id="successMessage" class="alert alert-success">
  ${message}
</div>
 Welcome ${user.name} 
 Model value : ${dummy}
<div class="jumbotron">
  <h1>Home page</h1>
  <p>This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
  <div style="width:240px; margin-left: 170px;">
<a href="/myapp/person/add.ini" class="btn btn-primary btn-lg  btn-block" role="button"><span class="glyphicon glyphicon-user"></span><span style="margin: 0px 15px;">Add a Person</span></a>
<a href="#" class="btn btn-primary btn-lg btn-block" role="button"><span class="glyphicon glyphicon-search"></span><span style="margin: 0px 15px;">Search a Person</span></a>
<a href="/myapp/person/list.ini" class="btn btn-primary btn-lg btn-block" role="button"><span class="glyphicon glyphicon-list"></span><span style="margin: 0px 15px;">List all people</span></a>
<a href="/myapp/login/signOut.ini" class="btn btn-danger btn-lg btn-block" role="button"><span class="glyphicon glyphicon-off"></span><span style="margin: 0px 15px;">Log Out</span></a>
</div>
</div>



</div>
</body>
</html>