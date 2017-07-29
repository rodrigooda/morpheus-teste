package com.morpheus.app;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.morpheus.app.exception.AppException;
import com.morpheus.app.service.UsuarioService;
import com.morpheus.app.model.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioServiceTests {
	@Autowired
	UsuarioService usuarioService;

	@Test
	public void testGetAll() throws IOException, AppException {
		Assert.assertNotNull(usuarioService.getAll());
	}
	
	@Test
	public void testAdd() throws IOException, AppException {
		Usuario usuario = new Usuario("Teste");
		usuarioService.add(usuario);
		Assert.assertNotNull(usuarioService.getByNome("Teste"));
	}

	@Test
	public void testGetByNome() throws IOException, AppException {
		Assert.assertNotNull(usuarioService.getByNome("Maria"));
	}

}

