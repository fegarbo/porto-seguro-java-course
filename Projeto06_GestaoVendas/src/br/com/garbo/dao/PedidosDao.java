package br.com.garbo.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import br.com.garbo.mapper.ClientePedidosMapper;
import br.com.garbo.models.Pedido;
import br.com.garbo.view.models.ClientePedidosVM;

public class PedidosDao implements Dao<Pedido> {

	private JdbcTemplate jdbcTemplate;
	
	public PedidosDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void incluir(Pedido pedido) throws Exception {
		try {
			String sql = "INSERT INTO PEDIDOS (NUMEROPEDIDO, DATAPEDIDO, DOCCLIENTE) "
					+ "VALUES (?,?,?)";
			jdbcTemplate.update(sql,
					pedido.getNumeroPedido(),
					new java.sql.Date(pedido.getDataPedido().getTime()),
					pedido.getDocumentoCliente());
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Collection<ClientePedidosVM> listarPedidos(String documento) throws Exception {
		Collection<ClientePedidosVM> pedidos = new ArrayList<>();
		try {
			String sql = "SELECT "
					+ "P.ID AS idPedido, "
					+ "P.NUMEROPEDIDO AS pedido, "
					+ "P.DATAPEDIDO AS data, "
					+ "C.DOCUMENTO AS documento, "
					+ "C.NOME AS cliente "
					+ "FROM "
					+ "PEDIDOS P, CLIENTES c "
					+ "WHERE "
					+ "P.DOCCLIENTE = C.DOCUMENTO AND C.DOCUMENTO = ?";
			
			pedidos = jdbcTemplate.query(sql,
					new String[] {documento},
					BeanPropertyRowMapper.newInstance(ClientePedidosVM.class));
			
		} catch (Exception e) {
			throw e;
		}
		
		return pedidos;
	}
	
	public ClientePedidosVM buscarPedido(int idPedido) throws Exception {
		ClientePedidosVM pedidosVM = new ClientePedidosVM();
		try {
			String sql = "SELECT "
					+ "P.ID AS id, "
					+ "P.NUMEROPEDIDO AS pedido, "
					+ "P.DATAPEDIDO AS data, "
					+ "C.DOCUMENTO AS documento, "
					+ "C.NOME AS cliente "
					+ "FROM "
					+ "PEDIDOS P, CLIENTES c "
					+ "WHERE "
					+ "P.DOCCLIENTE = C.DOCUMENTO AND P.ID = ?";
			pedidosVM = jdbcTemplate.queryForObject(sql, new Integer[] {idPedido}, new ClientePedidosMapper());
			
		} catch (Exception e) {
			throw e;
		}
		
		return pedidosVM;
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
