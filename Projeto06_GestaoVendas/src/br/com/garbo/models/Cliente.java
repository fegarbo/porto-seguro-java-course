package br.com.garbo.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

public class Cliente {
	
	@CPF(message = "CPF inv�lido")
	@Size(min=11, max=11, message="O CPF deve ter 11 d�gitos")
	private String documento;
	
	@NotEmpty(message = "O nome deve ser informado")
	@Size(min=1, max=45, message="O nome deve ter at� 45 caracteres")
	private String nome;
	
	@Email(message = "E-mail inv�lido")
	@Size(min=1, max=60, message="O email deve ter entre 5 e 60 caracteres")
	private String email;
	
	@Size(min=1, max=20, message="O telefone deve ter entre 8 e 20 d�gitos")
	private String telefone;
		
	
	public String getDocumento() {
		return documento;
	}
	
	public void setDocumento(String documento) {
		this.documento = documento;
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
}
