app.factory('loginService',['$http','$sessionStorage','$cookieStore',function($http,$sessionStorage,$cookieStore){
	
	var baseUrl = '/login';
	
	return {
		//登录
		login:function(user){
			return $http({
				url : baseUrl+'/checkLogin',
				method : 'post',
				data:user
			});
		},
		setLoginUser:function(user){
			$cookieStore.put('token',user.token);
		    $sessionStorage.user=user;
		},
		getLoginUser:function(){
			return $sessionStorage.user;
		},
		//注册
		register:function(user){
			return $http({
				url: baseUrl+'/register',
				method:'post',
				data:user
			});
		}
			
	}
	
}]);