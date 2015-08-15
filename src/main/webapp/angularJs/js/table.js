var empid = 1;
        function tableController($scope, $http) {
	
	    $http.get('http://localhost/v2-lt-1.0-SNAPSHOT/ws/rest/empMgmtRestService/getAllEmployees').
        success(function(data) {
            $scope.employees = data;
        });
 
            
 
            $scope.saveRecord = function () {
                if ($scope.newEmployee.id == null) {
                
                    $scope.employees.push($scope.newEmployee);
                } else {
 
                    for (i in $scope.employees) {
                        if ($scope.employees[i].id == $scope.newEmployee.id) {
                            $scope.employees[i] = $scope.newEmployee;
                        }
                    }
                }
                $scope.newEmployee = {};
            }
 
            $scope.delete = function (id) {
 
                for (i in $scope.employees) {
                    if ($scope.employees[i].id == id) {
                   
                        $scope.newEmployee = {};
                    }
                }
 
            }
 
            $scope.edit = function (id) {
                for (i in $scope.employees) {
                    if ($scope.employees[i].id == id) {
                        $scope.newEmployee = angular.copy($scope.employees[i]);
                    }
                }
            }
        }