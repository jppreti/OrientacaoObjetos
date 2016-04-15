package br.edu.ifmt.cba.java.teste;

import java.util.ArrayList;

public class Carrinho {

	ArrayList<ItemProduto> produtos = new ArrayList<ItemProduto>();
	
	public ItemProduto getItem(String nome) {
		for (ItemProduto item : produtos) {
			if (item.produto.nome.equalsIgnoreCase(nome))
				return item;
		}
		return null;
	}
	
	public int adicionar(Produto p) {
		if (p==null) return 0;
		ItemProduto item = getItem(p.nome);
		if (item!=null)
			item.qtde++;
		else {
			item = new ItemProduto();
			item.produto = p;
			item.qtde = 1;
			produtos.add(item);
		}
		return item.qtde;
	}
	
	public void remover(Produto p) {
		ItemProduto item = getItem(p.nome);
		produtos.remove(item);
	}
	
	public void modificar(Produto p, int qtde) {
		
	}
	
	public float getVlrTotal(Produto p) {
		return 0;
	}
	
	public float getVlrTotal() {
		return 0;
	}
	
}
