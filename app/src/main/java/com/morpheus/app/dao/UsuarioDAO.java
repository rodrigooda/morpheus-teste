package com.morpheus.app.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.morpheus.app.exception.AppException;
import com.morpheus.app.model.Usuario;

@Repository
public class UsuarioDAO {

	public void add(Usuario usuario) throws IOException, AppException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(this.readFile(), true));
		bw.newLine();
		bw.write(usuario.getNome());
		bw.close();
	}

	public List<Usuario> getAll() throws IOException, AppException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		BufferedReader br = new BufferedReader(new FileReader(this.readFile()));
		String record;
		while ((record = br.readLine()) != null)
			usuarios.add(new Usuario(record));
		br.close();
		return usuarios;
	}

	public Usuario getByNome(String nome) throws IOException, AppException {
		BufferedReader br = new BufferedReader(new FileReader(this.readFile()));
		String record;
		while ((record = br.readLine()) != null)
			if (record.equals(nome)) {
				br.close();
				return new Usuario(record);
			}
		br.close();
		return null;
	}

	public File readFile() throws AppException {
		File file = new File(System.getProperty("user.home"), "app/nomes.txt");
		if (!file.exists())
			throw new AppException("Base de dados não encontrada");
		return file;
	}

	public static void main(String[] args) {
		UsuarioDAO ud = new UsuarioDAO();
		try {
			ud.add(new Usuario("Teste4"));
			for (Usuario usuario : ud.getAll())
				System.out.println(usuario.getNome());
			System.out.println(ud.getByNome("Teste4").getNome());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IOException");
		} catch (AppException e) {
			e.printStackTrace();
			System.out.println("AppException");
		}
	}
}
