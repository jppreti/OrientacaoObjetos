package br.edu.ifmt.cba.java.projeto.supermercado.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.edu.ifmt.cba.java.projeto.supermercado.BancoDeDados;
import br.edu.ifmt.cba.java.projeto.supermercado.Produto;
import br.edu.ifmt.cba.java.projeto.supermercado.TipoProduto;
import br.edu.ifmt.cba.java.projeto.supermercado.Util;
import br.edu.ifmt.cba.java.projeto.supermercado.exception.ValidaException;

public class TesteValidacao {

	@Test(expected=ValidaException.class)
	public void testCampoObrigatorio() throws ValidaException {
		Produto p = new Produto();
		Util.valida(p);
	}

}
