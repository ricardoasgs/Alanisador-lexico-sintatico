package com.analisador.model;

public class Dicionario {

	public static final String[] PALAVRA_CHAVE = { "BEGIN", "END" };
	public static final char[] OPERADOR = { '+', '-', '*', '/', '=' };
	public static final char[] NUMERO = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	public static final char[] LETRA = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
			'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	public static final char[] ESPECIAL = { '_' };
	public static final char[] CARACTER_VALIDO = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
			'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '_' };


	public static String[] getPalavraChave() {
		return PALAVRA_CHAVE;
	}

	public static char[] getOperador() {
		return OPERADOR;
	}

	public static char[] getNumero() {
		return NUMERO;
	}

	public static char[] getLetra() {
		return LETRA;
	}

	public static char[] getEspecial() {
		return ESPECIAL;
	}

	public static char[] getCaracterValido() {
		return CARACTER_VALIDO;
	}
}
