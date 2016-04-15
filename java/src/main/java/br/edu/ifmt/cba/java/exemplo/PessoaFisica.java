package br.edu.ifmt.cba.java.exemplo;

import java.util.regex.Pattern;

public abstract class PessoaFisica extends Pessoa {

	private String cpf;

	public PessoaFisica() {
		super();
		cpf = "";
	}
	
	public PessoaFisica(String nome, String email, String telefone, String cpf) {
		super(nome, email, telefone);
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws PessoaFisicaException {
		if (cpf!=null && !Pattern.matches("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}", cpf))
			throw new PessoaFisicaException(PessoaFisicaException.CPF_FORMATO);
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return super.toString() +
				"CPF: " + cpf + "\n";
	}
}
