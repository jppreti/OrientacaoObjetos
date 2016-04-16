package br.edu.ifmt.cba.java.designpattern.observer;

public class Carro implements SemaforoListener {

	@Override
	public void verde() {
		System.out.println("Carro Acelera!");
	}

	@Override
	public void amarelo() {
		System.out.println("Carro Desacelera!");
	}

	@Override
	public void vermelho() {
		System.out.println("Carro Para!");
	}

}
