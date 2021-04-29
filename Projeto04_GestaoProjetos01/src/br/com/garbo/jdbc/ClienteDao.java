package br.com.garbo.jdbc;

import java.util.Collection;

import br.com.garbo.models.Cliente;

public class ClienteDao extends Dao<Cliente> {

	@Override
	public void incluir(Cliente cliente) throws Exception {
		try {
			abrirConexao();
			String sql = "INSERT INTO CLIENTES (usuario, nome, email, telefone) VALUES (?,?,?,?)";
			stmt = cn.prepareStatement(sql);
			stmt.setString(1, cliente.getUsuario().getNome());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getEmail());
			stmt.setString(4, cliente.getTelefone());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
	}

	@Override
	public Collection<Cliente> listar() throws Exception {
		try {
			abrirConexao();
			String sql = "SELECT * FROM CLIENTES";
			stmt = cn.prepareStatement(sql);
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		return null;
	}

	@Override
	public Cliente buscar(Object chave) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
