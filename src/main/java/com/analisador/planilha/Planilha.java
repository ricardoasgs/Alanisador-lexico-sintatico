package com.analisador.planilha;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.analisador.config.ConfigPath;
import com.analisador.lista.Lista;
import com.analisador.lista.No;

public class Planilha {

	
	public void expExcel(String nomeArquivo, Lista lista) {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet firstSheet = workbook.createSheet("Aba");

        FileOutputStream fos = null;

    	int i = 0;
    	int j = 0;
        
        try {
        	
        	System.out.println("Gerando saída.");
        	
            fos = new FileOutputStream(new File(nomeArquivo));

            No aux = lista.head;
            
                    
            while (aux != null) {
            	
            	if (j==0) {
            		
            		HSSFRow row = firstSheet.createRow(i);

            		row.createCell(0).setCellValue("Token           ");
            		row.createCell(1).setCellValue("Código          ");
            		j++;
            	} 
            	else if(!aux.getIgnorar()) {
            		
            		HSSFRow row = firstSheet.createRow(i);

            		row.createCell(0).setCellValue(aux.getPalavra());
            		row.createCell(1).setCellValue(aux.getSimbolo());
            		aux = aux.getNext();
            		
            	} else {
            		aux = aux.getNext();
            		i--;
            	}
            	i++;
            	

            } 
            workbook.write(fos);
            System.out.println("Saída gerada no diretorio: "+ConfigPath.OUTPUT_PATH_WINDOWS+ConfigPath.OUTPUT_FILENAME);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao exportar arquivo");
        } finally {
            try {
                fos.flush();
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
