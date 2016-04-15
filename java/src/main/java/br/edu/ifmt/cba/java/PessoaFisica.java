package br.edu.ifmt.cba.java;
public abstract class PessoaFisica extends Pessoa {

	private String cpf;
	
	public PessoaFisica() {
		super();
	}
	
	public PessoaFisica(String nome){
		super(nome);
	}
	
	public PessoaFisica(String nome, String cpf) throws PessoaFisicaException {
		super(nome);
		setCpf(cpf);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws PessoaFisicaException {
		if ((cpf!=null) && (!cpf.matches(PessoaFisicaException.EXP_CPF_FORMATO)))
			throw new PessoaFisicaException(PessoaFisicaException.CPF_FORMATO);
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaFisica other = (PessoaFisica) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
}
