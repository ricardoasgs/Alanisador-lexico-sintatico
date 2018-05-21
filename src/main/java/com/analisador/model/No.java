package com.analisador.model;

public class No {

	public String palavra;
	public TabelaSimbolosEnum simbolo;
	public No next;
	public boolean ignorar;

	public No() {
	}

	public String getPalavra() {
		return palavra;
	}

	public No getNext() {
		return next;
	}

	public TabelaSimbolosEnum getSimbolo() {
		return simbolo;
	}
	
	public boolean getIgnorar() {
		return ignorar;
	}

	public void setPalavra(String n) {
		this.palavra = n;
	}

	public void setNext(No n) {
		this.next = n;
	}

	public void setSimbolo(TabelaSimbolosEnum simbolo) {
		this.simbolo = simbolo;
	}
	
	public void setIgnorar(boolean n) {
		this.ignorar = n;
	}

}
