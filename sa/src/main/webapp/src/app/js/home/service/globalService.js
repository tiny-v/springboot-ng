app.factory('globalService',['$http',function($http){
	
	
	return{
		
		getOnlineNum:function(){
			return $http.get('/global/getOnlineNum');
		},
		logOut:function(){
			return $http.get('/login/logOut');
		}
		
	}
	

}]);