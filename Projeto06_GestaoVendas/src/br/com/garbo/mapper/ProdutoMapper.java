package br.com.garbo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.garbo.models.Produto;

public class ProdutoMapper implements RowMapper<Produto>{

	@Override
	public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {
		Produto produto = new Produto();
		
		produto.setId(rs.getInt("ID"));
		produto.setDescricao(rs.getString("DESCRICAO"));
		produto.setUnidade(rs.getString("UNIDADE"));
		produto.setPreco(rs.getDouble("PRECO"));
		produto.setCategoria(rs.getInt("IDCATEGORIA"));
		produto.setImagem(rs.getBytes("IMAGEM"));
		
		return produto;
	}
	
}
