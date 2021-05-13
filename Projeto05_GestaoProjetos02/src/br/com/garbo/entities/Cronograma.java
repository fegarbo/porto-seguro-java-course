package br.com.garbo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.garbo.enumerations.Concluido;

@Entity
@Table(name = "cronogramas")
public class Cronograma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDCRONOGRAMA")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDPROJETO")	
	private Projeto projeto;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "DATA")
	private Date date;
	
	@Column(name = "DURACAO")
	private int duracao;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "CONCLUIDO")
	private Concluido concluido;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Concluido getConcluido() {
		return concluido;
	}

	public void setConcluido(Concluido concluido) {
		this.concluido = concluido;
	}
}
