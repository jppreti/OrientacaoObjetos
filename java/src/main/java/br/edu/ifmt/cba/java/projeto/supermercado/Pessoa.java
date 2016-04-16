package br.edu.ifmt.cba.java.projeto.supermercado;

import java.util.Date;

import br.edu.ifmt.cba.java.projeto.supermercado.exception.PessoaException;

/**
 * Classe que representa um conceito genérico/abstrato dos tipos de pessoas que existem no sistema.
 * @author João Paulo D. Preti
 *
 */
public abstract class Pessoa {

	//Atributos de Pessoa
	private String nome;
	private Date dataNascimento;
	private Endereco endereco;

	//Construtor Default
	public Pessoa() {
		this.nome = "";
		this.dataNascimento = new Date();
		this.endereco = new Endereco();
	}
	
	//Construtor que já inicializa o objeto com todos os dados de pessoa
	public Pessoa(String nome, Date dataNascimento) throws PessoaException {
		setNome(nome);
		this.dataNascimento = dataNascimento;
		this.endereco = new Endereco();
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	//Método acessor da data de nascimento
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	//Método acessor do nome
	public String getNome() {
		return nome.toUpperCase();
	}

	//Método modificador da data de nascimento
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	//método modificador do nome
	public void setNome(String nome) throws PessoaException {
		if (nome.length()<=5 || nome.length() > 60)
			throw new PessoaException(PessoaException.NOME_INVALIDO);
		this.nome = nome;
	}
	
	/**
	 * Retorna os valores de todos os atributos da classe Pessoa
	 */
	@Override
	public String toString() {
		return  "ID: " + super.toString() + "\n" + 
				"Nome: " + nome + "\n" +
				"Data de Nascimento: " + dataNascimento + "\n" +
				endereco;
	}
	@Override
	public void finalize() {
		System.out.println("Objeto de nome: " + nome + " foi removido da memória!");
	}

}
