package br.edu.ifmt.cba.java.designpattern.observer;

public class Simulacao {

	public static void main(String[] args) {
		Semaforo semaforo = new Semaforo();
		Carro carro = new Carro();
		Relogio relogio = new Relogio();
		Semaforo semaforo2 = new Semaforo();
		//Criando classe an™nima, instanciando e passando como argumento
		semaforo.addListener(new SemaforoListener(){
			@Override
			public void verde() {
				System.out.println("An™nima no peda?o! Recebi verde!");
			}

			@Override
			public void amarelo() {
				System.out.println("An™nima no peda?o! Recebi Amarelo!");
			}

			@Override
			public void vermelho() { }
		});
		
		semaforo.addListener(carro);
		semaforo.addListener(semaforo2);
		semaforo.mudaSinal();
		
		semaforo.removeListener(carro);
		semaforo.addListener(relogio);
		semaforo.mudaSinal();
		
		semaforo.addListener(carro);
		semaforo.mudaSinal();
	}
	
}
