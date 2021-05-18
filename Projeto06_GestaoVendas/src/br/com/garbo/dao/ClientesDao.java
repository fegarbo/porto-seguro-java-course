package br.com.garbo.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.garbo.mapper.ClienteMapper;
import br.com.garbo.models.Cliente;

public class ClientesDao implements Dao<Cliente> {

	private JdbcTemplate jdbcTemplate;
	
	public ClientesDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void incluir(Cliente cliente) throws Exception {
		try {
			String sql = "INSERT INTO CLIENTES (DOCUMENTO, NOME, EMAIL, TELEFONE) VALUES (?,?,?,?)";
			this.jdbcTemplate.update(sql,
					cliente.getDocumento(),
					cliente.getNome(),
					cliente.getEmail(),
					cliente.getTelefone());
			
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Collection<Cliente> listar() throws Exception {
		List<Cliente> clientes = new ArrayList<>();
		
		try {
			clientes = jdbcTemplate.query("SELECT * FROM CLIENTES", new ClienteMapper());
		} catch (Exception e) {
			throw e;
		}
		return clientes;
	}
	
}
