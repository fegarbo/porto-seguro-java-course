package br.com.garbo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.garbo.entities.Pagamento;
import br.com.garbo.entities.Projeto;
import br.com.portoseguro.viewmodels.ClientesProjetosVM;

//metodos especificos de cada entidade
public class MetodosDao {
	
	private EntityManager em;
	
	public List<Projeto> listarProjetos(int idCliente){
		em = JpaUtil.getEntityManager();
		TypedQuery<Projeto> query = em.createQuery(
				"SELECT p FROM Projeto p WHERE p.cliente.id = :id", Projeto.class);
		query.setParameter("id", idCliente);		
		return query.getResultList();
	}
	
	public List<Pagamento> listarPagamentos(String documento){
		em = JpaUtil.getEntityManager();
		TypedQuery<Pagamento> query = em.createQuery(
				"SELECT p FROM Pagamento p WHERE p.prestador.documento = :documento", Pagamento.class);
		query.setParameter("documento", documento);		
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ClientesProjetosVM> listarQtdeProjetos(){
		List<ClientesProjetosVM> lista = new ArrayList<>();
		em = JpaUtil.getEntityManager();
		
		List<Object[]> query = em.createQuery(
				"SELECT c.nome, c.telefone, COUNT(p.descricao) AS quantidade "
				+ "FROM Cliente c, Projeto p WHERE c.id = p.cliente.id "
				+ "GROUP BY c.nome, c.telefone").getResultList();
		
		for (Object[] objs : query) {
			ClientesProjetosVM vm = new ClientesProjetosVM();
			vm.setCliente(objs[0].toString());
			vm.setTelefone(objs[1].toString());
			vm.setQuantidade((Long)objs[2]);
			
			lista.add(vm);
		}
		
		return lista;
	}
}
