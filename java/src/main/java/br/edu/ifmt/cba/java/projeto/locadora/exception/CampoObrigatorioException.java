package br.edu.ifmt.cba.java.projeto.locadora.exception;

import java.text.MessageFormat;

public class CampoObrigatorioException extends Exception {

	public static final String MENSAGEM = "O campo {0} � de preenchimento obrigat�rio.";
	
	public CampoObrigatorioException(String campo) {
		super(MessageFormat.format(MENSAGEM, campo));
	}
}