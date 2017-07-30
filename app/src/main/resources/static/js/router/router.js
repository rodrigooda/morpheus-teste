// rotas
app.config(function($routeProvider, $locationProvider) {
	$routeProvider.when('/', {
		templateUrl : 'view/list.html',
		controller : 'ListController'
	}).when('/add', {
		templateUrl : 'view/add.html',
		controller : 'AddController'
	}).when('/list', {
		templateUrl : 'view/list.html',
		controller : 'ListController'
	});
});
