app.factory('messageService',['$http',function($http){
	
	var baseUrl = "/message";
	
	
	return {
		getMessageList:function(){
			return $http({
				url:baseUrl + "/getMessageList",
				method:'get'
			});
		}
	}
	
}]);