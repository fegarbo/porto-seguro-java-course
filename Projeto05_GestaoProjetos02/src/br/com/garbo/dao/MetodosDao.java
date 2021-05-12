package br.com.garbo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.garbo.entities.Projeto;

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
}
