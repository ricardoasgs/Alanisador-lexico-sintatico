package com.analisador.main;

import com.analisador.analisador.AnalisadorLexico;
import com.analisador.analisador.AnalisadorSintatico;
import com.analisador.analisador.GerenciadorErros;
import com.analisador.arquivo.LeitorArquivo;
import com.analisador.auxiliar.Auxiliar;
import com.analisador.config.ConfigPath;
import com.analisador.model.Lista;
import com.analisador.planilha.Planilha;

public class Main {

	public static void main(String[] args) throws GerenciadorErros {
		
		

		Auxiliar aux = new Auxiliar();
		
		LeitorArquivo leitor = new LeitorArquivo();
		
		String string = leitor.lerArquivo(ConfigPath.INPUT_PATH_WINDOWS+ConfigPath.INPUT_FILENAME);

		Lista lista = aux.splitTokens(string);
		
		lista.VericarLista();
		
		AnalisadorLexico.analisarLista(lista);
		
		AnalisadorSintatico.fazerAnaliseSintatica(lista);
		
		System.out.println("Compilou!");
		
		//Planilha plan = new Planilha();
		
//		lista.Print();
		
		//plan.expExcel(ConfigPath.OUTPUT_PATH_WINDOWS+ConfigPath.OUTPUT_FILENAME, lista );
		
		
				

	}

}
