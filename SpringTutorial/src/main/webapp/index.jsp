<!DOCTYPE html>
<html>  
<head>

<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script src="resources/js/jquery-1.10.2.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<!-- Custom styles for this template -->
<link href="resources/css/jumbotron-narrow.css" rel="stylesheet">
    
<title>Spring MVC</title>  
</head>  
<body>  
<div class="container">

      <div class="header">
        <ul class="nav nav-pills pull-right">
          <li class="active"><a href="#">Home</a></li>
          <li><a href="#">About</a></li>
          <li><a href="#">Contact</a></li>
        </ul>
        
        <h3 class="text-muted">Spring Project </h3>
        
        <h5>Session value : ${user.name}</h5>
    	<h5>Model value : ${dummy}</h5>
      </div>
      
      <div class="jumbotron">
        <h1>Spring MVC Demo</h1>
        <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
        <p><a class="btn btn-lg btn-success" href="#" data-toggle="modal" data-target="#myModal" role="button">Sign In</a></p>
      </div>
    
		  <!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
		      </div>
		      <div class="modal-body">
		      
		      
							<form method="POST" action="${pageContext.request.contextPath}/login/signIn.ini" class="form-horizontal" role="form">
							
								  <div class="form-group">
							         <label for="username" class="col-sm-2 control-label">Username</label>
							         <div class="col-xs-4">
							         <input type="text" class="form-control" id="username" name="username" placeholder="Username"/>
							         </div>
							     </div>
							     
								 <div class="form-group">
							         <label for="password" class="col-sm-2 control-label">Password</label>
							         <div class="col-xs-4">
							         <input type="password" class="form-control" id="password" name="password" placeholder="Password"/>
							         </div>
							     </div>
								       
								<div class="form-group">
								    <div class="col-sm-offset-2 col-sm-10">
								      <button type="submit" class="btn btn-primary" id="signInButton">Sign In</button>
								      <button type="button" class="btn btn-default" id="clearButton">Clear</button>
								    </div>
								</div>
							  
							</form>


		      </div>
		      <!-- <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary">Save changes</button>
		      </div> -->
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->

     <div class="footer">
        <p>&copy; Company 2013</p>
      </div>
    
 </div> <!-- /container -->
</body>  
</html>  
