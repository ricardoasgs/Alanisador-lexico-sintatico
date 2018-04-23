package com.analisador.analisador;

import com.analisador.lista.Lista;
import com.analisador.lista.No;

public class Analisador {

	public static final String[] PALAVRA_CHAVE = { "BEGIN", "END" };
	public static final char[] OPERADOR = { '+', '-', '*', '/', '=' };
	public static final char[] NUMERO = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	public static final char[] LETRA = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
			'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	public static final char[] ESPECIAL = { '_' };
	public static final char[] CARACTER_VALIDO = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
			'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '_' };

	public Analisador() {

	}

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

	public boolean isPalavraChave(String string) {
		String[] palavraChave = getPalavraChave();
		for (String temp : palavraChave) {
			if (string.equalsIgnoreCase(temp)) {
				return true;
			}
		}
		return false;
	}

	public boolean isNumero(String numero) {
		char[] numeros = getNumero();
		if (numero.length() > 5) {
			return false;
		}
		for (int i = 0; i < numero.length(); i++) {
			for (int j = 0; j < numeros.length; j++) {
				if (numero.charAt(i) == numeros[j]) {
					break;
				} else if (numero.charAt(i) != numeros[j] && j == (numeros.length - 1)) {
					return false;
				}
			}
		}
		if (Integer.parseInt(numero) > 32767) {
			return false;
		}
		return true;
	}

	public boolean isVariavel(String string) {
		char[] caracteresValidos = getCaracterValido();
		char[] letras = getLetra();
		for (int i = 0; i < string.length(); i++) {
			for (int j = 0; j < caracteresValidos.length; j++) {
				if (i == 0) {
					if (string.charAt(i) == letras[j] || string.charAt(i) == Character.toUpperCase(letras[j])) {
						break;
					} else if (string.charAt(i) != letras[j] && string.charAt(i) != Character.toUpperCase(letras[j])
							&& j == (letras.length - 1)) {
						return false;
					}
				} else {
					if (string.charAt(i) == caracteresValidos[j]
							|| string.charAt(i) == Character.toUpperCase(caracteresValidos[j])) {
						break;
					} else if (string.charAt(i) != caracteresValidos[j]
							&& string.charAt(i) != Character.toUpperCase(caracteresValidos[j])
							&& j == (caracteresValidos.length - 1)) {
						return false;
					}

				}
			}
		}
		return true;
	}

	public boolean isOperador(String operador) {
		char[] operadores = getOperador();
		for (int i = 0; i < operador.length(); i++) {
			for (int j = 0; j < operadores.length; j++) {
				if (operador.charAt(i) == operadores[j]) {
					break;
				} else if (operador.charAt(i) != operadores[j] && j == (operadores.length-1)) {
					return false;
				}
			}
		}
		return true;
	}

	public void analisarLista(Lista lista) {
		System.out.println("Analisando Entrada.");
		if (lista.cont == 0) {
			System.out.println("Lista Vazia !!!");
		} else {
			No aux = lista.head;
			while (aux != null) {
				if(!aux.getIgnorar()) {
					if (isPalavraChave(aux.getPalavra())) {
//						aux.setSimbolo("PALAVRA_CHAVE");
						aux.setSimbolo("4");
					} else if (isOperador(aux.getPalavra())) {
//						aux.setSimbolo("OPERADOR");
						aux.setSimbolo("2");
					} else if (isNumero(aux.getPalavra())) {
//						aux.setSimbolo("NUMERO");
						aux.setSimbolo("3");
					} else if (isVariavel(aux.getPalavra())) {
//						aux.setSimbolo("VARIAVEL");
						aux.setSimbolo("1");
					} else {
//						aux.setSimbolo("NÂO RECONHECIDO");
						aux.setSimbolo("5");
					}
				}
				aux = aux.getNext();
			}
		}
	}
}

