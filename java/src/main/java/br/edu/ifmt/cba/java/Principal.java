package br.edu.ifmt.cba.java;
import java.util.ArrayList;
import java.util.List;

import br.ifmt.lpi.Aluno;
import br.ifmt.lpi.Cidade;
import br.ifmt.lpi.Estado;
import br.ifmt.lpi.Pessoa;
import br.ifmt.lpi.PessoaException;
import br.ifmt.lpi.PessoaFisica;
import br.ifmt.lpi.PessoaFisicaException;
import br.ifmt.lpi.Professor;
import br.ifmt.lpi.SexoEnum;

public class Principal {

	public static void main(String[] args) throws PessoaException, PessoaFisicaException {
		Aluno jose = new Aluno();
		jose.setNome("Jose da Silva");
		jose.setEmail("jose@algo.com.br");
		jose.setTelefone("(65) 1234-1234");
		jose.setNumMatricula("123");
		jose.setCpf("123.123.123-12");
		jose.setRua("Rua X");
		jose.setNumero("1");
		jose.setBairro("Jardim xx");
		jose.setComplemento("Apto 444");
		jose.sexo = SexoEnum.MASCULINO;

		Estado mt = new Estado("Mato Grosso", "MT");
		Cidade cuiaba = new Cidade("Cuiaba", "65", mt);

		jose.setCidade(cuiaba);

		Professor joao = new Professor();
		joao.setNome("Joao Paulo");
		joao.setEmail("joao@algo.com.br");
		joao.setTelefone("(65) 1234-1234");
		joao.setTitulacao("Dr.");
		joao.setCpf("123.123.123-12");
		joao.setRua("Rua X");
		joao.setNumero("1");
		joao.setBairro("Jardim xx");
		joao.setComplemento("Apto 444");
		joao.sexo = SexoEnum.MASCULINO;
		joao.setCidade(cuiaba);

		List<Pessoa> pessoasFisicas = new ArrayList<Pessoa>();
		pessoasFisicas.add(jose);
		pessoasFisicas.add(joao);

			System.out.println(pessoasFisicas.get(100));

		for (Pessoa pf : pessoasFisicas) {
			System.out.println(pf);
			Professor prof;
			if (pf instanceof Professor) {
				prof = (Professor) pf; // coerção explícita porque está indo de
										// uma generalização para uma
										// especialização
				prof.getTitulacao();
				prof.getCarteiraTrabalho(); // coerção implícia. não é
											// necessário informar sobre a
											// coerção quando se está
											// generalizando. O filho só tem um
											// pai.
				pf = prof;
			}
		}

	}

}
