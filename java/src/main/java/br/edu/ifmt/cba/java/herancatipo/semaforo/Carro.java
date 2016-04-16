package br.edu.ifmt.cba.java.herancatipo.semaforo;

public class Carro implements ISemaforo {

	@Override
	public void verde() {
		System.out.println("Carro n‹o faz nada!");
	}

	@Override
	public void amarelo() {
		System.out.println("Carro indica no painel ATENCAO!");
	}

	@Override
	public void vermelho() {
		System.out.println("Carro impede acelera?‹o!");
	}

	@Override
	public void intermitente() {
		System.out.println("Carro indica no painel ATENCAO!");
	}

}
