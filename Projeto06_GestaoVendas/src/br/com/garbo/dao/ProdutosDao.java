package br.com.garbo.dao;

import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.garbo.models.Produto;

public class ProdutosDao implements Dao<Produto> {
	
	private JdbcTemplate jdbcTemplate;
	
	public ProdutosDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void incluir(Produto produto) throws Exception {
		try {
			String sql = "INSERT INTO PRODUTOS (DESCRICAO, UNIDADE, PRECO,"
					+ "IDCATEGORIA, IMAGEM) VALUES (?,?,?,?,?)";
			jdbcTemplate.update(sql,
					produto.getDescricao(),
					produto.getUnidade(), 
					produto.getPreco(),
					produto.getCategoria().getId(),
					produto.getImagem());
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Collection<Produto> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Produto item) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto buscar(Object key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(Object key) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
