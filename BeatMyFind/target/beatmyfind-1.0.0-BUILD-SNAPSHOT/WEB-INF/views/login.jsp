<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="resources/css/style.css" rel="stylesheet" type="text/css">
	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-animate.js"></script>
	<title>Beat My Find - Login</title>
</head>
<body class="main">
	<div ng-app="myApp" ng-controller="loginCtrl" ng-init="displayNewForm=false, displayExistingForm=false">
		<div class="welcomeHeading">Welcome to <b><i>Beat My Find</i></b></div>
		<div class="userSelectionList">
			<a href="#" ng-click="displayForm('new')">New User</a> <br/>
			<a href="#" ng-click="displayForm('old')">Existing User</a>		
		</div>
		<div ng-show="displayNewForm" class="loginForm">
			<div class="error">
				<c:forEach items="${flowRequestContext.messageContext.allMessages}" var="message">
				    <br>
				    ${message.text}
				</c:forEach>
			</div>
		
			<form:form modelAttribute="user" action="${flowExecutionUrl}">
				<table>
					<tr class="formRow">
						<td width="20%">User Name</td>
						<td class="inputField"><form:input path="userName" /></td>
					</tr>
					<tr class="formRow">
						<td>Password</td>
						<td class="inputField"><input type="password" name="userPassword"/></td>
					</tr>
					<tr class="formRow">
						<td>First Name</td>
						<td class="inputField"><form:input path="firstName" /></td>
					</tr>
					<tr class="formRow">
						<td>Middle Name</td>
						<td class="inputField"><form:input path="middleName"/></td>
					</tr>
					<tr class="formRow">
						<td>Last Name</td>
						<td class="inputField"><form:input path="lastName"/></td>
					</tr>
					<tr class="formRow">
						<td>Email Address</td>
						<td class="inputField"><form:input path="emailAddress"/></td>
					</tr>
					<tr class="formRow">
						<td colspan="2">
							<button type="submit" name="_eventId" value="submit_newCustomer" class="submit-button">Submit</button>
						</td>
					</tr>
				</table>
				<input type="hidden" name="isNewUser" value="true"/>
				<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
			</form:form>
		</div>
		<div ng-show="displayExistingForm" class="loginForm">
			<div class="error">
				<c:forEach items="${flowRequestContext.messageContext.allMessages}" var="message">
				    <br>
				    ${message.text}
				</c:forEach>
			</div>
		
			<form:form modelAttribute="user" action="${flowExecutionUrl}">
				<table>
					<tr class="formRow">
						<td width="20%">User Name</td>
						<td class="inputField"><form:input path="userName" /></td>
					</tr>
					<tr class="formRow">
						<td>Password</td>
						<td class="inputField"><form:password path="userPassword"/></td>
					</tr>
					<tr class="formRow">
						<td colspan="2">
							<button type="submit" name="_eventId" value="submit_existingCustomer" class="submit-button">Submit</button>
						</td>
					</tr>
				</table>
				<input type="hidden" name="isNewUser" value="false"/>
				<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
			</form:form>
		</div>
	</div>
	
	<script>
	var app = angular.module('myApp', ['ngAnimate']);
	app.controller('loginCtrl', function($scope) {
		$scope.displayNewForm = false;
		$scope.displayExistingForm = false;
	    $scope.displayForm = function(type) {
	    	if(type=='new'){
	    		$scope.displayNewForm = true;
	    		$scope.displayExistingForm = false;
	        }else if (type=='old'){
	        	$scope.displayNewForm = false;
	    		$scope.displayExistingForm = true;
	        }
	    };
	});
	</script>
	
</body>
</html>