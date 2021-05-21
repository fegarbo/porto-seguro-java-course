package br.com.garbo.dao;

import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.garbo.models.Pedido;

public class PedidosDao implements Dao<Pedido> {

	private JdbcTemplate jdbcTemplate;
	
	public PedidosDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void incluir(Pedido item) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Pedido> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Pedido item) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pedido buscar(Object key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(Object key) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
