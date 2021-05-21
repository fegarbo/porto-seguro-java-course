package br.com.garbo.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.garbo.mapper.CategoriaMapper;
import br.com.garbo.mapper.ProdutoMapper;
import br.com.garbo.models.Categoria;
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
					produto.getCategoria(),
					produto.getImagem());
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Collection<Produto> listar() throws Exception {
		Collection<Produto> produtos = new ArrayList<Produto>();
		try {
			produtos = jdbcTemplate.query(
					"SELECT * FROM PRODUTOS", new ProdutoMapper());			
			
		} catch (Exception e) {
			throw e;
		}
		return produtos;
	}

	@Override
	public void alterar(Produto item) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto buscar(Object key) throws Exception {
		Produto produto = null;
		try {
			produto = jdbcTemplate.queryForObject(
					"SELECT * FROM PRODUTOS WHERE ID = ?",
					new Integer[] {(int)key},
					new ProdutoMapper());
		} catch (Exception e) {
			throw e;
		}
		
		return produto;
	}

	@Override
	public void remover(Object key) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public List<Categoria> listarCategorias() throws Exception{
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		try {
			categorias = jdbcTemplate.query("SELECT * FROM CATEGORIAS", new CategoriaMapper());
			
		} catch (Exception e) {
			throw e;
		}
		
		return categorias;
	}
	
	public Categoria buscarCategoria(int id) throws Exception{
		Categoria categoria = null;
		try {
			categoria = jdbcTemplate.queryForObject("SELECT * FROM CATEGORIAS WHERE ID = ?",
					new Integer[] {id}, new CategoriaMapper());
		} catch (Exception e) {
			throw e;
		}
		
		return categoria;
	}
}
