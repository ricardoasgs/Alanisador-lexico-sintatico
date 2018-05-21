package com.analisador.analisador;

public class GerenciadorErros extends Exception  {


	private static final long serialVersionUID = 1L;

		public GerenciadorErros(){}
		
		public GerenciadorErros(String mensagem){
			super(mensagem);		
		}
		
	}

