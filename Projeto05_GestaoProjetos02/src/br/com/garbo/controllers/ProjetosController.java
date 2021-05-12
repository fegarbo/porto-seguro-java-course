package br.com.garbo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.garbo.dao.GenericDao;
import br.com.garbo.dao.MetodosDao;
import br.com.garbo.entities.Cliente;
import br.com.garbo.entities.Projeto;

@Controller
public class ProjetosController {
	
	@RequestMapping("/projetos/cadastro")
	public String incluir(ModelMap model) {
		try {
			GenericDao<Cliente> dao = new GenericDao<>(Cliente.class);
			List<Cliente> clientes = dao.listar();
			model.addAttribute("listaClientes", clientes);
			return "forms/cadastroProjeto";

		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
		
	}
	
	@RequestMapping(value = "/cadprojeto", method = RequestMethod.POST)
	public String incluir(@RequestParam("idcliente") int idCliente, Projeto projeto, ModelMap model) {
		try {
			GenericDao<Cliente> daoc = new GenericDao<>(Cliente.class);
			Cliente cliente = daoc.buscar(idCliente);
			projeto.setCliente(cliente);
			
			GenericDao<Projeto> daop = new GenericDao<>(Projeto.class);
			daop.adicionar(projeto);
			
			return "redirect:/projetos/cadastro";
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
	}
	
	@RequestMapping("/projetos/lista/{id}")
	public String listar(@PathVariable("id") int idCliente, ModelMap model) {
		try {
			List<Projeto> listaProjetos = new MetodosDao().listarProjetos(idCliente);
			model.addAttribute("listaProjetos", listaProjetos);
			return "listas/listaProjetos";
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";			
		}
	}
}
