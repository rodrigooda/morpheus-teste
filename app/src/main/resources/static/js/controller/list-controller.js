// List Controller
app.controller("ListController", [ '$scope', 'UsuarioService',
		function($scope, UsuarioService) {
			$scope.usuarios;
			UsuarioService.getAll().then(function(response) {
				$scope.usuarios = response.data;
			});
		} ]);