package br.edu.ifmt.cba.java.projeto.locadora;

import java.util.Date;

import br.edu.ifmt.cba.java.projeto.locadora.exception.CampoObrigatorioException;
import br.edu.ifmt.cba.java.projeto.locadora.exception.MascaraException;
import br.edu.ifmt.cba.java.projeto.locadora.exception.TamanhoException;

public class Cliente extends PessoaFisica {

	private int pontosFidelidade;
	
	public Cliente() {
		super();
		this.pontosFidelidade = 0;
	}
	
	public Cliente(Long idPessoaFisica, String nome, Date dataNascimento, String cpf, String telefone, SexoEnum sexo, Endereco endereco, int pontosFidelidade) {
		super(idPessoaFisica, nome, dataNascimento, cpf, telefone, sexo, endereco);
		this.pontosFidelidade = pontosFidelidade;
	}

	public int getPontosFidelidade() {
		return pontosFidelidade;
	}

	public void setPontosFidelidade(int pontosFidelidade) {
		this.pontosFidelidade = pontosFidelidade;
	}
	
	public void valida() throws CampoObrigatorioException, TamanhoException, MascaraException {
		super.valida();	
		if (getPontosFidelidade() < 0)
			throw new TamanhoException(TamanhoException.MENSAGEM_NUMERO, 
					"Pontos de Fidelidade", "0", "infinito");		
	}
	
}
