package br.com.garbo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="projetos")
public class Projeto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDPROJETO")	
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="IDCLIENTE")	
	private Cliente cliente;
	
	@Column(name = "DESCRICAO")	
	private String descricao;
	
	@Column(name = "DURACAO")	
	private int duracao;
	
	@Column(name = "VALOR")	
	private double valor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}
