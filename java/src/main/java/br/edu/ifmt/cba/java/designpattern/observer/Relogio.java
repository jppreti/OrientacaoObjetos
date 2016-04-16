package br.edu.ifmt.cba.java.designpattern.observer;

public class Relogio implements SemaforoListener {

	@Override
	public void verde() {
		System.out.println("Rel—gio Vibra 2 Vezes!");
	}

	@Override
	public void amarelo() {
		System.out.println("Rel—gio Vibra continuamente por 3 segundos!");
	}

	@Override
	public void vermelho() {
		System.out.println("Rel—gio Vibra Continuamente por 3 segundos!");		
	}

}
