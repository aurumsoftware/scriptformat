var app = angular.module ("scriptFormatAngular", []);

app.factory('utilService', function() {
    return {
        getUrlArray: function() {
            var urlLocation = window.location.toString().replace(/#.*/,'');
    		var urlArray = urlLocation.split("/");
    		return urlArray;
        }
    };
});