package br.com.garbo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="prestadores")
public class Prestador {
	
	@Id
	@Column(name = "DOCUMENTO")
	private String documento;
	
	@Column(name = "USUARIO")
	private String usuario;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "TELEFONE")
	private String telefone;
	
	@OneToMany(
			cascade=CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "prestador")
	private Set<Pagamento> pagamentos = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "prestadores")
	private Set<Projeto> projetos = new HashSet<>();
	
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Set<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(Set<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public Set<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(Set<Projeto> projetos) {
		this.projetos = projetos;
	}
}
