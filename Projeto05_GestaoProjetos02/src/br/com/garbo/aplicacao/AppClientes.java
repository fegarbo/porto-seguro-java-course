package br.com.garbo.aplicacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.garbo.entities.Cliente;
import br.com.garbo.helper.ClientesHelper;

public class AppClientes {
	public static void main(String[] args) {
		System.out.println("Passei aqui");
		//ListarClientes();
	}
	
	private static void ListarClientes() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
		EntityManager em = emf.createEntityManager();
		ClientesHelper helper = new ClientesHelper(em);
		
		List<Cliente> clientes = helper.listarClientes();
		
		for (Cliente cliente : clientes) {
			System.out.println("Id:" + cliente.getId());
			System.out.println("Nome" + cliente.getNome());
		}
	}
}
