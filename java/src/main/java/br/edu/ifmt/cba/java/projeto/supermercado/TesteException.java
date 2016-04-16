



package br.edu.ifmt.cba.java.projeto.supermercado;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TesteException {
	
	public static void main (String args[]) {
		
		//CHECKED EXCEPTION
		File arquivo = new File("Teste.txt");
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(arquivo);
			os.write(2);
			os.flush();			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage()); //mais amig‡vel
			e.printStackTrace(); // pilha de erros (para o programador)
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//UNCHECKED EXCEPTION
		try {
			Integer.parseInt(Util.getInput("Digite um nœmero!"));
		} catch (NumberFormatException e) {
			Util.showError("Nœmero Inv‡lido!");
		}
		
		
	}

}
