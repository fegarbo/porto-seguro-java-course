package br.com.garbo.repository;

import br.com.garbo.jdbc.ClienteDao;
import br.com.garbo.jdbc.UsuarioDao;

public class Repositorio {
	static UsuarioDao usuarioDao;
	static ClienteDao clienteDao;
	
	public static UsuarioDao getUsuarioDao() {
		if (clienteDao == null) {
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
}
