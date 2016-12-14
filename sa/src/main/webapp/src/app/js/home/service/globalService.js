app.factory('globalService',['$http',function($http){
	
	
	return{
		
		getOnlineNum:function(){
			return $http.get('/global/getOnlineNum');
		},
		logOut:function(){
			return $http.get('/login/logOut');
		},
		getVisitRecord:function(param){
			return $http.get('/global/getVisitRecord?page='+param.page+'&size='+param.size);
		}
		
	}
	

}]);