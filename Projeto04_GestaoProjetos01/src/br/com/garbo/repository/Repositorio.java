package br.com.garbo.repository;

import br.com.garbo.jdbc.ClienteDao;
import br.com.garbo.jdbc.PrestadoresDao;
import br.com.garbo.jdbc.UsuarioDao;

public class Repositorio {
	static UsuarioDao usuarioDao;
	static ClienteDao clienteDao;
	static PrestadoresDao prestadoresDao;
	
	public static UsuarioDao getUsuarioDao() {
		if (usuarioDao == null) {
			usuarioDao = new UsuarioDao();
		}
		return usuarioDao;
	}
	
	public static ClienteDao getClienteDao() {
		if (clienteDao == null) {
			clienteDao = new ClienteDao();
		}
		return clienteDao;
	}
	
	public static PrestadoresDao getPrestadoresDao() {
		if (prestadoresDao == null) {
			prestadoresDao = new PrestadoresDao();
		}
		return prestadoresDao;
	}	
}
