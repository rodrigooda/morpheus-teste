// List Controller
app.controller("ListController", [ '$scope', 'UsuarioService',
		function($scope, UsuarioService) {
			$scope.usuarios;
			$scope.getAll = function(){
			UsuarioService.getAll().then(function(response) {
				$scope.usuarios = response.data;
			});
			};
			$scope.search = function() {
				UsuarioService.getByNome($scope.nome).then(function(response) {
					$scope.usuarios = [ response.data ];
				}, function(error) {
					$scope.usuarios = [ ];
				});
			};
			$scope.getAll();
		} ]);