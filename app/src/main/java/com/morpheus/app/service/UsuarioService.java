package com.morpheus.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morpheus.app.dao.UsuarioDAO;
import com.morpheus.app.exception.AppException;
import com.morpheus.app.model.Usuario;
@Service
public class UsuarioService {
	@Autowired
	UsuarioDAO usuarioDAO;

	public List<Usuario> getAll() throws IOException, AppException {
		return usuarioDAO.getAll();
	}

	public Usuario getByNome(String nome) throws IOException, AppException {
		return usuarioDAO.getByNome(nome);
	}

	public void add(Usuario usuario) throws IOException, AppException {
		usuarioDAO.add(usuario);
	}
}
