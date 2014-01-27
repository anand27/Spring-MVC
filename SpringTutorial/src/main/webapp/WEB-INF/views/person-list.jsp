<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="../resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script src="../resources/js/jquery-1.10.2.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/resources/css/jumbotron-narrow.css" rel="stylesheet">

<title>List of Persons</title>
</head>
<body>
<div class="container">
<div class="well">
<h1>List of Persons</h1>
<h6><p>Here you can see the list of the persons, edit them, remove or update.</p></h6>
<br/>
<div class="panel panel-primary">
  <div class="panel-heading">Persons list in the database.</div>
  <div class="panel-body">
<table class="table table-hover">
<thead>
<tr>
<th width="10%">User Id</th><th width="15%">Name</th><th width="10%">Age</th><th width="10%">Actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="person" items="${personsList}">
<tr>
        <td><span class="glyphicon glyphicon-user"></span><span style="margin: 0px 15px;">${person.id}</span></td>
        <td>${person.name}</td>
        <td>${person.age}</td>
        <td>
        <a href="${pageContext.request.contextPath}/person/edit/${person.id}.ini"><span class="glyphicon glyphicon-edit"></span><span style="margin: 0px 15px;">Edit</span></a><br/>
        <a href="${pageContext.request.contextPath}/person/delete/${person.id}.ini"><span class="glyphicon glyphicon-remove-circle"></span><span style="margin: 0px 15px;">Delete</span></a><br/>
        </td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>
</div>
<p><a href="${pageContext.request.contextPath}/welcome/home.ini"><span class="glyphicon glyphicon-home"></span><span style="margin: 0px 15px;">Home page</span></a></p>
</div>
</body>
</html>