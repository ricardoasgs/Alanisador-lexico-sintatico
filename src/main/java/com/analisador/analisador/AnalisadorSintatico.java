package com.analisador.analisador;

import com.analisador.model.Lista;
import com.analisador.model.No;

public class AnalisadorSintatico {
	
	private static No token;
	private static Lista lista;

	public static void fazerAnaliseSintatica(Lista listaParam){
		lista = listaParam;
		obtenha_simbolo();
		if(!token.getPalavra().equalsIgnoreCase("begin")){
			System.out.println("Falta o begin");
		}
		while(lista.getCont() != 1){
			obtenha_simbolo();
			expressao();
		}
		
		
	}
	
	public static void expressao() {
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

	public static void termo(){
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
	
	public static void fator(){
		primario();
		
	}
	
	public static void primario() {
		if (token.getSimbolo() == "1") {
			obtenha_simbolo();
		} else if (token.getSimbolo() == "3") {
			obtenha_simbolo();
		}  else {
			System.out.println("Erro de sintaxe");
		}
	}
	
	public static void obtenha_simbolo(){
		
		token = lista.removeFirst();
		if (token.ignorar && token != lista.tail) {
			obtenha_simbolo();
		}else if (token == lista.tail) {
			if(!token.getPalavra().equals("end")){
				System.out.println("Falta o end");
			}
		}else  {
			System.out.println("obteve simbolo: "+token.getPalavra());
		}
		
	}

}
