package br.com.garbo.controllers;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.garbo.dao.ClientesDao;
import br.com.garbo.dao.PedidosDao;
import br.com.garbo.models.Pedido;
import br.com.garbo.view.models.ClientePedidosVM;

@Controller
public class PedidosController {
	
	@Autowired
	private PedidosDao pedidosDao;
	
	@Autowired
	private ClientesDao clientesDao;
		
	@GetMapping("/pedidos/cadastro")
	public String incluir(@RequestParam("doc") Optional<String> docum, Model model) {
		try {
			String mensagem = "Nenhum cliente selecionado";
			if (docum.isPresent()) {
				model.addAttribute("ndoc", docum.get());
				
				Collection<ClientePedidosVM> lista = pedidosDao.listarPedidos(docum.get());
				
				if (lista.size() > 0) {
					model.addAttribute("pedidos", lista);
				}else {
					mensagem = "Nenhum pedido para este cliente";
				}
			}
			
			model.addAttribute("mensagem", mensagem);
			model.addAttribute("clientes", clientesDao.listar());						
			return "pedidos/cadastroPedidos";
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";			
		}
	}
	
	@PostMapping("/cadpedido")
	public String incluir(Pedido pedido, Model model) {
		try {
			if (pedido.getDocumentoCliente().equals("0")) {
				throw new Exception("Nenhum cliente selecionado.");
			}
			
			pedido.setDataPedido(new Date());
			pedidosDao.incluir(pedido);
			return "redirect:/pedidos/cadastro?doc=" + pedido.getDocumentoCliente();
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";	
		}
	}
}
