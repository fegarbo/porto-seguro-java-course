package br.com.garbo.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.garbo.dao.ItensDao;
import br.com.garbo.dao.PedidosDao;
import br.com.garbo.dao.ProdutosDao;
import br.com.garbo.models.Item;
import br.com.garbo.models.Produto;
import br.com.garbo.view.models.ClientePedidosVM;
import br.com.garbo.view.models.ItensPedidoVM;

@Controller
public class ItensController {
	
	@Autowired
	private PedidosDao pedidosDao;
	
	@Autowired
	private ProdutosDao produtosDao;
	
	@Autowired
	private ItensDao itensDao;	
	
	@GetMapping("/itens/gestao")
	public String incluir(@RequestParam("idpedido") int idPedido, Model model) {
		try {
			ClientePedidosVM pedidosVM = pedidosDao.buscarPedido(idPedido);	
			model.addAttribute("pedidosVM", pedidosVM);
			
			Collection<Produto> produtos = produtosDao.listar();
			model.addAttribute("produtos", produtos);
			
			Collection<ItensPedidoVM> listaItensPedidoVM = itensDao.listarItensPedido(idPedido);
			double valorTotal = 0;
			for (ItensPedidoVM itensPedidoVM : listaItensPedidoVM) {
				valorTotal += itensPedidoVM.getValorTotal();
			}
			
			model.addAttribute("valorTotal", valorTotal);
			model.addAttribute("itensPedido", listaItensPedidoVM);
			
			return "itens/cadastroItens";
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
	}
	
	@PostMapping("/caditem")
	public String incluir(Item item, Model model) {
		try {
			itensDao.incluir(item);			
			return "redirect:/itens/gestao?idpedido=" + item.getIdPedido();
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
	}
	
	@GetMapping("/itens/remover/{id}")
	public String remover(@PathVariable("id") int idItem, Model model) {
		try {
			int idPedido = itensDao.buscar(idItem).getIdPedido();
			itensDao.remover(idItem);			
			return "redirect:/itens/gestao?idpedido=" + idPedido;
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
	}
	
	
	
}
