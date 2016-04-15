package br.edu.ifmt.cba.java.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CarrinhoTest {
	
	Carrinho carrinho;
	Produto lapis, borracha, caderno;
	
	@Before
	public void inicializa() {
		carrinho = new Carrinho();
		lapis = new Produto();
		lapis.nome = "Lápis";
		lapis.valorUnitario = 1.5f;
		borracha = new Produto();
		borracha.nome = "Borracha";
		borracha.valorUnitario = 1f;
		caderno = new Produto();
		caderno.nome = "Caderno";
		caderno.valorUnitario = 6f;
	}
	
	@Test
	public void adicionar() {
		assertEquals(1, carrinho.adicionar(lapis));
		assertEquals(1, carrinho.adicionar(borracha));
		assertEquals(2, carrinho.adicionar(lapis));
		assertEquals(3, carrinho.adicionar(lapis));
		assertEquals(1, carrinho.adicionar(caderno));
		assertEquals(2, carrinho.adicionar(caderno));
		assertEquals(0, carrinho.adicionar(null));
	}
	
	@Test
	public void remover() {
		assertNotNull(carrinho.produtos);
		assertEquals(0, carrinho.produtos.size());
		carrinho.remover(lapis);
		assertEquals(0, carrinho.produtos.size());
		carrinho.adicionar(lapis);
		carrinho.adicionar(borracha);
		carrinho.adicionar(caderno);
		carrinho.remover(lapis);
		assertEquals(2, carrinho.produtos.size());
		carrinho.remover(lapis);
		assertEquals(2, carrinho.produtos.size());
		carrinho.remover(borracha);
		assertEquals(1, carrinho.produtos.size());
		carrinho.remover(caderno);
		assertEquals(0, carrinho.produtos.size());
		int size = carrinho.produtos.size();
		carrinho.remover(null);
		assertEquals(size, carrinho.produtos.size());
	}
	
	
	
	
	
	
	
	
	
	
	@Test
	public void modificar() {
		carrinho.adicionar(lapis);
		carrinho.modificar(lapis, 10);
		assertEquals(10,carrinho.getItem(lapis.nome).qtde);
		try {
			carrinho.modificar(lapis, -1);
			fail("Deveria ter lançado erro para qtdes negativas!");
		} catch (Exception e) {
			
		}
	}	
	
	@Test(expected=Exception.class)
	public void modificarErroQtdeNegativa() {
		carrinho.adicionar(lapis);
		carrinho.modificar(lapis, -1);
	}
	
	@Test(expected=Exception.class)
	public void modificarErroProdutoNull() {
		carrinho.adicionar(lapis);
		carrinho.modificar(null, -1);
	}

	@Test
	public void getVlrTotalProduto() {
		assertEquals(0, carrinho.getVlrTotal(lapis));
		carrinho.adicionar(lapis);
		assertEquals(1.5f, carrinho.getVlrTotal(lapis));
		carrinho.modificar(lapis, 3);
		assertEquals(4.5f, carrinho.getVlrTotal(lapis));
		carrinho.adicionar(borracha);
		carrinho.adicionar(borracha);
		assertEquals(2f, carrinho.getVlrTotal(borracha));
	}
	
	@Test
	public void getVlrTotal() {
		assertEquals(0,carrinho.getVlrTotal());
		carrinho.adicionar(lapis);
		carrinho.adicionar(borracha);
		carrinho.adicionar(caderno);
		assertEquals(8.5f,carrinho.getVlrTotal());
		carrinho.modificar(lapis, 2);
		assertEquals(10f,carrinho.getVlrTotal());
	}

}
