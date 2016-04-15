package br.edu.ifmt.cba.java.exemplo;

public class Professor extends Funcionario {
	
	private String titulacao;
	
	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	@Override
	public float calcularSalario() {
		return 0;
	}
	
}
