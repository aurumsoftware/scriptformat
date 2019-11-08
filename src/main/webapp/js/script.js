app.controller('scriptController', ['$scope', '$http', '$window', 'utilService', function($scope, $http, $window, utilService) {
			
	var init = function () {
		var url = "http://localhost:8080/insert";
					
			$http.get(url).success(function(data) {
				$scope.dados = data;		
			});
	}();
		
}]);