package br.com.garbo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.garbo.models.Cliente;

public class ClienteMapper implements RowMapper<Cliente> {

	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setDocumento(rs.getString("DOCUMENTO"));
		cliente.setNome(rs.getString("NOME"));
		cliente.setEmail(rs.getString("EMAIL"));
		cliente.setTelefone(rs.getString("TELEFONE"));
		
		return cliente;
	}
	
}
