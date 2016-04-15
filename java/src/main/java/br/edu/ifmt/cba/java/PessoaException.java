package br.edu.ifmt.cba.java;

public class PessoaException extends Exception {

	public static final String NOME_OBRIGATORIO="Nome é de preenchimento obrigatório.";
	public static final String NOME_TAMANHO="O nome deve possuir entre 8 e 80 caracteres.";
	public static final String NOME_CARACTERES_INVALIDOS="O nome possui caracteres inválidos.";
	
	public static final String EXP_NOME_CARAC_VALIDOS="[A-Za-zÁ-ÙãõÃÕ]+"; //expressão regular
	
	public PessoaException() {
		super();
	}

	public PessoaException(String msg) {
		super(msg);
	}
	
}
