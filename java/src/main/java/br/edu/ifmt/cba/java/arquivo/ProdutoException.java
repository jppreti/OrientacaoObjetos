package br.edu.ifmt.cba.java.arquivo;

public class ProdutoException extends Exception {

	private static final long serialVersionUID = -8702168638786932008L;

	public static final String NOME_OBRIGATORIO = "Nome é de preenchimento obrigatório!";
	public static final String QTDE_INVALIDO = "Valor inválido para quantidade!";
	public static final String VALOR_INVALIDO = "Valor do produto inválido!";
	public static final String DATA_OBRIGATORIO = "Data é de preenchimento obrigatório!";
	public static final String DATA_INVALIDO = "Data de vencimento inválida!";
	
	public ProdutoException(String msg) {
		super(msg);
	}
	
}
