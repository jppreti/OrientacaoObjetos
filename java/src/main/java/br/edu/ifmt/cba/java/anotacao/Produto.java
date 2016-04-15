package br.edu.ifmt.cba.java.anotacao;

import java.util.Date;

public class Produto {
	
	@Validacao(requerido=true, min=5, max=6)
	private String nome;

	@Validacao(pattern="[A-Za-z]+")
	private String descricao;
	
	@Validacao(requerido=true)
	private Date dataCadastro;
	
	@Validacao(requerido=true, min=1, max=10)
	private int qtde;
	
	@Validacao(requerido=true)
	private float valor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
}
