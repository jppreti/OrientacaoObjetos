package br.edu.ifmt.cba.java.arquivo;

import java.io.Serializable;
import java.util.Date;

public class Produto implements Serializable, Cloneable {

	private static final long serialVersionUID = -5499845633765753847L;
	
	private String nome;
	private int qtde;
	private float valorUnitario;
	private Date dataValidade;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws ProdutoException {
		if (nome==null || nome.trim().length()==0)
			throw new ProdutoException(ProdutoException.NOME_OBRIGATORIO);
		this.nome = nome;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) throws ProdutoException {
		if (qtde < 0)
			throw new ProdutoException(ProdutoException.QTDE_INVALIDO);
		this.qtde = qtde;
	}
	public float getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(float valor) throws ProdutoException {
		if (qtde < 0)
			throw new ProdutoException(ProdutoException.VALOR_INVALIDO);
		
		this.valorUnitario = valor;
	}
	public Date getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\n" +
				"Qtde.: " + qtde + "\n" +
				"Vlr. Unitário: " + valorUnitario + "\n" +
				"Data Validade: " + dataValidade + "\n";
	}
	
	public Produto clone() {
		Produto clone = new Produto();
		try {
			clone.setNome(this.getNome());
			clone.setDataValidade(this.getDataValidade());
			clone.setQtde(this.getQtde());
			clone.setValorUnitario(this.getValorUnitario());
		} catch (ProdutoException e) {
			e.printStackTrace();
		}
		return clone;
	}
	public boolean isExcluido() {
		// TODO Auto-generated method stub
		return false;
	}
	public void setExcluido(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
