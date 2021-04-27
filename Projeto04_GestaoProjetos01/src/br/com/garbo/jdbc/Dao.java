package br.com.garbo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;

public abstract class Dao<T> {
	
	protected Connection cn;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	
	String url = "jdbc:mysql://localhost:3307/db_projetos";
	
	protected void abrirConexao() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");		
		cn = DriverManager.getConnection(url, "root", "admin123");
	}
	
	protected void fecharConexao() throws Exception {
		if (cn != null && !cn.isClosed()) {
			cn.close();
		}
	}	
	
	public abstract void incluir(T item) throws Exception;	
	public abstract Collection<T> listar() throws Exception;
	public abstract T buscar(Object chave) throws Exception;
}
