package br.com.garbo.models;

import br.com.garbo.interfaces.IDocumento;

public class DocumentoCnpj implements IDocumento {

	private String numero;

	@Override
	public void setNumero(String numero) {
		
		if (numero == null || !numero.matches("[0-9]{14}")) {
			throw new IllegalArgumentException("CNPJ Inv�lido");
		}
		this.numero = numero;
	}

	@Override
	public String getNumero() {
		
		return this.numero;
	}
	
}
