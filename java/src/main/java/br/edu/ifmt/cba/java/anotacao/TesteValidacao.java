package br.edu.ifmt.cba.java.anotacao;

import java.util.Date;

public class TesteValidacao {

	public static void main(String[] args) {
		Produto p1 = new Produto();
		Exception exc = ValidacaoUtil.valida(p1);
		if (exc!=null) System.out.println("P1\n"+exc.getMessage());
		
		Produto p2 = new Produto();
		p2.setNome("Joao");
		exc = ValidacaoUtil.valida(p2);
		if (exc!=null) System.out.println("P2\n"+exc.getMessage());
		
		Produto p3 = new Produto();
		p3.setNome("Joao Paulo");
		p3.setDescricao("Esta descrição tem o número 5 dentro dela.");
		p3.setDataCadastro(new Date());
		exc = ValidacaoUtil.valida(p3);
		if (exc!=null) System.out.println("P3\n"+exc.getMessage());
	}
	
}
