app.controller('scriptController', ['$scope', '$http', '$window', 'utilService', function($scope, $http, $window, utilService) {
	
	$scope.getQuery = function() {
		var table = $scope.table;
		var column = $scope.column;
		var value = $scope.value;
		var query = $scope.query;
		var number = $scope.number;
		var type = $scope.type;
		var columnReferenced = $scope.columnReferenced;
		var tableReferenced = $scope.tableReferenced;
		
		if (type == 'addColumn') {
			var url = "http://localhost:8080/addColumn?query=" + query.replaceAll("\r\n","%0d%0a").replaceAll("\n","%0d%0a") + "&table=" + table + "&column=" + column + "&number=" + number;
						
				$http.get(url).success(function(data) {
					$scope.dados = data;		
				});
		}
		
		
		if (type == 'addForeignKey') {
			var url = "http://localhost:8080/addForeignKey?query=" + query + "&table=" + table + "&name=" + value
			+ "&columnReferenced=" + columnReferenced + "&tableReferenced=" + tableReferenced + "&number=" + number;
						
				$http.get(url).success(function(data) {
					$scope.dados = data;		
				});
		}
		

		if (type == 'addPrimaryKey') {
			var url = "http://localhost:8080/addPrimaryKey?table=" + table + "&name=" + value
			+ "&column=" + column + "&number=" + number;
						
				$http.get(url).success(function(data) {
					$scope.dados = data;		
				});
		}
		
		
		if (type == 'createTable') {
			var url = "http://localhost:8080/createTable?table=" + table + "&query=" + query + "&number=" + number;
						
				$http.get(url).success(function(data) {
					$scope.dados = data;		
				});
		}
		
		if (type == 'dropColumn') {
			var url = "http://localhost:8080/dropColumn?table=" + table + "&query=" + query + "&column=" + column + "&number=" + number;
						
				$http.get(url).success(function(data) {
					$scope.dados = data;		
				});
		}

		if (type == 'dropConstraint') {
			var url = "http://localhost:8080/dropConstraint?table=" + table + "&query=" + query + "&name=" + value + "&number=" + number;
						
				$http.get(url).success(function(data) {
					$scope.dados = data;		
				});
		}		
	
		if (type == 'dropTable') {
			var url = "http://localhost:8080/dropTable?table=" + table + "&query=" + query + "&number=" + number;
						
				$http.get(url).success(function(data) {
					$scope.dados = data;		
				});
		}			
	
		if (type == 'insert') {
			var url = "http://localhost:8080/insert?query=" + query + "&table=" + table + "&column=" + column + "&value=" + value + "&number=" + number;
						
				$http.get(url).success(function(data) {
					$scope.dados = data;		
				});
		}
		
	}
	
	String.prototype.replaceAll = function(de, para){
	    var str = this;
	    var pos = str.indexOf(de);
	    while (pos > -1){
			str = str.replace(de, para);
			pos = str.indexOf(de);
		}
	    return (str);
	}
		
}]);