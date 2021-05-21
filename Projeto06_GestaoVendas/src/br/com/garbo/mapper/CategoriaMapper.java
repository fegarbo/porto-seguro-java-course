package br.com.garbo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.garbo.models.Categoria;

public class CategoriaMapper implements RowMapper<Categoria> {
	
	public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException{
		Categoria categoria = new Categoria();
		categoria.setId(rs.getInt("ID"));
		categoria.setDescricao(rs.getString("DESCRICAO"));
		
		return categoria;
	}
}
