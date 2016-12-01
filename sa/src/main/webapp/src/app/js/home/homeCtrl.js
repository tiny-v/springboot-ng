app.controller('homeCtrl',['$scope','$sessionStorage','$state',function($scope,$sessionStorage,$state){
	
	
	$scope.user = $sessionStorage.user;
	
	//注销
	$scope.logOut = function(){
		$scope.user= null;
		$sessionStorage.user = null;
		$state.go('login');
	}
	
	
	
}]);