package br.edu.ifmt.cba.java.excecoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class TesteException {
	
	public static void main(String[] args) {
		//Exemplo de UncheckedException - nao e detectada na compilacao
		float divisao = 0;
		try {
			divisao = 3/0;//Se a excecao ocorreu neste ponto, as demais linhas do bloco try
						  //nao serao executadas
			//Linha...
			//Linha...
		} catch(ArithmeticException e) { //Captura apenas Excecoes do tipo Arithmetic
			System.out.println("Erro de divis‹o por zero! Favor informar outro valor");
		} catch(Exception e) { //Captura Excecoes de qualquer natureza
			e.printStackTrace();
		} finally { //bloco executado SEMPRE, independentemente de ter ocorrido erro ou n‹o
			System.out.println(divisao);
		}
		
		//Exemplo de CheckedException - e detectada na compilacao
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date data = sdf.parse("02/02/2002");
		} catch (ParseException e) {
			System.out.println("Data informada invalida!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
