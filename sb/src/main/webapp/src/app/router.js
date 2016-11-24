app.run(['$rootScope','$sessionStorage','$state',function($rootScope,$sessionStorage,$state) {
    $rootScope.$on('$stateChangeStart', function(event, next) {
    	if($sessionStorage.user==undefined || $sessionStorage.user==null){
        	if(next.url!='/login'){
        		event.preventDefault();
        		$state.go('login');
        	}
        }
    })
}])
.config(["$stateProvider", "$urlRouterProvider", function ($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise("/login");

	$stateProvider
	.state('login', {
		url: "/login",
		templateUrl: "app/views/login/login.html",
		resolve: {
			deps: ['$ocLazyLoad',function ($ocLazyLoad) {
				return $ocLazyLoad.load(['app/js/login/loginCtrl.js','app/js/login/service/loginService.js']);
			}]
		}
	})
	.state('app', {
		url:'/app',
		templateUrl: "app/views/home/home.html",
		resolve: {
			deps: ['$ocLazyLoad',function ($ocLazyLoad) {
				return $ocLazyLoad.load(['app/js/home/homeCtrl.js']);
			}]
		}
	})
	.state('app.message',{
		url:'/message',
		templateUrl:"app/views/message/message.html"
	})
}]);