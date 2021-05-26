package br.com.garbo.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.garbo.mapper.ItensPedidoMapper;
import br.com.garbo.models.Item;
import br.com.garbo.view.models.ItensPedidoVM;

public class ItensDao implements Dao<Item> {

	private JdbcTemplate jdbcTemplate;
	
	public ItensDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void incluir(Item item) throws Exception {
		try {
			String sql = "INSERT INTO ITENS (IDPEDIDO, IDPRODUTO, QUANTIDADE) "
					+ "VALUES (?,?,?)";
			jdbcTemplate.update(sql,
					item.getIdPedido(),
					item.getIdProduto(),
					item.getQuantidade());				
		} catch (Exception e) {
			throw e;
		}		
	}

	@Override
	public Collection<Item> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Item item) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Item buscar(Object key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(Object key) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public Collection<ItensPedidoVM> listarItensPedido(int idPedido) throws Exception {
		Collection<ItensPedidoVM> itensPedido = new ArrayList<>();
		try {
			String sql = "SELECT "
					+ "P.DESCRICAO AS nomeProduto, "
					+ "I.QUANTIDADE AS quantidade, "
					+ "(P.PRECO * I.QUANTIDADE) AS valorTotal "
					+ "FROM ITENS I, PRODUTOS P "
					+ "WHERE "
					+ "I.IDPRODUTO = P.ID "
					+ "AND I.IDPEDIDO = ?";
			
			itensPedido = jdbcTemplate.query(sql,
					new Integer[] {idPedido},
					new ItensPedidoMapper());
			
		} catch (Exception e) {
			throw e;
		}
		
		return itensPedido;
	}	
	
}
