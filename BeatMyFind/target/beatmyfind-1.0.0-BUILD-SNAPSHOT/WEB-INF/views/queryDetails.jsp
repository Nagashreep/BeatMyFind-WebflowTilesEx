<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<div ng-app="myApp" ng-controller="queryDetailsCtrl">
	<div class="querySummary">
		<form:form modelAttribute="querySummary" action="${flowExecutionUrl}">
			<table class="querySummaryTable">
				<tr class="query">
					<td><a href="#"><c:out value="${querySummary.query.queryText}"/></a></td>
				</tr>
				<c:forEach items="${querySummary.query.userCommentsList}" var="userComment">
					<tr class="comment">
							<td><c:out value="${userComment.commentText}"/></td>
							<td style="font-size: 14px;"><c:out value="${userComment.user.userName}"/></td>							
					</tr>
				</c:forEach>
				<tr>
					<td colspan="2">
						<form:textarea path="${newUserComment.commentText}" rows="3" cols="60" placeholder="Enter new comment"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit" name="_eventId" value="submit_newComment" class="submit-button">Submit</button>
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</div>

<script>
var app = angular.module('myApp', ['ngAnimate']);
app.controller('queryDetailsCtrl', function($scope) {
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
	
