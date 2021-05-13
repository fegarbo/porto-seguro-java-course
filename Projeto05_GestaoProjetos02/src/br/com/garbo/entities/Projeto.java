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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@OneToMany(
			cascade=CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "projeto")
	private Set<Cronograma> cronogramas = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "prestadores_projetos",
			joinColumns = {
					@JoinColumn(name="IDPROJETO")
			}, inverseJoinColumns = {
					@JoinColumn(name="DOCUMENTO")
			})
	private Set<Prestador> prestadores = new HashSet<>();
	
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
	public Set<Cronograma> getCronogramas() {
		return cronogramas;
	}
	public void setCronogramas(Set<Cronograma> cronogramas) {
		this.cronogramas = cronogramas;
	}
	public Set<Prestador> getPrestadores() {
		return prestadores;
	}
	public void setPrestadores(Set<Prestador> prestadores) {
		this.prestadores = prestadores;
	}
}
