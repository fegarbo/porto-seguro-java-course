package br.com.garbo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.garbo.view.models.ItensPedidoVM;

public class ItensPedidoMapper implements RowMapper<ItensPedidoVM> {

	@Override
	public ItensPedidoVM mapRow(ResultSet rs, int rowNum) throws SQLException {
		ItensPedidoVM vm = new ItensPedidoVM();
		vm.setNomeProduto(rs.getString("nomeProduto"));
		vm.setQuantidade(rs.getInt("quantidade"));
		vm.setValorTotal(rs.getDouble("valorTotal"));
		
		return vm;
	}

}
