package br.edu.ifmt.cba.java.exemplo;

public class PessoaException extends Exception {

	public static final String NOME_OBRIGATORIO = "Nome é de preenchimento obrigatório!";
	public static final String NOME_TAMANHO = "Nome deve possuir entre 5 e 80 caracteres!";
	public static final String EMAIL_INVALIDO = "E-mail inválido!";
	
	public PessoaException(String msg) {
		super(msg);
	}
	
}
