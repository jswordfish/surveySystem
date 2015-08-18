var app = angular.module('firstApp', []);



app.controller( 'EmployeeController',  function($scope, $http, $window, $filter) {
   $scope.name = "Jatin Sutaria";
   
    $scope.gloss = {     "glossary": {  "title": "example glossary"   } };
    console.log(JSON.stringify($scope.gloss ) );
   
   //http://localhost/v2-lt-1.0-SNAPSHOT/ws/rest//empMgmtRestService/getAllEmployees
   
   $http.get('http://localhost/v2-lt-1.0-SNAPSHOT/ws/rest//empMgmtRestService/getAllEmployees').
			success(function(data) {
			    $scope.employees = data;
			    
			   
			     console.log(' 3' +JSON.stringify($scope.employees ));
		    
		});
});