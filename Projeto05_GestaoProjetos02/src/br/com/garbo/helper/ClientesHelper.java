package br.com.garbo.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.garbo.entities.Cliente;

public class ClientesHelper {
	
	//Esta variavel eh usada para acessar o banco de dados por meio das entidades
	private EntityManager em;
	
	//Construtor
	public ClientesHelper(EntityManager em) {
		this.em = em;
	}
	
	//metodo para listar os clientes - usando JPQL
	public List<Cliente> listarClientes(){
		TypedQuery<Cliente> query = em.createQuery("Select c from Cliente c", Cliente.class);
		
		return query.getResultList();
	}
}
