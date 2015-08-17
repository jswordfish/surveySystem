var app = angular.module('myApp', []);

app.directive('helloWorld', function() {
  return {
      restrict: 'AE',
      replace: 'true',
      template: '<h3>Hello World!!</h3>'
  };
});

app.controller( 'ManagerController',  function($scope, $http, $window, $filter) {
    $scope.currentDate = new Date();
       console.log($window.localStorage.getItem('sNumber'));
    $scope.sessNo =  $window.localStorage.getItem('sNumber');
   
});

app.controller('PlayerController', function($scope, $http, $window, $filter) {
   $scope.currentDate = new Date();
     
   $scope.dt = $filter('date')( $scope.currentDate, "MM/dd/yyyyTHH:mm:ss");
    console.log(' date is '+$scope.dt);
    $scope.type = $window.localStorage.getItem('surveyType');
    
	if($scope.type == 'ManagerCompetencyAssessment'){
		$http.get('http://localhost/v2-survey-1.0-SNAPSHOT/ws/rest/surveyMgmtRestService/surveySessionForManagerComepency').
			success(function(data) {
			    $scope.surveySession = data;
			    
			    $scope.surveySession.user = $window.localStorage.getItem('fullName');
			    $scope.surveySession.email = $window.localStorage.getItem('email');
			    $scope.surveySession.surveyType = $window.localStorage.getItem('surveyType');
			    $scope.surveySession.surveySessionDate = $scope.dt;
			    console.log(' 1' +$scope.surveySession.user);
			     console.log(' 2' +$scope.surveySession.email);
			     console.log(' 3' +$scope.surveySession.surveyType);
		    
		});
	}
	else if($scope.type == 'ParticipantCompetencyAssessment'){
		$http.get('http://localhost/v2-survey-1.0-SNAPSHOT/ws/rest/surveyMgmtRestService/surveySessionForParticipantCompetency').
			success(function(data) {
			    $scope.surveySession = data;
			    
			    $scope.surveySession.user = $window.localStorage.getItem('fullName');
			    $scope.surveySession.email = $window.localStorage.getItem('email');
			    $scope.surveySession.surveyType = $window.localStorage.getItem('surveyType');
			    $scope.surveySession.surveySessionDate = $scope.dt;
			    console.log(' 1' +$scope.surveySession.user);
			     console.log(' 2' +$scope.surveySession.email);
			     console.log(' 3' +$scope.surveySession.surveyType);
		    
		});
	}
	else if($scope.type == 'ParticipantLeadershipStyle'){
		$http.get('http://localhost/v2-survey-1.0-SNAPSHOT/ws/rest/surveyMgmtRestService/surveySessionForParticipantLeadership').
			success(function(data) {
			    $scope.surveySession = data;
			    
			    $scope.surveySession.user = $window.localStorage.getItem('fullName');
			    $scope.surveySession.email = $window.localStorage.getItem('email');
			    $scope.surveySession.surveyType = $window.localStorage.getItem('surveyType');
			    $scope.surveySession.surveySessionDate = $scope.dt;
			    console.log(' 1' +$scope.surveySession.user);
			     console.log(' 2' +$scope.surveySession.email);
			     console.log(' 3' +$scope.surveySession.surveyType);
		    
		});
	}
    
    
	
	$scope.saveSurveySession = function() {
	
		$http.post('http://localhost/v2-survey-1.0-SNAPSHOT/ws/rest/surveyMgmtRestService/save/SurveySession', $scope.surveySession).
		success(function(data) {
		  
		    
		    $window.localStorage.setItem('sNumber', JSON.stringify(data) );
		    console.log($window.localStorage.getItem('sNumber'));
		    $window.location.href = 'thankYou.html';
		});
	};
	
	$scope.calcuateScoreLeadershipSurvey = function() {
	
		$http.post('http://localhost/v2-survey-1.0-SNAPSHOT/ws/rest/surveyMgmtRestService/get/ResultCountLeadership', $scope.surveySession).
		success(function(data) {
		  $scope.leadershipSurveyResult = data;
		    $scope.surveySession.numA = $scope.leadershipSurveyResult.numA;
		    $scope.surveySession.numT = $scope.leadershipSurveyResult.numT;
		    $scope.surveySession.numC = $scope.leadershipSurveyResult.numC;
		    $scope.surveySession.numE = $scope.leadershipSurveyResult.numE;
		    console.log( JSON.stringify(data));
		    console.log(  ' ' +$scope.surveySession.numA );
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
	
		if($window.localStorage.getItem('surveyType') == 'ManagerCompetencyAssessment'){
			console.log('here 1');
			$window.location.href = 'Manager_Competency_Assessment.htm';	
		}
		else if($window.localStorage.getItem('surveyType') == 'ParticipantCompetencyAssessment'){
			console.log('here 2');
			$window.location.href = 'Participant_Competency_Assessment.htm';	
		
		}
		else if($window.localStorage.getItem('surveyType') == 'ParticipantLeadershipStyle'){
			console.log('here 3');
			$window.location.href = 'Participant_LeadershipStyle_Assessment.htm';	
		}
	
     };
   
    
});




