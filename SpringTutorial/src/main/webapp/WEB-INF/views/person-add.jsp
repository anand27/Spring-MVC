<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
		  //var inp1 = $("input#username");
		  var inp2 = $("input#age");
		  var formInputs = [ inp2];
		  
		$( "button#clearButton").click(function(){
			  for(var i=0; i<formInputs.length; i++){
			 		appendDefault(formInputs[i]);
			  }
		});
		
		$( "form#addPersonForm" ).submit(function() {
			  var validation_success = new Boolean("true");
			  for(var i=0; i<formInputs.length; i++){
				  if($.trim(formInputs[i].val()).length == 0){
					  appendError(formInputs[i]);
					  validation_success = false;
				  }else{
					  appendSuccess(formInputs[i]);
				  }				  
			  }
			  return validation_success;
		});
		 
		function appendDefault(element){
			element.val("");
			element.parent().parent().removeClass("has-success");
			element.parent().parent().removeClass("has-error");
		}
		
		function appendError(element){
		    element.parent().parent().removeClass("has-success");
			element.parent().parent().addClass("has-error");
		}
		  
		function appendSuccess(element){
			element.parent().parent().addClass("has-success");
		}
		  
	});
</script>
<title>Add Person page</title>
</head>
<body>
<div class="container">
<div class="well">
<h1>Add Person page</h1>
<h6><p>Here you can add a new Person.</p></h6>

<br/>
<div class="panel panel-primary">
  <div class="panel-heading">Person table form.</div>
  <div class="panel-body">

<form:form method="POST" modelAttribute="person-form" action="${pageContext.request.contextPath}/person/add.ini" id="addPersonForm" class="form-horizontal" role="form">

	  <div class="form-group">
         <form:label for="username" path="name" class="col-sm-2 control-label">Username</form:label>
         <div class="col-xs-4">
         <form:input type="text" path="name" class="form-control" id="username" placeholder="Username"/>
         <form:errors path="name"/>
         </div>
     </div>
     
	 <div class="form-group">
         <label for="age" class="col-sm-2 control-label">Age</label>
         <div class="col-xs-4">
         <form:input type="text" path="age" class="form-control" id="age" placeholder="Age"/>
         </div>
     </div>
	       
	<div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default" id="addButton">Add</button>
	      <button type="button" class="btn btn-default" id="clearButton">Clear</button>
	    </div>
	</div>
  
</form:form>
</div>
</div>
</div>



<p><a href="${pageContext.request.contextPath}/welcome/home.ini"><span class="glyphicon glyphicon-home"></span><span style="margin: 0px 15px;">Home page</span></a></p>
</div>
</body>
</html>