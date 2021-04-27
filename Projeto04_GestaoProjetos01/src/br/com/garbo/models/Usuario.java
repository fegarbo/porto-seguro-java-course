package br.com.garbo.models;

import br.com.garbo.enumerations.Niveis;

public class Usuario {
	
	private String nome;
	private String senha;
	private Niveis nivel;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Niveis getNivel() {
		return nivel;
	}
	public void setNivel(Niveis nivel) {
		this.nivel = nivel;
	}
}
