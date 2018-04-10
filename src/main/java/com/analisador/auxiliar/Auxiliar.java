package com.analisador.auxiliar;

import com.analisador.lista.Lista;

public class Auxiliar {

	public static final char[] TOKENS = { '+', '-', '*', '/', '=', ' ' };

	public Auxiliar() {

	}

	public static char[] getTokens() {
		return TOKENS;
	}

	public Lista splitTokens(String total) {
		int index = 0;
		int aux = 0;
		Lista lista = new Lista();
		char[] tokens = getTokens();

		for (int i = 0; i < total.length(); i++) {
			for (int j = 0; j < tokens.length; j++) {
				if (total.charAt(i) == tokens[j]) {
					lista.insertLast(total.substring(aux, (i)));
					if (tokens[j] != ' ') {
						lista.insertLast(Character.toString(tokens[j]));
					}
					aux = i + 1;
					index++;
				}
			}
		}
		lista.insertLast(total.substring(aux, (total.length())));
		return lista;
	}

}
