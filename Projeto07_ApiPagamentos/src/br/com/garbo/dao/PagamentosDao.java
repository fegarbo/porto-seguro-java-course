package br.com.garbo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.garbo.models.Pagamento;

@Repository
public class PagamentosDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void save(Pagamento pagamento) {
		manager.persist(pagamento);
	}
	
	public List<Pagamento> list(){
		TypedQuery<Pagamento> query = manager.createNamedQuery("SELECT p FROM Pagamento p", Pagamento.class);
		return query.getResultList();
	}
	
	public Pagamento get(int id) {
		TypedQuery<Pagamento> query = manager.createQuery("SELECT p FROM Pagamento WHERE p.id = :id", Pagamento.class);
		query.setParameter("id", id);
		
		return query.getSingleResult();
	}
}
