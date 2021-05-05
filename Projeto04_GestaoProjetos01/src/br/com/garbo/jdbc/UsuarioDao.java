package br.com.garbo.jdbc;

import java.util.ArrayList;
import java.util.Collection;

import br.com.garbo.models.Usuario;
import br.com.garbo.utilities.Utils;

public class UsuarioDao extends Dao<Usuario> {

	@Override
	public void incluir(Usuario usuario) throws Exception {
		try {
			abrirConexao();
			String sql = "INSERT INTO USUARIOS (nome, senha, nivel) VALUES (?,?,?)";
			stmt = cn.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, Utils.verificarMD5(usuario.getSenha()));
			stmt.setString(3, usuario.getNivel().toString());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}		
	}

	@Override
	public Collection<Usuario> listar() throws Exception {		
		Collection<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			abrirConexao();
			String sql = "SELECT * FROM USUARIOS";
			stmt = cn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setNome(rs.getString("NOME"));
				u.setSenha(rs.getString("SENHA"));
				u.setNivel(Utils.buscarNivel(rs.getString("NIVEL")));
				
				usuarios.add(u);
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		
		return usuarios;
	}

	@Override
	public Usuario buscar(Object chave) throws Exception {		
		
		Usuario usuario = null;		
		try {			
			if (!(chave instanceof String)) {
				throw new Exception("Tipo de parâmetro deve ser uma String");
			}
			
			abrirConexao();
			String sql = "SELECT * FROM USUARIOS WHERE NOME = ?";
			stmt = cn.prepareStatement(sql);
			stmt.setString(1, (String)chave);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setNome(rs.getString("NOME"));
				usuario.setSenha(rs.getString("SENHA"));
				usuario.setNivel(Utils.buscarNivel(rs.getString("NIVEL")));
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		
		return usuario;
	}
	
	public Usuario validar(String nome, String senha) throws Exception {		
		
		Usuario usuario = null;		
		try {			
			abrirConexao();
			String sql = "SELECT * FROM USUARIOS WHERE NOME = ? AND SENHA = ?";
			stmt = cn.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.setString(2, Utils.verificarMD5(senha));
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setNome(nome);
				usuario.setSenha(senha);
				usuario.setNivel(Utils.buscarNivel(rs.getString("NIVEL")));
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		
		return usuario;
	}
}
