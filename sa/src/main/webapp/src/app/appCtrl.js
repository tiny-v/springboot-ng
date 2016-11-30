app.controller('appCtrl',['$scope',function($scope){
	
	console.log('this is appCtrl');
	
	var hello = sessionStorage.getItem("hello");
	console.log(hello);
}]);