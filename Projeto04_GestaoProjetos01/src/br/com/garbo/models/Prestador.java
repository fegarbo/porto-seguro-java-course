package br.com.garbo.models;

import br.com.garbo.interfaces.IDocumento;

public class Prestador {
	
	private IDocumento documento;
	private Usuario usuario;
	private String nome;
	private String telefone;
	private String email;
	
	public IDocumento getDocumento() {
		return documento;
	}
	public void setDocumento(IDocumento documento) {
		this.documento = documento;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
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
}
