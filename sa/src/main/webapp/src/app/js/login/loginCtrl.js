app.controller('loginCtrl',['$scope','$state','loginService','$modal',function($scope,$state,loginService,$modal){

	$scope.app = {};
	$scope.app.name = "angular";

	$scope.user = {"account":"15195899120","password":"123456"};
	$scope.login = function(){
		$scope.user.password = hex_md5($scope.user.password);
		loginService.login($scope.user).then(function(resp){
			if(resp.status==200){
				if(resp.data){
					$scope.authError = null;
					loginService.setLoginUser(resp.data);
					$state.go('app.message');
				}
			}else if(resp.status==400){
				$scope.authError = resp.data.message;
			}
		});
	}

	//注册
	$scope.register = function(){
		var modalInstance = $modal.open({
            templateUrl: 'app/views/login/register.html',
            controller: function ($scope, $modalInstance) {
                $scope.ok = function () {
                    $modalInstance.close(true);
                };
                $scope.cancel = function () {
                    $modalInstance.close(false);
                };
            },
            size: 'md'
        });
	}
}]);

app.controller('registerCtrl',['$scope','loginService',function($scope,loginService){
	
	$scope.user = {};
	$scope.register = function(){
		if($scope.user.password===$scope.user.password2 && $scope.user.password!=''){
			var user = {};
			user.account = $scope.user.account;
			user.password = calcMD5($scope.user.password);
			user.username = "abc";
			loginService.register(user).then(function(resp){
				console.log(resp);
				if(resp.data.message=='success'){
					$scope.ok();
				}
			});
			
		}else{
			$scope.authError = "两次输入的密码不一致";
		}
	}
	
}]);