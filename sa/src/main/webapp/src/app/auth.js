angular.module('app').service('authServ', function($window, $cookieStore) {
	this.isLoggedIn = function() {
		if ($cookieStore.get('token')) {
			return true;
		} else {
			return false;
		}
	}
});