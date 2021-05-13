package br.com.garbo.entities;

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

import br.com.garbo.enumerations.Tipo;

@Entity
@Table(name="pagamentos")
public class Pagamento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDPAGAMENTO")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="DOCUMENTO")	
	private Prestador prestador;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO")
	private Tipo tipo;
	
	@Column(name = "VALOR")
	private double valor;
	
	@Column(name = "IMPOSTO")
	private double imposto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Prestador getPrestador() {
		return prestador;
	}

	public void setPrestador(Prestador prestador) {
		this.prestador = prestador;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getImposto() {
		return imposto;
	}

	public void setImposto(double imposto) {
		this.imposto = imposto;
	}
}
