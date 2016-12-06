app.run(['$rootScope','$sessionStorage','$cookieStore','$state','authServ',function($rootScope,$sessionStorage,$cookieStore,$state,authServ) {
	$rootScope.$on('$stateChangeStart', function(event, next) {
		console.log(next);
		console.log(authServ.isLoggedIn());
		if(!authServ.isLoggedIn() && next.name!='login'){
			event.preventDefault();
			$state.go('login');
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
				return $ocLazyLoad.load(['app/js/home/homeCtrl.js','app/js/home/service/globalService.js']);
			}]
		}
	})
	.state('app.message',{
		url:'/message',
		templateUrl:"app/views/message/message.html",
		resolve: {
			deps: ['$ocLazyLoad',function ($ocLazyLoad) {
				return $ocLazyLoad.load(['app/js/message/messageCtrl.js','app/js/message/service/messageService.js']);
			}]
		}
	})
}]);