package br.com.garbo.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.garbo.dao.PagamentosDao;
import br.com.garbo.models.Pagamento;

@Controller
@Transactional
@RequestMapping("/api")
public class PagamentosController {

	@Autowired
	private PagamentosDao pagamentosDao;
	
	@RequestMapping("/pagamentos")
	@ResponseBody
	public List<Pagamento> listar(){
		
		return pagamentosDao.list();
	}
}
