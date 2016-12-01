app.controller('messageCtrl',['$scope','messageService',function($scope,messageService){
	
	console.log('this is messageCtrl');
	$scope.messageList = [];
	$scope.init = function(){
		messageService.getMessageList().then(function(resp){
			console.log(resp);
			if(resp.status==200){
				$scope.messageList = resp.data;
			}
		});
	}
	$scope.init();
	
	
}]);