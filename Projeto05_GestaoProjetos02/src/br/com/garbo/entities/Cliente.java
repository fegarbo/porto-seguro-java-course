package br.com.garbo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IDCLIENTE")
	private int id;
	
	@Column(name="USUARIO", length = 20, nullable = false, unique = true) // for remember the possibilities
	private String usuario;
	
	@Column(name="NOME", length = 45)
	private String nome;
	
	@Column(name="TELEFONE", length = 20)
	private String telefone;
	
	@Column(name="EMAIL", length = 45)
	private String email;
	
	@OneToMany(
			cascade=CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "cliente")
	private Set<Projeto> projetos = new HashSet<>(); //prop. de navegacao

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(Set<Projeto> projetos) {
		this.projetos = projetos;
	}
	
}
