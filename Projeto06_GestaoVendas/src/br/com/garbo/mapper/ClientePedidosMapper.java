package br.com.garbo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.garbo.view.models.ClientePedidosVM;

public class ClientePedidosMapper implements RowMapper<ClientePedidosVM> {

	@Override
	public ClientePedidosVM mapRow(ResultSet rs, int rowNum) throws SQLException {

		ClientePedidosVM vm = new ClientePedidosVM();
		vm.setIdPedido(rs.getInt("id"));
		vm.setPedido(rs.getString("pedido"));
		vm.setData(rs.getDate("data"));
		vm.setCliente(rs.getString("cliente"));
		vm.setDocumento(rs.getString("documento"));
		
		return vm;
	}
}
