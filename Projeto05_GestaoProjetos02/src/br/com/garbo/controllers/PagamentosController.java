package br.com.garbo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.garbo.dao.GenericDao;
import br.com.garbo.dao.MetodosDao;
import br.com.garbo.entities.Pagamento;
import br.com.garbo.entities.Prestador;
import br.com.garbo.enumerations.Tipo;

@Controller
public class PagamentosController {
	
	@RequestMapping("/pagamentos/cadastro")
	public String incluir(ModelMap model) {
		try {
			GenericDao<Prestador> dao = new GenericDao<>(Prestador.class);
			List<Prestador> prestadores = dao.listar();			
			List<Tipo> tipos = listarTipos(model);
			
			model.addAttribute("listaPrestadores", prestadores);
			model.addAttribute("enumTipo", tipos);

			return "forms/cadastroPagamento";

		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}	
	}
	
	@PostMapping(value = "/cadpagamento")
	public String incluir(@RequestParam("documentoPrest") String documentoPrest,
						  @RequestParam("tipo") String tipo, 
						  Pagamento pagamento, ModelMap model) {
		try {
			GenericDao<Prestador> daoc = new GenericDao<>(Prestador.class);
			Prestador prestador = daoc.buscar(documentoPrest);
			pagamento.setPrestador(prestador);
			
			//TODO incluir Tipo no objeto pagamento
			GenericDao<Pagamento> daop = new GenericDao<>(Pagamento.class);
			daop.adicionar(pagamento);
			
			return "redirect:/pagamentos/cadastro";
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
	}
	
	@RequestMapping("/pagamentos/lista/{documento}")
	public String listar(@PathVariable("documento") String documento, ModelMap model) {
		try {
			List<Pagamento> listaPagamentos = new MetodosDao().listarPagamentos(documento);			
			Prestador prestador = new GenericDao<Prestador>(Prestador.class).buscar(documento);			
			model.addAttribute("nomePrestador", prestador.getNome());
			model.addAttribute("listaPagamentos", listaPagamentos);
			return "listas/listaPagamentos";
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";			
		}
	}
	
	private List<Tipo> listarTipos(ModelMap model) {
		try {
			return Arrays.asList(Tipo.values());
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return null;
		}
	}		
}
