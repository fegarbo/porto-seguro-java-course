package br.com.garbo.jdbc;

import java.sql.CallableStatement;
import java.util.Collection;

import br.com.garbo.models.Prestador;

public class PrestadoresDao extends Dao<Prestador> {

	private String senha;
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public void incluir(Prestador prest) throws Exception {
		try {
			abrirConexao();
			CallableStatement cstmt = cn.prepareCall("{call incluir_prestador(?,?,?,?,?,?)}");
			cstmt.setString(1, prest.getDocumento().getNumero());
			cstmt.setString(2, prest.getDocumento().getNumero());
			cstmt.setString(3, prest.getNome());
			cstmt.setString(4, prest.getEmail());
			cstmt.setString(5, prest.getTelefone());
			cstmt.setString(6, this.senha);
			cstmt.execute();
			cstmt.close();
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
	}

	@Override
	public Collection<Prestador> listar() throws Exception {
		return null;
	}

	@Override
	public Prestador buscar(Object chave) throws Exception {
		return null;
	}

}
