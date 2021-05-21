package br.com.garbo.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import br.com.garbo.dao.ProdutosDao;
import br.com.garbo.models.Produto;

@Controller
public class ProdutosController {
	
	@Autowired
	private ProdutosDao produtosDao;
	
	@GetMapping("/produtos/cadastro")
	public String incluir(Model model) {
		try {
			model.addAttribute("produto", new Produto());
			model.addAttribute("categorias", produtosDao.listarCategorias());
			
			return "produtos/cadastroProdutos";
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
	}
	
	@PostMapping("/cadproduto")
	public String incluir(@ModelAttribute("produto") Produto produto,
						MultipartFile foto, Model model) {
		try {
			if (foto != null) {
				byte[] imagem = foto.getBytes();
				produto.setImagem(imagem);
			}
			
			produtosDao.incluir(produto);			
			return "redirect:/produtos/lista";			
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
	}
	
	@GetMapping("/produtos/lista")
	public String listar(Model model) {
		try {
			model.addAttribute("produtos", produtosDao.listar());
			return "produtos/listaProdutos";
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
	}
	
	//action para recuperar a imagem do produto selecionado
	@GetMapping("/imagem/{id}")
	public void buscarImagem(@PathVariable("id")int id, HttpServletResponse response) {
		try {
			Produto produto = produtosDao.buscar(id);
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			response.getOutputStream().write(produto.getImagem());
			response.getOutputStream().close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
}
