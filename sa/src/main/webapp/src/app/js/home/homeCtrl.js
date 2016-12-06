app.controller('homeCtrl',['$scope','$sessionStorage','$state','$timeout','$interval','globalService',function($scope,$sessionStorage,$state,$timeout,$interval,globalService){
	
	
	$scope.user = $sessionStorage.user;
	
	//注销
	//此处修改，注销时，后台对应的session要清除
	$scope.logOut = function(){
		globalService.logOut().then(function(resp){
			$scope.user= null;
			$sessionStorage.user = null;
		});
		$state.go('login');
	}
	
	$scope.getOnlineNum = function(){
		globalService.getOnlineNum().then(function(resp){
			if(resp.status==200){
				console.log(resp);
			}
		});
	}
	$scope.getOnlineNum();
	
	/*$interval(function(){
		$scope.getOnlineNum();
	},6000);*/
	
	
	
}]);