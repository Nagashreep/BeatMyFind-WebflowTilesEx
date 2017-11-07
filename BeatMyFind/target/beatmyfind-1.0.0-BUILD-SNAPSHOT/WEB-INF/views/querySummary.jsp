<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<div ng-app="myApp" ng-controller="querySummaryCtrl">
	<div class="querySummary">
		<form:form modelAttribute="querySummary" action="${flowExecutionUrl}">
			<table class="querySummaryTable">
				<c:forEach items="${querySummary.userQueryList}" var="userQuery">
					<tr class="query">
						<td><a href="#"><c:out value="${userQuery.queryText}"/></a></td>
					</tr>
					<c:forEach items="${userQuery.userCommentsList}" var="userComment">
						<tr class="comment">
								<td><c:out value="${userComment.commentText}"/></td>
								<td><c:out value="${userComment.user.userName}"/></td>							
						</tr>
					</c:forEach>
					<tr>
						<td colspan="2">
							<a href="${flowExecutionUrl}&_eventId=fetchQueryDetails&queryId=${userQuery.queryId}"> More>> </a> &nbsp; &nbsp;
							<a href="${flowExecutionUrl}&_eventId=fetchQueryDetails&queryId=${userQuery.queryId}">Add comment</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</form:form>
	</div>
</div>

<script>
var app = angular.module('myApp', ['ngAnimate']);
app.controller('querySummaryCtrl', function($scope) {
	/* $scope.displayNewForm = false;
	$scope.displayExistingForm = false;
    $scope.displayForm = function(type) {
    	if(type=='open'){
    		$scope.displayNewForm = true;
    		$scope.displayExistingForm = false;
        }else if (type=='closed'){
        	$scope.displayNewForm = false;
    		$scope.displayExistingForm = true;
        }
    }; */
});
</script>
	
