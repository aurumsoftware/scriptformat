app.controller('scriptController', ['$scope', '$http', '$window', 'utilService', function($scope, $http, $window, utilService) {
	
	String.prototype.replaceAll = function(search, replace)	{
		if (replace === undefined) {
			return this.toString().toUpperCase();
		}
		return this.replace(new RegExp(search, 'gi'), replace);
	};
	
	$scope.getQuery = function() {
		var table = $scope.table == undefined ? "" : $scope.table;
		var column = $scope.column == undefined ? "" : $scope.column;
		var value = $scope.value == undefined ? "" : $scope.value;
		var query = $scope.query == undefined ? "" : $scope.query;
//		var number = $scope.number == undefined ? 1 : $scope.number;
		var type = $scope.type == undefined ? "" : $scope.type;
		var columnReferenced = $scope.columnReferenced == undefined ? "" : $scope.columnReferenced;
		var tableReferenced = $scope.tableReferenced == undefined ? "" : $scope.tableReferenced;
		
		query = query.replaceAll("\r\n","%0d%0a").replaceAll("\n","%0d%0a");
		
		if (type == 'addColumn') {
			var url = "http://localhost:8080/addColumn?query=" + query + "&table=" + table + "&column=" + column;
					
			$http.get(url).success(function(data) {
				$scope.dados = data;		
			});
		}
		
		
		if (type == 'addForeignKey') {
			var url = "http://localhost:8080/addForeignKey?query=" + query + "&name=" + value;
						
			$http.get(url).success(function(data) {
				$scope.dados = data;		
			});
		}
		

		if (type == 'addPrimaryKey') {
			var url = "http://localhost:8080/addPrimaryKey?table=" + table + "&name=" + value
			+ "&column=" + column;
						
				$http.get(url).success(function(data) {
					$scope.dados = data;		
				});
		}
		
		
		if (type == 'createTable') {
			var url = "http://localhost:8080/createTable?table=" + table + "&query=" + query;
						
				$http.get(url).success(function(data) {
					$scope.dados = data;		
				});
		}
		
		if (type == 'dropColumn') {
			var url = "http://localhost:8080/dropColumn?table=" + table + "&query=" + query + "&column=" + column;
						
				$http.get(url).success(function(data) {
					$scope.dados = data;		
				});
		}

		if (type == 'dropConstraint') {
			var url = "http://localhost:8080/dropConstraint?table=" + table + "&query=" + query + "&name=" + value;
						
				$http.get(url).success(function(data) {
					$scope.dados = data;		
				});
		}		
	
		if (type == 'dropTable') {
			var url = "http://localhost:8080/dropTable?table=" + table + "&query=" + query;
						
				$http.get(url).success(function(data) {
					$scope.dados = data;		
				});
		}			
	
		if (type == 'insert') {
			var url = "http://localhost:8080/insert?query=" + query + "&table=" + table + "&column=" + column + "&value=" + value;
						
				$http.get(url).success(function(data) {
					$scope.dados = data;		
				});
		}
		
	}
}]);