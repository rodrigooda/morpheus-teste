// Add Controller
app
		.controller(
				"AddController",
				[
						'$scope',
						'UsuarioService',
						function($scope, UsuarioService) {
							$scope.usuario = {
								nome : ""
							};
							$scope.modal = {
								showModal : "",
								mensagem : ""
							};
							$scope.openModal = function(mensagem) {
								$scope.modal.showModal = "is-active";
								$scope.modal.mensagem = mensagem;
							};
							$scope.closeModal = function() {
								$scope.modal.showModal = "";
							};
							$scope.add = function() {
								UsuarioService
										.add($scope.usuario.nome)
										.then(
												function(response) {
													$scope
															.openModal("Usuário cadastrado com sucesso!");
													$scope.usuario.nome = "";
												},
												function(error) {
													$scope
															.openModal("Erro ao cadastrar usuário");
												});
							}
						} ]);