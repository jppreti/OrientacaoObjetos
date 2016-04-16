package br.edu.ifmt.cba.java.designpattern.observer;

import java.util.ArrayList;

public class Semaforo implements SemaforoListener{

	private ArrayList<SemaforoListener> interessados = new ArrayList<SemaforoListener>();
	
	private SemaforoEnum estadoSemaforo = SemaforoEnum.VERMELHO;
	
	public void addListener(SemaforoListener sl) {
		interessados.add(sl);
	}
	
	public void removeListener(SemaforoListener sl) {
		interessados.remove(sl);
	}
	
	public void mudaSinal() {
		switch (estadoSemaforo) {
		case VERMELHO:
				estadoSemaforo = SemaforoEnum.VERDE;
				System.out.println(estadoSemaforo);
				for (SemaforoListener interessado : interessados)
					interessado.verde();
			break;
		case VERDE:
			estadoSemaforo = SemaforoEnum.AMARELO;
			System.out.println(estadoSemaforo);
			for (SemaforoListener interessado : interessados)
				interessado.amarelo();			
			break;
		case AMARELO:
			estadoSemaforo = SemaforoEnum.VERMELHO;
			System.out.println(estadoSemaforo);
			for (SemaforoListener interessado : interessados)
				interessado.vermelho();			
			break;
		default:
			break;
		}
	}

	@Override
	public void verde() {
		estadoSemaforo = SemaforoEnum.VERMELHO;
		System.out.println("Sem‡foro Mudou para Vermelho!");
	}

	@Override
	public void amarelo() {
		System.out.println("Sem‡foro Recebeu a Mensagem e Decidiu n‹o fazer Nada!");		
	}

	@Override
	public void vermelho() {
		estadoSemaforo = SemaforoEnum.VERDE;		
		System.out.println("Sem‡foro Mudou para Verde!");
	}
	
}
