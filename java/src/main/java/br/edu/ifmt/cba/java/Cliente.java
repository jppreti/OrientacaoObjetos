package br.edu.ifmt.cba.java;

public class Cliente extends PessoaFisica {

	private int pontosFidelidade;

	public Cliente(String nome, String cpf) throws PessoaFisicaException {
		super(nome,cpf);
	}

	public int getPontosFidelidade() {
		return pontosFidelidade;
	}

	public void setPontosFidelidade(int pontosFidelidade) {
		this.pontosFidelidade = pontosFidelidade;
	}
}
