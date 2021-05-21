package br.com.garbo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.garbo.dao.ClientesDao;
import br.com.garbo.dao.PedidosDao;
import br.com.garbo.models.Pedido;

@Controller
public class PedidosController {
	
	@Autowired
	private PedidosDao pedidosDao;
	
	@Autowired
	private ClientesDao clientesDao;
	
	@GetMapping("/pedidos/cadastro")
	public String incluir(Model model) {
		try {
			
			model.addAttribute("clientes", clientesDao.listar());
			model.addAttribute("pedido", new Pedido());
			
			return "pedidos/cadastroPedidos";
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";			
		}
	}
}
