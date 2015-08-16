var app = angular.module('myApp', []);

app.directive('helloWorld', function() {
  return {
      restrict: 'AE',
      replace: 'true',
      template: '<h3>Hello World!!</h3>'
  };
});

app.controller( 'ManagerController',  function($scope, $http, $window) {
    $scope.currentDate = new Date();
       console.log($window.localStorage.getItem('sNumber'));
    $scope.sessNo =  $window.localStorage.getItem('sNumber');
   
    
});

app.controller('PlayerController', function($scope, $http, $window) {
   $scope.currentDate = new Date();
   console.log('1');
   console.log('Full name in player controller' + $window.localStorage.getItem('fullName') );
   console.log('2');	    
 
    
    $http.get('http://localhost/v2-survey-1.0-SNAPSHOT/ws/rest/surveyMgmtRestService/surveySessionForManagerComepency').
        success(function(data) {
            $scope.surveySession = data;
	    
            $scope.surveySession.user = $window.localStorage.getItem('fullName');
	    $scope.surveySession.email = $window.localStorage.getItem('email');
	    $scope.surveySession.surveyType = $window.localStorage.getItem('surveyType');
	    console.log(' 1' +$scope.surveySession.user);
	     console.log(' 2' +$scope.surveySession.email);
	     console.log(' 3' +$scope.surveySession.surveyType);
	    
        });
	
	$scope.saveSurveySession = function() {
		$http.post('http://localhost/v2-survey-1.0-SNAPSHOT/ws/rest/surveyMgmtRestService/save/SurveySession', $scope.surveySession).
		success(function(data) {
		  
		    
		    $window.localStorage.setItem('sNumber', JSON.stringify(data) );
		    console.log($window.localStorage.getItem('sNumber'));
		    $window.location.href = 'thankYou.html';
		});
	};
  

  });
  
  app.controller( 'InitController',  function($scope, $http, $window) {
    $scope.fullName = "";
    $scope.email = "";
    $scope.surveyType = "";
    $scope.options = ['ManagerCompetencyAssessment', 'ParticipantCompetencyAssessment', 'ParticipantLeadershipStyle'];
     
     $scope.navigateToFillSurvey = function() {
     console.log('full name '+ $scope.fullName);
     console.log($scope.email);
     console.log($scope.surveyType);
     
	$window.localStorage.setItem('fullName', $scope.fullName );
	$window.localStorage.setItem('email', $scope.email );
	$window.localStorage.setItem('surveyType', $scope.surveyType );
	
	console.log($window.localStorage.getItem('fullName'));
	console.log($window.localStorage.getItem('email'));
	console.log($window.localStorage.getItem('surveyType'));
	
	$window.location.href = 'Manager_Competency_Assessment.htm';	
     };
   
    
});




