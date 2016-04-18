package br.edu.ifmt.cba.java.designpattern.mock;

public class Conta {

	private int total;
	
	public void adiciona(ILinha linha) {
		total+=linha.total();
	}
	
	public int total() { return total; }
	
}
