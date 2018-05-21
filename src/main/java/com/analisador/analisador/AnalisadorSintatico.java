package com.analisador.analisador;

import com.analisador.model.Lista;
import com.analisador.model.No;
import com.analisador.model.TabelaSimbolosEnum;

public class AnalisadorSintatico {
	
	private static No token;
	private static Lista lista;

	public static void fazerAnaliseSintatica(Lista listaParam) throws GerenciadorErros{
		lista = listaParam;
		obtenha_simbolo();
		if(!token.getPalavra().equalsIgnoreCase("begin")){
			throw new GerenciadorErros("Falta o begin");
		}
		while(lista.getCont() != 1){
			obtenha_simbolo();
			expressao();
		}
		
		
	}
	
	public static void expressao() throws GerenciadorErros {
		termo();

		if (token.getPalavra().equals("+")) {
			obtenha_simbolo();
			expressao();
		}
		if (token.getPalavra().equals("-")) {
			obtenha_simbolo();
			expressao();
		}
		if (token.getPalavra().equals("=")) {
			obtenha_simbolo();
			expressao();
		}
		
	}

	public static void termo() throws GerenciadorErros {
		fator();
		if(token.getPalavra().equals("*")){
			obtenha_simbolo();
			termo();
		}
		if(token.getPalavra().equals("/")){
			obtenha_simbolo();
			termo();
		}
	}
	
	public static void fator() throws GerenciadorErros {
		primario();
		
	}
	
	public static void primario() throws GerenciadorErros {
		if (token.getSimbolo() == TabelaSimbolosEnum.VARIAVEL) {
			obtenha_simbolo();
		} else if (token.getSimbolo() == TabelaSimbolosEnum.NUMERO) {
			obtenha_simbolo();
		}  else {
			throw new GerenciadorErros("Erro de sintaxe");
		}
	}
	
	public static void obtenha_simbolo() throws GerenciadorErros {
		
		token = lista.removeFirst();
		if (token.ignorar && token != lista.tail) {
			obtenha_simbolo();
		}else if (token == lista.tail) {
			if(!token.getPalavra().equals("end")){
				throw new GerenciadorErros("Falta o end");
			}
		}else  {
			System.out.println("obteve simbolo: "+token.getPalavra());
		}
		
	}

}
