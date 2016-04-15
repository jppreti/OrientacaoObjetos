package br.edu.ifmt.cba.java;

public class PessoaFisicaException extends PessoaException {

	public static final String CPF_FORMATO="Formato do CPF inválido.";
	
	public static final String EXP_CPF_FORMATO="[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}";
	
	public PessoaFisicaException(String msg) {
		super(msg);
	}
		
}
