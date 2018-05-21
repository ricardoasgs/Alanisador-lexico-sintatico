package com.analisador.model;

public enum TabelaSimbolosEnum {

	VARIAVEL(1), OPERADOR(2), NUMERO(3), PALAVRA_CHAVE(4), NAO_RECONHECIDO(5);
	private final int codigo;
	
	private TabelaSimbolosEnum(int codigo){
		this.codigo = codigo;
	};
	
	public int getCodigo() {
		return this.codigo;
	}
}
