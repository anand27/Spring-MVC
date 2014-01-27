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


<title>Edit Person page</title>
</head>
<body>
<div class="container">
<h1>Edit Person page</h1>
<p>Here you can edit the existing Person.</p>
<p>${message}</p>
<form:form method="POST" commandName="person" action="${pageContext.request.contextPath}/person/edit/${person.id}.ini">
<table>
<tbody>
        <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
        </tr>
        <tr>
                <td>Age:</td>
                <td><form:input path="age" /></td>
        </tr>
        <tr>
                <td><input type="submit" value="Edit" /></td>
                <td></td>
        </tr>
</tbody>
</table>
</form:form>

<p><a href="${pageContext.request.contextPath}/welcome/home.ini"><span class="glyphicon glyphicon-home"></span><span style="margin: 0px 15px;">Home page</span></a></p>
</div>
</body>
</html>