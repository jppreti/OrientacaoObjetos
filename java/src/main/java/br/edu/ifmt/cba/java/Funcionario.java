package br.edu.ifmt.cba.java;

public abstract class Funcionario extends PessoaFisica {

	private float salario;

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	public abstract float calcularSalario();
}
