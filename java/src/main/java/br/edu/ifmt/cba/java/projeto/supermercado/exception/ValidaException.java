






package br.edu.ifmt.cba.java.projeto.supermercado.exception;

public class ValidaException extends Exception {

	public static final String CAMPO_OBRIGATORIO = "Campo {0} � de Preenchimento Obrigat�rio!";
	
	public ValidaException (String msg) {
		super(msg);
	}
	
}
