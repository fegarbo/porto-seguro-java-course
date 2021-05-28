package br.com.garbo.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.garbo.dao.PagamentosDao;
import br.com.garbo.models.Pagamento;

@Controller
@Transactional
@RequestMapping("/api")
public class PagamentosController {

	@Autowired
	private PagamentosDao pagamentosDao;
	
	@CrossOrigin
	@RequestMapping("/pagamentos")
	@ResponseBody
	public List<Pagamento> listar(){
		
		return pagamentosDao.list();
	}
	
	@CrossOrigin
	@RequestMapping(
			value = "/pagamentos",
			method = RequestMethod.POST,
			consumes = "application/json",
			produces = "application/json")
	@ResponseBody
	public Pagamento incluir(@RequestBody Pagamento pagamento) {
		try {
			pagamentosDao.save(pagamento);
			return pagamento;
		} catch (Exception e) {
			return new Pagamento();
		}
	}
}
