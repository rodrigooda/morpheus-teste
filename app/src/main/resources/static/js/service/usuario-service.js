// Service
app.service('UsuarioService', [ '$http', function($http) {
	this.getAll = function getAll() {
		return $http({
			method : 'GET',
			url : baseUrl + '/usuario'
		});
	}
	this.getByNome = function getByNome(nome) {
		return $http({
			method : 'GET',
			url : baseUrl + '/usuario/' + nome
		});
	}
	this.add = function add(nome) {
		return $http({
			method : 'POST',
			url : baseUrl + '/usuario',
			data : nome
		});
	}

} ]);
