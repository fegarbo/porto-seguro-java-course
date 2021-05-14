package br.com.garbo.enumerations;

public enum Tipo {
	PROJETO(1), HORA(2);

	private int valor;
	Tipo(int valorTipo) {
		valor = valorTipo;
	}
	
	public int getValor() {
		return valor;
	}
}
