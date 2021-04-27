package br.com.garbo.jdbc;

import java.util.Collection;

import br.com.garbo.models.Usuario;

public class UsuarioDao extends Dao<Usuario> {

	@Override
	public void incluir(Usuario usuario) throws Exception {
		try {
			abrirConexao();
			String sql = "INSERT INTO USUARIOS (nome, senha, nivel) VALUES (?,?,?)";
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}		
	}

	@Override
	public Collection<Usuario> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscar(Object chave) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
