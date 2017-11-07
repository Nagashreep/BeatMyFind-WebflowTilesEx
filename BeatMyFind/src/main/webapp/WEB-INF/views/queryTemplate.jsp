<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="resources/css/style.css" rel="stylesheet" type="text/css">
		<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
		<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-animate.js"></script>
		<title><tiles:getAsString  name="title"/></title>
	</head>
	<body class="main">
		<div>
			<tiles:insertAttribute name="header"/>
		</div>
		<div style="width: 100%;">
			<div>
				<tiles:insertAttribute name="sideNav"/>
			</div>
			<div>
				<tiles:insertAttribute name="body"/>
			</div>
		</div>
		<div>
			<tiles:insertAttribute name="footer"/>
		</div>
	</body>
</html>