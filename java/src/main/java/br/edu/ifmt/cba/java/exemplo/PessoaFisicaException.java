package br.edu.ifmt.cba.java.exemplo;

public class PessoaFisicaException extends Exception {

	public static final String CPF_FORMATO = "Formato do CPF inválido!";
	
	public PessoaFisicaException(String msg) {
		super(msg);
	}
	
}
