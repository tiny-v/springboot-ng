var app = angular.module('app').config(['$controllerProvider', '$compileProvider', '$filterProvider', '$provide',
                                        function ($controllerProvider, $compileProvider, $filterProvider, $provide) {

	// lazy controller, directive and service
	app.controller = $controllerProvider.register;
	app.directive = $compileProvider.directive;
	app.filter = $filterProvider.register;
	app.factory = $provide.factory;
	app.service = $provide.service;
	app.constant = $provide.constant;
	app.value = $provide.value;
}
]);

angular
.module('app')
.factory('authInterceptor', ['$rootScope','$q','$window','$injector','$cookieStore',function($rootScope, $q, $window, $injector,$cookieStore) {
	return {
		request: function(config) {
			config.headers = config.headers || {};
			if ($cookieStore.get('token')) {
				config.headers['access-token'] = $cookieStore.get('token');
			}
			return config;
		},
		response: function(response) {
			return response || $q.when(response);
		},
		responseError: function(rejection) {
			console.log(rejection);
			if(rejection && rejection.status == 400){
				if(rejection.data.code == '403'){
					var stateService = $injector.get('$state');
					stateService.go('login');
				}
			}else if (rejection && rejection.status === 403) {
				var stateService = $injector.get('$state');
				stateService.go('login');
			} else {
				if (rejection.status == 500 && rejection.data && rejection.data.exception == 'cn.infoease.idp.core.exception.ServiceException') {
				
				}else{
				}
			}
			return rejection || $q.when(rejection);
		},
		requestError: function(rejection) {
			return rejection || $q.when(rejection);
		}

	};
}
]);


angular.module('app').config(['$httpProvider',function($httpProvider){
	$httpProvider.interceptors.push('authInterceptor');
}]);




