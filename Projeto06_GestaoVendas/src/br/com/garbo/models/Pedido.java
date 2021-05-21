package br.com.garbo.models;

import java.util.Date;

public class Pedido {
	
	private int id;
	private String numeroPedido;
	private Date dataPedido;
	private String documentoCliente;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	public String getDocumentoCliente() {
		return documentoCliente;
	}
	public void setDocumentoCliente(String documentoCliente) {
		this.documentoCliente = documentoCliente;
	}
}
