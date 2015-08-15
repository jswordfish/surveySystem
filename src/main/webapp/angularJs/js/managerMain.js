var app = angular.module('myApp', []);

app.directive('helloWorld', function() {
  return {
      restrict: 'AE',
      replace: 'true',
      template: '<h3>Hello World!!</h3>'
  };
});

app.controller( 'ManagerController', ['$scope', function($scope, $http) {
    $scope.currentDate = new Date();
    
   
    
}]);

app.controller('PlayerController', function($scope, $http) {
  // Hidden our previous section's content
  // construct our http request
   $scope.currentDate = new Date();
   
    $http.get('http://localhost/v2-survey-1.0-SNAPSHOT/ws/rest/surveyMgmtRestService/surveySessionForManagerComepency').
        success(function(data) {
            $scope.surveySession = data;
        });
  

  });




