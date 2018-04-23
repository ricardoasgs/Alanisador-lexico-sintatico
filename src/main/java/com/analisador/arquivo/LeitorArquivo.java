package com.analisador.arquivo;

import java.io.*;

public class LeitorArquivo {
	
	public String resultado;
	
	
	public LeitorArquivo() {
		this.resultado = "";
	}


	public String getResultado() {
		return resultado;
	}


	public void setResultado(String resultado) {
		this.resultado = resultado;
	}


	public String lerArquivo(String caminho) {
		try {
			System.out.println("Recuperando Entrada.");
			BufferedReader br = new BufferedReader(new FileReader(caminho));
			while (br.ready()) {
				this.resultado = this.resultado.concat(br.readLine());
			}
			br.close();
		} catch (IOException ioe) {
			System.out.println("Erro ao ler arquivo: "+ioe);
			this.resultado = "Erro";
		}
		return this.resultado;
	}

}
