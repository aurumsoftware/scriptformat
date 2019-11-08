app.controller('scriptController', ['$scope', '$http', '$window', 'utilService', function($scope, $http, $window, utilService) {
	$scope.insert = function() {
		var table = $scope.table;
		var column = $scope.column;
		var value = $scope.value;
		var query = $scope.query;
		var number = $scope.number;
		
		number = 1;
		
		
		var url = "http://localhost:8080/insert?query=" + query + "&table=" + table + "&column=" + column + "&value=" + value + "&number=" + number;
					
			$http.get(url).success(function(data) {
				$scope.dados = data;		
			});
	};
		
}]);