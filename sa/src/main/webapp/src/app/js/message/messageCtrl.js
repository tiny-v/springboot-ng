app.controller('messageCtrl',['$scope','messageService',function($scope,messageService){
	
	$scope.messageList = [];
	$scope.init = function(){
		messageService.getMessageList().then(function(resp){
			if(resp.status==200){
				$scope.messageList = resp.data;
			}
		});
	}
	$scope.init();
	
	
}]);