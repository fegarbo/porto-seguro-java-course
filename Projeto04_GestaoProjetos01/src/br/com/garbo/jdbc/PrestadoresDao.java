package br.com.garbo.jdbc;

import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.Collection;

import br.com.garbo.models.DocumentoCPF;
import br.com.garbo.models.DocumentoCnpj;
import br.com.garbo.models.Prestador;
import br.com.garbo.utilities.Utils;

public class PrestadoresDao extends Dao<Prestador> {
	
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
			cstmt.setString(6, Utils.verificarMD5(prest.getUsuario().getSenha()));
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
		
		//IDocumento idoc = (prest.getDocumento().getNumero().length() == 11) ? new DocumentoCPF(): new DocumentoCnpj();
		Collection<Prestador> prestadores = new ArrayList<Prestador>();		
		try {				
			abrirConexao();
			String sql = "SELECT * FROM PRESTADORES";
			stmt = cn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Prestador p = new Prestador();	
				p.setDocumento((p.getDocumento().getNumero().length() == 11) ? new DocumentoCPF() : new DocumentoCnpj());				
				p.setNome(rs.getString("NOME"));
				p.setEmail(rs.getString("EMAIL"));
				p.setTelefone(rs.getString("TELEFONE"));
				
				prestadores.add(p);
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		return prestadores;
	}

	@Override
	public Prestador buscar(Object chave) throws Exception {
		return null;
	}

}
