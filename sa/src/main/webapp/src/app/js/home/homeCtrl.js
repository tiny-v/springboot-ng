app.controller('homeCtrl',['$scope','$sessionStorage','$state',function($scope,$sessionStorage,$state){
	
	//注销
	$scope.logOut = function(){
		$sessionStorage.user = null;
		$state.go('login');
	}
	
}]);