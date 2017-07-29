package com.morpheus.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.morpheus.app.exception.AppException;
import com.morpheus.app.model.Usuario;
import com.morpheus.app.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> getAll() throws IOException, AppException {
		List<Usuario> usuarios = usuarioService.getAll();
		if (usuarios.isEmpty()) {
			return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/{nome}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> getByNome(@PathVariable("nome") String nome) throws IOException, AppException {
		Usuario usuario = usuarioService.getByNome(nome);
		if (usuario == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Usuario> add(@RequestBody String nome) throws IOException, AppException {
		Usuario usuario = new Usuario(nome);
		usuarioService.add(usuario);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
	}
}