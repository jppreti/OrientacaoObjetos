package br.edu.ifmt.cba.java.exemplo;

public abstract class Funcionario extends PessoaFisica {

	private String carteiraTrabalho;
	
	public String getCarteiraTrabalho() {
		return carteiraTrabalho;
	}

	public void setCarteiraTrabalho(String carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}

	public abstract float calcularSalario();
	
}
