package br.edu.ifmt.cba.java.designpattern.mock;

public class Linha implements ILinha {

	private Item item;
	private int qtde;
	
	public Linha(Item item, int qtde) {
		this.item = item;
		this.qtde = qtde;
	}
	
	public int total() {
		return item.getPreco() * qtde;
	}
	
}
