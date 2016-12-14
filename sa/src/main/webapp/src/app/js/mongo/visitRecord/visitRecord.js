app.controller('visitRecordCtrl',['$scope','globalService',function($scope,globalService){
	
	console.log('this is visitRecord');
	
	$scope.page ={"totalItems":0,"currentPage":1,"size":10};
	
	$scope.visitRecords = [];
	
	$scope.init = function(){
		var param = {};
		param.size = $scope.page.size;
		param.page = $scope.page.currentPage;
		globalService.getVisitRecord(param).then(function(resp){
			console.log(resp);
			$scope.page.totalItems = resp.data.totalCount;
			$scope.visitRecords = resp.data.datas;
		});
	}
	$scope.init();
	
	$scope.refresh = function(){
		$scope.init();
	}
	
	
}]);