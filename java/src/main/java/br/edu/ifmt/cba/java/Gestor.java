package br.edu.ifmt.cba.java;

public class Gestor extends Funcionario {

	private float bonus;

	public float getBonus() {
		return bonus;
	}

	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public float calcularSalario() {
		return getSalario()+bonus;
	}
}
