var app = angular.module('myApp', []);



app.controller( 'ManagerController',  function($scope, $http, $window, $filter) {
    $scope.currentDate = new Date();
       console.log($window.localStorage.getItem('sNumber'));
    $scope.sessNo =  $window.localStorage.getItem('sNumber');
    $scope.email = $window.localStorage.getItem('email');
    $scope.sType = $window.localStorage.getItem('sType');
    
    $scope.gobackToLoginPage = function() {
    $window.localStorage.setItem('fullName', '' );
	$window.localStorage.setItem('email', '' );
	$window.localStorage.setItem('surveyType', '' );
	$window.localStorage.setItem('sNumber', '');
	$window.location.href = 'index.html';	
		
	};
   
});

app.controller('PlayerController', function($scope, $http, $window, $filter) {
   $scope.currentDate = new Date();
     
   $scope.dt = $filter('date')( $scope.currentDate, "MM/dd/yyyyTHH:mm:ss");
    console.log(' date is '+$scope.dt);
    $scope.type = $window.localStorage.getItem('surveyType');
    
    var email = $window.localStorage.getItem('email');
    var sType = $window.localStorage.getItem('surveyType');
    var fullName = $window.localStorage.getItem('fullName');
    fullName = trim(fullName);
    console.log('email is '+email + ' sType is ' +sType + ' fullname '+fullName);
	if(fullName == null || fullName == '' || email == 'undefined' || fullName == 'undefined'){
		if(email == 'undefined' ){
			alert('Invalid Email. Go back to First Page and enter valid Email');
			$window.location.href = 'index.html';
		}
		else if(fullName == '' || fullName == 'undefined'){
		        alert('Full Name Field may be blank. Go back to First Page and enter FullName');
			$window.location.href = 'index.html';
		}
		console.log('emal and fullName blank');
		//$window.location.href = 'index.html';	
	}
	else{
		email = $window.encodeURIComponent(email);
		var url = '../ws/rest/surveyMgmtRestService/surveySession/exist/email/'+email+'/surveyType/'+sType;
		console.log('url is '+url);
		$http.get(url).
			success(function(data) {
			var res = data;
			console.log('result is '+data);
				if(res == 'true'){
				console.log('email existis for survey type');
				$window.localStorage.setItem('email', $window.localStorage.getItem('email'));
				$window.localStorage.setItem('sType', $window.localStorage.getItem('surveyType'));
				$window.location.href = 'info.html';
				}
				else{
					if($scope.type == 'ManagerCompetencyAssessment'){
						$http.get('../ws/rest/surveyMgmtRestService/surveySessionForManagerComepency').
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
						$http.get('../ws/rest/surveyMgmtRestService/surveySessionForParticipantCompetency').
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
						$http.get('../ws/rest/surveyMgmtRestService/surveySessionForParticipantLeadership').
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
				
				}
			})
	}
	
			
	
	function trim(value) {
	  return value.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
	}

	
    
    
	
	$scope.saveSurveySession = function() {
	
		$http.post('../ws/rest/surveyMgmtRestService/save/SurveySession', $scope.surveySession).
		success(function(data) {
		  var res = parseInt(data);
			if ( res < 0 ){
			$window.localStorage.setItem('email', $scope.surveySession.email);
			$window.localStorage.setItem('sType', $scope.surveySession.surveyType);
			 $window.location.href = 'info.html';
			}
			else{
			$window.localStorage.setItem('sNumber', JSON.stringify(data) );
			console.log($window.localStorage.getItem('sNumber'));
			$window.location.href = 'thankYou.html';
			}
		    
		    
		});
	};
	
	$scope.calcuateScoreLeadershipSurvey = function() {
	
		$http.post('../ws/rest/surveyMgmtRestService/get/ResultCountLeadership', $scope.surveySession).
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
   // $scope.options = ['ManagerCompetencyAssessment', 'ParticipantCompetencyAssessment', 'ParticipantLeadershipStyle'];
     
     $scope.navigateToFillSurvey = function() {
     $scope.surveyType = (!$scope.surveyType) ? '' : $scope.surveyType.replace(/ /g, '');
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




