package com.analisador.analisador;

import com.analisador.model.Dicionario;
import com.analisador.model.Lista;
import com.analisador.model.No;
import com.analisador.model.TabelaSimbolosEnum;

public class AnalisadorLexico {

	public AnalisadorLexico() {};

	public static boolean isPalavraChave(String string) {
		String[] palavraChave = Dicionario.getPalavraChave();
		for (String temp : palavraChave) {
			if (string.equalsIgnoreCase(temp)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isNumero(String numero) throws GerenciadorErros {
		char[] numeros = Dicionario.getNumero();
		if (numero.length() > 5) {
			throw new GerenciadorErros("Numero possui muitos digitos.");
//			return false;
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
			throw new GerenciadorErros("Numero acima do tamanho esperado.");
//			return false;
		}
		return true;
	}

	public static boolean isVariavel(String string) {
		char[] caracteresValidos = Dicionario.getCaracterValido();
		char[] letras = Dicionario.getLetra();
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

	public static boolean isOperador(String operador) {
		char[] operadores = Dicionario.getOperador();
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

	public static void analisarLista(Lista lista) throws GerenciadorErros {
		System.out.println("Analisando Entrada.");
		if (lista.cont == 0) {
			System.out.println("Lista Vazia !!!");
		} else {
			No aux = lista.head;
			while (aux != null) {
				if(!aux.getIgnorar()) {
					if (isPalavraChave(aux.getPalavra())) {
						aux.setSimbolo(TabelaSimbolosEnum.PALAVRA_CHAVE);
					} else if (isOperador(aux.getPalavra())) {
						aux.setSimbolo(TabelaSimbolosEnum.OPERADOR);
					} else if (isNumero(aux.getPalavra())) {
						aux.setSimbolo(TabelaSimbolosEnum.NUMERO);
					} else if (isVariavel(aux.getPalavra())) {
						aux.setSimbolo(TabelaSimbolosEnum.VARIAVEL);
					} else {
						aux.setSimbolo(TabelaSimbolosEnum.NAO_RECONHECIDO);
						throw new GerenciadorErros("Token não reconhecido pela linguagem.");
					}
				}
				aux = aux.getNext();
			}
		}
	}
}

