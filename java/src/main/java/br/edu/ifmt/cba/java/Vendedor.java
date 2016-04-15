package br.edu.ifmt.cba.java;

public class Vendedor extends Funcionario {

	private float comissao;

	public float getComissao() {
		return comissao;
	}

	public void setComissao(float comissao) {
		this.comissao = comissao;
	}

	@Override
	public float calcularSalario() {
		return getSalario()+comissao;
	}
	
}
