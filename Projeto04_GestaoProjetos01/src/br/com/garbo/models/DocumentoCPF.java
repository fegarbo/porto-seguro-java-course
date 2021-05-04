package br.com.garbo.models;

import br.com.garbo.interfaces.IDocumento;

public class DocumentoCPF implements IDocumento{

	private String numero;
	
	@Override
	public void setNumero(String numero) {
		
		if (numero == null || !numero.matches("[0-9]{11}")) {
			throw new IllegalArgumentException("CPF Inválido");
		}
		this.numero = numero;
	}

	@Override
	public String getNumero() {
		return this.numero;
	}

}
